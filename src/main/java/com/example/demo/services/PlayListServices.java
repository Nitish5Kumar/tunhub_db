package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Playlist;

public interface PlayListServices {

public List<Playlist> fetchAllPlaylist();

public void addPlayList(Playlist playlist);

}
