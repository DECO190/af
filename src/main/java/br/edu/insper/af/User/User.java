package br.edu.insper.af.User;


public class User {
    private String nome;
    private String email;
    private String cpf;
    private String password;
    private String papel;

    public User(String nome, String email, String cpf, String password, String papel) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public String getPapel() {
        return papel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}
