package view;

import controller.ProdutoController;
import model.Produto;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProductView {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        int decisao = 0;
        Scanner sc = new Scanner (System.in);
        Produto produto;
        int idProduto;
        String nomeProduto;
        double precoProduto;
        boolean ativo = true;


        while (ativo) {
        System.out.println("Digite para escolher");
        System.out.println("---------------------\n");
        System.out.println("1 - Listar Produto\n 2 - Cadastrar Produto");
        System.out.println(("----------------------\n"));
        System.out.print("Escolha: ");
        decisao = sc.nextInt();

        if (decisao == 1) {
            System.out.println("====================");
            produtoController.listarProdutos();
            System.out.println("====================");
        } else if (decisao == 2) {
            System.out.println("==============");
            System.out.print("Id: ");
            idProduto = sc.nextInt();
            System.out.print("Nome: ");
            nomeProduto = sc.next();
            System.out.print("preco: ");
            precoProduto = sc.nextDouble();

            produto = new Produto(idProduto, nomeProduto, precoProduto);
            produtoController.adicionarProduto(produto);

            System.out.println("Produto adicionado !");
        } else if (decisao == 0) {
            ativo = false;

        }
        }
    }
}