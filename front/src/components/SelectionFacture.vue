<template>
  <div class="page-container">
    <div class="banner-container">
      <div class="dark-banner">
        <h1>Informations Facture</h1>
        <form @submit.prevent="submitForm">
          <div class="form-row">
            <div class="form-group">
              <label for="invoiceReference">Référence facture :</label>
              <input type="text" id="invoiceReference" v-model="invoiceReference" required placeholder="Référence de la facture ici" class="focus-animation">
            </div>
            <div class="form-group">
              <label for="invoiceAmount">Montant facture :</label>
              <input type="number" id="invoiceAmount" v-model="invoiceAmount" required placeholder="Montant de la facture ici" class="focus-animation">
            </div>
            <div class="form-group">
              <label for="email">Adresse électronique :</label>
              <input type="email" id="email" v-model="email" required placeholder="Adresse mail" class="focus-animation">
            </div>
            <div class="form-group">
              <label for="confirmEmail">Confirmez l'adresse saisie :</label>
              <input type="email" id="confirmEmail" v-model="confirmEmail" required placeholder="Confirmer adresse mail" class="focus-animation">
            </div>
          </div>
          <div class="form-actions-validate-cancel-form">
            <button class="validate-button" type="submit">Valider</button>
            <button class="cancel-button" type="button" @click="annuler">Annuler</button>
          </div>
          <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
        </form>
      </div>
    </div>
    <div class="text-explication">
      <p>* Saisir les informations de la facture à payer.</p>
    </div>
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { useRouter } from 'vue-router';
import { FactureAPI, UserAPI } from '@/api/api-index';

export default defineComponent({
  name: 'SelectionFacture',
  setup() {
    const invoiceReference = ref('');
    const invoiceAmount = ref('');
    const email = ref('');
    const confirmEmail = ref('');
    const errorMessage = ref('');
    const router = useRouter();

    const submitForm = async () => {
      if (email.value !== confirmEmail.value) {
        errorMessage.value = "Les adresses électroniques ne correspondent pas.";
        return;
      }

      try {
        // Vérification de la référence de la facture et du montant
        const factureResponse = await FactureAPI.checkReferenceFactureAndMontant(invoiceReference.value, parseFloat(invoiceAmount.value));
        if (!factureResponse.data) {
          errorMessage.value = "La référence ou le montant de la facture est incorrect.";
          return;
        }
        console.log(factureResponse.data);

        // Vérification de l'existence de l'utilisateur par email
        const userResponse = await UserAPI.checkUserByEmail(email.value);
        if (!userResponse.data) {
          errorMessage.value = "Aucun utilisateur avec cet email trouvé.";
          return;
        }
        console.log(userResponse.data);

        // Redirection si toutes les vérifications sont correctes
        router.push({ name: 'ProOuParticulier' });
      } catch (error) {
        console.error('Erreur lors de la vérification de la facture ou de l\'utilisateur:', error);
        errorMessage.value = "Une erreur s'est produite lors de la vérification.";
      }
    };

    const annuler = () => {
      router.go(-1);
    };

    return {
      invoiceReference,
      invoiceAmount,
      email,
      confirmEmail,
      errorMessage,
      submitForm,
      annuler,
    };
  },
});
</script>

<style scoped>
h1 {
  font-family: 'Poppins', sans-serif;
  color: var(--vt-c-white);
  text-align: center;
  font-size: 2em;
  font-weight: 600;
  margin: 0 0 20px;
  padding: 0;
  line-height: 1.2;
}

p {
  font-size: 1.2em;
  font-weight: 700;
  margin-top: 2vh;
  margin-bottom: 5vh;
}

.error-message {
  color: red;
  margin-top: 10px;
}
</style>
