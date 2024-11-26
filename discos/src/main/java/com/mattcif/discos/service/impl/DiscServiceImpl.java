package com.mattcif.discos.service.impl;

import com.mattcif.discos.dto.requestDto.DiscRequestDTO;
import com.mattcif.discos.model.Artist;
import com.mattcif.discos.model.Disc;
import com.mattcif.discos.model.MusicalGenre;
import com.mattcif.discos.repositories.ArtistRepository;
import com.mattcif.discos.repositories.DiscRepository;
import com.mattcif.discos.repositories.MusicalGenreRepository;
import com.mattcif.discos.service.DiscService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscServiceImpl implements DiscService {

    @Autowired
    DiscRepository discRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    MusicalGenreRepository musicalGenreRepository;

    @Override
    public List<Disc> getAllDiscs() {
        return discRepository.findAll().stream().toList();
    }

    @Override
    @Transactional
    public Disc createDisc(DiscRequestDTO data) {
        // Recupera o artista "Desconhecido" ou lança exceção caso não seja encontrado
        Artist artist = artistRepository.findByArtistName("Desconhecido")
                .orElseThrow(() -> new IllegalStateException("Artista desconhecido não encontrado"));


        // Cria e popula o objeto Disc
        Disc disc = new Disc();
        disc.setTitleDisc(data.getTitleDisc());
        disc.setCoverUrl(data.getCoverUrl());
        disc.setReleaseYear(data.getReleaseYear());
        disc.setTrackMusicList(data.getTrackMusicList());
        disc.setArtist(artist);

        // Salva o disco
        return discRepository.save(disc);
    }

}
