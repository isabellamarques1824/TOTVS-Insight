package br.com.fiap.bean;

import java.time.LocalDateTime;

public class Relatorio {
    // atributos
    private int idRelatorio;
    private Usuario usuario;
    private String tipoRelatorio;
    private LocalDateTime dataGeracao;

    // construtores
    public Relatorio() {
    }

    public Relatorio(int idRelatorio, Usuario usuario, String tipoRelatorio, LocalDateTime dataGeracao) {
        this.idRelatorio = idRelatorio;
        this.usuario = usuario;
        this.tipoRelatorio = tipoRelatorio;
        this.dataGeracao = dataGeracao;
    }

    // métodos getters/setters
    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(String tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    // métodos da classe
    public String gerarRelatorio() {
        dataGeracao = LocalDateTime.now();

        return "Relatório gerado" +
                "\nCódigo do relatório: " + idRelatorio +
                "\nUsuário responsável: " + usuario.getNome() +
                "\nTipo do relatório: " + tipoRelatorio +
                "\nData de geração: " + dataGeracao;
    }
}