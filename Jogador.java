import java.util.random;
public abstract class Jogador {
    protected String nome;
    protected int HP; //pontos de vida
    protected int PE; // pontos de energia
    protected int ataque_basico;
    protected int defesa;
    protected int habilidade_elemental;
    protected int ataque_fisico_especial;
    protected int agilidade;
    protected int idPersonagem;


    public void setPersonagem(int idPersonagem){
        this.idPersonagem = idPersonagem;
    }


    public void pensarEstrategia(Jogador oponente,int valor){
        switch (valor) {
            case 1:
                oponente.HP =- ataque_basico;
                break;
            case 2:
                oponente.HP =- habilidade_elemental;
                PE =- 20;
                break;
            case 3:

                break;
            case 4:
                // defesa =- ;
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
    public abstract void mudanca(); // mudar as regras de acordo com o personagem
    public abstract void descricao(); // História do personagem
    
}