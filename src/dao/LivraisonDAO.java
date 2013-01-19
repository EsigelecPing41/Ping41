package dao;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import Modele.Livraison;
import dao.Connexion;



	/**
	 * Classe d'acc�s aux donn�es contenues dans la table Livraison
	 * */

	public class LivraisonDAO {

		private static Connection con;
				
				//singleton attribut permettant de mettre en oeuvre le design pattern singleton
				private static LivraisonDAO singleton;
				private  LivraisonDAO() throws Exception
				{
					Connexion connect;
					connect = new Connexion();
					con = connect.getConnection();	
				}
				public LivraisonDAO getInstance() throws Exception
				{
					if(LivraisonDAO.singleton==null)
						singleton=new LivraisonDAO();
					return singleton;
				}
							/**
							 * Permet d'ajouter un Livraison dans la table Livraison
							 * @param a Livraison � ajouter
							 * @return le nombre de lignes ajout�es dans la table
							 */
							public static int ajouter(Livraison a)
							{

								PreparedStatement ps = null;
								int retour=0;
							
								//connexion a la base de donn�es
								try {

									ps = con.prepareStatement("INSERT INTO Livraison(Liv_Date,Liv_P_ID,Liv_Bliv_ID,Liv_F_CodeFournisseur) VALUES (?,?,?,?)");
									ps.setTimestamp(1,a.getLiv_Date());
									ps.setInt(2,a.getLiv_P_ID());
									ps.setInt(3,a.getLiv_Bliv_ID());
									ps.setString(4,a.getLiv_F_CodeFournisseur());

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
							* Permet de modifier la date de la Livraison dans la table Livraison
							* @param Liv_Date la date de la Livraison � modifier 
							* @return nombre de lignes modifi�es dans la table Livraison
							*/
							public int modifierDate(int Liv_ID ,Timestamp Liv_Date)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de donn�es
									try 
									{
										ps = con.prepareStatement("UPDATE Livraison SET Liv_Date=? WHERE Liv_ID=?");
										ps.setTimestamp(1,Liv_Date);
										ps.setInt(2,Liv_ID);
										
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
							* Permet de modifier le fournisseur d'Livraison dans la table Livraison
							* @param Liv_F_ID de le fournisseur d'Livraison � modifier
							* @return nombre de lignes modifi�es dans la table Livraison
							*/
							public int modifierFournisseur(int Liv_ID ,int Liv_F_ID)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de donn�es
									try 
									{
										ps = con.prepareStatement("UPDATE Livraison SET Liv_F_ID=? WHERE Liv_ID=?");
										ps.setInt(1,Liv_F_ID);
										ps.setInt(2,Liv_ID);
										
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
							* Permet de modifier le Bon de Livraison dans la table Livraison
							* @param Liv_Bliv_ID de le Bon de Livraisonr d'une Livraison � modifier
							* @return nombre de lignes modifi�es dans la table Livraison
							*/
							public int modifierBonLivraison(int Liv_ID ,int Liv_Bliv_ID)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de donn�es
									try 
									{
										ps = con.prepareStatement("UPDATE Livraison SET Liv_Bliv_ID=? WHERE Liv_ID=?");
										ps.setInt(1,Liv_Bliv_ID);
										ps.setInt(2,Liv_ID);
										
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
							* Permet de modifier la piece d'une Livraison dans la table Livraison
							* @param Liv_P_ID de la piece d'une Livraison � modifier 
							* @return nombre de lignes modifi�es dans la table Livraison
							*/
							public int modifierPiece(int Liv_P_ID ,int Liv_ID)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de donn�es
									try 
									{
										ps = con.prepareStatement("UPDATE Livraison SET Liv_P_ID=? WHERE Liv_ID=?");
										ps.setInt(1,Liv_P_ID);
										ps.setInt(2,Liv_ID);
										
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
							 * Permet de supprimer une Livraison dans la table Livraison
							 * @param Liv_ID de la Livraison � supprimer
							 *@return null si aucune Livraison ne correspond � ce Liv_ID du Livraison 
							 */
							public int supprimer(int Liv_ID)
							{
								PreparedStatement ps=null;
								int retour=0;
								
								//connexion a la base de donn�es
								try {
									ps = con.prepareStatement("DELETE FROM Livraison WHERE Liv_ID=?");
									ps.setInt(1, Liv_ID);
						
												
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
							 * Permet de r�cup�rer une Livraison 
							 * @param Liv_ID est l'ID de la Livraison
							 * @return la Livraison
							 * @return null si aucune Livraison ne correspond � cet ID
							 */
							public Livraison getLivraison(int Liv_ID)
							{					
								PreparedStatement ps = null;
								ResultSet rs=null;
								Livraison retour=null;
							
								//connexion a la base de donn�es
								try {

									ps = con.prepareStatement("SELECT * FROM Livraison WHERE Liv_ID=?");
									ps.setInt(1,Liv_ID);
												
									//on execute la requete 
									rs=ps.executeQuery();
									if(rs.next())
										retour=new Livraison(rs.getTimestamp("Liv_Date"),rs.getInt("Liv_P_ID"),rs.getInt("Liv_Bliv_ID"),rs.getString("Liv_F_CodeFournisseur"),rs.getInt("Liv_ID"));
									

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
							 * Permet de r�cup�rer toutes les Livraisons de la table
							 * @return la liste des Livraisons
							 */
							public List<Livraison> getListLivraison()
							{
								PreparedStatement ps = null;
								ResultSet rs=null;
								List<Livraison> retour=new ArrayList<Livraison>();
							
								//connexion a la base de donn�es
								try {
									ps = con.prepareStatement("SELECT * FROM Livraison");
															
									//on execute la requete 
									rs=ps.executeQuery();
									//on parcourt les lignes du resultat
									while(rs.next())
										retour.add(new Livraison(rs.getTimestamp("Liv_Date"),rs.getInt("Liv_P_ID"),rs.getInt("Liv_Bliv_ID"),rs.getString("Liv_F_CodeFournisseur"),rs.getInt("Liv_ID")));
									

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
							 * Permet de r�cup�rer toutes les Livraisons de la table pour UN assemblage
							 * @return la liste des Livraisons
							 */
							public List<Livraison> getListLivraison(int Liv_P_ID)
							{
								PreparedStatement ps = null;
								ResultSet rs=null;
								List<Livraison> retour=new ArrayList<Livraison>();
							
								//connexion a la base de donn�es
								try {
									ps = con.prepareStatement("SELECT * FROM Livraison");
															
									//on execute la requete 
									rs=ps.executeQuery();
									//on parcourt les lignes du resultat
									while(rs.next())
										retour.add(new Livraison(rs.getTimestamp("Liv_Date"),rs.getInt("Liv_P_ID"),rs.getInt("Liv_Bliv_ID"),rs.getString("Liv_F_CodeFournisseur"),rs.getInt("Liv_ID")));	

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



