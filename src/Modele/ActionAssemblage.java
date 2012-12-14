package Modele;
import java.util.Date;

public class ActionAssemblage
{
    

	private Date AA_Date;
    private int AA_IDAssemblage;
    private int AA_IDOperateur;
    private int AA_IDOperation;

    
    public int getAA_IDAssemblage() {
		return AA_IDAssemblage;
	}

	public void setAA_IDAssemblage(int AA_IDAssemblage) {
		this.AA_IDAssemblage = AA_IDAssemblage;
	}

	public int getAA_IDOperateur() {
		return AA_IDOperateur;
	}

	public void setAA_IDOperateur(int AA_IDOperateur) {
		this.AA_IDOperateur = AA_IDOperateur;
	}

	public int getAA_IDOperation() {
		return AA_IDOperation;
	}

	public void setAA_IDOperation(int AA_IDOperation) {
		this.AA_IDOperation = AA_IDOperation;
	}
	
    public Date getAA_Date()
    {
        return this.AA_Date;
    }

    public void setAA_Date(final Date value)
    {
        this.AA_Date = value;
    }

	

	

}

