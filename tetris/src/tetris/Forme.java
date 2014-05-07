package tetris;

/**
 * 
 * les diff�rentes formes possibles
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
	 * donne une forme par tirage al�atoire
	 * @return Forme
	 */
	public static Forme getForme() {
        return values()[(int) (Math.random() * values().length)];
    }

}
