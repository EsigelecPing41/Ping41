package Modele;

public class Operation 
{
    private int Op_ID;
    private String Op_Libelle;
    private EtatOperation Op_EO;
    private String Op_A_Nom;
    
    public Operation(int ID,String A_Nom, String libelle,EtatOperation EO_ID)
    {
    	this.Op_ID =ID;
    	this.Op_A_Nom = A_Nom;
    	this.Op_Libelle=libelle;
    	this.Op_EO=EO_ID;
    }
    
    public Operation(String A_Nom, String libelle,EtatOperation EO_ID)
    {
    	this.Op_A_Nom = A_Nom;
    	this.Op_Libelle=libelle;
    	this.Op_EO=EO_ID;
    }
    
    public int getOp_ID()
    {
        return this.Op_ID;
    }

    public void setOp_ID(int value) 
    {
        this.Op_ID = value;
    }

    public String getOp_Libelle() 
    {
        return this.Op_Libelle;
    }

    public void setOp_Libelle(String value)
    {
        this.Op_Libelle = value;
    }

	public void setOp_EO(EtatOperation op_EO_ID) 
	{
		Op_EO = op_EO_ID;
	}

	public EtatOperation getOp_EO() 
	{
		return Op_EO;
	}

	public void setOp_A_Nom(String op_A_Nom)
	{
		Op_A_Nom = op_A_Nom;
	}

	public String getOp_A_Nom() 
	{
		return Op_A_Nom;
	}

}
