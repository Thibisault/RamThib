import { createRouter, createWebHistory } from 'vue-router';
import PageAcceuil from '../components/PageAcceuil.vue';
import UsersManagement from '../components/UsersManagement.vue';
import FactureManagement from '../components/FactureManagement.vue';
import CollectiviteManagement from '../components/CollectiviteManagement.vue';
import SelectionCollectivite from '../components/SelectionCollectivite.vue';
import SelectionFacture from '../components/SelectionFacture.vue'; 
import ProOuParticulier from '../components/ProOuParticulier.vue'; 
import ChoisirMoyenPayement from '../components/ChoisirMoyenPayement.vue';
import ConexionFiscale from '../components/ConexionFiscale.vue'; 
import ChoixDuCompteBancaire from '../components/ChoixDuCompteBancaire.vue'; 
import ValidationPaiement from '../components/ValidationPaiement.vue';
import ConfirmationDePaiement from '../components/ConfirmationDePaiement.vue'; 
import VuePrincipal from '@/components/VuePrincipal.vue';

const routes = [
  {
    path: '/',  
    name: 'PageAcceuil',
    component: VuePrincipal
  },
  {
    path: '/usersManagement',
    name: 'UsersManagement',
    component: UsersManagement
  },
  {
    path: '/factureManagement',
    name: 'FactureManagement',
    component: FactureManagement
  },
  {
    path: '/collectiviteManagement',
    name: 'CollectiviteManagement',
    component: CollectiviteManagement
  },
  {
    path: '/selectionCollectivite',
    name: 'SelectionCollectivite',
    component: SelectionCollectivite,
    meta: { title: 'SelectionCollectivite' },
  },
  {
    path: '/selectionFacture',
    name: 'SelectionFacture',
    component: SelectionFacture,
    meta: { title: 'SelectionFacture' },
  },
  {
    path: '/proOuParticulier',
    name: 'ProOuParticulier',
    component: ProOuParticulier,
    meta: { title: 'ProOuParticulier' },
  },
  {
    path: '/choisirMoyenPayement/:userType',
    name: 'ChoisirMoyenPayement',
    component: ChoisirMoyenPayement,
    meta: { title: 'ChoisirMoyenPayement' },
  },
  {
    path: '/conexionFiscale',
    name: 'ConexionFiscale',
    component: ConexionFiscale,
    meta: { title: 'ConexionFiscale' },
  },
  {
    path: '/choixDuCompteBancaire',
    name: 'ChoixDuCompteBancaire',
    component: ChoixDuCompteBancaire,
    meta: { title: 'ChoixDuCompteBancaire' },
  },
  {
    path: '/validationPaiement',
    name: 'ValidationPaiement',
    component: ValidationPaiement,
    meta: { title: 'ValidationPaiement' },
  },
  {
    path: '/confirmationDePaiement',
    name: 'ConfirmationDePaiement',
    component: ConfirmationDePaiement,
    meta: { title: 'ConfirmationDePaiement' },
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
