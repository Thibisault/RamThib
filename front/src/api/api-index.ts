//path: src/api/api-index.ts
import { fetchFactureById, fetchAllFactures, createFacture, updateFacture, deleteFacture, un, checkReferenceFactureAndMontant } from './facture-api';
import { fetchUserById, fetchAllUsers, createUser, updateUser, deleteUser, checkUserByFirstName, checkUserByEmail } from './user-api';
import { fetchCollectiviteById, fetchAllCollectivites, createCollectivite, updateCollectivite, deleteCollectivite, checkCollectiviteByCode } from './collectivite-api';

export const FactureAPI = {
    un,
    fetchFactureById,
    fetchAllFactures,
    createFacture,
    updateFacture,
    deleteFacture,
    checkReferenceFactureAndMontant
};

export const UserAPI = {
    fetchUserById,
    fetchAllUsers,
    createUser,
    updateUser,
    deleteUser,
    checkUserByFirstName,
    checkUserByEmail
};

export const CollectiviteAPI = {
    fetchCollectiviteById,
    fetchAllCollectivites,
    createCollectivite,
    updateCollectivite,
    deleteCollectivite,
    checkCollectiviteByCode
};
