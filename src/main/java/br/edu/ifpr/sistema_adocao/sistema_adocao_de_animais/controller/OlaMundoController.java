package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OlaMundoController {

    @GetMapping("/teste")
    public String home(Model model){
       // model.addAttribute("mensagem", "que iso");
        return "telaCadastro";
    }

}
