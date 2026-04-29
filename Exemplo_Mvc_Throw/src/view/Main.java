package view;

import controller.AlunoController;
import model.Aluno;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    AlunoController alunoController = new AlunoController();
    String nomeAluno;
    double nota1;
    double nota2;
    Aluno aluno;

    System.out.print("Informe o nome do aluno: ");
    nomeAluno = sc.nextLine();
    System.out.print("Informea nota 1:  ");
    nota1 = sc.nextDouble();
    System.out.print("Informe a nota 2: ");
    nota2 = sc.nextDouble();

    aluno = alunoController.criarAluno(nomeAluno, nota1, nota2);

    System.out.println(alunoController.exibirResultado(aluno));
    System.out.println(alunoController.exibirDados(aluno));

    }



}