package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import Modele.BonCommande;

	/**
	 * Classe d'accès aux données contenues dans la table BonCommande
	 * */

	public class BonCommandeDAO {
		private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static BonCommandeDAO singleton;
		private  BonCommandeDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public BonCommandeDAO getInstance() throws Exception
		{
			if(BonCommandeDAO.singleton==null)
				singleton=new BonCommandeDAO();
			return singleton;
			}
		
					/**
					 * Permet d'ajouter un BonCommande 
					 * @param a BonCommande à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(BonCommande a)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO BonCommandeDAO (BCom_ID,BCom_Fournisseur,BCom_Date) VALUES (?,?,?)");
							ps.setInt(1,a.getBCom_ID());
							ps.setString(2,a.getBCom_Fournisseur());
							ps.setDate(3,(Date)a.getBCom_Date());

							
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
					* Permet de modifier la date d'un bon dans la table BonCommande
					* @param BCom_Date de la date du bon à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierDate (int BCom_ID ,Date BCom_Date)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonCommande SET BCom_Date=? WHERE BCom_ID=?");
							ps.setDate(1, BCom_Date);
							ps.setInt(2,BCom_ID);
							
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
					* Permet de modifier le fournisseur dans la table BonCommande
					* @param BCom_Fournisseur de le fournisseur à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierFournisseur (int BCom_ID ,String BCom_Fournisseur)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE BonCommande SET BCom_Fournisseur=? WHERE BCom_ID=?");
								ps.setString(1,BCom_Fournisseur);
								ps.setInt(2,BCom_ID);
								
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
					 * Permet de supprimer un BonCommande dans la table BonCommande
					 * @param BCom_ID du Bon  à supprimer
					 *@return null si aucun Bon ne correspond à cet ID du BonCommande
					 */
					public int supprimer(int BCom_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de données
						try {
							ps = con.prepareStatement("DELETE FROM BonCommande WHERE BCom_ID=?");
							ps.setInt(1, BCom_ID);
				
										
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
					 * Permet de récupérer un BonCommande d'un Bon 
					 * @param BCom_ID est l'ID du Bon à récupérer
					 * @return le Bon
					 * @return null si aucun Bon ne correspond à cet ID
					 */
					public static BonCommandeDAO getBonCommandeDAO(int BCom_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						BonCommandeDAO retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM BonCommande WHERE BCom_ID LIKE ?");
							ps.setInt (1,BCom_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new BonCommandeDAO ();
							

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
					 * Permet de récupérer tous les Bons de Commande de la table
					 * @return la liste des Bons de Commande
					 */
					public List<BonCommandeDAO> getListBonCommandeDAO()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonCommandeDAO> retour=new ArrayList<BonCommandeDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonCommande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonCommandeDAO ());
							

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
					 * Permet de récupérer UN Bon de Commande de la table
					 * @return le Bon de Commande
					 */
					public List<BonCommandeDAO> getListBonCommandeDAO(int BCom_ID)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonCommandeDAO> retour=new ArrayList<BonCommandeDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonCommande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonCommandeDAO ());
							

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
					 * Permet de récupérer UN Bon de Commande de la table par rapport au Numero Dossier
					 * @return le Bon de Commande
					 */
					public List<BonCommandeDAO> getListBonCommandeDAO(String BCom_NumDossier)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonCommandeDAO> retour=new ArrayList<BonCommandeDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonCommande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonCommandeDAO ());
							

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
						BonCommandeDAO BonCommandeDAO=new BonCommandeDAO();
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode ajouter");
						System.out.println("********************");
						
						//test de la méthode ajouter
						BonCommande a=new BonCommande();
						int retour= dao.BonCommandeDAO.ajouter(a);
						System.out.println(retour+ " lignes ajoutées");

						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode supprimer");
						System.out.println("********************");
						
						//test de la méthode supprimer
						int BCom_ID= (Integer) null;
						int retour1= BonCommandeDAO.supprimer(BCom_ID);
						System.out.println(retour1+ " lignes supprimées");
						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getBonCommandeDAO avec BCom_ID");
						System.out.println("********************");
						
						//test de la méthode getBonCommande avec BCom_ID
						BonCommandeDAO a2=dao.BonCommandeDAO.getBonCommandeDAO(BCom_ID);
						System.out.println(a2);

						
											
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getListBonCommandeDAO");
						System.out.println("********************");
						
						//test de la méthode getListBonCommandeDAO
						List<BonCommandeDAO> liste=BonCommandeDAO.getListBonCommandeDAO();
						System.out.println(liste);
						
					}**/
	       
		}



