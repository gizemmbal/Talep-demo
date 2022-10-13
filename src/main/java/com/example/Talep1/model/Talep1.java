package com.example.Talep1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Talep1 {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long Id;
	@Column
	private String talepKonusu;
	@Column
	private String talepDurumu;// I might do boolean?
	@Column
	private String talepAciklamasi;

	// Contructor
	public Talep1() {
		this.setTalep1Aciklamasi(talepAciklamasi);
		this.setTalep1Durumu(talepDurumu);
		this.setTalep1Konusu(talepKonusu);
	}

	// Constructor with parameters
	public Talep1(@JsonProperty("konu") String talepKonusu, @JsonProperty("durum") String talepDurumu,
			@JsonProperty("aciklama") String talepAciklamasi) {
		this.setTalep1Aciklamasi(talepAciklamasi);
		this.setTalep1Durumu(talepDurumu);
		this.setTalep1Konusu(talepKonusu);
	}

	public String getTalep1Konusu() {
		return talepKonusu;
	}

	public void setTalep1Konusu(String talepKonusu) {
		this.talepKonusu = talepKonusu;
	}

	public String getTalep1Durumu() {
		return talepDurumu;
	}

	public void setTalep1Durumu(String talepDurumu) {
		this.talepDurumu = talepDurumu;
	}

	public String getTalep1Aciklamasi() {
		return talepAciklamasi;
	}

	public void setTalep1Aciklamasi(String talepAciklamasi) {
		this.talepAciklamasi = talepAciklamasi;
	}
}
