package Modele;

import java.util.List;

public class ControleQualite
{
	private int CQ_ID;
    private int CQ_O_ID;
    private int CQ_A_ID;
    private boolean CQ_Resultat;
    private List<CritereQualite> CQ_ListCriteres;

	public ControleQualite(int CQ_ID,int CQ_O_ID,int CQ_A_ID,boolean CQ_Resultat, List<CritereQualite> CQ_ListCriteres ) 
	{
		this.CQ_ID = CQ_ID;
    	this.CQ_A_ID = CQ_A_ID;
    	this.CQ_O_ID = CQ_O_ID;
    	this.CQ_Resultat= CQ_Resultat;
    	this.CQ_ListCriteres = CQ_ListCriteres;
    	
	}
	
    public int getCQ_ID() 
    {
        return this.CQ_ID;
    }
    public void setCQ_ID(final int value) 
    {
        this.CQ_ID = value;
    }    
	
    public int getCQ_O_ID()
    {
        return this.CQ_O_ID;
    }   
    public void setCQ_O_ID(final int value)
    {
        this.CQ_O_ID = value;
    }
    
    public int getCQ_A_ID()
    {
        return this.CQ_A_ID;
    }
    
    public void setCQ_A_ID(final int value)
    {
        this.CQ_A_ID = value;
    }
	public void setCQ_ListCriteres(List<CritereQualite> cQ_ListCriteres)
	{
		CQ_ListCriteres = cQ_ListCriteres;
	}
	public List<CritereQualite> getCQ_ListCriteres()
	{
		return CQ_ListCriteres;
	}

	public void setCQ_Resultat(boolean cQ_Resultat)
	{
		CQ_Resultat = cQ_Resultat;
	}
	
	public boolean getCQ_Resultat() 
	{
		return CQ_Resultat;
	}
   
     
}

