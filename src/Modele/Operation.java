package Modele;

public class Operation 
{
    private int Op_ID;
    private String Op_Libelle;
<<<<<<< HEAD
    private int Op_EO_ID;
    private String Op_A_Nom;
    
    public Operation(int ID,String A_Nom, String libelle,int EO_ID)
=======
    private EtatOperation Op_EO;
    
    public Operation(int ID, String libelle,EtatOperation EO)
>>>>>>> 3a2463e7daa32c40f1da54cdd3bf403687e44640
    {
    	this.Op_ID =ID;
    	this.Op_A_Nom = A_Nom;
    	this.Op_Libelle=libelle;
    	this.Op_EO=EO;
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

	/**
	 * @return the op_EO_ID
	 */
	public EtatOperation getOp_EO() {
		return Op_EO;
	}

	/**
	 * @param op_EO_ID the op_EO_ID to set
	 */
	public void setOp_EO_ID(EtatOperation op_EO_ID) {
		Op_EO = op_EO_ID;
	}

<<<<<<< HEAD
	public void setOp_A_Nom(String op_A_Nom)
	{
		Op_A_Nom = op_A_Nom;
	}

	public String getOp_A_Nom() 
	{
		return Op_A_Nom;
	}
=======
	
>>>>>>> 3a2463e7daa32c40f1da54cdd3bf403687e44640

}
