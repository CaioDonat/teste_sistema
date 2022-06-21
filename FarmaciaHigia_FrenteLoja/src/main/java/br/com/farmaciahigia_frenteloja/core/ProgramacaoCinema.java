/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.farmaciahigia_frenteloja.core;

/**
 *
 * @author caiodonat
 */
public class ProgramacaoCinema {
    
    private String nome;
    private int faixaEtaria;
    private int capacidadeSala;
    
    public ProgramacaoCinema() {
    }
    
    public ProgramacaoCinema(String nome, String faixaEtaria, String capacidadeSala) {

        this.nome = nome;
        this.faixaEtaria = setFaixaEtaria(faixaEtaria);
        this.capacidadeSala = StringToInteger(capacidadeSala);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public int setFaixaEtaria(String faixaEtaria) {
        if (faixaEtaria.equalsIgnoreCase("L")) {
            this.faixaEtaria = 0;
            return 0;

        } else {
            this.faixaEtaria = StringToInteger(faixaEtaria);
            return StringToInteger(faixaEtaria);
        }
    }

    public int getCapacidadeSala() {
        return capacidadeSala;
    }

    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }

    public int StringToInteger(String entrada) {
        return Integer.parseInt(entrada);
    }

    
}
