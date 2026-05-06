package model;

public class ProdutoImportado extends Produto{
    double taxaImportacao;

    @Override
    public double getFrete() {
        return super.getFrete() + taxaImportacao;
    }

    public double getTaxaImportacao () {
        return taxaImportacao;
    }

    public void setTaxaImportacao (double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }

    public ProdutoImportado (int id, String nome, double preco, double taxaImportacao) {
        super(id, nome, preco);
        this.taxaImportacao = taxaImportacao;
    }

    @Override
    public String exibirDados () {
        return "\nid: " + super.getId() + "\nNome: " + super.getNome() + "\nPreco: $" + super.getPreco() + "\nTaxa de importação: " + getTaxaImportacao() + "\nFrete com taxa: $" + getFrete() + "\nDesconto: $" + calcularDesconto();
    }


}
