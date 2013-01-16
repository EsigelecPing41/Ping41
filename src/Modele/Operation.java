package Modele;

public class Operation 
{
    private int Op_ID;
    private String Op_Libelle;
    private EtatOperation Op_EO;
    
    public Operation(int ID, String libelle,EtatOperation EO)
    {
    	this.Op_ID =ID;
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

	

}
