// path: src/api/collectivite-api.ts
import apiClient from './api-client';
import type { Collectivite } from '@/types/CollectiviteType';

export const fetchCollectiviteById = (id: number) => {
  return apiClient.get<Collectivite>(`/api/collectivite/${id}`);
};

export const fetchAllCollectivites = () => {
  return apiClient.get<Collectivite[]>(`/api/collectivite`);
};

export const createCollectivite = (collectiviteDto: Collectivite) => {
  return apiClient.post<Collectivite>(`/api/collectivite`, collectiviteDto);
};

export const updateCollectivite = (id: number, collectiviteDto: Collectivite) => {
  return apiClient.put<Collectivite>(`/api/collectivite/${id}`, collectiviteDto);
};

export const deleteCollectivite = (id: number) => {
  return apiClient.delete(`/api/collectivite/${id}`);
};

export const checkCollectiviteByCode = (codeCollectivite: string) => {
  return apiClient.get<boolean>(`/api/collectivite/checkCodeCollectivite`, {
    params: { codeCollectivite }
  });
};
