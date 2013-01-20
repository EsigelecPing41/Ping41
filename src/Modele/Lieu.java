package Modele;

public class Lieu 
{
    private int L_ID;
    private String L_Nom;

    public Lieu(int ID, String Nom)
    {
    	this.L_ID=ID;
    	this.L_Nom=Nom;
    }
    
    public Lieu(String Nom)
    {
    	this.L_Nom=Nom;
    }
    
    public int getL_ID()
    {
        return this.L_ID;
    }

    public void setL_ID(final int value) 
    {
        this.L_ID = value;
    }

    public String getL_Nom() 
    {
        return this.L_Nom;
    }

    public void setL_Nom(final String value)
    {
        this.L_Nom = value;
    }

}
