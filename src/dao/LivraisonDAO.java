package dao;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import Modele.Livraison;
	import dao.Connexion;



	/**
	 * Classe d'accès aux données contenues dans la table Livraison
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
							 * @param a Livraison à ajouter
							 * @return le nombre de lignes ajoutées dans la table
							 */
							public static int ajouter(Livraison a)
							{

								PreparedStatement ps = null;
								int retour=0;
							
								//connexion a la base de données
								try {

									ps = con.prepareStatement("INSERT INTO LivraisonDAO (Liv_Date,Liv_P_ID,Liv_Bliv_ID,Liv_F_ID,Liv_ID) VALUES (?,?,?,?,?)");
									ps.setDate(1,(Date)a.getLiv_Date());
									ps.setInt(2,a.getLiv_P_ID());
									ps.setInt(3,a.getLiv_Bliv_ID());
									ps.setInt(4,a.getLiv_F_ID());
									ps.setInt(5,a.getLiv_ID());

									
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
							* @param Liv_Date la date de la Livraison à modifier 
							* @return nombre de lignes modifiées dans la table Livraison
							*/
							public int modifierDate(int Liv_ID ,Date Liv_Date)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de données
									try 
									{
										ps = con.prepareStatement("UPDATE Livraison SET Liv_Date=? WHERE Liv_ID=?");
										ps.setDate(1,Liv_Date);
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
							* @param Liv_F_ID de le fournisseur d'Livraison à modifier
							* @return nombre de lignes modifiées dans la table Livraison
							*/
							public int modifierFournisseur(int Liv_ID ,int Liv_F_ID)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de données
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
							* @param Liv_Bliv_ID de le Bon de Livraisonr d'une Livraison à modifier
							* @return nombre de lignes modifiées dans la table Livraison
							*/
							public int modifierBonLivraison(int Liv_ID ,int Liv_Bliv_ID)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de données
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
							* @param Liv_P_ID de la piece d'une Livraison à modifier 
							* @return nombre de lignes modifiées dans la table Livraison
							*/
							public int modifierPiece(int Liv_P_ID ,int Liv_ID)
							{
									PreparedStatement ps = null;
									int retour=0;
								
									//connexion a la base de données
									try 
									{
										ps = con.prepareStatement("UPDATE Livraison SET Liv_P_ID=? WHERE Exp_D=?");
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
							 * @param Liv_ID de la Livraison à supprimer
							 *@return null si aucune Livraison ne correspond à ce Liv_ID du Livraison 
							 */
							public int supprimer(int Liv_ID)
							{
								PreparedStatement ps=null;
								int retour=0;
								
								//connexion a la base de données
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
							 * Permet de récupérer une Livraison 
							 * @param Liv_ID est l'ID de la Livraison
							 * @return la Livraison
							 * @return null si aucune Livraison ne correspond à cet ID
							 */
							public static LivraisonDAO getLivraisonDAO(int Liv_ID)
							{					
								PreparedStatement ps = null;
								ResultSet rs=null;
								LivraisonDAO retour=null;
							
								//connexion a la base de données
								try {

									ps = con.prepareStatement("SELECT * FROM Livraison WHERE Liv_ID LIKE ?");
									ps.setInt(1,Liv_ID);
												
									//on execute la requete 
									rs=ps.executeQuery();
									if(rs.next())
										retour=new LivraisonDAO ();
									

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
							 * Permet de récupérer toutes les Livraisons de la table
							 * @return la liste des Livraisons
							 */
							public List<LivraisonDAO> getListLivraisonDAO()
							{
								PreparedStatement ps = null;
								ResultSet rs=null;
								List<LivraisonDAO> retour=new ArrayList<LivraisonDAO>();
							
								//connexion a la base de données
								try {
									ps = con.prepareStatement("SELECT * FROM Livraison");
															
									//on execute la requete 
									rs=ps.executeQuery();
									//on parcourt les lignes du resultat
									while(rs.next())
										retour.add(new LivraisonDAO ());
									

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
							 * Permet de récupérer toutes les Livraisons de la table pour UN assemblage
							 * @return la liste des Livraisons
							 */
							public List<LivraisonDAO> getListLivraisonDAO(int Liv_P_ID)
							{
								PreparedStatement ps = null;
								ResultSet rs=null;
								List<LivraisonDAO> retour=new ArrayList<LivraisonDAO>();
							
								//connexion a la base de données
								try {
									ps = con.prepareStatement("SELECT * FROM Livraison");
															
									//on execute la requete 
									rs=ps.executeQuery();
									//on parcourt les lignes du resultat
									while(rs.next())
										retour.add(new LivraisonDAO ());
									

								} catch (Exception ee) {
									ee.printStackTrace();
								} finally {
									//fermeture du rs,preparedStatement et de la connexion
									try {if (rs != null)rs.close();} catch (Exception t) {}
									try {if (ps != null)ps.close();} catch (Exception t) {}
								}
								return retour;
							
							}

					
					
					
		/**			//main permettant de tester la classe
					public static void main(int[] args){
						LivraisonDAO LivraisonDAO=new LivraisonDAO();
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode ajouter");
						System.out.println("********************");
						
						//test de la méthode ajouter
						Livraison a=new Livraison();
						int retour= dao.LivraisonDAO.ajouter(a);
						System.out.println(retour+ " lignes ajoutées");

						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode supprimer");
						System.out.println("********************");
						
						//test de la méthode supprimer
						Date LivDate= null;
						int retour1= LivraisonDAO.supprimer(LivDate);
						System.out.println(retour1+ " lignes supprimées");
						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getLivraisonDAO avec LivDate");
						System.out.println("********************");
						
						//test de la méthode getLivraison avec ComDate
						LivraisonDAO a2=dao.LivraisonDAO.getLivraisonDAO(LivDate);
						System.out.println(a2);

						
											
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getListLivraisonDAO");
						System.out.println("********************");
						
						//test de la méthode getListLivraisonDAO
						List<LivraisonDAO> liste=LivraisonDAO.getListLivraisonDAO();
						System.out.println(liste);
						
					}        **/
		}



