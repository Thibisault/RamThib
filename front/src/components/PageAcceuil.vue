<template>
  <div>

    <div class="mgmt-nav">
    <router-link to="/pageAcceuil" :class="{ active: $route.path === '/' }">Acceuil</router-link>
    <router-link to="/usersManagement">Gérer les utilisateurs</router-link>
    <router-link to="/factureManagement">Gérer les factures</router-link>
  </div>
  <h1>Page d'accueil</h1>
    <p>Résultat de l'API : {{ apiResult }}</p>
  </div>
</template>


<script lang="ts">
//path: src/components/PageAcceuil.vue
import { defineComponent, ref, onMounted } from 'vue';
import { FactureAPI } from '../api/api-index'; 
  
export default defineComponent({
  setup() {
    const apiResult = ref('Chargement...');

    const loadData = async () => {
      try {
        const response = await FactureAPI.un();
        apiResult.value = response.data.toString(); 
      } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
        apiResult.value = 'Erreur lors du chargement des données';
      }
    };

    onMounted(() => {
      loadData();
    });

    return {
      apiResult
    };
  }
});
</script>
