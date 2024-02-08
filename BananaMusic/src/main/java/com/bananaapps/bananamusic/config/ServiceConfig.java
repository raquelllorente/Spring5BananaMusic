package com.bananaapps.bananamusic.config;

import com.bananaapps.bananamusic.persistence.music.SongRepository;
import com.bananaapps.bananamusic.service.music.Catalog;
import com.bananaapps.bananamusic.service.music.CatalogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    SongRepository songRepository;

    @Bean
    public Catalog getCatalog(){
        CatalogImpl catalog = new CatalogImpl();
        catalog.setSongRepository(songRepository);
        return catalog;
    }
}
