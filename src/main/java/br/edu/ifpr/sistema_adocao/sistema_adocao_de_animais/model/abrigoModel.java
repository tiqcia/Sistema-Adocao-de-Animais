package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.AssertTrue;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder


@Entity
@Table(name = "abrigo_tbl")

public class abrigoModel implements Serializable {
   
    private static final long serialVersionUID = 1L;

    // Chave Primária
    @Id 
    private Long idLong;

    //atributos
    @Column(name= "CPF", nullable = true)
    private String CPF;

    @Column(name="CNPJ", nullable = true)
    private String CNPJ;

    @Column(name = "Nome", nullable = false)
    private String Nome;

    @Column(name = "Endereço", nullable = false)
    private String Endereço;

    @Column(name = "Telefone", nullable = false)
    private String Telefone;

   // @Column (columnDefinition = "TEXT")
   // private String listaAnimais; armazena ids em um arquivo json, uma única coluna do banco

   //@ElementCollection 
   //private List<String> animal_tbl; cria uma tabela auxiliar no BD, abordagem de um pra muitos

   @OneToMany (mappedBy = "abrigo_tbl", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<animalModel> animais;

   //vai ser responsável por conferir se foi inserido o cpf ou cnpj, caso contrário ele não salva as infomações
   @AssertTrue(message= "CPF ou CNPJ devem ser preenchidos!")
   public boolean isvalid(){
     return (CPF != null && !CPF.isEmpty()) || (CNPJ != null && !CNPJ.isEmpty());
   }
}
