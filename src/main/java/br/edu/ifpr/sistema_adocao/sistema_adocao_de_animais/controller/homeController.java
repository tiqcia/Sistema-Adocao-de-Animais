package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String paginaInicial() {
        return "redirect:/catalogo";
    }
}
