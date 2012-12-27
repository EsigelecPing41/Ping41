package Modele;

public class Bon 
{
    private String B_Designation;
    private String B_Reference;
    private String B_NumDossier;
    private int B_Quantite;

    public Bon (String b_Designation, String b_Reference, String b_NumDossier, int b_Quantite)
    {
		super();
        B_Designation= b_Designation;
        B_Reference=b_Reference;
        B_NumDossier=b_NumDossier;
        B_Quantite=b_Quantite;
    }
    

    public String getB_Designation()
    {
        return this.B_Designation;
    }

    public void setB_Designation( String  b_Designation)
    {
        this.B_Designation =  b_Designation;
    }

    public String getB_Reference() 
    {
        return this.B_Reference;
    }

    public void setB_Reference(String b_Reference) 
    {
        this.B_Reference = b_Reference;
    }

    public String getB_NumDossier()
    {
        return this.B_NumDossier;
    }

    public void setB_NumDossier(String b_NumDossier)
    {
        this.B_NumDossier = b_NumDossier;
    }

    public int getB_Quantite()
    {
        return this.B_Quantite;
    }

    public void setB_Quantite( int b_Quantite)
    {
        this.B_Quantite = b_Quantite;
    }
    

    public void CreerBon() 
    {
    }

    public void SupprimerBon()
    {
    }

    public void ModifierBon() 
    {
    }

    public void AfficherBon() 
    {
    }

}
