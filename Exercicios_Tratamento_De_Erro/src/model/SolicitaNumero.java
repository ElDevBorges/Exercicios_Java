package model;

import java.util.Scanner;

public class SolicitaNumero {
    private Scanner sc = new Scanner(System.in);
    private Integer numeroSolicitado;
    private String inputUsuario;

    public int solicitarNum () {
        try {
            System.out.println("Solicite um número: ");
            inputUsuario = sc.nextLine();
            numeroSolicitado = Integer.parseInt(inputUsuario);
        } catch (NumberFormatException erro) {
            System.out.println("Formato digitado pelo usuário esta incorreto");
        }
        return numeroSolicitado;


    }
}
