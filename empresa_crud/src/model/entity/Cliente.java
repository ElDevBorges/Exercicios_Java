package model.entity;

public class Cliente {
    private int id;
    private String nome;
    private String email;


    public Cliente (String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Cliente (String nome, String email, int id) {
        this.nome = nome;
        this.email = email;
        this.id = id;

    }
    
    public Cliente () {
    	
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
