package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Songs;
import com.example.demo.services.PlayListServices;
import com.example.demo.services.SongServices;

@Controller
public class PlayListController {

	@Autowired
	PlayListServices playlistServices;
	
	@Autowired
	SongServices songServices;
	
	@GetMapping("/createPlaylist")
	public String createPlayList(Model model) {
		List<Songs>songlist=songServices.fetchAllSongs();
		model.addAttribute("songs",songlist);
		System.out.println("Mapping success");
		return "createPlaylist";
	}
	
	@PostMapping("/addPlayList")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		playlistServices.addPlayList(playlist);
		
		List<Songs> songList=playlist.getSongs();
		for(Songs s:songList) {
			s.getPlaylists().add(playlist);
			songServices.updateSong(s);
		}
		return "adminhome";
	}
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model model) {
		List<Playlist>allPlaylist=playlistServices.fetchAllPlaylist();
		model.addAttribute("allPlaylist", allPlaylist);
		return "displayPlayList";
	}
}
