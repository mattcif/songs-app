package com.mattcif.discos.service.impl;

import com.mattcif.discos.dto.requestDto.DiscRequestDTO;
import com.mattcif.discos.model.Artist;
import com.mattcif.discos.model.Disc;
import com.mattcif.discos.repositories.ArtistRepository;
import com.mattcif.discos.repositories.DiscRepository;
import com.mattcif.discos.service.DiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscServiceImpl implements DiscService {

    @Autowired
    DiscRepository discRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Override
    public List<Disc> getAllDiscs() {
        return discRepository.findAll().stream().toList();
    }

    @Override
    public Disc createDisc(DiscRequestDTO data) {
        Artist artist = artistRepository.findByArtistName("Desconhecido")
                .orElseThrow(() -> new IllegalStateException("Artista desconhecido não encontrado"));


        Disc disc = new Disc();
        disc.setTitleDisc(data.getTitleDisc());
        disc.setCoverUrl(data.getCoverUrl());
        disc.setReleaseYear(data.getReleaseYear());
        disc.setTrackMusicList(data.getTrackMusicList());
        disc.setMusicalGenreList(data.getMusicalGenreList());
        disc.setArtist(artist);

        System.out.println(data);
        System.out.println(disc);
        return discRepository.save(disc);

    }
}
