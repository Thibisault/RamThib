<template>
    <div class="page-container">
  
      <div class="banner-container">
  
            <div class="dark-banner">


              <H1>Choix du compte bancaire</H1>
                <div class="text-explication text-in-dark-banner">
                <p>Bonjour usager fictif</p>
                <p>Veuillez sléctionner le compte bancaire que vous désirez utiliser pour votre paiement</p>
                </div>
              <router-link to="/validationPaiement" custom v-slot="{ navigate }"> 
              <button @click="navigate" class="group-compte-bancaire focus-animation">
                <p>Banque de france</p>
                <p>XXTS83</p>
                <p>Compte de test</p>
              </button>
              </router-link>

                  <div class="form-actions-validate-cancel-form">
                    <button class="cancel-button" type="button" @click="annuler">Annuler</button>
                  </div>
          </div>
      </div>
    <div class="text-explication">
      <p>Conformément à a loi "informatique et libetés" du 6 janvier 1978 modifiée, vous pouvez exercer votre droit d'accès et de réctification aux informations
        qui vous concernent en adressant votre demande à l'adresse suivante : dp.usager-payfip@dgfip.finance.gouv.fr
      </p>
    </div>
  
    </div>
  </template>
  
  <script>
  import { defineComponent, computed } from 'vue';
  
  export default defineComponent({
    name: 'ChoixDuCompteBancaire',
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

  h1 {
    border-bottom: 0.1vh solid white;
  }

  .text-in-dark-banner{
    border-bottom: 0.05vh solid white;
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