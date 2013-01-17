package dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import dao.Connexion;
import Modele.Expedition;


	/**
	 * Classe d'acc�s aux donn�es contenues dans la table Expedition
	 * */

	public class ExpeditionDAO {

private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ExpeditionDAO singleton;
		private  ExpeditionDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}
		public static ExpeditionDAO getInstance() throws Exception
		{
			if(ExpeditionDAO.singleton==null)
				singleton=new ExpeditionDAO();
			return singleton;
		}
					/**
					 * Permet d'ajouter un Expedition dans la table Expedition
					 * @param a Expedition � ajouter
					 * @return le nombre de lignes ajout�es dans la table
					 */
					public static int ajouter(Expedition a)
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de donn�es
						try {

							ps = con.prepareStatement("INSERT INTO Expedition(Exp_Date,Exp_A_ID,Exp_BExp_ID,Exp_CodeClient) VALUES (?,?,?,?)");
							ps.setTimestamp(1,a.getExp_Date());
							ps.setInt(2,a.getExp_A_ID());
							ps.setInt(3,a.getExp_BExp_ID());
							ps.setString(4,a.getExp_C_CodeClient());

							//on execute la requete 
							retour=ps.executeUpdate();
							

						} catch (Exception ee) 
						{
							ee.printStackTrace();
						} finally
						{
							//fermeture du getConnection().preparedStatement et de la connexion
							try {if (ps != null)ps.close();} catch (Exception t) {}
						}
						return retour;				}


					/**
					* Permet de modifier la date de l'Expedition dans la table Expedition
					* @param Exp_Date la date de l'Expedition � modifier 
					* @return nombre de lignes modifi�es dans la table Expedition
					*/
					public int modifierDate(int Exp_ID ,Timestamp Exp_Date)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_Date=? WHERE Exp_ID=?");
								ps.setTimestamp(1,Exp_Date);
								ps.setInt(2,Exp_ID);
								
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
					* Permet de modifier le client d'Expedition dans la table Expedition
					* @param Exp_C_CodeClient de le client d'Expedition � modifier
					* @return nombre de lignes modifi�es dans la table Expedition
					*/
					public int modifierClient(int Exp_ID ,String Exp_C_CodeClient)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_C_CodeClient=? WHERE Exp_ID=?");
								ps.setString(1,Exp_C_CodeClient);
								ps.setInt(2,Exp_ID);
								
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
					* Permet de modifier le Bon d'Expeditiond'une Expedition dans la table Expedition
					* @param Exp_BExp_ID de le Bon d'Expeditiond'une Expedition � modifier
					* @return nombre de lignes modifi�es dans la table Expedition
					*/
					public int modifierBonExpedition(int Exp_ID ,int Exp_BExp_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_BExp_ID=? WHERE Exp_ID=?");
								ps.setInt(1,Exp_BExp_ID);
								ps.setInt(2,Exp_ID);
								
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
					* Permet de modifier l'assemblage d'une Expedition dans la table Expedition
					* @param Exp_A_ID de l'assemblage d'une Expedition � modifier 
					* @return nombre de lignes modifi�es dans la table Expedition
					*/
					public int modifierAssemblage(int Exp_A_ID ,int Exp_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_A_ID=? WHERE Exp_ID=?");
								ps.setInt(1,Exp_A_ID);
								ps.setInt(2,Exp_ID);
								
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
					 * Permet de supprimer une Expedition dans la table Expedition
					 * @param Exp_ID de la Expedition � supprimer
					 *@return null si aucune Expedition ne correspond � ce Exp_ID du Expedition 
					 */
					public int supprimer(int Exp_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de donn�es
						try {
							ps = con.prepareStatement("DELETE FROM Expedition WHERE Exp_ID=?");
							ps.setInt(1, Exp_ID);
				
										
							//on execute la requete 
							retour=ps.executeUpdate();

						} catch (Exception ee) 
						{
							ee.printStackTrace();
						} finally
						{
							//fermeture du rs,preparedStatement et de la connexion
							
							try {if (ps != null)ps.close();} catch (Exception t) {}
						}
						return retour;
					
					}	
					
					/**
					 * Permet de r�cup�rer une Expedition 
					 * @param Exp_ID est l'ID de la Expedition
					 * @return la Expedition
					 * @return null si aucune Expedition ne correspond � cet ID
					 */
					public Expedition getExpedition(int Exp_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						Expedition retour=null;
					
						//connexion a la base de donn�es
						try {

							ps = con.prepareStatement("SELECT * FROM Expedition WHERE Exp_ID= ?");
							ps.setInt(1,Exp_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new Expedition(rs.getTimestamp("Exp_Date"),rs.getString("Exp_C_CodeClient"),rs.getInt("Exp_BExp_ID"),rs.getInt("Exp_A_ID"),rs.getInt("Exp_ID"));
							

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
					 * Permet de r�cup�rer toutes les Expeditions de la table
					 * @return la liste des Expeditions
					 */
					public List<Expedition> getListExpedition()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<Expedition> retour=new ArrayList<Expedition>();
					
						//connexion a la base de donn�es
						try {
							ps = con.prepareStatement("SELECT * FROM Expedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new Expedition(rs.getTimestamp("Exp_Date"),rs.getString("Exp_C_CodeClient"),rs.getInt("Exp_BExp_ID"),rs.getInt("Exp_A_ID"),rs.getInt("Exp_ID")));
							

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
					 * Permet de r�cup�rer toutes les Expeditions de la table pour UN assemblage
					 * @return la liste des Expeditions
					 */
					public List<Expedition> getListExpedition(int Exp_A_ID)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<Expedition> retour=new ArrayList<Expedition>();
					
						//connexion a la base de donn�es
						try {
							ps = con.prepareStatement("SELECT * FROM Expedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new Expedition(rs.getTimestamp("Exp_Date"),rs.getString("Exp_C_CodeClient"),rs.getInt("Exp_BExp_ID"),rs.getInt("Exp_A_ID"),rs.getInt("Exp_ID")));
							

						} catch (Exception ee) {
							ee.printStackTrace();
						} finally {
							//fermeture du rs,preparedStatement et de la connexion
							try {if (rs != null)rs.close();} catch (Exception t) {}
							try {if (ps != null)ps.close();} catch (Exception t) {}
						}
						return retour;
					
					}
		}

