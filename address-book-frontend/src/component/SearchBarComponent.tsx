import React, { useState, useEffect } from 'react';
import { api } from "../api/api";
import { useDebounce } from '../hooks/useDebounce';
import { AddressData } from '../types/address-book';

const SearchBarComponent: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [results, setResults] = useState<AddressData[]>([]);
  const [isLoading, setIsLoading] = useState(false);
  
  // Only triggers API when user stops typing for 500ms
  const debouncedSearch = useDebounce(searchTerm, 500);

  useEffect(() => {
    const controller = new AbortController();

    const fetchResults = async () => {
      if (!debouncedSearch) {
        setResults([]);
        return;
      }

      setIsLoading(true);
      try {
        // Path variable and AbortSignal for the Java backend call
        const response = await api.search(searchTerm);
        
        // Assuming your backend returns a JSON string to parse
        const data: AddressData[] = JSON.parse(response);
        setResults(data);
      } catch (err: any) {
        if (err.name !== 'AbortError') {
          console.error("Search failed:", err);
        }
      } finally {
        setIsLoading(false);
      }
    };

    fetchResults();

    // Cleanup: abort the fetch if the component unmounts or search changes
    return () => controller.abort();
  }, [debouncedSearch]);

  return (
    <div className="search-container">
      <input
        type="text"
        placeholder="Search for something..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      
      {isLoading && <p>Loading...</p>}
      
      <ul>
        {results.map((item) => (
          <li key={item.id}>{item.firstName} {item.lastName}</li>
        ))}
      </ul>
    </div>
  );
};

export default SearchBarComponent;