package tetris;

/**
 * 
 * les différentes formes possibles
 *
 */
public enum Forme {
	ROUGE,
	BLEU,
	VERT,
	ORANGE,
	MAGENTA,
	CYAN,
	JAUNE;
	
	/**
	 * donne une forme par tirage aléatoire
	 * @return Forme
	 */
	public static Forme getForme() {
        return values()[(int) (Math.random() * values().length)];
    }

}
