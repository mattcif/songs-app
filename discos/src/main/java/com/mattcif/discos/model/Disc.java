package com.mattcif.discos.model;

import com.mattcif.discos.dto.requestDto.DiscRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titleDisc;

    private Year releaseYear;

    private String coverUrl;

    @OneToMany(mappedBy = "disc", cascade = CascadeType.ALL)
    private List<TrackMusic> trackMusicList;

    @ManyToMany
    @JoinTable(
            name = "disc_genre",
            joinColumns = @JoinColumn(name = "disc_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @Enumerated(EnumType.STRING)
    private List<MusicalGenreEntity> musicalGenreList;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Disc(DiscRequestDTO data) {
    }
}
