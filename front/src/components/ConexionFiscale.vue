<template>
  <div class="page-container">

    <div class="banner-container">

          <div class="dark-banner">
            <H1>Connexion avec mes identifiants impots.gouv.fr</H1>

            <form @submit.prevent="submitForm">
                <div class="form-group">
                    <label for="numeroFiscal">Numéro fiscal :</label>
                    <input type="text" id="numeroFiscal" name="numeroFiscal" v-model="numeroFiscal" required placeholder="Veuillez renseigner votre numéro fiscal" class="focus-animation">
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe :</label>
                    <input type="password" id="password" name="password" v-model="password" required placeholder="mot de passe" class="focus-animation">
                </div>
                
                    <div class="form-actions-validate-cancel-form">
                        <router-link to="/choixDuCompteBancaire" custom v-slot="{ navigate }"> 
                         <button class="validate-button" type="submit" @click="navigate" >Connexion</button>
                        </router-link>
                    <button class="cancel-button" type="button" @click="annuler">Annuler</button>
                </div>
            </form>
            <span>Numero fiscal perdu | Mot de passe oublié</span>
        </div>
    </div>
    <div class="text-explication">
    <H1>Je n'ai pas encore d'espace particulier sur impots.gouv.fr</H1>
  </div>
  <button class="Create-espace-particluier-bouton">Créer mon espace particulier</button>
  <div class="text-explication">
    <p>En cliquant sur ce bouton vous serez dirigé vers le site impots.gouv.fr</p>
    <p>à l'issue de la procédure, vous pourez retourner sur votre site afin d'effectuer votre paiement</p>
  </div>

  </div>
</template>

<script>
import { defineComponent, computed } from 'vue';

export default defineComponent({
  name: 'ConexionFiscale',
  setup() {

    return {
        numeroFiscal: '',
      submitForm() {
        this.$router.push({ name: 'SelectionFacture' });
      },
      annuler() {
        this.$router.go(-1);
      },
    };
  },
});
</script>

<style>
.form-actions-validate-cancel-form{
    margin-bottom: 2vh;
}
.form-group{
    margin-top: 2vh;
    margin-bottom: 2vh;
}
</style>