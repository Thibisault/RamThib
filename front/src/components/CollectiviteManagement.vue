<template>
    <div class="mgmt-global-container">
      <div class="mgmt-nav">
        <router-link to="/pageAcceuil">Acceuil</router-link>
        <router-link to="/usersManagement" :class="{ active: $route.path === '/usersManagement' }">Gérer les utilisateurs</router-link>
        <router-link to="/factureManagement">Gérer les factures</router-link>
        <router-link to="/collectiviteManagement" :class="{ active: $route.path === '/collectiviteManagement' }">Gérer les collectivités</router-link>
      </div>
      <div class="mgmt-container">
        <h1 class="mgmt-heading">Gestion des collectivités</h1>
        <input type="text" v-model="search" placeholder="Search collectivites..." class="mgmt-search-input"/>
        <hr class="mgmt-divider"/>
  
        <!-- Creation form for new collectivity -->
        <form v-if="!selectedCollectivite.id" @submit.prevent="handleCreate" class="mgmt-form">
          <div class="mgmt-input-group">
            <input class="mgmt-input" v-model="formCollectivite.nomCollectivite" placeholder="Nom de la Collectivité" />
            <input class="mgmt-input" v-model="formCollectivite.codeCollectivite" placeholder="Code de la Collectivité" />
          </div>
          <button type="submit" class="mgmt-button">Add Collectivity</button>
        </form>
        <hr class="mgmt-divider"/>
  
        <div class="mgmt-user-list">
          <div v-for="collectivite in filteredCollectivites" :key="collectivite.id" class="mgmt-user-item">
            <template v-if="selectedCollectivite.id === collectivite.id">
              <!-- Update form that replaces the collectivity display -->
              <form @submit.prevent="handleUpdate" class="mgmt-form-update">
                <div class="mgmt-input-group">
                  <input class="mgmt-input" v-model="selectedCollectivite.nomCollectivite" placeholder="Nom de la Collectivité" />
                  <input class="mgmt-input" v-model="selectedCollectivite.codeCollectivite" placeholder="Code de la Collectivité" />
                </div>
                <button type="submit" class="mgmt-button">Update Collectivity</button>
                <button @click="cancelUpdate" class="mgmt-form-update-cancel">Cancel</button>
              </form>
            </template>
            <template v-else>
              <!-- Collectivity item display -->
              <p>{{ collectivite.nomCollectivite }} - {{ collectivite.codeCollectivite }}</p>
              <div class="mgmt-actions">
                <button @click="startUpdate(collectivite)" class="mgmt-button">Edit</button>
                <button @click="handleDelete(collectivite.id)" class="mgmt-button">Delete</button>
              </div>
            </template>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { onMounted, ref, computed } from 'vue';
  import { CollectiviteAPI } from '@/api/api-index';
  
  export default {
    setup() {
      const collectivites = ref([]);
      const formCollectivite = ref({ id: null, nomCollectivite: '', codeCollectivite: '' });
      const selectedCollectivite = ref({ id: null, nomCollectivite: '', codeCollectivite: '' });
      const search = ref('');
  
      const fetchCollectivites = async () => {
        try {
          const response = await CollectiviteAPI.fetchAllCollectivites();
          collectivites.value = response.data;
        } catch (error) {
          console.error('Error fetching collectivites:', error);
        }
      };
      onMounted(fetchCollectivites);
  
      const filteredCollectivites = computed(() => {
        return collectivites.value.filter(collectivite => 
          collectivite.nomCollectivite.toLowerCase().includes(search.value.toLowerCase()) ||
          collectivite.codeCollectivite.toLowerCase().includes(search.value.toLowerCase())
        );
      });
  
      const handleCreate = async () => {
        try {
          const response = await CollectiviteAPI.createCollectivite(formCollectivite.value);
          collectivites.value.push(response.data);
          formCollectivite.value = { id: null, nomCollectivite: '', codeCollectivite: '' };
        } catch (error) {
          console.error('Error creating collectivity:', error);
        }
      };
  
      const handleDelete = async (id) => {
        try {
          await CollectiviteAPI.deleteCollectivite(id);
          collectivites.value = collectivites.value.filter(collectivite => collectivite.id !== id);
        } catch (error) {
          console.error('Error deleting collectivity:', error);
        }
      };
  
      const startUpdate = (collectivite) => {
        selectedCollectivite.value = collectivite.id === selectedCollectivite.value.id ? { id: null } : collectivite;
      };
  
      const handleUpdate = async () => {
        try {
          const response = await CollectiviteAPI.updateCollectivite(selectedCollectivite.value.id, selectedCollectivite.value);
          const index = collectivites.value.findIndex(c => c.id === selectedCollectivite.value.id);
          collectivites.value[index] = response.data;
          cancelUpdate();
        } catch (error) {
          console.error('Error updating collectivity:', error);
        }
      };
  
      const cancelUpdate = () => {
        selectedCollectivite.value = { id: null, nomCollectivite: '', codeCollectivite: '' };
      };
  
      return {
        collectivites,
        formCollectivite,
        selectedCollectivite,
        handleCreate,
        handleDelete,
        startUpdate,
        handleUpdate,
        cancelUpdate,
        search,
        filteredCollectivites
      };
    }
  };
  </script>
  
  <style>
    @import '@/assets/management-styles.css';
  </style>
  