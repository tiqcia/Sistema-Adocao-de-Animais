package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.repository;
import br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model.solicitacaoAdocaoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface solicitacaoAdocaoRepository extends JpaRepository<solicitacaoAdocaoModel, Long> {
    List<solicitacaoAdocaoModel> findByStatus(String status);
}
