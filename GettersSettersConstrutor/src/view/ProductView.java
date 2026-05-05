package view;

import controller.ProdutoController;
import model.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProductView {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        int decisao = -1;
        Scanner sc = new Scanner(System.in);
        Produto produto;
        int idProduto;
        String nomeProduto;
        double precoProduto;
        double taxaImportacao;
        boolean ativo = true;


        do {
            try {

                System.out.println("Digite para escolher");
                System.out.println("---------------------\n");
                System.out.println("1 - Listar Produto\n 2 - Cadastrar Produto \n 3 - Cadastrar produto importado \n 0 - Sair");
                System.out.println("----------------------\n");
                System.out.print("Escolha: ");

                decisao = sc.nextInt();





                switch (decisao) {
                    case 1:
                        System.out.println("====================");
                        produtoController.listarProdutos();
                        System.out.println("====================");
                        break;

                    case 2:
                        System.out.println("==============");
                        System.out.print("Id: ");
                        idProduto = sc.nextInt();
                        System.out.print("Nome: ");
                        nomeProduto = sc.nextLine();
                        sc.nextLine();
                        System.out.print("preco: ");
                        precoProduto = sc.nextDouble();

                        if (precoProduto < 0) {
                            throw new IllegalArgumentException("Erro! Preço com valor negativo");
                        }

                        produto = produtoController.criarProduto(idProduto, nomeProduto, precoProduto);
                        produtoController.adicionarProduto(produto);
                        break;

                    case 3:
                        System.out.println("==============");
                        System.out.print("Id Produto Importado: ");
                        idProduto = sc.nextInt();
                        System.out.print("Nome do Produto Importado: ");
                        nomeProduto = sc.nextLine();
                        System.out.print("preco do Produto Importado: ");
                        precoProduto = sc.nextDouble();
                        System.out.print("Taxa de importação: ");
                        taxaImportacao = sc.nextDouble();


                        produto = produtoController.criarProdutoImp(idProduto, nomeProduto, precoProduto, taxaImportacao);
                        produtoController.adicionarProduto(produto);
                        break;
                    case 0:
                        ativo = false;
                        System.out.println("encerrando..");
                        break;
                    default:
                        System.out.println("Opção inválida !");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (ativo);

        sc.close();


    }
}
