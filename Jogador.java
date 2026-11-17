import java.util.random;
import java.util.ArrayList;
public abstract class Jogador {
    protected String nome;
    protected int HP; //pontos de vida
    protected int PE; // pontos de energia
    protected int ataque_basico;
    protected int defesa;
    // protected int habilidade_elemental;
    // protected int ataque_fisico_especial;
    protected ArrayList<Habilidade> ataques_elementais = new ArrayList<>();
    protected ArrayList<Habilidade> ataques_fisicos = new ArrayList<>();

    protected int agilidade;
    protected int idPersonagem;


    public void setPersonagem(int idPersonagem){
        this.idPersonagem = idPersonagem;
    }


    public void pensarEstrategia(){
        System.out.println("Escolha a estratégia");
        System.out.println("Digite\n1 - Ataque básico");
        System.out.println("2 - Ataques Elementais");
        System.out.println("3 - Ataques Físicos Especiais");
        System.out.println("4 - Defender");
        System.out.println("5 - Abrir Inventário");
    }

    public void aplicarEstrategia(Jogador oponente,int valor){
        switch (valor) {
                    case 1:
                        oponente.HP =- ataque_basico;
                        break;
                    case 2:
                        int perda_PE = 0;
                        oponente.HP =- habilidade_elemental;
                        PE =- perda_PE;
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