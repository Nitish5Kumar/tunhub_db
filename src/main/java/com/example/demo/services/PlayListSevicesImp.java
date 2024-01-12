package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlayListRepository;

@Service
public class PlayListSevicesImp implements PlayListServices{

	@Autowired
	PlayListRepository repo;

	@Override
	public List<Playlist> fetchAllPlaylist() {
		
		return repo.findAll();
	}

	@Override
	public void addPlayList(Playlist playlist) {
		repo.save(playlist);
		
	}

	

	

	
}
