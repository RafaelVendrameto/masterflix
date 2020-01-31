package br.com.mastertech.masterflix.masterflix.service;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import br.com.mastertech.masterflix.masterflix.repository.FilmeRepository;
import ch.qos.logback.core.net.server.ClientVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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

    public Filme listarFilme(String nome) {
        Optional<Filme> filme = filmeRepository.findByNome(nome);
        if(filme.isPresent()){
            return filme.get();
        }
        return null;
    }

    public void excluirFilme(long id) {
        filmeRepository.deleteById(id);
    }
}
