package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.cadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class cadastroController {

    @Autowired
    private cadastroRepository cadastroRepository;

    //acessa a tela de cadastro
    @GetMapping("/cadastros")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("cadastroModel", new cadastroModel());
        return "Cadastro"; //cadastro.html
    }

    //recebe os dados do formulario e salva no banco de dados através do repository
    @PostMapping("/cadastros")
    public String salvarCadastro(@ModelAttribute cadastroModel cadastroModel, Model model) {
        // Você pode validar se o tipo foi informado, opcional
        if (cadastroModel.getTipo() == null || cadastroModel.getTipo().isEmpty()) {
            model.addAttribute("erro", "O campo tipo é obrigatório.");
            return "Cadastro";
        }
        
        cadastroRepository.save(cadastroModel);
        model.addAttribute("mensagem", "Cadastro realizado com sucesso!");
        model.addAttribute("cadastroModel", new cadastroModel());
        return "Cadastro"; 
    }


}
