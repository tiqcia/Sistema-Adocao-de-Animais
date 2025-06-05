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
@Table(name = "animal_tbl")
public class animalModel implements Serializable {
    private static final long serialVersionUID = 1L;

    // chave primária 
    @Id 
    private Long ID_animal;

    // atributos
    @Column (name = "Nome", nullable = false)
    private String Nome; 

    @Column (name = "Idade", nullable = false )
    private Integer Idade;

    @Column (name = "Sexo", nullable = false)
    private String Sexo;
    
    @Column (name = "Status", nullable = false)
    private String Status;

    @Column (name = "Espécies", nullable = false)
    private String Especies;

    @ManyToOne
    @JoinColumn(name = "idLong", nullable = false)
    private abrigoModel abrigo;
    
}
