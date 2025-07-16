package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.abrigoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface abrigoRepository extends JpaRepository<abrigoModel, Long>{
    
}