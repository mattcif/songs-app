package com.mattcif.discos.repositories;

import com.mattcif.discos.model.MusicalGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalGenreEntityRepository extends JpaRepository<MusicalGenreEntity, Long> {
}
