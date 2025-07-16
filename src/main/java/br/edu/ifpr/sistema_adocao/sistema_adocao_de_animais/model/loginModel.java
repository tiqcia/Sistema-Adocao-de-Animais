package br.edu.ifpr.sistema_adocao.sistema_adocao_de_animais.model;

public class loginModel {
    private String email;
    private String senha;

    public loginModel() {
    }

    public loginModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
}
