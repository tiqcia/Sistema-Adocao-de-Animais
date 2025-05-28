package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repositorios;

import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cadastroRepositorio extends JpaRepository<cadastroModel, Long>{
    
}
