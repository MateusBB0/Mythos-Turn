public class Itens_inventario {
    public String nome;
    private int quantidade;
    public int recuperar_hp;
    public int recuperar_pe;

    public Itens_inventario(String nome, int quantidade, int recuperar_hp, int recuperar_pe) {
        this.nome = nome;
        setQuantidade(quantidade);
        this.recuperar_hp = recuperar_hp;
        this.recuperar_pe = recuperar_pe;
    }

    

    public void setQuantidade(int quantidade){
        if (quantidade >= 0 && quantidade <= 100) {
            this.quantidade = quantidade;
        }
    }

    public int getQuantidade(){
        return quantidade;
    }

    public int reduzirQtd(){
        return this.quantidade--;
    }

    public String getNome() {
        return nome;
    }

    public int getRecuperar_hp() {
        return recuperar_hp;
    }

    public int getRecuperar_pe() {
        return recuperar_pe;
    }

}
