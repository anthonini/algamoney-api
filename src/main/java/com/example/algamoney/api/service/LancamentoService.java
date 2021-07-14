package com.example.algamoney.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.LancamentoRespository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRespository repository;

	public List<Lancamento> findAll() {
		return repository.findAll();
	}

	public Lancamento findById(Long id) {
		return repository.findById(id).orElse(null);
	}
}
