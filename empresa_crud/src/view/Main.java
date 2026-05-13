package view;

import controller.ClientController;
import model.Cliente;
import model.DAO.ClienteDAO;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String [] args) {
        ClientController clientController = new ClientController();
        ClienteDAO clienteDAO = new ClienteDAO();
        Scanner sc = new Scanner(System.in);
        String nomeCliente;
        String emailCliente;
        int idCliente;
        int opcao = -0;

        /*

        ADICIONAR CLIENTE ------------------------

        System.out.print("Nome do cliente: ");
        nomeCliente = sc.nextLine();

        System.out.print("Email do cliente: ");
        emailCliente = sc.nextLine();

        clientController.inserirCliente(nomeCliente, emailCliente);

        ATUALIZAR CLIENTE ----------------

        System.out.print("ID: ");
        idCliente = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo nome do cliente: ");
        nomeCliente = sc.nextLine();

        System.out.print("Novo email do cliente: ");
        emailCliente = sc.nextLine();

        clientController.atualizarCliente(nomeCliente, emailCliente, idCliente);

        clientController.listarCliente();
        System.out.print("Id do cliente a ser deletado: ");
        idCliente = sc.nextInt();
        clientController.deletarCliente(idCliente);
        */


        do {
            System.out.println("\n------ MENU ------");
            System.out.println(("1 - Cadastrar Cliente"));
            System.out.println(("2 - Listar Cliente"));
            System.out.println(("3 - Atualizar Cliente"));
            System.out.println(("4 - Exluir Cliente"));
            System.out.println(("0 - Encerrar\n"));

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    nomeCliente = sc.nextLine();

                    System.out.print("Email do cliente: ");
                    emailCliente = sc.nextLine();

                    clientController.inserirCliente(nomeCliente, emailCliente);

                    break;

                case 2:

                    clientController.listarCliente();
                    break;

                case 3:
                    System.out.print("ID: ");
                    idCliente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome do cliente: ");
                    nomeCliente = sc.nextLine();

                    System.out.print("Novo email do cliente: ");
                    emailCliente = sc.nextLine();

                    clientController.atualizarCliente(nomeCliente, emailCliente, idCliente);
                    break;

                case 4:
                    System.out.print("Id do cliente a ser deletado: ");
                    idCliente = sc.nextInt();
                    clientController.deletarCliente(idCliente);
                    break;
                case 0:
                    opcao = 0;
                    break;
                default:
                    System.out.println("Opção invalida");
            }

        } while (opcao != 0);

        sc.close();









}
}
