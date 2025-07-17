package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.animalRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
public class animalController {

    @Autowired
    private animalRepository animalRepository;

    @GetMapping("/animais/cadastrar")
    public String exibirFormulario(Model model, HttpSession session) {
        cadastroModel usuario = (cadastroModel) session.getAttribute("usuarioLogado");
        if (usuario == null || !usuario.getTipo().equals("FUNCIONARIO")) {
            return "redirect:/catalogo"; // redireciona se não for funcionário
        }

        model.addAttribute("animalModel", new animalModel());
        return "CadastroAnimais"; // nome do template do formulário
    }

    //recebe os dados do formulario e salva no banco de dados através do repository
    @PostMapping("/animais/cadastrar")
    public String salvarAnimal(
            @RequestParam("nome") String nome,
            @RequestParam("idade") Integer idade,
            @RequestParam("sexo") String sexo,
            @RequestParam("status") String status,
            @RequestParam("especies") String especies,
            @RequestParam("imagem") MultipartFile imagem,
            Model model) {

        try {
            animalModel animal = new animalModel();
            animal.setNome(nome);
            animal.setIdade(idade);
            animal.setSexo(sexo);
            animal.setStatus(status);
            animal.setEspecies(especies);

            if (imagem != null && !imagem.isEmpty()) {
                animal.setImagem(imagem.getBytes());
            }

            animalRepository.save(animal);
            model.addAttribute("mensagem", "Animal cadastrado com sucesso!");
            model.addAttribute("animalModel", new animalModel());
        } catch (IOException e) {
            model.addAttribute("mensagem", "Erro ao salvar imagem: " + e.getMessage());
        }

        return "redirect:/catalogo";
    }

}