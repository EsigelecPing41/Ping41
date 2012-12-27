package Modele;


public class ControleQualite
{
    public int CQ_Resultat;
    public int CQ_ID;
    public int CQ_CrQ_ID;
    public int CQ_O_ID;
    public int CQ_A_ID;
    

	public ControleQualite(int Resultat,int ID,int ControleQualite,int Operateur,int Assemblage) {
		// TODO Auto-generated constructor stub
		
    	this.CQ_Resultat = Resultat;
    	this.CQ_A_ID = Assemblage;
    	this.CQ_O_ID = Operateur;
    	this.CQ_CrQ_ID = ControleQualite;
    	this.CQ_ID = ID;
	}
    public int getCQ_Resultat() 
    {
        return this.CQ_Resultat;
    }
    public void setCQ_Resultat(final int value) 
    {
        this.CQ_Resultat = value;
    }

    public int getCQ_ID() 
    {
        return this.CQ_ID;
    }
    public void setCQ_ID(final int value) 
    {
        this.CQ_ID = value;
    }    
	public int getCQ_CrQ_ID()
    {
        return this.CQ_CrQ_ID;
    }
    public void setCQ_CrQ_ID(final int value)
    {
        this.CQ_CrQ_ID = value;
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
     
}

