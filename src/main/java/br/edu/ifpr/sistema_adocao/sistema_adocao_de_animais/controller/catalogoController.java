package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.animalRepository;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/catalogo")
public class catalogoController {

    @Autowired
    private animalRepository animalRepository;

    @GetMapping
    public String mostrarCatalogo(Model model, HttpSession session) {
        model.addAttribute("animais", animalRepository.findAll());

        cadastroModel usuario = (cadastroModel) session.getAttribute("usuarioLogado");

        if (usuario != null) {
            model.addAttribute("username", usuario.getNome());
            model.addAttribute("tipo", usuario.getTipo());
        }

        return "catalogo";
    }

    @GetMapping("/imagem/{id}")
    public ResponseEntity<byte[]> getImagemAnimal(@PathVariable Long id) {
        Optional<animalModel> animalOpt = animalRepository.findById(id);
        if (animalOpt.isPresent() && animalOpt.get().getImagem() != null) {
            byte[] imagem = animalOpt.get().getImagem();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); 
            return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
