package package_one;

public class Agendamento {

    private String nome;
    private int idade;
    private String filme;
    
    public Agendamento(String entrada) {
        
        String[] entradaA = entrada.split(";", 3);

        this.nome = entradaA[0];
        this.idade = Integer.parseInt(entradaA[1]);
        this.filme = entradaA[2];
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
