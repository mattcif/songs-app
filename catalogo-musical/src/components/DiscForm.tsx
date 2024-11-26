import React, { useState } from "react";
import { useDiscDataMutate } from "../hooks/useDiscDataMutate";
import { DiscData } from "../interface/DiscData";

const DiscForm: React.FC = () => {
  const { mutate, isLoading, isError, isSuccess } = useDiscDataMutate();
  const [formData, setFormData] = useState<DiscData>({
    titleDisc: "",
    releaseYear: new Date().getFullYear(), // Definindo como número
    coverUrl: "",
    artist: {
      artistId: 0,
      artistName: "",
      discList: [],
      artistMusicalGenreList: []
    }
  });

  // Função para lidar com alterações nos campos do formulário
  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: name === "releaseYear" ? Number(value) : value // Convertendo para número se for 'releaseYear'
    }));
  };

  const handleArtistChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData(prev => ({
      ...prev,
      artist: { ...prev.artist, artistName: e.target.value }
    }));
  };

  // Função para submeter o formulário
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    mutate(formData);
  };

  return (
    <div>
      <h1>Create New Disc</h1>
      {isSuccess && <div>Disc created successfully!</div>}
      {isError && <div>Error creating disc. Please try again.</div>}
      
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="titleDisc">Title</label>
          <input
            type="text"
            id="titleDisc"
            name="titleDisc"
            value={formData.titleDisc}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label htmlFor="releaseYear">Release Year</label>
          <input
            type="number"
            id="releaseYear"
            name="releaseYear"
            value={formData.releaseYear}
            onChange={handleChange} // Usando handleChange para garantir que 'releaseYear' seja um número
            required
          />
        </div>

        <div>
          <label htmlFor="coverUrl">Cover URL</label>
          <input
            type="text"
            id="coverUrl"
            name="coverUrl"
            value={formData.coverUrl}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label htmlFor="artistName">Artist Name</label>
          <input
            type="text"
            id="artistName"
            name="artistName"
            value={formData.artist.artistName}
            onChange={handleArtistChange}
            required
          />
        </div>

        <div>
          <button type="submit" disabled={isLoading}>
            {isLoading ? "Creating..." : "Create Disc"}
          </button>
        </div>
      </form>
    </div>
  );
};

export default DiscForm;
