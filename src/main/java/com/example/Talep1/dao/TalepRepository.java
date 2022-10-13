package com.example.Talep1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Talep1.model.Talep1;

@Repository
public interface TalepRepository extends JpaRepository<Talep1, Long> {
//
//	// Using an in-memory Map
//	// to store the object data
//	private Map<Long, Talep1> repository;
//
//	public Talep1Repository() {
//		this.repository = new HashMap<>();
//	}
//
//	// Implementation for save method
//	@Override
//	public void save(Talep1 talep) {
//		repository.put(talep.getTalep1Konusu(), talep);
//	}

//
//	// Implementation for findStudentById method
//	@Override
//	public Student findStudentById(Long id) {
//		return repository.get(id);
//	}
}