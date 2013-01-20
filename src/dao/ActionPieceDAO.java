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

						ps = con.prepareStatement("INSERT INTO ActionPiece (AP_P_ID,AP_O_ID,AP_Op_ID,AP_L_ID,AP_Date) VALUES (?,?,?,?,?)");
						ps.setInt(1,a.getAP_P_ID());
						ps.setInt(2,a.getAP_O_ID());
						ps.setInt(3,a.getAP_Op_ID());
						ps.setInt(1,a.getAP_L_ID());
						ps.setDate(2,a.getAP_Date());
						
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
				* Permet de modifier l'id piece de l'action piece
				* @param l'action piece a modifier et la nouvelle Piece
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
				* Permet de modifier l'id operateur de l'action piece
				* @param l'action piece a modifier et le nouvel operateur
				* @return nombre de lignes modifiées dans la table ActionPiece
				*/
				public int modifierOperateur(int AP_ID ,int AP_O_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionPiece SET AP_O_ID=? WHERE AP_ID=?");
							ps.setInt(1,AP_O_ID);
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
				* Permet de modifier l'id operation de l'action piece
				* @param l'action piece a modifier et la nouvelle operation
				* @return nombre de lignes modifiées dans la table ActionPiece
				*/
				public int modifierOperation(int AP_ID ,int AP_Op_ID)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionPiece SET AP_Op_ID=? WHERE AP_ID=?");
							ps.setInt(1,AP_Op_ID);
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
				* Permet de modifier l'id lieu de l'action piece
				* @param l'action piece a modifier et le nouveau lieu
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
				* Permet de modifier la date de l'action piece
				* @param l'action piece a modifier et la nouvelle date
				* @return nombre de lignes modifiées dans la table ActionPiece
				*/
				public int modifierDate(int AP_ID ,Date AP_Date)
				{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE ActionPiece SET AP_Date=? WHERE AP_ID=?");
							ps.setDate(1,AP_Date);
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
				 * Permet de supprimer une action piece
				 * @param l'id de l'action à supprimer
				 *@return null si aucune Action ne correspond à cet id
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
				 * Permet de récupérer une action piece à partir de son id 
				 * @param id de l'action à récupérer
				 * @return l'action
				 * @return null si aucune action ne correspond à cet
				 */
				public static ActionPiece getActionPiece(int AP_ID)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionPiece retour=null;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("SELECT * FROM ActionPiece WHERE AP_ID= ?");
						ps.setInt(1,AP_ID);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionPiece(rs.getInt("AP_ID"),rs.getInt("AP_P_ID"),rs.getInt("AP_O_ID"),rs.getInt("AP_Op_ID"),rs.getInt("AP_L_ID"),rs.getDate("AP_Date"));
						

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
				 * Permet de récupérer toutes les Actions de la table pour une piece donnee
				 * @return la liste des Actions
				 */
				public List<ActionPiece> getListActionPiece(int AP_ID)
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionPiece> retour=new ArrayList<ActionPiece>();
				
					//connexion a la base de données
					try 
					{
						ps = con.prepareStatement("SELECT * FROM ActionPiece WHERE AP_ID=" +AP_ID);
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionPiece(rs.getInt("AP_ID"),rs.getInt("AP_P_ID"),rs.getInt("AP_O_ID"),rs.getInt("AP_Op_ID"),rs.getInt("AP_L_ID"),rs.getDate("AP_Date")));
						

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
				public List<ActionPiece> getListActionPiece()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionPiece> retour=new ArrayList<ActionPiece>();
				
					//connexion a la base de données
					try 
					{
						ps = con.prepareStatement("SELECT * FROM ActionPiece");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionPiece(rs.getInt("AP_ID"),rs.getInt("AP_P_ID"),rs.getInt("AP_O_ID"),rs.getInt("AP_Op_ID"),rs.getInt("AP_L_ID"),rs.getDate("AP_Date")));
						

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

				