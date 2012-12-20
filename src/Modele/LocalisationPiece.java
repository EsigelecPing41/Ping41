package Modele;

import java.util.Date;

public class LocalisationPiece 
{
	private int LP_ID;
	private Date LP_Date;
	private int LP_O_ID;
	private int LP_L_ID;
	private int LP_P_ID;
	
	public LocalisationPiece(int lP_ID, Date lP_Date, int lP_O_ID, int lP_L_ID, int lP_P_ID)
	{
		super();
		LP_ID = lP_ID;
		LP_Date = lP_Date;
		LP_O_ID = lP_O_ID;
		LP_L_ID = lP_L_ID;
		setLP_P_ID(lP_P_ID);
	}
	
	public int getLP_ID() 
	{
		return LP_ID;
	}
	public void setLP_Id(int lP_ID) 
	{
		LP_ID = lP_ID;
	}
	public Date getLP_Date() 
	{
		return LP_Date;
	}
	public void setLP_Date(Date lP_Date) 
	{
		LP_Date = lP_Date;
	}
	public int getLP_O_ID()
	{
		return LP_O_ID;
	}
	public void setLP_O_ID(int lP_O_ID)
	{
		LP_O_ID = lP_O_ID;
	}
	public int getLP_L_ID()
	{
		return LP_L_ID;
	}
	public void setLP_L_ID(int lP_L_ID) 
	{
		LP_L_ID = lP_L_ID;
	}

	public void setLP_P_ID(int lP_P_ID) 
	{
		LP_P_ID = lP_P_ID;
	}

	public int getLP_P_ID() 
	{
		return LP_P_ID;
	}
	
	
}

