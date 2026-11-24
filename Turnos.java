import java.util.Scanner;
import java.util.ArrayList;

public class Turnos implements Jogo
{
    private ArrayList<Jogador> jogadores;
    public Scanner tec;

    public Turnos()
    {
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

        while (jogador1 == null)
        {
            
            int opcao1 = tec.nextInt();
            switch (opcao1) {
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
                default:
                    System.out.println("Nenhum personagem foi escolhido! tente novamente!");
                    break;
        
        }
            while (jogador2 == null) 
            {
            
                int opcao2 = tec.nextInt();
                switch (opcao2) 
                {
                    case 1:
                        jogador2 = new Thor();
                        break;
                    case 2:
                        jogador2 = new Melquisedeque();
                        break;
                    case 3:
                        jogador2 = new Loki();
                        break;
                    case 0:
                        return null;
                    default:
                        System.out.println("Nenhum personagem foi escolhido! tente novamente!");
                        break;

                }
            }
    }
    public void jogarTurno(Jogador jogador){

        
    }
    public boolean jogoAcabou()
    {
            System.out.println("=== FIM DE JOGO ===");
            if (jogador1.getHP() <= 0) {
                System.out.println(jogador2.nome + " venceu por nocaute!");
                return true;
            } else if (jogador2.getHP() <= 0) {
                System.out.println(jogador1.nome + " venceu por nocaute!");
                return true;
            } else {
                if (jogador1.getHP() > jogador2.getHP()) {
                    System.out.println("Limite de turnos atingido! " + jogador1.nome + " venceu com mais HP!");
                } else if (jogador2.getHP() > jogador1.getHP()) {
                    System.out.println("Limite de turnos atingido! " + jogador2.nome + " venceu com mais HP!");
                    return true;
                } else {
                    System.out.println("Empate!");
                    return true;
                }
            return false;

    }




        return jogadores;
}
        


    
