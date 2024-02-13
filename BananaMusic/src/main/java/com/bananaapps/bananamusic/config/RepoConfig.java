package com.bananaapps.bananamusic.config;

import com.bananaapps.bananamusic.persistence.music.InMemorySongRepository;
import com.bananaapps.bananamusic.persistence.music.SongRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RepoConfig {

    @Bean
    @Profile("dev")
    public SongRepository getSongRepo(){
        return new InMemorySongRepository();
    }

}
