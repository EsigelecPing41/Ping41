package Modele;
public class EtatOperation 
{
    private int E_ID;
    public Piece E_Piece;
    private enum E_Etat {Annule, Suspendu, EnCours, Fait, ControleOK, EnAttente};
    	

    public int getE_ID() 
    {
    	return this.E_ID;
    }

    public void setE_ID(final int value) 
    {
        this.E_ID = value;
    }
}
