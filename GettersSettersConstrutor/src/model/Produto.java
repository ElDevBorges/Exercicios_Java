package model;

public class Produto implements IDesconto{
    private int id;
    private String nome;
    private double preco;
    private double frete = 10;

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

    public double getFrete() {
        return frete;
    }

    public void setFrete(int frete) {
        this.frete = frete;
    }

    public String exibirDados() {
        return "Id: " + getId() + "\nNome: " + getNome() + "\npreco: $" + getPreco() +  "\nFrete: $" + getFrete() + "\nDesconto: $" + calcularDesconto();
    }

    @Override
    public double calcularDesconto() {
        double porcentagemADescontar = 10;
        double desconto = getPreco() * porcentagemADescontar / 100;

        return desconto;
    }
}
