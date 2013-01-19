package dao;

	import java.sql.*;
	import java.util.ArrayList;
import java.util.Date;
	import java.util.List;

import Modele.Commande;
import dao.Connexion;


	/**
	 * Classe d'acc�s aux donn�es contenues dans la table Commande
	 * */

	public class CommandeDAO {
		private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static CommandeDAO singleton;
		private  CommandeDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}
		public CommandeDAO getInstance() throws Exception
		{
			if(CommandeDAO.singleton==null)
				singleton=new CommandeDAO();
			return singleton;
		}
					/**
					 * Permet d'ajouter un Commande dans la table Commande
					 * @param a Commande � ajouter
					 * @return le nombre de lignes ajout�es dans la table
					 */
					public static int ajouter(Commande a)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de donn�es
						try {

							ps = con.prepareStatement("INSERT INTO CommandeDAO (Com_Date,Com_F_CodeFournisseur,Com_BCom_ID,Com_P_ID) VALUES (?,?,?,?)");
							ps.setDate(1,(java.sql.Date)a.getCom_Date());
							ps.setString(2,a.getCom_F_CodeFournisseur());
							ps.setInt(3,a.getCom_BCom_ID());
							ps.setInt(4,a.getCom_P_ID());

							
							//on execute la requete 
							retour=ps.executeUpdate();
							

						} catch (Exception ee) {
							ee.printStackTrace();
						} finally {
							//fermeture du getConnection().preparedStatement et de la connexion
							try {if (ps != null)ps.close();} catch (Exception t) {}
						}
						return retour;				}


					/**
					* Permet de modifier la date de la Commande dans la table Commande
					* @param Com_Date la date de la Commande � modifier 
					* @return nombre de lignes modifi�es dans la table Commande
					*/
					public int modifierDate(int Com_ID ,Date Com_Date)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_Date=? WHERE Com_ID=?");
								ps.setDate(1,(java.sql.Date) Com_Date);
								ps.setInt(2,Com_ID);
								
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
					* Permet de modifier le Bon de Commande dans la table Commande
					* @param Com_BCom_ID de le Bon de Commande � modifier
					* @return nombre de lignes modifi�es dans la table Commande
					*/
					public int modifierBonCommande(int Com_ID ,int Com_BCom_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_BCom_ID=? WHERE Com_ID=?");
								ps.setInt(1,Com_BCom_ID);
								ps.setInt(2,Com_ID);
								
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
					* Permet de modifier le Fournisseur d'une Commande dans la table Commande
					* @param Com_F_ID de le Fournisseur d'une Commande � modifier
					* @return nombre de lignes modifi�es dans la table Commande
					*/
					public int modifierFournisseur(int Com_ID ,String Com_F_CodeFournisseur)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_F_CodeFournisseur=? WHERE Com_ID=?");
								ps.setString(1,Com_F_CodeFournisseur);
								ps.setInt(2,Com_ID);
								
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
					* Permet de modifier la Piece d'une Commande dans la table Commande
					* @param Com_P_ID de la Piece d'une Commande � modifier 
					* @return nombre de lignes modifi�es dans la table Commande
					*/
					public int modifierPiece(int Com_ID ,int Com_P_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_P_ID=? WHERE Com_ID=?");
								ps.setInt(1,Com_P_ID);
								ps.setInt(2,Com_ID);
								
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
					 * Permet de supprimer une Commande dans la table Commande
					 * @param Com_ID de la Commande � supprimer
					 *@return null si aucune Commande ne correspond � ce Com_ID du Commande 
					 */
					public int supprimer(int Com_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de donn�es
						try {
							ps = con.prepareStatement("DELETE FROM Commande WHERE Com_ID=?");
							ps.setInt(1, Com_ID);
				
										
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
					 * Permet de r�cup�rer une Commande 
					 * @param Com_ID est l'ID de la Commande
					 * @return la Commande
					 * @return null si aucune Commande ne correspond � cet ID
					 */
					public static Commande getCommande(int Com_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						Commande retour=null;
					
						//connexion a la base de donn�es
						try {

							ps = con.prepareStatement("SELECT * FROM Commande WHERE Com_ID=?");
							ps.setInt(1,Com_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new Commande(rs.getDate("Com_Date"),rs.getString("Com_F_CodeFournisseur"),rs.getInt("Com_BCom_ID"),rs.getInt("Com_P_ID"),rs.getInt("Com_ID"));
							

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
					 * Permet de r�cup�rer toutes les Commandes de la table
					 * @return la liste des Commandes
					 */
					public List<Commande> getListCommande()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<Commande> retour=new ArrayList<Commande>();
					
						//connexion a la base de donn�es
						try {
							ps = con.prepareStatement("SELECT * FROM Commande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new Commande(rs.getDate("Com_Date"),rs.getString("Com_F_CodeFournisseur"),rs.getInt("Com_BCom_ID"),rs.getInt("Com_P_ID"),rs.getInt("Com_ID")));
							

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
					 * Permet de r�cup�rer toutes les Commandes de la table pour UNE piece
					 * @return la liste des Commandes
					 */
					public List<Commande> getListCommande(int Com_P_ID)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<Commande> retour=new ArrayList<Commande>();
					
						//connexion a la base de donn�es
						try {
							ps = con.prepareStatement("SELECT * FROM Commande WHERE Com_P_ID=" +Com_P_ID);
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new Commande(rs.getDate("Com_Date"),rs.getString("Com_F_CodeFournisseur"),rs.getInt("Com_BCom_ID"),rs.getInt("Com_P_ID"),rs.getInt("Com_ID")));
							

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


