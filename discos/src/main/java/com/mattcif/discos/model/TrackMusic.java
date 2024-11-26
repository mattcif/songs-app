package com.mattcif.discos.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TrackMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trackId;

    private String trackName;

    @ManyToOne
    @JoinColumn(name = "disc_id")
    private Disc disc;

    @ManyToMany
    @JoinTable(
            name = "track_music_genre",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<MusicalGenreEntity> trackMusicalGenreList;
}
