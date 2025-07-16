package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.animalModel;

public interface animalRepository extends JpaRepository<animalModel, Long> {}
