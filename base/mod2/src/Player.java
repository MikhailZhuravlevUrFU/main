import java.util.Random;

public class Player {
    public enum VARIANTS { ROCK, PAPER, SCISSORS }

    private VARIANTS arg;
    private String name;

    public Player() {
        this.arg = randomArg();
        this.name = "Bot";
    }

    public Player(VARIANTS arg, String name) {
        this.arg = arg;
        this.name = name;
    }

    public String whoWins(Player player1, Player player2) {
        if (player1.arg == player2.arg) {
            return "Ничья";
        } else if ((player1.arg == VARIANTS.ROCK && player2.arg == VARIANTS.SCISSORS) ||
                (player1.arg == VARIANTS.PAPER && player2.arg == VARIANTS.ROCK) ||
                (player1.arg == VARIANTS.SCISSORS && player2.arg == VARIANTS.PAPER)) {
            return "Победил игрок с именем: " + player1.name;
        } else {
            return "Победил игрок с именем: " + player2.name;
        }
    }

    private VARIANTS randomArg() {
        Random random = new Random();
        return VARIANTS.values()[random.nextInt(VARIANTS.values().length)];
    }
}

