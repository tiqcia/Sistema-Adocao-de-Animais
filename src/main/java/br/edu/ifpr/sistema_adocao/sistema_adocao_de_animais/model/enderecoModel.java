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
@Table(name = "endereco_tbl")

public class enderecoModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long idLong;

    @Column(name = "rua", nullable = true)
    private String rua;

    @Column(name = "CEP", nullable = true)
    private int CEP;

    @Column(name = "numero", nullable = true)
    private int numero;

    @Column(name = "bairro", nullable = true)
    private String bairro;

    @Column(name = "cidade", nullable = true)
    private String cidade;

    @Column(name = "estado", nullable = true)
    private String estado;

}
