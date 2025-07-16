package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder


@Entity
@Table(name = "adocao_tbl")

public class adocaoModel implements Serializable {
   
    private static final long serialVersionUID = 1L;

    // Chave Primária
    @Id 
    private Long idLong;

    //atributos
    @Column(name = "dataAdocao", nullable = true)
    private Date dataAdocao;

    @Column(name = "animal", nullable = true)
    private String Animal;

    @Column(name = "Adotante", nullable = true)
    private String Adotante;
   
}
