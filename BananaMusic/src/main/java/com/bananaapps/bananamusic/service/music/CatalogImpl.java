package com.bananaapps.bananamusic.service.music;

import java.util.Collection;
import java.util.List;

import com.bananaapps.bananamusic.exception.SongNotfoundException;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.persistence.music.SongRepository;

@Service
public class CatalogImpl implements Catalog {

    @Autowired
    private SongRepository songRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Song findById(Long id) {
        return songRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Collection<Song> findByKeyword(String keyword) {
        return songRepository.findByKeyword(keyword);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public long size() {
        return songRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCollection(Collection<Song> songs) {
        for (Song aSong : songs) {
            System.out.println("Attempting to save " + aSong);
            songRepository.save(aSong);
        }
        System.out.println("If you are seeing this, saveBatch ended normally!");

    }

    @Override
    public ResponseEntity getSongById(Long id) {
        Song findSong = songRepository.findOne(id);
        if(findSong != null){
            return ResponseEntity.status(HttpStatus.OK).body(findSong);
        } else {
            throw new SongNotfoundException();
        }
    }

    @Override
    public ResponseEntity getSongsByKeywords(String keyword) {
        Collection<Song> findSongs = songRepository.findByArtistContainingOrTitleContainingAllIgnoreCase(keyword, keyword);
        if(findSongs.size() >= 1){
            return ResponseEntity.status(HttpStatus.OK).body(findSongs);
        } else {
            throw new SongNotfoundException();
        }
    }

    @Override
    public Song createSong(Song newSong) {
        return songRepository.save(newSong);
    }

    @Override
    public String saveSongs(Collection<Song> songs) {
        for(Song s : songs){
            songRepository.save(s);
        }
        return "Se han guardado todas las canciones correctamente";
    }


}
