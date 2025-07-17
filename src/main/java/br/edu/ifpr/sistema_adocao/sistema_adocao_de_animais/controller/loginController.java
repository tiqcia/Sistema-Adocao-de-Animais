package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.loginModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.cadastroRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class loginController {

    @Autowired
    private cadastroRepository cadastroRepository;

    //exibe a tela de login
    @GetMapping("/login")
    public String mostrarTelaLogin(Model model) {
        model.addAttribute("loginModel", new loginModel());
        return "Login"; 
    }

    //processa o login
    @PostMapping("/login")
    public String processarLogin(@ModelAttribute loginModel loginModel, Model model, HttpSession session) {
        cadastroModel usuario = cadastroRepository.findByEmailAndSenha(
            loginModel.getEmail(), loginModel.getSenha()
        );

        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);  // objeto completo
            return "redirect:/catalogo";
        } else {
            model.addAttribute("erro", "Email ou senha inválidos");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); //limpa os dados da sessão
        return "redirect:/login"; 
    }
    
    
}