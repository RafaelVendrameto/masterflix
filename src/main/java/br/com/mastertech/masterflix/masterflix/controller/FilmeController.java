package br.com.mastertech.masterflix.masterflix.controller;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import br.com.mastertech.masterflix.masterflix.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmeController {
    @Autowired
    public FilmeService filmeService;

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }

    @PostMapping("/respostaCadastro")
    public String resposta(Filme filme){
        filmeService.cadastrarFilme(filme);
        return "respostaCadastro";
    }

    @GetMapping("/filmes")
    public ModelAndView listarFilmes(){
        ModelAndView pagina = new ModelAndView("listarFilmes");
        Iterable<Filme> filmes = filmeService.listarFilmes();
        pagina.addObject("filmes", filmes);
        return pagina;
    }

    @GetMapping("/filme")
    public String listarEvento(@RequestParam("nome") String nome, Model model){
        Filme filme = filmeService.listarFilme(nome);
        if(filme != null){
            model.addAttribute("filme", filme);
            return "listarFilme";
        }
        else {
            model.addAttribute("msg", "O Filme " + nome + " não foi encontrado, tente novamente.");
            return "index";
        }
    }

    @GetMapping("/filme{nome}")
    public String listarEventoUrl(@PathVariable("nome") String nome, Model model){
        Filme filme = filmeService.listarFilme(nome);
        if(filme != null){
            model.addAttribute("filme", filme);
            return "listarFilme";
        }
        else {
            model.addAttribute("msg", "O Filme " + nome + " não foi encontrado, tente novamente.");
            return "index";
        }
    }
}
