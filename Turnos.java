import java.util.Scanner;
import java.util.ArrayList;

public class Turnos implements Jogo{
    private ArrayList<Jogador> jogadores;
    public Scanner tec;

    public Turnos(){
        this.jogadores = new ArrayList<>();
        this.tec = new Scanner(System.in);
    }

    @Override 
    public ArrayList<Jogador> iniciarJogo(){
        System.out.println("BEM VINDO AO MYTHOS TURN!");
        System.out.println("\nEscolha seu personagem:");
        Jogador jogador1 = null;
        Jogador jogador2 = null;

        System.out.println("Digite 1: Thor");
        System.out.println("Digite 2: Melquisedeque");    
        System.out.println("Digite 3: Loki");
        System.out.println("Digite 0: Voltar");

        while (jogador1 == null) {
            
            int opcao = tec.nextInt();
            switch (opcao) {
                case 1:
                    jogador1 = new Thor();
                    break;
                case 2:
                    jogador1 = new Melquisedeque();
                    break;
                case 3:
                    jogador1 = new Loki();
                    break;
                case 0:
                    return null;
                    break;
                default:
                    System.out.println("Nenhum personagem foi escolhido! tente novamente!");
                    break;
            }
        }





        return jogadores;
    }
}
