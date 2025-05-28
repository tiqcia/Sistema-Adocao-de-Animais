package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repositorios.cadastroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class cadastroController {

    @Autowired 
    private cadastroRepositorio cadastroRepositorio;

    @GetMapping("/cadastro")
    public List<cadastroModel> listaCadastros(){
        return cadastroRepositorio.findAll();
    }

}
