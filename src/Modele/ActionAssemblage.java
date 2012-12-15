package Modele;
import java.util.Date;

public class ActionAssemblage extends Action
{
	private int AA_IDAssemblage;
	
	public ActionAssemblage(Date aP_Date, int AA_IDAssemblage, int aP_IDOperateur, int aP_IDOperation) {
		super(aP_Date, aP_IDOperateur, aP_IDOperation);
		this.AA_IDAssemblage = AA_IDAssemblage;
	}

    
    public int getAA_IDAssemblage() {
		return AA_IDAssemblage;
	}

	public void setAA_IDAssemblage(int AA_IDAssemblage) {
		this.AA_IDAssemblage = AA_IDAssemblage;
	}

	
	

	

}

