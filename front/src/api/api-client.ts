// path: src/api/api-client.ts
import axios from 'axios';
import { API_BASE_URL } from './api-config';

const apiClient = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json'
    }
});

export default apiClient;
