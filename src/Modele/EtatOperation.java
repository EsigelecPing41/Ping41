package Modele;

public class EtatOperation
{
	private int E_ID;
	private String E_Etat;

	public EtatOperation(int ID,String etat)
	{
		this.E_ID=ID;
		this.E_Etat=etat;
	}
	
	public EtatOperation(String etat)
	{
		this.E_Etat=etat;
	}

	public void setE_ID(int e_ID)
	{
		E_ID = e_ID;
	}
	public int getE_ID() 
	{
		return E_ID;
	}
	public void setE_Etat(String e_Etat) 
	{
		E_Etat = e_Etat;
	}
	public String getE_Etat() 
	{
		return E_Etat;
	}

}
