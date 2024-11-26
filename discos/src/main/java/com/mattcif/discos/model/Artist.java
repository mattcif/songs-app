package com.mattcif.discos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long artistId;

    private String artistName;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Disc> discList;

    @ManyToMany
    @JoinTable(
            name = "artist_genre",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<MusicalGenreEntity> artistMusicalGenreList;

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
