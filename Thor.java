public class Thor extends Jogador{
    public Thor(){
        super("Thor", 500, 70);
        this.ataques_fisicos.add(new Habilidade("Golpe básico", 10, "Físico",0, 0));
        this.ataques_elementais.add(new Habilidade("Ziodyne", 45, "Trovão", 0, 7));
        this.ataques_fisicos.add(new Habilidade("Martelada Gigante", 50, "Físico",30, 0));
        this.ataques_elementais.add(new Habilidade("Maziodyne", 100, "Trovão", 0, 20));
    }
}
