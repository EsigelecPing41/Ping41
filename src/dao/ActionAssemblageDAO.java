package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.ActionAssemblage;
import dao.Connexion;


/**
 * Classe d'accès aux données contenues dans la table ActionAssemblage
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

			public ActionAssemblageDAO getInstance() throws Exception
			{
				if(ActionAssemblageDAO.singleton==null)
					singleton=new ActionAssemblageDAO();
				return singleton;
			}
		
				/**
				 * Permet d'ajouter une Action d'assemblage dans la table ActionAssemblage
				 * @param a l'Action à ajouter
				 * @return le nombre de lignes ajoutées dans la table
				 */
				public static int ajouter(ActionAssemblage a)
				{

					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("INSERT INTO ActionAssemblageDAO (AA_A_ID,AA_L_ID,AA_ID) VALUES (?,?,?)");
						ps.setInt(1,a.getAA_A_ID());
						ps.setInt(2,a.getAA_L_ID());
						ps.setInt(3,a.getAA_ID());
						
						
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
				* Permet de modifier le lieu d'un assemblage dans la table ActionAssemblage
				* @param AA_l_ID de le lieu de l'assemblage à modifier et le nouvel assemblage
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
				* Permet de modifier l'action d'un assemblage dans la table ActionAssemblage
				* @param AA_A_ID de l'action de l'assemblage à modifier et le nouvel assemblage
				* @return nombre de lignes modifiées dans la table ActionAssemblage
				*/
				public int modifierAssemblage(int AA_ID ,int AA_A_ID )
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionAssemblage SET AA_A_ID =? WHERE AA_ID=?");
							ps.setInt(1,AA_A_ID );
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
				 * Permet de supprimer un assemblage dans la table ActionAssemblage
				 * @param AA_ID l'id de l'Action  à supprimer
				 *@return null si aucune Action ne correspond à cette date
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
				 * Permet de récupérer un assemblage d'une Action 
				 * @param AA_ID l'ID de l'Actin d'assemblage à récupérer
				 * @return l'Action
				 * @return null si aucune Action ne correspond à cette date
				 */
				public static ActionAssemblageDAO getActionAssemblageDAO(int AA_ID)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionAssemblageDAO retour=null;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("SELECT * FROM ActionAssemblage WHERE AA_ID LIKE ?");
						ps.setInt(1,AA_ID);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionAssemblageDAO ();
						

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
				 * Permet de récupérer toutes les Actions de la table
				 * @return la liste des Actions pour les assemblages
				 */
				public List<ActionAssemblageDAO> getListActionAssemblageDAO()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionAssemblageDAO> retour=new ArrayList<ActionAssemblageDAO>();
				
					//connexion a la base de données
					try {
						ps = con.prepareStatement("SELECT * FROM ActionAssemblage");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionAssemblageDAO ());
						

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
				 * Permet de récupérer toutes les Actions pour UN assemblage de la table
				 * @return la liste des Actions
				 */
				public List<ActionAssemblageDAO> getListActionAssemblageDAO(int AA_ID )
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionAssemblageDAO> retour=new ArrayList<ActionAssemblageDAO>();
				
					//connexion a la base de données
					try {
						ps = con.prepareStatement("SELECT * FROM ActionAssemblage");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionAssemblageDAO ());
						

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du rs,preparedStatement et de la connexion
						try {if (rs != null)rs.close();} catch (Exception t) {}
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}			
				
				
				
				
/**				//main permettant de tester la classe
				public static void main(int[] args){
					ActionAssemblageDAO ActionAssemblageDAO=new ActionAssemblageDAO();
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode ajouter");
					System.out.println("********************");
					
					//test de la méthode ajouter
					ActionAssemblage a=new ActionAssemblage();
					int retour= dao.ActionAssemblageDAO.ajouter(a);
					System.out.println(retour+ " lignes ajoutées");

					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode supprimer");
					System.out.println("********************");
					
					//test de la méthode supprimer
					Date AA_Date= null;
					int retour1= ActionAssemblageDAO.supprimer(AA_Date);
					System.out.println(retour1+ " lignes supprimées");
					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getActionAssemblageDAO avec AA_Piece");
					System.out.println("********************");
					
					//test de la méthode getActionassemblage avec AA_Date
					ActionAssemblageDAO a2=dao.ActionAssemblageDAO.getActionAssemblageDAO(AA_Date);
					System.out.println(a2);

					
										
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getListActionAssemblageDAO");
					System.out.println("********************");
					
					//test de la méthode getListActionAssemblageDAO
					List<ActionAssemblageDAO> liste=ActionAssemblageDAO.getListActionAssemblageDAO();
					System.out.println(liste);
					
				}    **/    
	}

