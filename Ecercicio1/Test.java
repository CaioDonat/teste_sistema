package teste_sistema.Ecercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

      //no fim de cada "registro" (nome; idade; filme) [ENTER]
      Scanner scanner = new Scanner(System.in);
      
      //Agendamento
      List<Agendamento> agendamentos = new ArrayList<>();
      System.out.println("use \"X\" para finalizar");
      for (int i=0; i<15; i++){
        System.out.printf("%dº Entrada de Agendamento: ", (i+1));

        String entradaFull = scanner.next();
        if(entradaFull.equalsIgnoreCase("X")){
          break;
        }
        Agendamento agendamento = new Agendamento(entradaFull);
        agendamentos.add(agendamento);
      }

      //ProgramacaoCinema
      List<ProgramacaoCinema> programacosCinema = new ArrayList<>();
      System.out.println("use \"X\" para finalizar");
      for (int i=0; i<=3; i++){
        System.out.printf("%dº Programação do Cinema: ", (i+1));

        String entradaFull = scanner.next();
        if(entradaFull.equalsIgnoreCase("X")){
          break;
        }
        ProgramacaoCinema programacaoCinema = new ProgramacaoCinema(entradaFull);
        programacosCinema.add(programacaoCinema);
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
            if(ag.getIdade() == faixaEtaria){
              //saidaString.append("    ").append();
            }
          }
        }
      }
    }
  }
  