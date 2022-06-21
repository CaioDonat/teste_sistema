package package_one;

public class ProgramacaoCinema {
    
    private String nome;
    private int faixaEtaria;
    private int capacidadeSala;

    public ProgramacaoCinema(String entradaFull) {

        String[] entradaSplit = entradaFull.split(";", 3);

        this.nome = entradaSplit[0];
        this.faixaEtaria = setFaixaEtaria(entradaSplit[1]);
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
    public int setFaixaEtaria(String faixaEtaria) {
        if(faixaEtaria.equalsIgnoreCase("L")){
            this.faixaEtaria = 0;
            return 0;

        }else {
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

    public int StringToInteger(String entrada){
            return Integer.parseInt(entrada);
    }
    
}
