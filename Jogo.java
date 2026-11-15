import java.util.ArrayList;
public interface Jogo {
    ArrayList<Jogador> iniciarJogo();
    public void jogarTurno(Jogador jogador);
    public boolean jogoAcabou();
    static int criarNumeroAleatorio(){
        return (int) (Math.random()*100);
    }

}
