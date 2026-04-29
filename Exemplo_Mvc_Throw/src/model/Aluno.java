package model;

public class Aluno {
    String nome;
    double nota1;
    double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double calcularMedia(Aluno aluno) {
        return nota1 + nota2;
    }

    public String exibirResultado(Aluno aluno) {
        if (calcularMedia(aluno) >= 7) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }


}



