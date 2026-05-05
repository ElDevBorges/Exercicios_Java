package model;

public class ProdutoImportado extends Produto{
    double taxaImportacao;

    public double getTaxaImportacao () {
        return taxaImportacao;
    }

    public void setTaxaImportacao (double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }

    public ProdutoImportado (int id, String nome, double preco, double taxaImportacao) {
        super(id, nome, preco);
    }

    @Override
    public String exibirDados () {
        return "id: " + super.getId() + "\nNome: " + super.getNome() + "\nPreco: " + super.getPreco() + "\nTaxa de importação: " + getTaxaImportacao();
    }


}
