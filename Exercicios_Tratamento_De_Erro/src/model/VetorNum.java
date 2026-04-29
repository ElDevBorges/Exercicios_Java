package model;

import java.util.Scanner;

public class VetorNum {
    int [] numeros = new int [5];
    int vetorSolicitado;
    String inputUsuario;
    Scanner sc = new Scanner(System.in);

    numeros[0] = 2;
    public int solicitarItemVetor () {
        System.out.println("Solicite um índice do vetor: ");
        inputUsuario = sc.nextLine();
        vetorSolicitado = Integer.parseInt(inputUsuario);

        return numeros[vetorSolicitado];

    }
}
