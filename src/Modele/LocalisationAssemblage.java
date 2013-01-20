package Modele;

import java.util.Date;


public class LocalisationAssemblage 
{
	private int LA_ID;
	private Date LA_Date;
	private int LA_O_ID;
	private int LA_L_ID;
	private int LA_A_ID;
	
	public LocalisationAssemblage(int lA_Id, Date lA_Date, int lA_O_ID, int lA_L_ID, int lA_A_ID) 
	{
		LA_ID = lA_Id;
		LA_Date = lA_Date;
		LA_O_ID = lA_O_ID;
		LA_L_ID = lA_L_ID;
		LA_A_ID= lA_A_ID;
	}
	
	public LocalisationAssemblage( Date lA_Date, int lA_O_ID, int lA_L_ID, int lA_A_ID) 
	{
		LA_Date = lA_Date;
		LA_O_ID = lA_O_ID;
		LA_L_ID = lA_L_ID;
		LA_A_ID= lA_A_ID;
	}
	
	public int getLA_ID() 
	{
		return LA_ID;
	}
	
	public void setLA_ID(int lA_ID)
	{
		LA_ID = lA_ID;
	}
	
	public Date getLA_Date()
	{
		return LA_Date;
	}
	
	public void setLA_Date(Date lA_Date)
	{
		LA_Date = lA_Date;
	}
	
	public int getLA_O_ID()
	{
		return LA_O_ID;
	}
	
	public void setLA_O_ID(int lA_O_ID)
	{
		LA_O_ID = lA_O_ID;
	}
	
	public int getLA_L_ID() 
	{
		return LA_L_ID;
	}
	
	public void setLA_L_ID(int lA_L_ID)
	{
		LA_L_ID = lA_L_ID;
	}

	public void setLA_P_ID(int lA_P_ID)
	{
		LA_A_ID = lA_P_ID;
	}

	public int getLA_P_ID()
	{
		return LA_A_ID;
	}
	
	
}

