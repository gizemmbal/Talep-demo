package com.example.Talep1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Talep1.model.Talep1;
import com.example.Talep1.service.Service;

@RestController
@RequestMapping("api/v1")

public class Controller {

	@Autowired
	Service service;

	@DeleteMapping("/delete")
	public void deleteTalep1byKonu(@RequestParam String talepKonusu) {
		service.deleteTalep1byKonu_service(talepKonusu, getDB());
	}

	@PutMapping("/updatebyKonu")
	public void updateTalep1byKonu(@RequestParam String talepKonusu, @RequestParam String talepDurumu) {
		service.updateTalep1DurumubyKonu_service(talepKonusu, talepDurumu, getDB());
	}

	@PutMapping("/updateAll")
	public void updateAllTalep1DurumuToOnaylandı() {
		service.updateAllTalep1DurumuToOnaylandı_service(getDB());
	}

	@GetMapping("/getDummyTalep1")
	public ResponseEntity<Talep1> getDummyTalep1() {
		Talep1 talep = service.setDummyTalep1();
		return new ResponseEntity<>(talep, HttpStatus.OK);
	}

	@PostMapping("/post")
	public void post(@RequestBody Talep1 talep) {
		service.insertTalep1_service(talep, getDB());
	}

	@GetMapping("/getDB")
	public List<Talep1> getDB() {
		return service.allTalep1s();
	}

	@GetMapping("/getDBbyDurum")
	public List<Talep1> displayTalep1sByDurum(@RequestParam String talepDurumu) {
		return service.displayTalep1sByDurum_service(talepDurumu, getDB());
	}

	@GetMapping("/getDBwithParam") // http://localhost:8080/api/v1/a?talep=my_value
	public List<Talep1> getDBwithParam(@RequestParam String talep) {
		return service.allTalep1s();
	}

	@GetMapping("/getAllKonu")
	public List<String> getAllKonu() {
		return service.displayAllTalep1Konu_service(getDB());
	}

}
