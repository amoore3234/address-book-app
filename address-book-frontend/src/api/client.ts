const BASE_URL: string = import.meta.env.VITE_API_URL;
console.log('base url', BASE_URL);

/**
 * Generic request wrapper using native Fetch types
 */
const request = async (endpoint: string, options: RequestInit = {}): Promise<string> => {
  const url = `${BASE_URL}${endpoint}`;

  const response = await fetch(url, options);

  if (!response.ok) {
    throw new Error(`HTTP error! status: ${response.status}`);
  }

  return response.text();
};

export const apiClient = {
  get: (endpoint: string): Promise<string> => 
    request(endpoint, { method: 'GET' }),

  post: <T>(endpoint: string, body: T): Promise<string> =>
    request(endpoint, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    })
};