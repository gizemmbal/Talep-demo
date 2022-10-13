package com.example.Talep1.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Talep1.model.Talep1;

@Component
public class DaoImpl implements Dao {

	@Override
	public void insertTalep1(Talep1 talep, List<Talep1> DB) {
		DB.add(talep);
	}

	// Deletes the first Talep1 from DB that has talepKonusu
	@Override
	public void deleteTalep1byKonu(String talepKonusu, List<Talep1> DB) {

		// For loop using Stream
		for (Talep1 talep : DB) {
			if (talep.getTalep1Konusu().equalsIgnoreCase(talepKonusu)) {
				DB.remove(talep);
			} else {
				System.out.println("Talep1 is not available");
			}
		}

		// My old class for loop
		// for (int i = 0; i < DB.size(); i++) {
		// if (DB.get(i).getTalep1Konusu().equalsIgnoreCase(talepKonusu)) {
		// DB.remove(i);
		// } else {
		// System.out.print("Talep1 is not available");
		// }
		// }

	}

	// Updates talepDurumu to given Talep1Durumu by searching talepKonusu
	@Override
	public void updateTalep1DurumubyKonu(String talepKonusu, String talepDurumu, List<Talep1> DB) {

		for (Talep1 talep : DB) {
			if (talep.getTalep1Konusu().equalsIgnoreCase(talepKonusu)) {

				if (talep.getTalep1Durumu().equalsIgnoreCase(talepDurumu)) {
					System.out.println("Talep1 already has the given talepDurumu : " + talepDurumu);
				} else {
					talep.setTalep1Durumu(talepDurumu);
				}

			} else {
				System.out.println("Talep1 with given Konu is not available");
			}
		}
	}

	// Updates all talepDurumu to Onaylandı
	@Override
	public void updateAllTalep1DurumuToOnaylandı(List<Talep1> DB) {
		for (Talep1 talep : DB) {
			if (talep.getTalep1Durumu().equalsIgnoreCase("Bekleyen")) {
				talep.setTalep1Durumu("Onaylandı");
			} else {
				System.out.print("Talep1 with given Durum is not available");
			}
		}
	}

}
