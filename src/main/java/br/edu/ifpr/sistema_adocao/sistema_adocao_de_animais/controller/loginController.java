package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.loginModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.cadastroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class loginController {

    @Autowired
    private cadastroRepository cadastroRepository; //usando o cadastroRepository

    //exibe a tela de login
    @GetMapping("/login")
    public String mostrarTelaLogin(Model model) {
        model.addAttribute("loginModel", new loginModel());
        return "Login"; 
    }

    //processa o login
    @PostMapping("/login")
    public String processarLogin(@ModelAttribute loginModel loginModel, Model model) {
        //busca do email e da senha
        cadastroModel usuario = cadastroRepository.findByEmailAndSenha(
            loginModel.getEmail(), loginModel.getSenha()
        );

        if (usuario != null) {
            //login válido
            model.addAttribute("usuario", usuario); //adiciona o usuário ao modelo
            return "redirect:/"; //redireciona para a página inicial
        } else {
            return "login"; //retorna para a tela de login
        }
    }
}
