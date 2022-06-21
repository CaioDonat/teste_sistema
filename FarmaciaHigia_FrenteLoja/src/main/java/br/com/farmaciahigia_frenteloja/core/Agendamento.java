/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.farmaciahigia_frenteloja.core;

/**
 *
 * @author caiodonat
 */
public class Agendamento {
    
    private String nome;
    private int idade;
    private String filme;

    public Agendamento(String nome, String idade, String filme) {
        this.nome = nome;
        this.idade = Integer.parseInt(idade);
        this.filme = filme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }
}
