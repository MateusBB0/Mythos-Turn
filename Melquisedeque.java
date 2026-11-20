public class Melquisedeque extends Jogador{
    public boolean escudo = false;
    public Melquisedeque(){
        super("Melquisedeque", 800, 75, 15, 1, "Trevas");
        this.ataques.add(new Habilidade("Golpe básico", 10, "Físico",0, 0));
        this.ataques.add(new Habilidade("Luz divina", 45, "Luz", 0, 7));
        this.ataques.add(new Habilidade("Mão de Deus", 80, "Físico",50, 0));
        this.ataques.add(new Habilidade("Luz mitológica", 180, "Luz", 0, 30));
        
        this.inventario.add(new Itens_inventario("Poção de Cura", 3, 50, 0));
        this.inventario.add(new Itens_inventario("Poção de Recuperar PE", 7, 0, 10));

    }

    @Override 
    public void descricao(){
        System.out.println("O antigo Rei de Salém e sacerdote supremo citado nas tradições bíblicas, retratado como um guerreiro sábio de aura celestial justo. Possui atributos equilibrados e domínio sobre habilidades de Luz suporte, tendo fraqueza contra ataques de Trevas. ");
    }

    // Muda a regra de defesa
    @Override 
    public void mudanca(){
        this.escudo = true;
        System.out.println("Égide de Salém Ativada! \n (30% a menos de dano e 30% refletem no inimigo)");
    }

    @Override 
    public void aplicarEstrategia(Jogador oponente,int valor, int id) {
        super.aplicarEstrategia(oponente, valor, id);
        Habilidade hab_oponente = this.ataques.get(id);

        // Quando a persona ativa se Defende, ativa a passiva "Égide de Salém", 
        if(valor >= 1 && valor <= 3){
            this.PE += 5; 
            // Recupera PE a cada ataque
        }
        if(valor == 4){
            mudanca();
            if (escudo == true) {
                this.HP -= (int) (oponente.hab_oponente.getDano()* 0.7);
                this.PE -= (int) (oponente.hab_oponente.getDano()* 0.3);
                turno_extra = false;
                // Não vai ter turno extra!
            }
        }
    }
}
