public class Habilidade {
    public String nome;
    public int dano;
    public String elemento;
    public int gasta_HP;
    public int gasta_PE;

    public Habilidade(String nome, int dano, String elemento, int gasta_HP, int gasta_PE){
        this.nome = nome;
        this.dano = dano;
        this.elemento = elemento;
        this.gasta_HP = gasta_HP;
        this.gasta_PE = gasta_PE;
    }
}
