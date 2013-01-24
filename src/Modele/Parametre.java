package Modele;

public class Parametre 
{
	private String[][] P_Menu;
	private int P_DureeVie;


	public Parametre() 
	{
		//Parametre en minute la dur�e de vie de la session
		this.P_DureeVie = 12000;
		
		this.P_Menu = new String[9][7];
		/***
		 * P_Menu
		 * 0 -> id
		 * 1 -> Libell� affich�
		 * 2 -> URL
		 * 3 -> id lieu	
		 * 4 -> scanner (1 -> affichage du formulaire pour scanner piece, l'action du formulaire est d�crit par l'url/0 -> affichage de l'URL)
		 * 5 -> action du scanner
		 * 6 -> page compl�mentaire au scanner ((0/1)page menu.html)
		 */
		
		P_Menu[0][0] = "0";
		P_Menu[0][1] = "Accueil";
		P_Menu[0][2] = "Accueil";
		P_Menu[0][3] = "0";		
		P_Menu[0][4] = "0";	
		P_Menu[0][5] = "0";	
		P_Menu[0][6] = " ";		
		
		P_Menu[1][0] = "1";
		P_Menu[1][1] = "Magasin";
		P_Menu[1][2] = "Magasin";
		P_Menu[1][3] = "1";
		P_Menu[1][4] = "0";	
		P_Menu[1][5] = "1";
		P_Menu[1][6] = "magasin";
		
		P_Menu[2][0] = "2";
		P_Menu[2][1] = "Metrologie";
		P_Menu[2][2] = "Metrologie";
		P_Menu[2][3] = "2";
		P_Menu[2][4] = "1";	
		P_Menu[2][5] = "0";
		P_Menu[2][6] = "ficheQualite";
		P_Menu[2][6] = "metrologie";
		
		P_Menu[3][0] = "3";
		P_Menu[3][1] = "Ordonnancement";
		P_Menu[3][2] = "Ordonnancement";
		P_Menu[3][3] = "3";
		P_Menu[3][4] = "0";	
		P_Menu[3][5] = "0";
		//P_Menu[3][6] = " ";
		P_Menu[3][6] = "genererAssemblage";
		
		P_Menu[4][0] = "4";
		P_Menu[4][1] = "R&D";
		P_Menu[4][2] = "R&D";
		P_Menu[4][3] = "4";
		P_Menu[4][4] = "1";	
		P_Menu[4][5] = "0";
		//P_Menu[4][6] = " ";
		P_Menu[4][6] = "modifierPieceRD";
		
		P_Menu[5][0] = "5";
		P_Menu[5][1] = "Production";
		P_Menu[5][2] = "Production";
		P_Menu[5][3] = "5";
		P_Menu[5][4] = "1";	
		P_Menu[5][5] = "0";	
		P_Menu[5][6] = "ficheSuiveuse";
		
		P_Menu[6][0] = "6";
		P_Menu[6][1] = "Qualite";
		P_Menu[6][2] = "Qualite";
		P_Menu[6][3] = "6";
		P_Menu[6][4] = "1";	
		P_Menu[6][5] = "0";
		P_Menu[6][6] = "ficheQualite";
		
		P_Menu[7][0] = "7";
		P_Menu[7][1] = "Expedition";
		P_Menu[7][2] = "Expedition";
		P_Menu[7][3] = "7";
		P_Menu[7][4] = "0";	
		P_Menu[7][5] = "0";
		//P_Menu[7][6] = " ";
		P_Menu[7][6] = "envoyerPiece";
		
		P_Menu[8][0] = "8";
		P_Menu[8][1] = "Aide";
		P_Menu[8][2] = "Aide";
		P_Menu[8][3] = "0";
		P_Menu[8][4] = "0";	
		P_Menu[8][5] = "0";
		P_Menu[8][6] = " ";
		
	}
	
	public int getP_DureeVie() 
	{
		return P_DureeVie;
	}

	public void setP_DureeVie(int p_DureeVie) 
	{
		P_DureeVie = p_DureeVie;
	}

	public int get_S_P_Menu()
	{
		return 9;
	}
	
	public String getMenu(int i, int j)
	{
		return P_Menu[i][j];
	}
	
}

