package package_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {

    //no fim de cada "registro" (nome;idade;filme) [ENTER]
    
    //Agendamento
    List<ProgramacaoCinema> programacosCinema = new ArrayList<ProgramacaoCinema>();
    System.out.print("number of entry: ");
    Scanner scr = new Scanner(System.in);
    int numberOfEntry = scr.nextInt();
    for (int i=0; i<numberOfEntry; i++){
      System.out.printf("%dº Entrada de Agendamento: \n", (i+1));

      Scanner scr2 = new Scanner(System.in);
      String entradaFull = scr2.nextLine();
      entradaValida(entradaFull);
      ProgramacaoCinema programacaoCinema = new ProgramacaoCinema(entradaFull);
      programacosCinema.add(programacaoCinema);
    }

    //ProgramacaoCinema
    List<Agendamento> agendamentos = new ArrayList<Agendamento>();
    System.out.println("number of entry");
    Scanner scr2 = new Scanner(System.in);
    numberOfEntry = scr2.nextInt();
    for (int i=0; i<numberOfEntry; i++){
      Scanner scr3 = new Scanner(System.in);
      System.out.printf("%dº Programação do Cinema: \n", (i+1));

      String entradaFull = scr3.nextLine();
      Agendamento agendamento = new Agendamento(entradaFull);
      agendamentos.add(agendamento);
      
    }

    //Saida

    //Essa string que sera exibida como saida
    StringBuilder saidaString = new StringBuilder();

    for (ProgramacaoCinema pC : programacosCinema){
      String nomeFilme = pC.getNome();
      int faixaEtaria = pC.getFaixaEtaria();
      saidaString.append(nomeFilme).append("\n");

      for (Agendamento ag : agendamentos){
        if (nomeFilme.equalsIgnoreCase(ag.getFilme())){
          if(ag.getIdade() >= faixaEtaria){
            saidaString.append("  ").append(ag.getNome()).append("\n");
          }
        }
      }
    }
    System.out.println(String.valueOf(saidaString));
  }

  private static void entradaValida(String entradaFull) {

    try{
      entradaFull.split(";", 3);

    }catch(Exception e){
      System.out.println("Erro => " + e);
    }
  }

/*
Entradas

3
Batman;16;3
Os Vingadores;12;4
Porto Seguro;L;2

7
Maria;25;Batman
Mateus;15;Os Vingadores
Pedro;20;Batman
Marcos;17;Os Vingadores
Beatriz;30;Os Vingadores
Joana;50;Porto Segurob
Felipe;18;Batman

*/
}
  