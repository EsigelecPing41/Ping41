
package Modele;

public class Droits 
{

	private int D_ID;
	private int D_O_ID;
	private int D_Module;
	private boolean D_Acces;
	
	public Droits(int ID, int O_ID, int Module,boolean Acces)
	{
		this.D_ID=ID;
		this.D_O_ID=O_ID;
		this.D_Module=Module;
		this.D_Acces=Acces;
	}
	
	public void setD_ID(int d_ID)
	{
		D_ID = d_ID;
	}
	public int getD_ID() 
	{
		return D_ID;
	}
	public void setD_O_ID(int d_O_ID) 
	{
		D_O_ID = d_O_ID;
	}
	public int getD_O_ID() 
	{
		return D_O_ID;
	}
	public void setD_Module(int d_Module)
	{
		D_Module = d_Module;
	}
	public int getD_Module() {
		return D_Module;
	}
	public void setD_Acces(boolean d_Acces) {
		D_Acces = d_Acces;
	}
	public boolean getD_Acces() {
		return D_Acces;
	}
}
