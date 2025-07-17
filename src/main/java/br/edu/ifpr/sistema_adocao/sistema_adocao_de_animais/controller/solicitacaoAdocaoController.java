package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.controller;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.solicitacaoAdocaoModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.solicitacaoAdocaoRepository;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository.animalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/solicitacoes")
public class solicitacaoAdocaoController {

    @Autowired
    private solicitacaoAdocaoRepository solicitacaoAdocaoRepository ;

    @Autowired
    private animalRepository animalRepo;

    @PostMapping("/interesse/{idAnimal}")
    public String indicarInteresse(@PathVariable Long idAnimal, HttpSession session) {
        cadastroModel adotante = (cadastroModel) session.getAttribute("usuarioLogado");
        if (adotante == null) {
            return "redirect:/login";
        }

        Optional<animalModel> animalOpt = animalRepo.findById(idAnimal);
        if (animalOpt.isEmpty()) {
            return "redirect:/catalogo";
        }
        animalModel animal = animalOpt.get();

        solicitacaoAdocaoModel solicitacao = new solicitacaoAdocaoModel();
        solicitacao.setAnimal(animal);
        solicitacao.setAdotante(adotante);
        solicitacao.setStatus("PENDENTE");
        solicitacao.setTipo(adotante.getTipo());  // por exemplo
        solicitacao.setDataSolicitacao(LocalDate.now());

        solicitacaoAdocaoRepository .save(solicitacao);

        return "redirect:/catalogo";
    }


    @GetMapping("/pendentes")
    public String listarPendentes(Model model) {
        List<solicitacaoAdocaoModel> pendentes = solicitacaoAdocaoRepository .findByStatus("PENDENTE");
        model.addAttribute("solicitacoes", pendentes);
        return "telaSolicitacoes"; 
        
    }

    @PostMapping("/aceitar/{id}")
    public String aceitar(@PathVariable Long id) {
        Optional<solicitacaoAdocaoModel> solicitacaoOpt = solicitacaoAdocaoRepository .findById(id);

        if (solicitacaoOpt.isPresent()) {
            solicitacaoAdocaoModel solicitacao = solicitacaoOpt.get();
            solicitacao.setStatus("ACEITO");
            solicitacaoAdocaoRepository .save(solicitacao);

            animalModel animal = solicitacao.getAnimal();
            animal.setStatus("ADOTADO");
            animalRepo.save(animal);  
        }

        return "redirect:/solicitacoes/pendentes";
    }


    @PostMapping("/recusar/{id}")
    public String recusar(@PathVariable Long id) {
        solicitacaoAdocaoModel solicitacao = solicitacaoAdocaoRepository .findById(id).orElse(null);
        if (solicitacao != null) {
            solicitacao.setStatus("RECUSADA");
            solicitacaoAdocaoRepository .save(solicitacao);
        }
        return "redirect:/solicitacoes/pendentes";
    }
}
