package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.service.music.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Autowired
    private Catalog catalog;

    @GetMapping("/{id}")
    public ResponseEntity getSongById(@PathVariable Long id){
        return catalog.getSongById(id);
    }

    @GetMapping("")
    public ResponseEntity getSongsByKeywords(@RequestParam(defaultValue = "") String keyword){
        return catalog.getSongsByKeywords(keyword);
    }

    @PostMapping("")
    public ResponseEntity createSong(@RequestBody Song newSong){
        return ResponseEntity.status(HttpStatus.CREATED).body(catalog.createSong(newSong));
    }

    @PutMapping("")
    public ResponseEntity saveSongs(@RequestBody Collection<Song> songs){
        return ResponseEntity.status(HttpStatus.CREATED).body(catalog.saveSongs(songs));
    }


}
