package model;

public class Quarto {
    private int id;
    private String nome;
    private String numero;
    private double qtd_cama_casal;
    private double qtd_cama_solteiro;
    private double preco;
    private boolean disponivel;

    public Quarto(String nome, String numero, double qtd_cama_casal, double qtd_cama_solteiro, double preco, boolean disponivel) {
        this.nome = nome;
        this.numero = numero;
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solteiro = qtd_cama_solteiro;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getQtd_cama_casal() {
        return qtd_cama_casal;
    }

    public void setQtd_cama_casal(double qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }

    public double getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }

    public void setQtd_cama_solteiro(double qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}