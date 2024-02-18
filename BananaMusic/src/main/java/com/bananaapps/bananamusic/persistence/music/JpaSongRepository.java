package com.bananaapps.bananamusic.persistence.music;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.domain.music.SongCategory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class JpaSongRepository implements SongRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Song findOne(Long id) {
        return em.find(Song.class, id);
    }

    @Override
    @Transactional
    public Collection<Song> findAll() {
        TypedQuery<Song> q = em.createQuery("SELECT s FROM Song s", Song.class);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Collection<Song> findByKeyword(String keyword) {
       TypedQuery<Song> q = em.createQuery("SELECT s FROM Song s WHERE s.title LIKE CONCAT('%',:keyword,'%')", Song.class);
       q.setParameter("keyword", keyword);
       return q.getResultList();
    }

    @Override
    @Transactional
    public Collection<Song> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {
       TypedQuery<Song> q = em.createQuery("SELECT s FROM Song s WHERE LOWER(s.artist) LIKE LOWER(CONCAT('%',:artist,'%')) OR LOWER(s.title) LIKE LOWER(CONCAT('%',:title,'%'))", Song.class);
       q.setParameter("artist", artist);
       q.setParameter("title", title);
       return q.getResultList();
    }

    @Override
    @Transactional
    public Collection<Song> findBySongCategory(SongCategory category) {
        return null;
    }

    @Override
    @Transactional
    public long count() {
        Query q = em.createQuery("SELECT COUNT(*) FROM Song");
        return (long) q.getSingleResult();
    }

    @Override
    @Transactional
    public Song save(Song song) {
        em.persist(song);
        return song;
    }

    @Override
    @Transactional
    public void delete(Song song) {
        em.remove(song);
    }
}
