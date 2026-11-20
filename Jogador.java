import java.util.ArrayList;
public abstract class Jogador{
    protected String nome;
    protected int HP; //pontos de vida
    protected int PE; // pontos de energia
    protected ArrayList<Habilidade> ataques = new ArrayList<>();
    protected ArrayList<Itens_inventario> inventario = new ArrayList<>();
    protected int agilidade;
    protected int idPersonagem;
    protected String fraqueza;
    protected boolean defender = false; //defesa desativada

    // Não tem como colocar ArrayList como parâmetro
    public Jogador(String nome, int HP, int PE, int agilidade, int idPersonagem, String fraqueza){
        this.nome = nome;
        this.HP = HP;
        this.PE = PE;
        this.ataques = new ArrayList<>();
        this.inventario = new ArrayList<>();
        this.agilidade = agilidade;
        this.idPersonagem = idPersonagem;
        this.fraqueza = fraqueza;
    }

    public void defesa(){
        this.defender = true;
        System.out.println("Defesa ativada!");
    }

    public int getHP() {
        return HP;
    }

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

    public boolean turno_extra;

    public void aplicarEstrategia(Jogador oponente,int valor, int id){

        if((valor >= 1 && valor <= 3) && oponente.Esquivar(oponente) == true){
            System.out.println(oponente.nome + "esquiva!");
            return;
        }

        this.turno_extra = false;

        Habilidade atacar = this.ataques.get(id);
        switch (valor) {
                    // Ataque básico
                    case 1:
                        if(atacar.getElemento().equals("Físico") && atacar.getGasta_HP() == 0){
                            if(oponente.defender == true){
                                oponente.HP -= (int) (0.3*atacar.getDano());    
                            }
                            else{
                                oponente.HP -= atacar.getDano();    
                            }
                            
                            // Se o golpe é igual a fraqueza do adversário, terá turno extra
                            if(atacar.getElemento().equals(oponente.fraqueza)){
                                this.turno_extra = true;
                                System.out.println("Inimigo atordoado!");
                            }
                        }
                        break;
                    // Ataques elementais
                    case 2:
                        if(!atacar.getElemento().equals("Físico") && atacar.getGasta_PE() > 0){
                            if(oponente.defender == true){
                                oponente.HP -= (int) (0.3*atacar.getDano());      
                                this.PE -= atacar.getGasta_PE();  
                            }
                            else{
                                oponente.HP -= atacar.getDano(); 
                                this.PE -= atacar.getGasta_PE(); 
                            }

                            // Se o golpe é igual a fraqueza do adversário, terá turno extra
                            if(atacar.getElemento().equals(oponente.fraqueza)){
                                this.turno_extra = true;
                                System.out.println("Inimigo atordoado!");
                            }
                        }
                        break;
                    // Ataques físicos especiais
                    case 3:
                        if(atacar.getElemento().equals("Físico") && atacar.getGasta_HP() > 0){
                            if(oponente.defender == true){
                                oponente.HP -= (int) (0.3*atacar.getDano());  
                                this.HP -= atacar.getGasta_HP();  
                            }
                            else{
                                oponente.HP -= atacar.getDano(); 
                                this.HP -= atacar.getGasta_HP(); 
                            }
                            // Se o golpe é igual a fraqueza do adversário, terá turno extra
                            if(atacar.getElemento().equals(oponente.fraqueza)){
                                this.turno_extra = true;
                                System.out.println("Inimigo atordoado!");
                            }
                        }
                        break;
                    // Defender
                    case 4:
                        this.defesa();
                        break;
                    // Inventário
                    case 5:
                        if (inventario.isEmpty()) {
                            System.out.println("Não há itens utilizáveis!");
                            break;
                        }

                        Itens_inventario usado = this.inventario.get(id);
                        HP += usado.getRecuperar_hp();
                        PE += usado.getRecuperar_pe();
                        usado.getQuantidade();
                        

                        if(usado.getQuantidade() <= 0){
                            this.inventario.remove(id);
                            System.out.println(usado.getNome()+" acabou!");
                        }
                        break;
        }
    }

    // Esquivar(%) = Chance Base(10%) + (agilidade defensor - agilidade do atacante) * 2
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