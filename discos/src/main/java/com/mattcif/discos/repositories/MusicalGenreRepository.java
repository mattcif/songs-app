package com.mattcif.discos.repositories;

import com.mattcif.discos.model.MusicalGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicalGenreRepository extends JpaRepository<MusicalGenre, Long> {

    Optional<MusicalGenre> findByName(String name);
}
