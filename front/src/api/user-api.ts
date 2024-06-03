//path: src/api/user-api.ts
import axios from 'axios';
import { API_BASE_URL } from './api-config';
import { User } from '@/types/UserType';

export const fetchUserById = (id: number) => {
    return axios.get<User>(`${API_BASE_URL}/api/user/${id}`);
};

export const fetchAllUsers = () => {
    return axios.get<User[]>(`${API_BASE_URL}/api/user`);
};

export const createUser = (userDto: User) => {
    return axios.post<User>(`${API_BASE_URL}/api/user`, userDto);
};

export const updateUser = (id: number, userDto: User) => {
    return axios.put<User>(`${API_BASE_URL}/api/user/${id}`, userDto);
};

export const deleteUser = (id: number) => {
    return axios.delete(`${API_BASE_URL}/api/user/${id}`);
};

export const checkUserByFirstName = (firstName: string) => {
    return axios.get<boolean>(`${API_BASE_URL}/api/user/checkFirstName`, {
        params: { firstName }
    });
};

export const checkUserByEmail = (email: string) => {
    return axios.get<boolean>(`${API_BASE_URL}/api/user/checkEmail`, {
        params: { email }
    });
};
