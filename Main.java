import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MythosTurn jogo = new MythosTurn();

        ArrayList<Jogador> jogadores = jogo.iniciarJogo();
        Jogador jogador1 = jogadores.get(0);
        Jogador jogador2 = jogadores.get(1);

        int turno = 0;
        int maxTurnos = 20;

        System.out.println("=== BATALHA INICIADA ===");

        while (!jogo.jogoAcabou() && turno < maxTurnos) {
            Jogador jogadorAtual;

            if (turno % 2 == 0) {
                jogadorAtual = jogador1;
            } else {
                jogadorAtual = jogador2;
            }

            System.out.println("--- Turno " + (turno + 1) + " | " + jogadorAtual.nome + " ---");
            System.out.println("HP: " + jogadorAtual.getHP() + " | PE: " + jogadorAtual.PE);
            System.out.println("HP do oponente: " + (jogadorAtual == jogador1 ? jogador2.getHP() : jogador1.getHP()));
            System.out.println();

            jogo.jogarTurno(jogadorAtual);

            if (jogadorAtual.turno_extra) {
                System.out.println("[TURNO EXTRA] " + jogadorAtual.nome + " joga novamente!");
                jogo.jogarTurno(jogadorAtual);
            }

            turno++;
        }

        System.out.println("=== FIM DE JOGO ===");
        if (jogador1.getHP() <= 0) {
            System.out.println(jogador2.nome + " venceu por nocaute!");
        } else if (jogador2.getHP() <= 0) {
            System.out.println(jogador1.nome + " venceu por nocaute!");
        } else {
            if (jogador1.getHP() > jogador2.getHP()) {
                System.out.println("Limite de turnos atingido! " + jogador1.nome + " venceu com mais HP!");
            } else if (jogador2.getHP() > jogador1.getHP()) {
                System.out.println("Limite de turnos atingido! " + jogador2.nome + " venceu com mais HP!");
            } else {
                System.out.println("Empate!");
            }
        }

    }
}