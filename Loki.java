final class Loki extends Jogador{

    public boolean esquivou = false;
    public Loki(){
        super("Loki", 300, 60, 35, 1, "Luz");
        this.ataques.add(new Habilidade("Golpe básico", 8, "Físico",0, 0));
        this.ataques.add(new Habilidade("Neblina escura", 65, "Trevas", 0, 5));
        this.ataques.add(new Habilidade("Lâmina fulgaz", 100, "Físico",30, 0));
        this.ataques.add(new Habilidade("Arma de fogo", 80, "Fogo", 0, 20));
        
        this.inventario.add(new Itens_inventario("Poção de Cura", 10, 50, 0));
        this.inventario.add(new Itens_inventario("Poção de Recuperar PE", 10, 0, 10));

    }

    @Override 
    public void descricao(){
        System.out.println("O astuto deus nórdico da trapaça e das ilusões. Tem baixa resistência física, mas altíssima Agilidade e domínio sobre ataques de Trevas e Fogo, possuindo fraqueza contra as habilidades de Luz.");
    }

    // Muda a regra de esquiva
    @Override 
    public void mudanca(){
        System.out.println("Passo Trapaceiro Ativada! \n (Aumenta a probabilidade de esquivar e, quando desvia, drena 15HP do inimigo)");
    }

    

    @Override
    public boolean Esquivar(Jogador oponente) {
        int diferenca = this.agilidade - oponente.agilidade;
        int chance_de_esquivar = 10 + (diferenca*2);
        if(chance_de_esquivar < 10){
            chance_de_esquivar = 10;
        }
        else if(chance_de_esquivar > 65){
            chance_de_esquivar = 65;
        }
        int dado = Jogo.criarNumeroAleatorio();

        boolean esquivou = dado <= chance_de_esquivar;
        if (esquivou) {
            // Passiva: drenar 15 HP do oponente
            oponente.HP -= 15;
            HP += 15;
            System.out.println("Drenou 15HP do inimigo");
        }
        return esquivou;
    }
    
}