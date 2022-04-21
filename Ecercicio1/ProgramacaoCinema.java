package teste_sistema.Ecercicio1;
public class ProgramacaoCinema {
    
    private String nome;
    private int faixaEtaria;
    private int capacidadeSala;

    public ProgramacaoCinema(String entradaFull) {

        String[] entradaSplit = entradaFull.split(";", 3);

        this.nome = entradaSplit[0];
        this.faixaEtaria = StringToInteger(entradaSplit[1]);
        this.capacidadeSala = StringToInteger(entradaSplit[2]);
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
    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    public int getCapacidadeSala() {
        return capacidadeSala;
    }
    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }

    public int StringToInteger(String entrada){
            return Integer.parseInt(entrada);
    }
    
}
