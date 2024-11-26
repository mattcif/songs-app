package com.mattcif.discos.dto.requestDto;

import com.mattcif.discos.model.MusicalGenre;
import com.mattcif.discos.model.TrackMusic;
import lombok.Data;

import java.time.Year;
import java.util.List;

@Data
public class DiscRequestDTO {

    private String titleDisc;
    private Year releaseYear;
    private String coverUrl;
    private List<TrackMusic> trackMusicList;
    private List<MusicalGenre> musicalGenreList;

}
