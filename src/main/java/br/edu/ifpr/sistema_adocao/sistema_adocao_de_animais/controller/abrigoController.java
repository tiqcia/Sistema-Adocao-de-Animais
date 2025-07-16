package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.abrigoModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.abrigoRepository;
import org.springframework.web.bind.annotation.GetMapping;

public class abrigoController {
    @Autowired 
    private abrigoRepository abrigoRepositorio;

    @GetMapping("/abrigo")
    public List<abrigoModel> listaAbrigos(){
        return abrigoRepositorio.findAll();
    }
}
