package Modele;

enum Etat
{
	Annule,Suspendu,EnCours,Fait,ControleOK,EnAttente;
}

public class Operation 
{
    private int Op_ID;
    private String Op_Libelle;
    private Etat Op_Etat;
    
    public Operation(int ID, String nom)
    {
    	this.Op_ID =ID;
    	this.Op_Libelle=nom;
    }
    
    public int getOp_ID()
    {
        return this.Op_ID;
    }

    public void setOp_ID(final int value) 
    {
        this.Op_ID = value;
    }

    public String getOp_Libelle() 
    {
        return this.Op_Libelle;
    }

    public void setOp_Libelle(final String value)
    {
        this.Op_Libelle = value;
    }

	public void setOp_Etat(Etat op_Etat)
	{
		Op_Etat = op_Etat;
	}

	public Etat getOp_Etat() 
	{
		return Op_Etat;
	}

}
