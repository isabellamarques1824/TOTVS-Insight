package br.com.fiap.bean;

import java.time.LocalDateTime;

public class Reuniao {
    // atributos
    private int idReuniao;
    private Cliente cliente;
    private Usuario usuarioResponsavel;
    private String titulo;
    private String tipoReuniao;
    private LocalDateTime dataReuniao;
    private String idioma;

    // construtores
    public Reuniao() {
    }

    public Reuniao(int idReuniao, Cliente cliente, Usuario usuarioResponsavel, String titulo, String tipoReuniao, LocalDateTime dataReuniao, String idioma) {
        this.idReuniao = idReuniao;
        this.cliente = cliente;
        this.usuarioResponsavel = usuarioResponsavel;
        this.titulo = titulo;
        this.tipoReuniao = tipoReuniao;
        this.dataReuniao = dataReuniao;
        this.idioma = idioma;
    }

    // métodos getters/setters
    public int getIdReuniao() {
        return idReuniao;
    }

    public void setIdReuniao(int idReuniao) {
        this.idReuniao = idReuniao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoReuniao() {
        return tipoReuniao;
    }

    public void setTipoReuniao(String tipoReuniao) {
        this.tipoReuniao = tipoReuniao;
    }

    public LocalDateTime getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDateTime dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    // métodos da classe
    public String exibirResumoReuniao() {
        return "Reunião: " + titulo +
                "\nCliente: " + cliente.getNomeCliente() +
                "\nResponsável: " + usuarioResponsavel.getNome() +
                "\nData: " + dataReuniao +
                "\nIdioma: " + idioma;
    }
}