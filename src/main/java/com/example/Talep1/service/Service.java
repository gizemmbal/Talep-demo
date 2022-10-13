package com.example.Talep1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Talep1.dao.Dao;
import com.example.Talep1.dao.TalepRepository;
import com.example.Talep1.model.Talep1;

@Component // @Repository,Service de olabilir
public class Service {

	@Autowired
	TalepRepository talepRepository;
	@Autowired
	Dao dao;

	// Creates dummy Talep1
	public Talep1 setDummyTalep1() {
		Talep1 talep = new Talep1();
		talep.setTalep1Aciklamasi("Dummy Talep1 açıklamam bu");
		talep.setTalep1Durumu("Dummy Talep1 durumum Beklemede");
		talep.setTalep1Konusu("Dummy Talep1 Konum bu");
		return talep;
	}

	static List<Talep1> DB = new ArrayList<>();

	public void insertTalep1_service(Talep1 talep, List<Talep1> DB) {
		// dao.insertTalep1(talep, DB);
		talepRepository.save(talep);
	}

	public void deleteTalep1byKonu_service(String talepKonusu, List<Talep1> DB) {
		dao.deleteTalep1byKonu(talepKonusu, DB);
	}

	public void updateTalep1DurumubyKonu_service(String talepKonusu, String talepDurumu, List<Talep1> DB) {
		dao.updateTalep1DurumubyKonu(talepKonusu, talepDurumu, DB);
	}

	public void updateAllTalep1DurumuToOnaylandı_service(List<Talep1> DB) {
		dao.updateAllTalep1DurumuToOnaylandı(DB);
	}

	// only in service - listing items in different ways
	// #######################################################

	// Returns DB
	public List<Talep1> allTalep1s() {
		return talepRepository.findAll();
		// return DB;
	}

	// Displays Talep1s with stated talepDurumu
	public List<Talep1> displayTalep1sByDurum_service(String talepDurumu, List<Talep1> DB) {

		return DB.stream().filter(p -> p.getTalep1Durumu().equalsIgnoreCase(talepDurumu)).map(pm -> pm)
				.collect(Collectors.toList());
		// .forEach(System.out::println);
	}

	// Displays all talepKonusu
	public List<String> displayAllTalep1Konu_service(List<Talep1> DB) {
		List<String> myAllKonu = new ArrayList<>();
		for (Talep1 talep : DB) {
			if (!myAllKonu.contains(talep.getTalep1Konusu())) {
				myAllKonu.add(talep.getTalep1Konusu());
			}
		}
		return myAllKonu;
	}
}
