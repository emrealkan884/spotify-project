package com.berkemre.spotifyproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "artists")
public class Artist extends User {

    @OneToMany(mappedBy = "artist")
    private List<Music> musics;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
}
