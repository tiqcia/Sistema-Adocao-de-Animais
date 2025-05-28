package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "cadastro_tbl")
public class cadastroModel implements Serializable{

    private static final long serialVersionUID = 1L;

    //Chave primária
    @Id
    private Long CPF;

    //Atributos
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name="data_nas", nullable = false)
    private String data_nas;

    @Column(name="numTelefone1", nullable = false)
    private String numTelefone1;

    @Column(name="numTelefone2", nullable = false)
    private String numTelefone2;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="senha", nullable = false)
    private String senha;

    @Column(name="rua", nullable = false)
    private String rua;

    @Column(name="CEP", nullable = false)
    private String CEP;

    @Column(name="numero", nullable = false)
    private String numero;

    @Column(name="bairro", nullable = false)
    private String bairro;



   
    
}
