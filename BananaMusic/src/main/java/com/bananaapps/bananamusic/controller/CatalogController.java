package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.service.music.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@RestController()
@RequestMapping(value = "/catalog")
@Validated
@CrossOrigin(origins = "http://localhost:8080")
public class CatalogController {

    @Autowired
    private Catalog catalog;

    @GetMapping("/{id}")
    public ResponseEntity getSongById(@PathVariable @Min(1) Long id){
        return catalog.getSongById(id);
    }

    @GetMapping("")
    public ResponseEntity getSongsByKeywords(@RequestParam @NotBlank String keyword){
        return catalog.getSongsByKeywords(keyword);
    }

    @PostMapping("")
    public ResponseEntity createSong(@RequestBody @Valid Song newSong){
        return ResponseEntity.status(HttpStatus.CREATED).body(catalog.createSong(newSong));
    }

    @PutMapping("")
    public ResponseEntity saveSongs(@RequestBody @Valid Collection<Song> songs){
        return ResponseEntity.status(HttpStatus.CREATED).body(catalog.saveSongs(songs));
    }


}
