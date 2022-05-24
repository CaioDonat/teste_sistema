/**
Como forma de roterizacao foi utilizado comentario direto no codigo
 */

package senai.src.main.java.br.com.senai.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {

    //no fim de cada "registro" (nome;idade;filme) [ENTER]

    
    //Scheduling/Agendamento
    List<Agendamento> schedules = new ArrayList<Agendamento>();
    Scanner schedulesEntriesScr = new Scanner(System.in);
    int schedulesEntries = 0;
    System.out.println("Scheduling's entries: ");
    while (schedulesEntries == 0) {
      String schedulesEntriesStr = schedulesEntriesScr.next();//coleto a entrada como string para verificar
      if(entryIsANumber(schedulesEntriesStr)){
        if(validatingSchedulingEntries(Integer.parseInt(schedulesEntriesStr))){
          schedulesEntries = Integer.parseInt(schedulesEntriesStr);
          break;
        }
      }
        System.out.printf("Invalid entry, try again\nScheduling's entries: ");
    }

    for (int i=0; i<schedulesEntries; i++){        //valido (0 > numberOfEntry > 15 & numberOfEntry == int)
      Scanner scr3 = new Scanner(System.in);
      System.out.printf("%dº Scheduling\n", (i+1));  //show what user have to type
      String fullEntry = scr3.nextLine();     //necessario validar 'entradaFull' ('name's people';'age old';'name's movie')
      if (validatingInputSplit(fullEntry)){
        Agendamento scheduling = new Agendamento(fullEntry);
        schedules.add(scheduling);
      }else{
        System.out.printf("Invalid entry, try again\n%dº Scheduling: ", (i+1));
      }
    }

    //MoviesProgramming/ProgramacaoCinema
    List<ProgramacaoCinema> moviesProgramming = new ArrayList<ProgramacaoCinema>();

    Scanner moviesProgrammingEntriesScr = new Scanner(System.in);
    int moviesProgrammingEntries = 0;
    System.out.println("Scheduling's entries: ");
    while (moviesProgrammingEntries == 0) {
      String moviesProgrammingEntriesStr = moviesProgrammingEntriesScr.next();//coleto a entrada como string para verificar
      if(entryIsANumber(moviesProgrammingEntriesStr)){
        if(validatingMoviesProgrammingEntries(Integer.parseInt(moviesProgrammingEntriesStr))){
          moviesProgrammingEntries = Integer.parseInt(moviesProgrammingEntriesStr);
          break;
        }
      }
        System.out.printf("Invalid entry, try again\nScheduling's entries: ");
    }

    System.out.print("number of entry: ");
    Scanner scr = new Scanner(System.in);
    int numberOfEntry2 = scr.nextInt();
    for (int i=0; i<numberOfEntry2; i++){
      System.out.printf("%dº Entrada de Agendamento: \n", (i+1));

      Scanner scr1 = new Scanner(System.in);
      String entradaFull = scr1.nextLine();
      validatingInputSplit(entradaFull);
      ProgramacaoCinema programacaoCinema = new ProgramacaoCinema(entradaFull);
      moviesProgramming.add(programacaoCinema);
    }

    //Saida

    //Essa string que sera exibida como saida
    StringBuilder saidaString = new StringBuilder();

    for (ProgramacaoCinema pC : moviesProgramming){
      String nomeFilme = pC.getNome();
      int faixaEtaria = pC.getFaixaEtaria();
      saidaString.append(nomeFilme).append("\n");

      for (Agendamento ag : schedules){
        if (nomeFilme.equalsIgnoreCase(ag.getFilme())){
          if(ag.getIdade() >= faixaEtaria){
            saidaString.append("  ").append(ag.getNome()).append("\n");
          }
        }
      }
    }
    System.out.println(String.valueOf(saidaString));
  }

  private static boolean validatingMoviesProgrammingEntries(int moviesProgrammingEntries) {
    if(moviesProgrammingEntries > 0 && moviesProgrammingEntries < 3){
      return true;
    }else{
      return false;
    }
  }

  private static boolean validatingInputSplit(String fullEntry) {//verifica apenas se a entrada possui 3 parametros
      String[] splitString = fullEntry.split(";", 3);
      if(splitString.length == 3){
        return true;
      }else{
        return false;
      }
  }

  private static boolean entryIsANumber(String numberOfEntries) {
    int number = 0;
    try {
       number = Integer.parseInt(numberOfEntries);
    } catch (Exception e) {
    }
    if(number != 0){
      return true;
    }else{
      return false;
    }
  }

  private static boolean validatingSchedulingEntries(int schedulingEntries){
    if(schedulingEntries > 0 && schedulingEntries < 15){
      return true;
    }else{
      return false;
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
  