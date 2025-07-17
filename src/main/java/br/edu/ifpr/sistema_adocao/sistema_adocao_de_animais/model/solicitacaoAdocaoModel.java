package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "solicitacao_tbl")
public class solicitacaoAdocaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", referencedColumnName = "ID_animal", nullable = false)
    private animalModel animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adotante_cpf", referencedColumnName = "CPF", nullable = false)
    private cadastroModel adotante;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDate dataSolicitacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public animalModel getAnimal() {
        return animal;
    }

    public void setAnimal(animalModel animal) {
        this.animal = animal;
    }

    public cadastroModel getAdotante() {
        return adotante;
    }

    public void setAdotante(cadastroModel adotante) {
        this.adotante = adotante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
