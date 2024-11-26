package com.mattcif.discos.config;

import com.mattcif.discos.model.Artist;
import com.mattcif.discos.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistInitializer {

    private final ArtistRepository artistRepository;

    @Bean
    CommandLineRunner init() {
        return args -> {
            if (artistRepository.findByArtistName("Desconhecido").isEmpty()) {
                Artist desconhecido = new Artist("Desconhecido");
                artistRepository.save(desconhecido);
            }
        };
    }

}
