// path: src/api/facture-api.ts
import apiClient from './api-client'; 
import type { Facture } from '@/types/FactureType';


export const un = (id: number) => {
    return apiClient.get<Facture>(`/api/facture/${id}`);
};

export const fetchFactureById = (id: number) => {
    return apiClient.get<Facture>(`/api/facture/${id}`);
};

export const fetchAllFactures = () => {
    return apiClient.get<Facture[]>(`/api/facture`);
};

export const createFacture = (factureDto: Facture) => {
    return apiClient.post<Facture>(`/api/facture`, factureDto);
};

export const updateFacture = (id: number, factureDto: Facture) => {
    return apiClient.put<Facture>(`/api/facture/${id}`, factureDto);
};

export const deleteFacture = (id: number) => {
    return apiClient.delete(`/api/facture/${id}`);
};

// Vérification de la référence de facture et du montant
export const checkReferenceFactureAndMontant = (referenceFacture: string, montantFacture: number) => {
    return apiClient.get<boolean>(`/api/facture/checkReferenceFacture`, {
        params: { referenceFacture, montantFacture }
    });
};