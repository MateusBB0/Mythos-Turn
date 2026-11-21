import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        
        System.out.println("Escolha um personagem:\nDigite 1: Thor\nDigite 2: Melquesideque\nDigite 3: Loki");
        int personagem = tec.nextInt();
        if (personagem == 1) {
            Jogador jogador3 = new Thor();
        }
        if (personagem == 2) {
            Jogador jogador3 = new Melquisedeque();
        }
        if (personagem == 3) {
            Jogador jogador3 = new Loki();
        }

    }
}
