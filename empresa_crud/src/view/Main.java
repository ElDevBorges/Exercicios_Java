package view;

import controller.ClientController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String [] args) {
        String nomeCliente;
        String emailCliente;
        Scanner sc = new Scanner (System.in);

        ClientController clientController = new ClientController();

        System.out.print("Nome do cliente: ");
        nomeCliente = sc.nextLine();

        System.out.print("Email do cliente: ");
        emailCliente = sc.nextLine();

        clientController.inserirCliente(nomeCliente, emailCliente);

}
}