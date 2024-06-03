<template>
  <div class="page-container">
    <div class="banner-container">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <div class="dark-banner">
            <label for="publicStructureId"><h1>Identifiant de la structure publique</h1></label>
            <input type="text" id="publicStructureId" v-model="publicStructureId" required placeholder="Veuillez renseigner l'identifiant de la structure publique ici" class="focus-animation">
            <div class="form-actions-validate-cancel-form">
              <button class="validate-button" type="submit">Valider</button>
              <button class="cancel-button" type="button" @click="annuler">Annuler</button>
            </div>
            <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
          </div>
        </div>
      </form>
    </div>
    <div class="text-explication">
      <p>Saisissez l'identifiant de la structure publique comme spécifié...</p>
    </div>
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { useRouter } from 'vue-router';
import { UserAPI, CollectiviteAPI } from '@/api/api-index';

export default defineComponent({
  name: 'SelectionCollectivite',
  setup() {
    const publicStructureId = ref('');
    const errorMessage = ref('');
    const router = useRouter();

    const submitForm = async () => {
      try {
        //const response = await UserAPI.checkUserByFirstName(publicStructureId.value);
        const response = await CollectiviteAPI.checkCollectiviteByCode(publicStructureId.value);
        if (response.data) {
          router.push({ name: 'SelectionFacture' });
        } else {
          errorMessage.value = "La collectivite n'existe pas.";
        }
      } catch (error) {
        console.error('Erreur lors de la vérification de l\'utilisateur:', error);
        errorMessage.value = "Une erreur s'est produite lors de la vérification.";
      }
    };

    const annuler = () => {
      router.go(-1);
    };

    return {
      publicStructureId,
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
  color: white;
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

.form-group label {
  color: #333;
  display: block;
  margin-bottom: 0.5em;
}

.form-group input {
  width: 100%;
  padding: 10px;
  margin-bottom: 1em;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #fafafa;
}

.error-message {
  color: red;
  margin-top: 10px;
}
</style>
