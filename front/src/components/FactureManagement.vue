<template>


<div class="mgmt-global-container">
  <div class="mgmt-nav">
    <router-link to="/pageAcceuil">Acceuil</router-link>
    <router-link to="/usersManagement">Gérer les utilisateurs</router-link>
    <router-link to="/factureManagement" :class="{ active: $route.path === '/factureManagement' }">Gérer les factures</router-link>
  </div>

    <div class="mgmt-container">
      <h1 class="mgmt-heading">Gestion des factures</h1>
      <input type="text" v-model="search" placeholder="Search invoices..." class="mgmt-search-input"/>
      <hr class="mgmt-divider"/>

            <!-- Creation form for new facture -->
            <form v-if="!selectedFacture.id" @submit.prevent="handleCreate" class="mgmt-form">
        <div class="mgmt-input-group">
          <input class="mgmt-input" v-model="formFacture.typeFacture" placeholder="Type de Facture" />
          <input class="mgmt-input" v-model.number="formFacture.montantFacture" placeholder="Montant" type="number" />
          <input class="mgmt-input" v-model="formFacture.referenceFacture" placeholder="Référence" />
        </div>
        <button type="submit" class="mgmt-button">Add Facture</button>
      </form>
      <hr class="mgmt-divider"/>
  
      <div class="mgmt-user-list">
        <div v-for="facture in filteredFactures" :key="facture.id" class="mgmt-user-item">
          <template v-if="selectedFacture.id === facture.id">

            <!-- Update form -->
            <form @submit.prevent="handleUpdate" class="mgmt-form-update">
              <div class="mgmt-input-group">
                <input class="mgmt-input" v-model="selectedFacture.typeFacture" placeholder="Type de Facture" />
                <input class="mgmt-input" v-model.number="selectedFacture.montantFacture" placeholder="Montant" type="number" />
                <input class="mgmt-input" v-model="selectedFacture.referenceFacture" placeholder="Référence" />
              </div>
              <button type="submit" class="mgmt-button">Update Facture</button>
              <button @click="cancelUpdate" class="mgmt-form-update-cancel">Cancel</button>
            </form>
          </template>
          <template v-else>
            <p>{{ facture.typeFacture }} - {{ facture.montantFacture }} - {{ facture.referenceFacture }}</p>
            <div class="mgmt-actions">
              <button @click="startUpdate(facture)" class="mgmt-button">Edit</button>
              <button @click="handleDelete(facture.id)" class="mgmt-button">Delete</button>
            </div>
          </template>
        </div>
      </div>
    </div>
    </div>
  </template>
  

<script>
import { onMounted, ref, computed } from 'vue';
import { FactureAPI } from '../api/api-index';

export default {
    setup() {
    const factures = ref([]);
    const formFacture = ref({ id: null, typeFacture: '', montantFacture: 0, referenceFacture: '' });
    const selectedFacture = ref({ id: null, typeFacture: '', montantFacture: 0, referenceFacture: '' });
    const search = ref('');

    const fetchFactures = async () => {
      try {
        const response = await FactureAPI.fetchAllFactures();
        factures.value = response.data;
      } catch (error) {
        console.error('Error fetching factures:', error);
      }
    };

    onMounted(fetchFactures);

    const filteredFactures = computed(() => {
      return factures.value.filter(facture =>
        facture.typeFacture.toLowerCase().includes(search.value.toLowerCase()) ||
        facture.referenceFacture.toLowerCase().includes(search.value.toLowerCase())
      );
    });

    const handleCreate = async () => {
    try {
        const newFacture = {
        typeFacture: formFacture.value.typeFacture,
        montantFacture: formFacture.value.montantFacture,
        referenceFacture: formFacture.value.referenceFacture
        };
        
        const response = await FactureAPI.createFacture(newFacture);
        console.log("Response data:", response.data); // Pour déboguer et voir les données retournées

        if (response.data) {
        factures.value.push(response.data); // Mise à jour de l'état local avec la nouvelle facture
        formFacture.value = { id: null, typeFacture: '', montantFacture: 0, referenceFacture: '' }; // Réinitialisation du formulaire
        } else {
        console.error("No data returned on facture creation");
        }
    } catch (error) {
        console.error('Error creating facture:', error);
    }
    };



    const handleDelete = async (id) => {
      try {
        await FactureAPI.deleteFacture(id);
        factures.value = factures.value.filter(facture => facture.id !== id);
      } catch (error) {
        console.error('Error deleting facture:', error);
      }
    };

    const startUpdate = (facture) => {
      selectedFacture.value = facture.id === selectedFacture.value.id ? { id: null } : facture;
    };

    const handleUpdate = async () => {
      try {
        const response = await FactureAPI.updateFacture(selectedFacture.value.id, selectedFacture.value);
        const index = factures.value.findIndex(f => f.id === selectedFacture.value.id);
        factures.value[index] = response.data;
        cancelUpdate();
      } catch (error) {
        console.error('Error updating facture:', error);
      }
    };

    const cancelUpdate = () => {
      selectedFacture.value = { id: null, detail: '', amount: 0 };
    };

    return {
      factures,
      formFacture,
      selectedFacture,
      handleCreate,
      handleDelete,
      startUpdate,
      handleUpdate,
      cancelUpdate,
      search,
      filteredFactures
    };
  }
};
</script>

<style>
  @import '@/assets/management-styles.css';
</style>


  