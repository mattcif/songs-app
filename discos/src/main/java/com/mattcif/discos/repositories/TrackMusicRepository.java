package com.mattcif.discos.repositories;

import com.mattcif.discos.model.TrackMusic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackMusicRepository extends JpaRepository<TrackMusic, Long> {
}
