package tetris;

public class Brique {
	boolean tab[][];
	private int id;
	private int forme;
	private Cellule position;
	private int rotation;
	static int cpt =0;
	
	public Brique (int forme){
		this.tab = new boolean[3][3];
		this.id=this.cpt;
		cpt++;
		this.forme=forme;
		this.position=new Cellule();
		this.rotation = 0;
		
	}

	public void drawShape(){
		switch (this.forme){
		/*
		 * T    
		 * T T  
		 *   T  
		 */
		case 1:
			this.tab[0][0]=true;
			this.tab[0][1]=false;
			this.tab[0][2]=false;

			this.tab[1][0]=true;
			this.tab[1][1]=true;
			this.tab[1][2]=false;

			this.tab[2][0]=false;
			this.tab[2][1]=true;
			this.tab[2][2]=false;
			break;

			/*
			 *     T
			 *   T T
			 *   T 
			 */	
		case 2:
			this.tab[0][0]=false;
			this.tab[0][1]=false;
			this.tab[0][2]=true;

			this.tab[1][0]=false;
			this.tab[1][1]=true;
			this.tab[1][2]=true;

			this.tab[2][0]=false;
			this.tab[2][1]=true;
			this.tab[2][2]=false;
			break;
			
			/*
			 * T
			 * T
			 * T
			 */
			
		case 3:
			this.tab[0][0]=true;
			this.tab[0][1]=false;
			this.tab[0][2]=false;

			this.tab[1][0]=true;
			this.tab[1][1]=false;
			this.tab[1][2]=false;

			this.tab[2][0]=true;
			this.tab[2][1]=false;
			this.tab[2][2]=false;
			break;
		
			/*
			 * T T
			 * T T
			 */
		case 4:
			this.tab[0][0]=false;
			this.tab[0][1]=false;
			this.tab[0][2]=false;

			this.tab[1][0]=true;
			this.tab[1][1]=true;
			this.tab[1][2]=false;

			this.tab[2][0]=true;
			this.tab[2][1]=true;
			this.tab[2][2]=false;
			break;
		
			/*
			 * T
			 * T T
			 * T
			 */
		case 5 : 
			this.tab[0][0]=true;
			this.tab[0][1]=false;
			this.tab[0][2]=false;

			this.tab[1][0]=true;
			this.tab[1][1]=true;
			this.tab[1][2]=false;

			this.tab[2][0]=true;
			this.tab[2][1]=false;
			this.tab[2][2]=false;
			break;
			
			/* 
			 * 	 T
			 *   T
			 * T T
			 * 	
			 * 
			 */
		case 6 : 
			this.tab[0][0]=false;
			this.tab[0][1]=false;
			this.tab[0][2]=true;

			this.tab[1][0]=false;
			this.tab[1][1]=false;
			this.tab[1][2]=true;

			this.tab[2][0]=false;
			this.tab[2][1]=true;
			this.tab[2][2]=true;
			break;
			
			/*
			 * T
			 * T
			 * T T
			 */
		case 7 : 
			this.tab[0][0]=true;
			this.tab[0][1]=false;
			this.tab[0][2]=false;

			this.tab[1][0]=true;
			this.tab[1][1]=false;
			this.tab[1][2]=false;

			this.tab[2][0]=true;
			this.tab[2][1]=true;
			this.tab[2][2]=false;
			break;
		}
				
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getForme(){
		return this.forme;
	}
	
	public Cellule getPosition(){
		return this.position;
	}
	
	public int getRotation(){
		return this.rotation;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	

}
