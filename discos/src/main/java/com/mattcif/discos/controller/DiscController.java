package com.mattcif.discos.controller;


import com.mattcif.discos.dto.requestDto.DiscRequestDTO;
import com.mattcif.discos.model.Disc;
import com.mattcif.discos.service.DiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disc")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class DiscController {

    @Autowired
    private DiscService discService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Disc> getAllDiscs() {
        return discService.getAllDiscs();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disc createDisc(@RequestBody DiscRequestDTO data) {
        return discService.createDisc(data);
    }
}
