package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private Integer CPF;

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

    @Column(name="tipo", nullable = false)
    private String tipo; // valores: "FUNCIONARIO" ou "ADOTANTE"


    public cadastroModel(){
        
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nas() {
        return data_nas;
    }

    public void setData_nas(String data_nas) {
        this.data_nas = data_nas;
    }

    public String getNumTelefone1() {
        return numTelefone1;
    }

    public void setNumTelefone1(String numTelefone1) {
        this.numTelefone1 = numTelefone1;
    }

    public String getNumTelefone2() {
        return numTelefone2;
    }

    public void setNumTelefone2(String numTelefone2) {
        this.numTelefone2 = numTelefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
  
}
