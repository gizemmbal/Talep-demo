package com.example.Talep1.dao;

import java.util.List;

import com.example.Talep1.model.Talep1;

public interface Dao {
	public void insertTalep1(Talep1 talep, List<Talep1> DB);

	public void deleteTalep1byKonu(String talepKonusu, List<Talep1> DB);

	public void updateTalep1DurumubyKonu(String talepKonusu, String talepDurumu, List<Talep1> DB);

	public void updateAllTalep1DurumuToOnaylandı(List<Talep1> DB);
}
