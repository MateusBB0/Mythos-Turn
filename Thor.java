public class Thor extends Jogador{
    public boolean sobrecarga = false;
    public Thor(){
        super("Thor", 500, 70, 10, 1, "Fogo");
        this.ataques.add(new Habilidade("Golpe básico", 20, "Físico",0, 0));
        this.ataques.add(new Habilidade("Ziodyne", 60, "Trovão", 0, 7));
        this.ataques.add(new Habilidade("Martelada Gigante", 120, "Físico",(int) (HP*0.4), 0));
        this.ataques.add(new Habilidade("Maziodyne", 100, "Trovão", 0, 20));
        
        this.inventario.add(new Itens_inventario("Poção de Cura", 5, 50, 0));
        this.inventario.add(new Itens_inventario("Poção de Recuperar PE", 4, 0, 10));

    }

    @Override 
    public void descricao(){
        System.out.println("O grande deus nórdico do trovão, empunhando seu martelo Mjolnir, está pronto para te ajudar em grandes batalhas. Ele possui alto poder físico e tem a habilidade elemental do trovão, mas tem uma agilidade 'normal' fraqueza contra ataque de fogo e gelo. ");
    }
    @Override 
    public void mudanca(){
        this.sobrecarga = true;
        System.out.println("Sobrecarga Ativada!");
    }

    @Override 
    public void aplicarEstrategia(Jogador oponente,int valor, int id) {
        super.aplicarEstrategia(oponente, valor, id);
        Habilidade atacar = this.ataques.get(id);
        int contador = 0;
        // Se ele atacar 2 vezes o oponente com sua fraqueza, o próximo ataque aumenta em 30%
        if(valor >= 1 && valor <= 3){
            while (atacar.getElemento().equals(oponente.fraqueza)) {
                contador++;
                if(contador == 2){ 
                    mudanca();
                }
                for(Habilidade ataq : this.ataques){
                    if(sobrecarga == true){
                        if (ataq.getElemento().equals("Trovão")) {
                            ataq.dano = (int) (ataq.dano + (ataq.dano*0.3));
                            System.out.println("Sobrecarga! O dano de"+ ataq.getNome() +" aumentou em 30%!");
                        }
                    }
                }
            }
        }

    }
    
}
