package com.bananaapps.bananamusic.service.music;

import java.util.Collection;
import java.util.List;

import com.bananaapps.bananamusic.domain.music.Song;
import org.springframework.http.ResponseEntity;

public interface Catalog {

	   public Song findById(Long id);
	   public Collection<Song> findByKeyword(String keyword);
	   public long size();
	   public void save(Song song);
	   public void saveCollection(Collection<Song> songs);
	   public ResponseEntity getSongById(Long id);
	   public ResponseEntity getSongsByKeywords(String keyword);
	   public Song createSong(Song newSong);
	   public String saveSongs(Collection<Song> songs);
	}