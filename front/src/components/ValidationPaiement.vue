<template>
    <div class="page-container">
  
      <div class="banner-container">
  
          <div class="dark-banner">
              <H1>Validation du paiement</H1>
            
              <div class="reference-facture-validation-paiement">

                <div class="reference-particuliere-validation-paiement">
              <h4>Référence de la facture</h4>
              <p>TEST-ACTIVATION</p>
            </div>

              <div class="reference-particuliere-validation-paiement">
              <h4>Compte Bancaire</h4>
              <p>FR76-XXXX-XXXX-XXXX-XXXX-XXXX-077</p>
            </div>

              <div class="reference-particuliere-validation-paiement">
              <h4>Montant</h4>
              <p>300.00$</p>
            </div>
        </div>


        <div class="form-actions-validate-cancel-form">
             <router-link to="/confirmationDePaiement" custom v-slot="{ navigate }"> 
              <button class="validate-button" type="submit" @click="navigate" >Valider</button>
             </router-link>
              <button class="cancel-button" type="button" @click="annuler">Annuler</button>
            </div>


          </div>
      </div>
    <div class="text-explication">
      <p>Je valide les informations induquées et autorise le comptable public à présenter un ordre de prélèvement sur le compte bancaire que j'ai sélectionné</p>
    </div>
  
    </div>
  </template>

  <script>
  import { defineComponent, computed } from 'vue';
  
  export default defineComponent({
    name: 'ValidationPaiement',
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

  h4{
    font-size: 0.9em;
    font-weight: 600;
    padding: 1vh;
    color: black;
    border-bottom: 0.3vh solid black;
  }

  p{
    padding: 1vh;
  }
  .reference-particuliere-validation-paiement{
    justify-content: center;
    align-items: center;
    color: black;
    margin: 1vh;
    background-color: rgb(172, 172, 172);
  }

  .reference-facture-validation-paiement{
    text-align: center;
    display: flex;
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