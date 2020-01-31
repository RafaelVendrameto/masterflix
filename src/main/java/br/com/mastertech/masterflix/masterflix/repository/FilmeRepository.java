package br.com.mastertech.masterflix.masterflix.repository;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme, Long> {
}
