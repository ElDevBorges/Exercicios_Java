package controller;

import model.Produto;
import model.ProdutoImportado;

public class ProdutoController {
    Produto [] produtos = new Produto[5];
    int contador = 0;
    boolean vazio = false;


    public void adicionarProduto (Produto produto) {
        if (contador == produtos.length) {
            System.out.println("Vetor chegou ao limite \nProduto não foi adicionado");
        } else {
            produtos[contador] = produto;
            contador++;
            System.out.println("Produto adicionado !");
        }
    }

    public Produto criarProduto (int id, String nome, double preco){
        return new Produto(id, nome, preco);
    }

    public ProdutoImportado criarProdutoImp (int id, String nome, double preco, double taxaImportacao){
        return new ProdutoImportado(id, nome, preco, taxaImportacao);
    }


    public void listarProdutos ( ) {
        if (contador == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < produtos.length; i++) {
                if (produtos[i] != null) {
                System.out.println(produtos[i].exibirDados());
            }
            }
        }

    }


}

