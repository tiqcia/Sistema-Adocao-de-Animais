package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.cadastroModel;

public interface cadastroRepository extends JpaRepository<cadastroModel, Long> {
    
    //busca de usuário pelo email e senha
    cadastroModel findByEmailAndSenha(String email, String senha);
}