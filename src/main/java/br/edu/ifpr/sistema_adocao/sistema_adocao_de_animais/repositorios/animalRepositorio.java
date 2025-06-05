package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repositorios;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface animalRepositorio extends JpaRepository<animalModel, Long>{
    
}
