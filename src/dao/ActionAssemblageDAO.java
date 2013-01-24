package dao;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import Modele.ActionAssemblage;
import dao.Connexion;


/**
 * Classe d'accès aux données contenues dans la table ActionPiece
 * */

public class ActionAssemblageDAO {

		private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ActionAssemblageDAO singleton;
		private  ActionAssemblageDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static ActionAssemblageDAO getInstance() throws Exception
		{
			if(ActionAssemblageDAO.singleton==null)
				singleton=new ActionAssemblageDAO();
			return singleton;
		}
		
				/**
				 * Permet d'ajouter une Action a un assemblage dans la table ActionAssemblage
				 * @param a l'Action à ajouter
				 * @return le nombre de lignes ajoutées dans la table
				 */
				public static int ajouter(ActionAssemblage a)
				{

					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("INSERT INTO ActionAssemblage (AA_A_ID,AA_O_ID,AA_Op_ID,AA_L_ID,AA_Date) VALUES (?,?,?,?,?)");
						ps.setInt(1,a.getAA_A_ID());
						ps.setInt(2,a.getAA_O_ID());
						ps.setInt(3,a.getAA_Op_ID());
						ps.setInt(1,a.getAA_L_ID());
						ps.setDate(2,a.getAA_Date());
						
						//on execute la requete 
						retour=ps.executeUpdate();
						

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du getConnection().preparedStatement et de la connexion
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}


				/**
				* Permet de modifier l'id piece de l'action assemblage
				* @param l'action piece a modifier et le nouvel assemblage
				* @return nombre de lignes modifiées dans la table ActionAssemblage
				*/
				public int modifierPiece(int AA_ID ,int AA_A_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionAssemblage SET AA_A_ID=? WHERE AA_ID=?");
							ps.setInt(1,AA_A_ID);
							ps.setInt(2,AA_ID);
							
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
				* Permet de modifier l'id operateur de l'action assemblage
				* @param l'action piece a modifier et le nouvel operateur
				* @return nombre de lignes modifiées dans la table ActionAssemblage
				*/
				public int modifierOperateur(int AA_ID ,int AA_O_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionAssemblage SET AA_O_ID=? WHERE AA_ID=?");
							ps.setInt(1,AA_O_ID);
							ps.setInt(2,AA_ID);
							
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
				* Permet de modifier l'id operation de l'action assemblage
				* @param l'action piece a modifier et la nouvelle operation
				* @return nombre de lignes modifiées dans la table ActionAssemblage
				*/
				public int modifierOperation(int AA_ID ,int AA_Op_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionAssemblage SET AA_Op_ID=? WHERE AA_ID=?");
							ps.setInt(1,AA_Op_ID);
							ps.setInt(2,AA_ID);
							
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
				* Permet de modifier l'id lieu de l'action assemblage
				* @param l'action piece a modifier et le nouveau lieu
				* @return nombre de lignes modifiées dans la table ActionAssemblage
				*/
				public int modifierLieu(int AA_ID ,int AA_L_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionAssemblage SET AA_L_ID=? WHERE AA_ID=?");
							ps.setInt(1,AA_L_ID);
							ps.setInt(2,AA_ID);
							
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
				* Permet de modifier la date de l'action assemblage
				* @param l'action piece a modifier et la nouvelle date
				* @return nombre de lignes modifiées dans la table ActionAssemblage
				*/
				public int modifierDate(int AA_ID ,Date AA_Date)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionAssemblage SET AA_Date=? WHERE AA_ID=?");
							ps.setDate(1,AA_Date);
							ps.setInt(2,AA_ID);
							
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
				 * Permet de supprimer une action assemblage
				 * @param l'id de l'action à supprimer
				 *@return null si aucune Action ne correspond à cet id
				 */
				public int supprimer(int AA_ID)
				{
					PreparedStatement ps=null;
					int retour=0;
					
					//connexion a la base de données
					try {
						ps = con.prepareStatement("DELETE FROM ActionAssemblage WHERE AA_ID=?");
						ps.setInt(1,AA_ID);
			
									
						//on execute la requete 
						retour=ps.executeUpdate();
						
									

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du rs,preparedStatement et de la connexion
						
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}		
				
				/**
				 * Permet de récupérer une action assemblage à partir de son id 
				 * @param id de l'action à récupérer
				 * @return l'action
				 * @return null si aucune action ne correspond à cet
				 */
				public static ActionAssemblage getActionAssemblage(int AA_ID)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionAssemblage retour=null;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("SELECT * FROM ActionAssemblage WHERE AA_ID= ?");
						ps.setInt(1,AA_ID);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionAssemblage(rs.getInt("AA_ID"),rs.getInt("AA_A_ID"),rs.getInt("AA_O_ID"),rs.getInt("AA_Op_ID"),rs.getInt("AA_L_ID"),rs.getDate("AA_Date"));
						

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du rs,preparedStatement et de la connexion
						try {if (rs != null)rs.close();} catch (Exception t) {}
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}
				
				
				/**
				 * Permet de récupérer toutes les Actions de la table pour un assemblage donne
				 * @return la liste des Actions
				 */
				public List<ActionAssemblage> getListActionAssemblage(int AA_ID)
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionAssemblage> retour=new ArrayList<ActionAssemblage>();
				
					//connexion a la base de données
					try 
					{
						ps = con.prepareStatement("SELECT * FROM ActionAssemblage WHERE AA_ID=" +AA_ID);
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionAssemblage(rs.getInt("AA_ID"),rs.getInt("AA_A_ID"),rs.getInt("AA_O_ID"),rs.getInt("AA_Op_ID"),rs.getInt("AA_L_ID"),rs.getDate("AA_Date")));
						

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
				 * Permet de récupérer toutes les Actions de la table
				 * @return la liste des Actions
				 */
				public List<ActionAssemblage> getListActionAssemblage()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionAssemblage> retour=new ArrayList<ActionAssemblage>();
				
					//connexion a la base de données
					try 
					{
						ps = con.prepareStatement("SELECT * FROM ActionAssemblage");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionAssemblage(rs.getInt("AA_ID"),rs.getInt("AA_A_ID"),rs.getInt("AA_O_ID"),rs.getInt("AA_Op_ID"),rs.getInt("AA_L_ID"),rs.getDate("AA_Date")));
						

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

				