package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	/*
	 * public Lancamento salvar(Lancamento lancamento) { Pessoa pessoa =
	 * pessoaRepository.findById(lancamento.getPessoa().getCodigo()); if (pessoa ==
	 * null || pessoa.isInativo()) { throw new
	 * PessoaInexistenteOuInativaException(); } return
	 * lancamentoRepository.save(lancamento); }
	 */

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo())
				.orElseThrow(PessoaInexistenteOuInativaException::new);

		if (pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}

		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);
		if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
			validarPessoa(lancamento);
		}
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		
		return lancamentoRepository.save(lancamentoSalvo);
	}


	private void validarPessoa(Lancamento lancamento) {
		Optional<Pessoa> pessoa = null;
		if (lancamento.getPessoa().getCodigo() != null) {
			pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		}
		
		if (pessoa.isEmpty() || pessoa.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
	}

	private Lancamento buscarLancamentoExistente(Long codigo) {
/*		Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(codigo);
		if (LancamentoSalvo.isEmpty()) {
			throw new IllegalArgumentException();
		} */
		return lancamentoRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException());
	}
	
	
}
