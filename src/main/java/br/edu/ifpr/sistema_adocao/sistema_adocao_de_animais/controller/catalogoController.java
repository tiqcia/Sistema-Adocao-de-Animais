package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.animalRepository;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;

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

        String usuarioLogado = (String) session.getAttribute("usuario");
        String tipoUsuario = (String) session.getAttribute("tipo");  // Pega o tipo da sessão

        if (usuarioLogado != null) {
            model.addAttribute("username", usuarioLogado);
        }
        if (tipoUsuario != null) {
            model.addAttribute("tipo", tipoUsuario);  // Passa tipo para o template
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
