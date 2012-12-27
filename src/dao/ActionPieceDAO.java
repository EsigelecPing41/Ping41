package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.ActionPiece;
import dao.Connexion;


/**
 * Classe d'accès aux données contenues dans la table ActionPiece
 * */

public class ActionPieceDAO {

		private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ActionPieceDAO singleton;
		private  ActionPieceDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public ActionPieceDAO getInstance() throws Exception
		{
			if(ActionPieceDAO.singleton==null)
				singleton=new ActionPieceDAO();
			return singleton;
		}
		
				/**
				 * Permet d'ajouter une Action a une piece dans la table ActionPiece
				 * @param a l'Action à ajouter
				 * @return le nombre de lignes ajoutées dans la table
				 */
				public static int ajouter(ActionPiece a)
				{

					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("INSERT INTO ActionPieceDAO (AP_P_ID, AP_L_ID,AP_ID) VALUES (?,?,?)");
						ps.setInt(1,a.getAP_P_ID());
						ps.setInt(2,a.getAP_L_ID());
						ps.setInt(3,a.getAP_ID());
						
						
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
				* Permet de modifier le lieu d'une Piece dans la table ActionPiece
				* @param AP_l_ID de le lieu de la Piece à modifier et la nouvelle Piece
				* @return nombre de lignes modifiées dans la table ActionPiece
				*/
				public int modifierLieu(int AP_ID ,int AP_L_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionPiece SET AP_L_ID=? WHERE AP_ID=?");
							ps.setInt(1,AP_L_ID);
							ps.setInt(2,AP_ID);
							
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
				* Permet de modifier l'action d'une Piece dans la table ActionPiece
				* @param AP_P_ID de l'action de la Piece à modifier et la nouvelle Piece
				* @return nombre de lignes modifiées dans la table ActionPiece
				*/
				public int modifierPiece(int AP_ID ,int AP_P_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionPiece SET AP_P_ID=? WHERE AP_ID=?");
							ps.setInt(1,AP_P_ID);
							ps.setInt(2,AP_ID);
							
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
				 * Permet de supprimer une piece dans la table ActionPiece
				 * @param AP_ID l'id de l'Action  à supprimer
				 *@return null si aucune Action ne correspond à cette date
				 */
				public int supprimer(int AP_ID)
				{
					PreparedStatement ps=null;
					int retour=0;
					
					//connexion a la base de données
					try {
						ps = con.prepareStatement("DELETE FROM ActionPiece WHERE AP_ID=?");
						ps.setInt(1,AP_ID);
			
									
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
				 * Permet de récupérer une piece d'une Action 
				 * @param AP_IDla date de l'Action à récupérer
				 * @return l'Action
				 * @return null si aucune Action ne correspond à cette date
				 */
				public static ActionPieceDAO getActionPiece(int AP_ID)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionPieceDAO retour=null;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("SELECT * FROM ActionPiece WHERE AP_ID LIKE ?");
						ps.setInt(1,AP_ID);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionPieceDAO ();
						

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
				 * Permet de récupérer une piece d'une Action 
				 * @param AP_ID l'ID de l'Action d'une piece à récupérer
				 * @return l'Action
				 * @return null si aucune Action ne correspond à cette date
				 */
				public static ActionPieceDAO getActionPieceDAO(int AP_ID)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionPieceDAO retour=null;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("SELECT * FROM ActionPiece WHERE AP_ID LIKE ?");
						ps.setInt(1,AP_ID);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionPieceDAO ();
						

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
				 * @return la liste des Actions
				 */
				public List<ActionPieceDAO> getListActionPieceDAO()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionPieceDAO> retour=new ArrayList<ActionPieceDAO>();
				
					//connexion a la base de données
					try {
						ps = con.prepareStatement("SELECT * FROM ActionPiece");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionPieceDAO ());
						

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
				 * Permet de récupérer toutes les Actions pour UNE piece de la table
				 * @return la liste des Actions
				 */
				public List<ActionPieceDAO> getListActionPieceDAO(int AP_ID )
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionPieceDAO> retour=new ArrayList<ActionPieceDAO>();
				
					//connexion a la base de données
					try {
						ps = con.prepareStatement("SELECT * FROM ActionPiece");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionPieceDAO ());
						

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
					ActionPieceDAO ActionDAO=new ActionPieceDAO();
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode ajouter");
					System.out.println("********************");
					
					//test de la méthode ajouter
					ActionPiece a=new ActionPiece();
					int retour= ActionPieceDAO.ajouter(a);
					System.out.println(retour+ " lignes ajoutées");

					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode supprimer");
					System.out.println("********************");
					
					//test de la méthode supprimer
					Date AP_Date= null;
					int retour1= ActionDAO.supprimer(AP_Date);
					System.out.println(retour1+ " lignes supprimées");
					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getActionPiece avec AP_Piece");
					System.out.println("********************");
					
					//test de la méthode getActionPiece avec AP_Date
					ActionPiece a2=ActionPieceDAO.getActionPiece(AP_Date);
					System.out.println(a2);

					
										
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getListActionPiece");
					System.out.println("********************");
					
					//test de la méthode getListActionPiece
					List<ActionPiece> liste=ActionDAO.getListActionPiece();
					System.out.println(liste);
					
				}         **/
	}

