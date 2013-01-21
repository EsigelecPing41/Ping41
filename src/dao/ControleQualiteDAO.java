package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.ControleQualite;
import Modele.CritereQualite;

public class ControleQualiteDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ControleQualiteDAO singleton;
		private ControleQualiteDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static ControleQualiteDAO getInstance() throws Exception
		{
			if(ControleQualiteDAO.singleton==null)
				singleton=new ControleQualiteDAO();
			return singleton;
		}
		
		
	/**
	* Permet d'ajouter un controle qualite dans la table ControleQualite
	* @param le controle a ajouter
	* @return nombre de lignes ajoutes dans la table ControleQualite
	*/
	public int ajouter(ControleQualite cq)
	{
			String listCritere = null;
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO ControleQualite (CQ_O_ID,CQ_A_ID,CQ_Resultat,CQ_ListCriteres) VALUES (?,?,?,?)");
				ps.setInt(1,cq.getCQ_O_ID());
				ps.setInt(2,cq.getCQ_A_ID());
				ps.setBoolean(3,cq.getCQ_Resultat());
				for(CritereQualite c : cq.getCQ_ListCriteres())
				{
					listCritere += c.getCrQ_libelle() + ",";
				}
				ps.setString(4,listCritere);

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
	 * Permet d'ajouter un critere qualite dans un controle qualite � partir du libelle du critere
	 * @param le controle qualite dans lequel on veut ajouter le critere et l'id du critere
	 *@return nombre de lignes impact�es
	 */
	public int AjouterCritere(int CQ_ID,String libelle)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String chaine = " ";
		boolean doublon=false;
		int retour=0;
		
		//connexion a la base de donnees
		try 
		{	
			ps = con.prepareStatement("SELECT CQ_ListCriteres FROM ControleQualite WHERE CQ_ID=?");
			ps.setInt(1,CQ_ID);
						
			//on execute la requete 
			rs = ps.executeQuery();
			if(rs.next())
				chaine = rs.getString("CQ_ListCriteres");
				if(chaine==null)
					chaine = libelle;
				else
					{
					String tableau[] = chaine.split(",");
					for(int i=0; i< tableau.length; i++)
					{
						if(tableau[i]==libelle)
							doublon=true;
					}
					if (doublon==false)
						chaine = chaine +','+ libelle;
					}
					ps = con.prepareStatement("UPDATE ControleQualite SET CQ_ListCriteres =? WHERE CQ_ID=?");
					ps.setString(1,chaine);
					ps.setInt(2,CQ_ID);
				
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
	 * Permet supprimer un critere qualite dans un controle qualite � partir du libelle du critere
	 * @param l'id du controle qualite dans lequel on veut supprimer le critere et le libelle du critere
	 *@return nombre de lignes impact�es
	 */
	public int SupprimerCritere(int CQ_ID, String libelle)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String chaine = " ";
		int retour=0;
		
		//connexion a la base de donnees
		try 
		{	
			ps = con.prepareStatement("SELECT CQ_ListCriteres FROM ControleQualite WHERE CQ_ID=?");
			ps.setInt(1,CQ_ID);
						
			//on execute la requete 
			rs = ps.executeQuery();
			if(rs.next())
				chaine = rs.getString("CQ_ListCriteres");
				if(chaine!=null)
					{
					String tableau[] = chaine.split(",");
						for(int i=0; i< tableau.length; i++)
						{
							if(tableau[i]==libelle)
								tableau[i]= " ";
						}
					
						chaine = " ";
						for(int i=1; i< tableau.length; i++)
						{
							if(tableau[i]!= " ")
								if(chaine == " ")
									chaine = tableau[i];
								else
									chaine = chaine +','+ tableau[i];
						}
					}
					ps = con.prepareStatement("UPDATE ControleQualite SET CQ_ListCriteres =? WHERE A_ID=?");
					ps.setString(1,chaine);
					ps.setInt(2,CQ_ID);
				
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
	 * Permet de supprimer un controle qualite de la table ControleQualite
	 * @param ID du controle a supprimer
	 *@return null si aucun controle ne correspond a cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM ControleQualite WHERE CQ_ID=?");
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
		 * Permet de recuperer un controle qualite partir le l'id de l'assemble
		 * @param id de l'assemblage du controle a recuperer
		 * @return le controle qualite
		 * @return null si aucun controle qualite ne correspond a cet id
		 */
		public ControleQualite getControleQualite(int ID)
		{
			PreparedStatement ps = null;
			PreparedStatement request = null;
			ResultSet rs=null;
			ResultSet result = null;
			ControleQualite ControleQualiteRetourne = null;
			CritereQualite critereQualite; 
			ArrayList<CritereQualite> listCritere = new ArrayList<CritereQualite>();
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM ControleQualite WHERE CQ_A_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				while(rs.next())
				{
					listCritere = (ArrayList<CritereQualite>) getListCritereControle(rs.getInt("CQ_ID"));//récuperation des criteres							
					ControleQualiteRetourne = new ControleQualite(rs.getInt("CQ_ID"),rs.getInt("CQ_O_ID"),rs.getInt("CQ_A_ID"),rs.getBoolean("CQ_Resultat"),listCritere);
					
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
			return ControleQualiteRetourne;
		}
		
		/**
		* Permet de modifier l'ID operateur du controle qualite
		* @param ID du controle qualite et le nouvel ID operateur
		* @return nombre de lignes modifi�es dans la table ControleQualite
		* */
		public int modifierOperateur(int ID,int ID_Operateur)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de donn�es
				try 
				{
					ps = con.prepareStatement("UPDATE ControleQualite SET CQ_O_ID =? WHERE CQ_ID=?");
					ps.setInt(1,ID_Operateur);
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
		* Permet de modifier l'ID assemblage du controle qualite
		* @param ID du controle qualite et le nouvel ID assemblage
		* @return nombre de lignes modifi�es dans la table ControleQualite
		* */
		public int modifierAssemblage(int ID,int ID_Assemblage)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de donn�es
				try 
				{
					ps = con.prepareStatement("UPDATE ControleQualite SET CQ_A_ID =? WHERE CQ_ID=?");
					ps.setInt(1,ID_Assemblage);
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
		* Permet de modifier le resultat global du controle qualite
		* @param ID du controle qualite et le nouveau resultat
		* @return nombre de lignes modifi�es dans la table ControleQualite
		* */
		public int modifierResultat(int ID,boolean resultat)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de donn�es
				try 
				{
					ps = con.prepareStatement("UPDATE ControleQualite SET CQ_Resultat =? WHERE CQ_ID=?");
					ps.setBoolean(1,resultat);
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
		 * Permet de recuperer tous les controles qualite de la table
		 * @return la liste des controles qualite
		 */
		public List<ControleQualite> getListControleQualite()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<ControleQualite> ListeControleQualite = new ArrayList<ControleQualite>();
			PreparedStatement request = null;
			ResultSet result = null;
			ControleQualite ControleQualiteRetourne = null;
			CritereQualite critereQualite; 
			ArrayList<CritereQualite> listCritere = new ArrayList<CritereQualite>();
		
			//connexion a la base de donn?es
			try 
			{
				ps = con.prepareStatement("SELECT * FROM ControleQualite");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
				{
					
					listCritere = (ArrayList<CritereQualite>) getListCritereControle(rs.getInt("CQ_ID"))		;			
					ControleQualiteRetourne = new ControleQualite(rs.getInt("CQ_ID"),rs.getInt("CQ_O_ID"),rs.getInt("CQ_A_ID"),rs.getBoolean("CQ_Resultat"),listCritere);
					
					ListeControleQualite.add(ControleQualiteRetourne);
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
			return ListeControleQualite;
		
		}
		
		/**
		 * Permet de r�cup�rer tous les Controles Qualite ayant un resultat precis (ok ou ko)
		 * @return la liste des Controles Qualite concernes
		 */
		public List<ControleQualite> getListControleQualite(Boolean CQ_resultat)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<ControleQualite> retour=new ArrayList<ControleQualite>();
			List<ControleQualite> ListeControleQualite = new ArrayList<ControleQualite>();
			PreparedStatement request = null;
			ResultSet result = null;
			ControleQualite ControleQualiteRetourne = null;
			CritereQualite critereQualite; 
			ArrayList<CritereQualite> listCritere = new ArrayList<CritereQualite>();
		
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("SELECT * FROM ControleQualite WHERE CQ_Resultat=" +CQ_resultat);
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
				{
					listCritere = (ArrayList<CritereQualite>) getListCritereControle(rs.getInt("CQ_ID"));
										
					
					
					retour.add(new ControleQualite(rs.getInt("CQ_ID"),rs.getInt("CQ_O_ID"),rs.getInt("CQ_A_ID"),rs.getBoolean("CQ_Resultat"),listCritere));
				}
					
			} 
			catch (Exception ee) 
			{
				ee.printStackTrace();
			} 
			finally 
			{
				//fermeture du rs,preparedStatement et de la connexion
				try {if (rs != null)rs.close();} catch (Exception t) {}
				try {if (ps != null)ps.close();} catch (Exception t) {}
			}
			return retour;
		
		}
		
		/**
		 * Permet de r�cup�rer tous les Criteres de qualite d'un controle qualite � partir de l'ID du controle
		 * @param ID du controle qualite 
		 * @return null si aucun controle qualite ne correspond a cet ID
		 **/
		public List<CritereQualite> getListCritereControle(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			String chaine = " ";
			List<CritereQualite> retour=new ArrayList<CritereQualite>();
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("SELECT CQ_ListCriteres FROM ControleQualite WHERE CQ_ID=?");
				
				ps.setInt(1,ID);
					//on execute la requete 
					rs = ps.executeQuery();
					if(rs.next())
						chaine = rs.getString("CQ_ListCriteres");
							String tableau[] = chaine.split(",");
							for(int i=0; i< tableau.length; i++)
							{
								ps = con.prepareStatement("SELECT * FROM CritereQualite WHERE CrQ_libelle=?" );
								System.out.println(tableau[i]);
								ps.setString(1,tableau[i]);
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new CritereQualite(rs.getInt("CrQ_ID"),rs.getString("CrQ_libelle"),rs.getBoolean("CrQ_resultat")));
							}
			 } 
			catch (Exception ee) 
			{
				ee.printStackTrace();
			} 
			finally 
			{
				//fermeture du rs,preparedStatement et de la connexion
				try {if (rs != null)rs.close();} catch (Exception t) {}
				try {if (ps != null)ps.close();} catch (Exception t) {}
			}
			return retour;
		
		}
		
}


