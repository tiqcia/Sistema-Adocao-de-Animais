package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repositorios.animalRepositorio;

import org.springframework.web.bind.annotation.GetMapping;


public class animalController {

     @Autowired
     private animalRepositorio animalRepositorio;


     @GetMapping("/animal")
    public List<animalModel> listaAnimal(){
        return animalRepositorio.findAll();
    }
    
}
