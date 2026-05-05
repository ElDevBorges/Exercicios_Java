package model;

public class Produto implements IDesconto{
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String exibirDados() {
        return "Id: " + getId() + "\nNome: " + getNome() + "\npreco: " + getPreco() + "\n";
    }

    @Override
    public double calcularDesconto() {
        double porcentagemADescontar = 0.10;
        double desconto = getPreco() * porcentagemADescontar;

        return desconto;
    }
}
