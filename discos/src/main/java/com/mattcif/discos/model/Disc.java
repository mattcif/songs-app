package com.mattcif.discos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titleDisc;

    private Year releaseYear;

    private String coverUrl;

    @OneToMany(mappedBy = "disc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackMusic> trackMusicList;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;


}
