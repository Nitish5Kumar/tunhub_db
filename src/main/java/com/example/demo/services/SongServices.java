package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Songs;

public interface SongServices {

	public void addSong(Songs song);
	
	public boolean isNameExist(String name);

	public List<Songs> fetchAllSongs();

	public void updateSong(Songs song);
	
}
