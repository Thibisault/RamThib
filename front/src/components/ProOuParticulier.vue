/** Pro Ou Particulier vue. Path :"src/views/ProOuParticulier.vue" */
<template>
    <div class="pro-ou-particulier-container">
      <div class="banner-container">
        <div class="dark-banner">
          <button @click="navigate('professionnel')" class="pro-btn focus-animation">Professionnel</button>
          <button @click="navigate('particulier')" class="particulier-btn focus-animation">Particulier</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { defineComponent } from 'vue';
  import { useRouter } from 'vue-router'; 
  
  export default defineComponent({
    name: 'ProOuParticulier',
    setup() {
      const router = useRouter(); 
      const navigate = (type) => {
        console.log('Je suis passé par là' , type)
        router.push({ name: 'ChoisirMoyenPayement', params: { userType: type } }); 
      };
      return {
        navigate,
      };
    },
  });
  </script>
  
<style scoped>
.pro-ou-particulier-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.banner-container {
  text-align: center;
  margin-bottom: 20px;
}

.dark-banner {
  padding: 20px;
  border-radius: 10px;
  background-color: rgba(0,0,0,0.7);
  width: 80%;
  margin: auto;
}

.pro-btn, .particulier-btn {
  padding: 15px 30px;
  cursor: pointer;
  border: none;
  border-radius: 5px;
  font-size: 18px;
  letter-spacing: 1px;
  transition: all 0.3s ease;
  margin: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.pro-btn {
  background-color: #007bff;
  color: white;
}

.particulier-btn {
  background-color: #28a745;
  color: white;
}

.pro-btn:hover, .particulier-btn:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.pro-btn:focus, .particulier-btn:focus {
  outline: none;
}
</style>
  