package controller;

import model.Aluno;

public class AlunoController {

    public Aluno criarAluno (String nome, double nota1, double nota2) {
        return new Aluno(nome, nota1, nota2);

    }

    public double calcularMedia(Aluno aluno) {
        return aluno.calcularMedia(aluno);

    }



    public String exibirResultado (Aluno aluno) {
        return aluno.exibirResultado(aluno);
    }

    public String exibirDados(Aluno aluno) {
        return "Aluno: " + aluno.getNome() +
                "\nMédia: " + calcularMedia(aluno) +
                "\nResultado: " + exibirResultado(aluno);
    }



}
