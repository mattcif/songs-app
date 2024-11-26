package com.mattcif.discos.service;

import com.mattcif.discos.dto.requestDto.DiscRequestDTO;
import com.mattcif.discos.model.Disc;

import java.util.List;

public interface DiscService {
    
    List<Disc> getAllDiscs();

    Disc createDisc(DiscRequestDTO dto);
}
