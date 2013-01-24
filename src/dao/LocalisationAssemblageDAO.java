package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.LocalisationAssemblage;

public class LocalisationAssemblageDAO 
{
		private static final String BDD_LOCALISATION_ASSEMBLAGE  = "LocalisationAssemblage";
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static LocalisationAssemblageDAO singleton;
		private LocalisationAssemblageDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static LocalisationAssemblageDAO getInstance() throws Exception
		{
			if(LocalisationAssemblageDAO.singleton==null)
				singleton=new LocalisationAssemblageDAO();
			return singleton;
		}
		
	/**
	* Permet d'ajouter une localisationAssemblage dans la table LocalisationAssemblage
	* @param LocalisationAssemblage a ajouter
	* @return nombre de lignes ajoutees dans la table LocalisationAssemblage
	*/
	public int ajouter(LocalisationAssemblage la)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO "+BDD_LOCALISATION_ASSEMBLAGE+" (LocA_Date ,LocA_O_ID ,LocA_L_ID,LocA_A_ID) VALUES (?,?,?,?)");
				ps.setDate(1,(java.sql.Date)la.getLA_Date());
				ps.setInt(2,la.getLA_O_ID());
				ps.setInt(3,la.getLA_L_ID());
				ps.setInt(4,la.getLA_P_ID());
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}
		
	/**
	 * Permet de supprimer une localisationAssemblage de la table 
	 * @param ID de la LocalisationAssemblage a supprimer
	 *@return null si aucune LocalisationAssemblage ne correspond a cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM "+BDD_LOCALISATION_ASSEMBLAGE+" WHERE LocA_ID=?");
				ps.setInt(1,ID);
	
				//on execute la requete 
				retour=ps.executeUpdate();	
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			}
				return retour;	
	}	
		
	/**
	* Permet de modifier la date d'une localisation assemblage
	* @param ID de la localisation assemblage et le nouvelle date
	* @return nombre de lignes modifi�es dans la table LocalisationAssemblage
	* */
	public int modifierDate(int ID,Date d)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE LocalisationAssemblage SET LocA_Date =? WHERE LocA_ID=?");
				ps.setDate(1,d);
				ps.setInt(2,ID);
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}
	
	
	/**
	* Permet de modifier l'ID operateur d'une localisation assemblage
	* @param ID de la localisation assemblage et le nouvel ID operateur
	* @return nombre de lignes modifi�es dans la table LocalisationAssemblage
	* */
	public int modifierOperateur(int ID,int O)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE LocalisationAssemblage SET LocA_O_ID =? WHERE LocA_ID=?");
				ps.setInt(1,O);
				ps.setInt(2,ID);
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}
	
	/**
	* Permet de modifier l'ID lieu d'une localisation assemblage
	* @param ID de la localisation assemblage et le nouvel ID lieu
	* @return nombre de lignes modifi�es dans la table LocalisationAssemblage
	* */
	public int modifierLieu(int ID,int L)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE LocalisationAssemblage SET LocA_L_ID =? WHERE LocA_ID=?");
				ps.setInt(1,L);
				ps.setInt(2,ID);
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}
	
	/**
	* Permet de modifier l'ID assemblage d'une localisation assemblage
	* @param ID de la localisation assemblage et le nouvel ID assemblage
	* @return nombre de lignes modifi�es dans la table LocalisationAssemblage
	* */
	public int modifierAssemblage(int ID,int A)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE LocalisationAssemblage SET LocA_A_ID =? WHERE LocA_ID=?");
				ps.setInt(1,A);
				ps.setInt(2,ID);
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}
	
		/**
		 * Permet de recuperer une LocalisationAssemblage partir de son id
		 * @param id de LocalisationAssemblage a recuperer
		 * @return la LocalisationAssemblage
		 * @return null si aucune LocalisationAssemblage ne correspond a cet id
		 */
		public LocalisationAssemblage getLocalisationAssemblage(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			LocalisationAssemblage LocalisationAssemblageRetourne = null;
	
		
			//connexion a la base de donnees
			
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM LocalisationAssemblage WHERE LocA_A_ID=?");
				System.out.println(ID);
				ps.setInt(1,ID);
				//on execute la requete 
				
				rs = ps.executeQuery();
				if(rs.next())
				{
					System.out.println(rs.getInt("LocA_ID"));
					System.out.println(rs.getDate("LocA_Date"));
					System.out.println(rs.getInt("LocA_O_ID"));
					System.out.println(rs.getInt("LocA_L_ID"));
					System.out.println(rs.getInt("LocA_A_ID"));
					LocalisationAssemblageRetourne = new LocalisationAssemblage(rs.getInt("LocA_ID"),rs.getDate("LocA_Date"),rs.getInt("LocA_O_ID"),rs.getInt("LocA_L_ID"),rs.getInt("LocA_A_ID"));
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					if (rs != null)
					rs.close();
				} 
				catch (Exception t)
				{
					
				}
				
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			}
			return LocalisationAssemblageRetourne;
		}
		
		

		/**
		 * Permet de recuperer une localisationAssemblage partir de l'ID de l'assemblage recherche
		 * @param id de l'assemblage dont on veut la localisationAssemblage
		 * @return la LocalisationAssemblage
		 * @return null si aucune piece ne correspond a cet id
		 */
		public LocalisationAssemblage getLocalisationAssemblageID(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			LocalisationAssemblage LocalisationAssemblageRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_ASSEMBLAGE+" WHERE LocA_A_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					LocalisationAssemblageRetourne = new LocalisationAssemblage(rs.getInt("LocA_ID"),rs.getDate("LocA_Date"),rs.getInt("LocA_O_ID"),rs.getInt("LocA_L_ID"),rs.getInt("LocA_A_ID"));
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					if (rs != null)
					rs.close();
				} 
				catch (Exception t)
				{
					
				}
				
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			}
			return LocalisationAssemblageRetourne;
		}
		
		
		
		/**
		 * Permet de recuperer toutes les LocalisationAssemblage de la table
		 * @return la liste des LocalisationAssemblage
		 */
		public List<LocalisationAssemblage> getListLocalisationAssemblage()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<LocalisationAssemblage> ListeLocalisationAssemblage = new ArrayList<LocalisationAssemblage>();
		
			//connexion a la base de donnees
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_ASSEMBLAGE+"");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeLocalisationAssemblage.add(new LocalisationAssemblage(rs.getInt("LocA_ID"),rs.getDate("LocA_Date"),rs.getInt("LocA_O_ID"),rs.getInt("LocA_L_ID"),rs.getInt("LocA_A_ID")));
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if (rs != null)
						rs.close();
				} 
				catch (Exception t) 
				{
					
				}
				
				try
				{
					if (ps != null)
						ps.close();
				}
				catch (Exception t) 
				{
					
				}
			}
			return ListeLocalisationAssemblage;
		
		}
		
		/**
		 * Permet de recuprer toutes les LocalisationAssemblage de la table dans un lieu precis
		 * @return la liste des LocalisationAssemblages
		 */
		public List<LocalisationAssemblage> getListLocalisationAssemblageLieu(int L_ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<LocalisationAssemblage> ListeLocalisationAssemblage = new ArrayList<LocalisationAssemblage>();
		
			//connexion a la base de donn?es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_ASSEMBLAGE+" WHERE LocA_L_ID=?");
				ps.setInt(1,L_ID);
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeLocalisationAssemblage.add(new LocalisationAssemblage(rs.getInt("LocA_ID"),rs.getDate("LocA_Date"),rs.getInt("LocA_O_ID"),rs.getInt("LocA_L_ID"),rs.getInt("LocA_A_ID")));
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if (rs != null)
						rs.close();
				} 
				catch (Exception t) 
				{
					
				}
				
				try
				{
					if (ps != null)
						ps.close();
				}
				catch (Exception t) 
				{
					
				}
			}
			return ListeLocalisationAssemblage;
		
		}
}



