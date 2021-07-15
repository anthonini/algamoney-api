package com.example.algamoney.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRespository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.repository.filter.LancamentoFilter;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRespository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Lancamento> findAll() {
		return repository.findAll();
	}

	public Lancamento findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getId()).orElse(null);
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return repository.save(lancamento);
	}

	public List<Lancamento> filtrar(LancamentoFilter filter) {
		return repository.filtrar(filter);
	}
}
