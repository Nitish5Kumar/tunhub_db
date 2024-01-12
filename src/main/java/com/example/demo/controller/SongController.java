package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Songs;
import com.example.demo.services.SongServices;

@Controller
public class SongController {

	@Autowired
	SongServices service;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song) {
		boolean isExist=service.isNameExist(song .getName());
		if(isExist==false) {
			service.addSong(song);
			System.out.println("song added");
			return "adminhome";
		}
		else {
			System.out.println("aond already added");
			return "adminhome";
		}
	}
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Songs>songList=service.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser=false;
		if(premiumUser==true) {
		List<Songs>songList=service.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "displaySongs";
		}
		else {
			return "makePayment";
		}
	}
}
