package com.mattcif.discos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrackMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trackId;

    private String trackName;

    @ManyToOne
    @JoinColumn(name = "disc_id")
    @JsonIgnore
    private Disc disc;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "track_music_genre",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<MusicalGenre> trackMusicalGenreList;
}
