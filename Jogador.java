import java.util.random;
public abstract class Jogador {
    protected String nome;
    protected int HP; //pontos de vida
    protected int PE; // pontos de energia
    protected int ataque_basico;
    protected int defesa;
    protected int habilidade_elemental;
    protected int agilidade;
    protected int idPersonagem;


    public void setPersonagem(int idPersonagem){
        this.idPersonagem = idPersonagem;
    }


    public void pensarEstrategia(int valor){
        switch (valor) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                throw new AssertionError();
        }
    }

    public void aplicarEstrategia(){

    }

    public boolean Esquivar(Jogador oponente){
        int diferenca = this.agilidade - oponente.agilidade;
        int chance_de_esquivar = 10 + (diferenca*2);
        if(chance_de_esquivar < 5){
            chance_de_esquivar = 5;
        }
        else if(chance_de_esquivar > 50){
            chance_de_esquivar = 50;
        }
        int dado = Jogo.criarNumeroAleatorio();
        return dado <= chance_de_esquivar;
    }
    public abstract void modificarRegra(); // mudar as regras de acordo com o personagem
    public abstract void contarHistoria(); // História do personagem
    
}