package tetris;

public enum Forme {
	ROUGE,
	BLEU,
	VERT,
	ORANGE,
	MAGENTA,
	CYAN,
	JAUNE;
	public static Forme getForme() {
        return values()[(int) (Math.random() * values().length)];
    }

}
