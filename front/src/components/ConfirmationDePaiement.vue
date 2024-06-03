<template>
    <div class="page-container">
  
      <div class="banner-container">
  
          <div class="dark-banner">
              <H1>Confirmation de paiement</H1>
            
            <p>
                Paiement de test
            </p>
            <p>
                Votre ordre de paiement a bien été enregistré le JJ/MM/AAAA à HH:MM
            </p>
            <p>
                Au profit de : Regie Fictive
            </p>
            <p>
                Sous le numéro 112233445566-tip sur le compte banvaire FR76-XXXX-XXXX-XXXX-XXXX-XXXX-077
            </p>
            <p>
                (Etablissement teneur du compte : BANQUE DE FRANCE - COMPTE DE TEST et titurlaire du compte : Usager fictif) pour un montant de 300.00$.
            </p>
            <p>
                Le mandat qui autorise ce prélèvement pour la référence Unique de Mandat (RUM) n²6712c18d11e84f87658723f7a55d.
            </p>
            <p>
                Vous serez prélevé sur votre compte 3 jours ouvrés à compter d'aujourd'hui soit le JJ/MM/AAAA.
            </p>
            <p>
                Vous recevrez la notification de votre paiement par courriel à l'adresse : test@operateur.fr
            </p>

        <div class="form-actions-validate-cancel-form">
             <router-link to="/" custom v-slot="{ navigate }"> 
              <button class="validate-button" type="submit" @click="navigate" >Fermer</button>
             </router-link>
            </div>

            
          </div>
      </div>
    </div>
  </template>

  <script>
  import { defineComponent, computed } from 'vue';
  
  export default defineComponent({
    name: 'ConfirmationDePaiement',
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

  p{
    font-weight: bold;
  }

  .group-compte-bancaire{
    cursor: pointer;
    margin-top: 1vh;
    background-color: rgb(0, 0, 0);
    color: white;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    text-decoration: none;
    border: 0.1vh solid white;
    padding: 1vh;
    border-left: 1vh solid blue;
  }
  .group-compte-bancaire:hover{
    transform: scale(2);
    background-color: rgb(133, 133, 133);
    color: rgb(0, 0, 0);
  }
  .form-actions-validate-cancel-form{
      margin-bottom: 2vh;
  }
  .form-group{
      margin-top: 2vh;
      margin-bottom: 2vh;
  }
  </style>