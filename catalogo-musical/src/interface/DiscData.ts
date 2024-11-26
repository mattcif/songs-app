import { Key } from "react";

export interface DiscData {
    id?: Key | null | undefined;
    titleDisc: string;
    releaseYear: number; // Alterado para number
    coverUrl: string;
    artist: {
      artistId: number;
      artistName: string;
      discList: any[];
      artistMusicalGenreList: any[];
    };
  }
  