package controller;

import model.Produto;

public class ProdutoController {
    Produto [] produtos = new Produto[5];
    int contador = 0;
    boolean vazio = false;


    public void adicionarProduto (Produto produto) {
        if (contador == produtos.length) {
            System.out.println("Vetor chegou ao limite");
        } else {
            produtos[contador] = produto;
            contador++;
            vazio = false;
        }
    }



    public void listarProdutos () {

        for (int i = 0; i <= 4; i++) {
            if (produtos[i] != null) {
                vazio = false;
                System.out.println("Id: = " + produtos[i].getId());
                System.out.println("Nome: " + produtos[i].getNome());
                System.out.println("Preço: " + produtos[i].getPreco());
                System.out.println("");

            } else {
                vazio = true;
            }

        }

        if (vazio) {
            System.out.println("Lista vazia");
        }
    }
}

