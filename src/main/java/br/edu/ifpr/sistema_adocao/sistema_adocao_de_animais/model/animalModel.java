package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "animal_tbl")
public class animalModel implements Serializable {
    private static final long serialVersionUID = 1L;

    // chave primária 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_animal;

    // atributos
    @Column (name = "nome", nullable = false)
    private String nome; 

    @Column (name = "idade", nullable = false )
    private Integer idade;

    @Column (name = "sexo", nullable = false)
    private String sexo;

    @Column (name = "status", nullable = false)
    private String status;

    @Column (name = "especies", nullable = false)
    private String especies;
    
}
