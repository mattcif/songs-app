import React from 'react';
import { useDiscData } from '../hooks/useDiscData';  // Importando o hook que você criou
import { DiscData } from '../interface/DiscData';  // Importando a interface para tipar os dados

const DiscList: React.FC = () => {
  const { data, isLoading, isError } = useDiscData();  // Usando o hook para buscar os dados

  // Exibe um indicador de carregamento enquanto os dados são obtidos
  if (isLoading) {
    return <div>Loading...</div>;
  }

  // Exibe uma mensagem de erro caso a requisição falhe
  if (isError) {
    return <div>Error fetching discs</div>;
  }

  return (
    <div>
      <h1>Discs List</h1>
      <div className="disc-list">
        {/* Mapeia os dados dos discos e exibe cada um */}
        {data?.map((disc: DiscData) => (
          <div key={disc.id} className="disc-card">
            <h2>{disc.titleDisc}</h2>
            <p>Release Year: {disc.releaseYear}</p>
            <img src={disc.coverUrl} alt={disc.titleDisc} width={150} height={150} />
            <p>Artist: {disc.artist.artistName}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default DiscList;
