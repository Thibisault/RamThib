<script setup lang="ts">
//path: src/App.vue
</script>

<template>
  <div>
    <div class="mgmt-nav">
    <router-link to="/">Acceuil</router-link>
    <router-link to="/usersManagement">Gérer les utilisateurs</router-link>
    <router-link to="/factureManagement">Gérer les factures</router-link>
    <router-link to="/collectiviteManagement">Gérer les collectivites</router-link>
  </div>
    <router-view />
  </div>
</template>

<style scoped>

</style>
