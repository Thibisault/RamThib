<template>
  <div class="mgmt-global-container">
    <div class="mgmt-nav">
      <router-link to="/pageAcceuil">Acceuil</router-link>
      <router-link to="/usersManagement" :class="{ active: $route.path === '/usersManagement' }">Gérer les utilisateurs</router-link>
      <router-link to="/factureManagement">Gérer les factures</router-link>
      <router-link to="/collectiviteManagement" :class="{ active: $route.path === '/collectiviteManagement' }">Gérer les collectivités</router-link>
    </div>
    <div class="mgmt-container">
      <h1 class="mgmt-heading">Gestion des utilisateurs</h1>
      <input type="text" v-model="search" placeholder="Search users..." class="mgmt-search-input"/>
      <hr class="mgmt-divider"/>

      <!-- Creation form for new user -->
      <form v-if="!selectedUser.id" @submit.prevent="handleCreate" class="mgmt-form">
        <div class="mgmt-input-group">
          <input class="mgmt-input" v-model="formUser.email" placeholder="Email" type="email" />
          <input class="mgmt-input" v-model="formUser.firstName" placeholder="First Name" />
          <input class="mgmt-input" v-model="formUser.lastName" placeholder="Last Name" />
          <input class="mgmt-input" v-model="formUser.password" placeholder="Password" type="password" />
          <input class="mgmt-input" v-model="formUser.numeroFiscal" placeholder="Numéro Fiscal" />
        </div>
        <button type="submit" class="mgmt-button">Add User</button>
      </form>
      <hr class="mgmt-divider"/>

      <div class="mgmt-user-list">
        <div v-for="user in filteredUsers" :key="user.id" class="mgmt-user-item">
          <template v-if="selectedUser.id === user.id">
            <!-- Update form that replaces the user display -->
            <form @submit.prevent="handleUpdate" class="mgmt-form-update">
              <div class="mgmt-input-group">
                <input class="mgmt-input" v-model="selectedUser.email" placeholder="Email" type="email" />
                <input class="mgmt-input" v-model="selectedUser.firstName" placeholder="First Name" />
                <input class="mgmt-input" v-model="selectedUser.lastName" placeholder="Last Name" />
                <input class="mgmt-input" v-model="selectedUser.password" placeholder="Password" type="password" />
                <input class="mgmt-input" v-model="selectedUser.numeroFiscal" placeholder="Numéro Fiscal" />
              </div>
              <button type="submit" class="mgmt-button">Update User</button>
              <button @click="cancelUpdate" class="mgmt-form-update-cancel">Cancel</button>
            </form>
          </template>
          <template v-else>
            <!-- User item display -->
            <p>{{ user.email }} - {{ user.firstName }} {{ user.lastName }} - {{ user.numeroFiscal }}</p>
            <div class="mgmt-actions">
              <button @click="startUpdate(user)" class="mgmt-button">Edit</button>
              <button @click="handleDelete(user.id)" class="mgmt-button">Delete</button>
            </div>
          </template>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted, ref, computed } from 'vue';
import { UserAPI } from '@/api/api-index';

export default {
  setup() {
    const users = ref([]);
    const formUser = ref({ id: null, email: '', firstName: '', lastName: '', password: '', numeroFiscal: '' });
    const selectedUser = ref({ id: null, email: '', firstName: '', lastName: '', password: '', numeroFiscal: '' });
    const search = ref('');

    const fetchUsers = async () => {
      try {
        const response = await UserAPI.fetchAllUsers();
        users.value = response.data;
      } catch (error) {
        console.error('Error fetching users:', error);
      }
    };
    onMounted(fetchUsers);

    const filteredUsers = computed(() => {
      return users.value.filter(user => 
        user.email.toLowerCase().includes(search.value.toLowerCase()) ||
        user.firstName.toLowerCase().includes(search.value.toLowerCase()) ||
        user.lastName.toLowerCase().includes(search.value.toLowerCase()) ||
        user.numeroFiscal.toLowerCase().includes(search.value.toLowerCase())
      );
    });

    const handleCreate = async () => {
      try {
        const response = await UserAPI.createUser(formUser.value);
        users.value.push(response.data);
        formUser.value = { id: null, email: '', firstName: '', lastName: '', password: '', numeroFiscal: '' };
      } catch (error) {
        console.error('Error creating user:', error);
      }
    };

    const handleDelete = async (id) => {
      try {
        const response = await UserAPI.deleteUser(id);
        if (response.status === 200) {
          users.value = users.value.filter(user => user.id !== id);
        } else {
          console.error('Failed to delete user, server responded with status:', response.status);
        }
      } catch (error) {
        console.error('Error deleting user:', error);
      }
    };

    const startUpdate = (user) => {
      selectedUser.value = user.id === selectedUser.value.id ? { id: null } : user;
    };

    const handleUpdate = async () => {
      try {
        const response = await UserAPI.updateUser(selectedUser.value.id, selectedUser.value);
        const index = users.value.findIndex(u => u.id === selectedUser.value.id);
        users.value[index] = response.data;
        cancelUpdate();
      } catch (error) {
        console.error('Error updating user:', error);
      }
    };

    const cancelUpdate = () => {
      selectedUser.value = { id: null, email: '', firstName: '', lastName: '', password: '', numeroFiscal: '' };
    };

    return {
      users,
      formUser,
      selectedUser,
      handleCreate,
      handleDelete,
      startUpdate,
      handleUpdate,
      cancelUpdate,
      search,
      filteredUsers
    };
  }
};
</script>

<style>
  @import '@/assets/management-styles.css';
</style>
