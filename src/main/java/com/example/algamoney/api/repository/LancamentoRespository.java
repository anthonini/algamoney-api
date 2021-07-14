package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Lancamento;

public interface LancamentoRespository extends JpaRepository<Lancamento, Long>  {

}
