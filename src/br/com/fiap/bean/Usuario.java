package br.com.fiap.bean;

public class Usuario {
    // atributos
    private int idUsuario;
    private String nome;
    private String email;
    private String senhaHash;
    private String perfil;
    private String status;

    // construtores
    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String email, String senhaHash, String perfil, String status) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.perfil = perfil;
        this.status = status;
    }

    // métodos getters/setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // métodos da classe
    public boolean autenticar() {
        if (status.equalsIgnoreCase("ATIVO")) {
            return true;
        } else {
            return false;
        }
    }

    public void alterarStatus() {
        if (status.equalsIgnoreCase("ATIVO")) {
            status = "INATIVO";
        } else {
            status = "ATIVO";
        }
    }
}