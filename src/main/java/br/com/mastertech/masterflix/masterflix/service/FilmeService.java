package br.com.mastertech.masterflix.masterflix.service;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import br.com.mastertech.masterflix.masterflix.repository.FilmeRepository;
import ch.qos.logback.core.net.server.ClientVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FilmeService {
    @Autowired
    public FilmeRepository filmeRepository;

    public Filme cadastrarFilme(Filme filme) {
        filme.setAtivo(Boolean.TRUE);
        filme.setDataCriacao(LocalDate.now());
        return filmeRepository.save(filme);
    }

    public Iterable<Filme> listarFilmes() {
        Iterable<Filme> filmes = filmeRepository.findAll();
        return filmes;
    }
}
