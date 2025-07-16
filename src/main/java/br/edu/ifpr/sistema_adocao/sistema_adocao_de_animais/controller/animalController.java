package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.animalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class animalController {

    @Autowired
    private animalRepository animalRepository;

    //acessa a tela de cadastro de animal
    @GetMapping("/animais/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("animalModel", new animalModel());
        return "CadastroAnimais"; // nome do template sem extensão
    }


    //recebe os dados do formulario e salva no banco de dados através do repository
    @PostMapping("/animais/cadastrar")
    public String salvarAnimal(animalModel animalModel, Model model) {
        animalRepository.save(animalModel);
        model.addAttribute("mensagem", "Animal cadastrado com sucesso!");
        model.addAttribute("animalModel", new animalModel()); // limpa o formulário
        return "CadastroAnimais"; // permanece na mesma página
    }
}
