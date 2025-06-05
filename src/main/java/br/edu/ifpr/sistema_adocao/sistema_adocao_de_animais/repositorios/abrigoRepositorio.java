package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repositorios;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.abrigoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface abrigoRepositorio extends JpaRepository<abrigoModel, Long>{
    
}