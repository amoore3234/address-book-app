import { apiClient } from "./client";

export const api = {
  
  addresses: async (): Promise<string> => {
    return apiClient.get("/api/addressBooks")
  },
  search: (item: string): Promise<string> => 
    apiClient.get(`/api/addressBook/search/${item}`),
};