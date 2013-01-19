package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modele.BonLivraison;
import dao.Connexion;


			/**
			 * Classe d'accès aux données contenues dans la table Bon de Commande
			 * */

				public class BonLivraisonDAO {
					private static Connection con;
					
					//singleton attribut permettant de mettre en oeuvre le design pattern singleton
					private static BonLivraisonDAO singleton;
					private  BonLivraisonDAO() throws Exception
					{
						Connexion connect;
						connect = new Connexion();
						con = connect.getConnection();	
					}

					public BonLivraisonDAO getInstance() throws Exception
					{
						if(BonLivraisonDAO.singleton==null)
							singleton=new BonLivraisonDAO();
						return singleton;
						}
					
				
					/**
					 * Permet d'ajouter un BonLivraison
					 * @param BonLivraison à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(BonLivraison b)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO BonLivraison(BLiv_Designation,BLiv_Quantite,BLiv_Reference,BLiv_NumDossier,BLiv_Fournisseur,BLiv_Date) VALUES (?,?,?,?,?,?)");
							ps.setString(1,b.getBLiv_Designation());
							ps.setInt(2,b.getBLiv_Quantite());
							ps.setString(2,b.getBLiv_Reference());
							ps.setString(3,b.getBLiv_NumDossier());
							ps.setString(4,b.getBLiv_Fournisseur());
							ps.setDate(5,b.getBLiv_Date());

							
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
					* Permet de modifier la designation
					* @param id bon et designation à modifier 
					* @return nombre de lignes modifiées dans la table BonLivraison
					*/
					public int modifierDesignation(int BLiv_ID ,String BLiv_Designation)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonLivraison SET BLiv_Designation=? WHERE BLiv_ID=?");
							ps.setString(1,BLiv_Designation);
							ps.setInt(2,BLiv_ID);
							
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
					* Permet de modifier la quantite
					* @param id bon et quantite à modifier 
					* @return nombre de lignes modifiées dans la table BonLivraison
					*/
					public int modifierQuantite(int BLiv_ID ,int BLiv_Quantite)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonLivraison SET BLiv_Quantite=? WHERE BLiv_ID=?");
							ps.setInt(1,BLiv_Quantite);
							ps.setInt(2,BLiv_ID);
							
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
					* Permet de modifier la reference
					* @param reference à modifier 
					* @return nombre de lignes modifiées dans la table BonLivraison
					*/
					public int modifierReference (int BLiv_ID ,String BLiv_Reference)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonLivraison SET BLiv_Reference=? WHERE BLiv_ID=?");
							ps.setString(1,BLiv_Reference);
							ps.setInt(2,BLiv_ID);
							
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
					* Permet de modifier le num dossier
					* @param numero dossier à modifier 
					* @return nombre de lignes modifiées dans la table BonLivraison
					*/
					public int modifierNumDossier (int BLiv_ID ,String BLiv_NumDossier)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonLivraison SET BLiv_NumDossier=? WHERE BLiv_ID=?");
							ps.setString(1,BLiv_NumDossier);
							ps.setInt(2,BLiv_ID);
							
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
					* Permet de modifier le code fournisseur
					* @param code à modifier 
					* @return nombre de lignes modifiées dans la table BonLivraison
					*/
					public int modifierFournisseur(int BLiv_ID ,String BLiv_Fournisseur)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonLivraison SET BLiv_Fournisseur=? WHERE BLiv_ID=?");
							ps.setString(1,BLiv_Fournisseur);
							ps.setInt(2,BLiv_ID);
							
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
					* Permet de modifier la date
					* @param date à modifier 
					* @return nombre de lignes modifiées dans la table BonLivraison
					*/
					public int modifierDate(int BLiv_ID ,Date BLiv_Date)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonLivraison SET BLiv_Date=? WHERE BLiv_ID=?");
							ps.setDate(1,(java.sql.Date) BLiv_Date);
							ps.setInt(2,BLiv_ID);
							
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
					 * Permet de supprimer un BonLivraison dans la table BonLivraison
					 * @param ID du Bon à supprimer
					 *@return null si aucun Bon ne correspond à cet ID 
					 */
					public int supprimer(int BLiv_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de données
						try {
							ps = con.prepareStatement("DELETE FROM BonLivraison WHERE BLiv_ID=?");
							ps.setInt(1, BLiv_ID);
				
										
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
					 * Permet de récupérer un BonLivraison
					 * @param ID du Bon à récupérer
					 * @return le Bon
					 * @return null si aucun Bon ne correspond à cet ID
					 */
					public static BonLivraison getBonLivraison(int ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						BonLivraison retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM BonLivraison WHERE BLiv_ID=?");
							ps.setInt (1,ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new BonLivraison(rs.getInt("BLiv_ID"),rs.getString("BLiv_Designation"),rs.getInt("BLiv_Quantite"),rs.getString("BLiv_Reference"),rs.getString("BLiv_NumDossier"),rs.getString("BLiv_Fournisseur"),rs.getDate("BLiv_Date"));
							

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
					 * Permet de récupérer tous les Bons de livraison de la table
					 * @return la liste des BonLivraison
					 */
					public List<BonLivraison> getListBonLivraison()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonLivraison> retour=new ArrayList<BonLivraison>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonLivraison");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonLivraison(rs.getInt("BLiv_ID"),rs.getString("BLiv_Designation"),rs.getInt("BLiv_Quantite"),rs.getString("BLiv_Reference"),rs.getString("BLiv_NumDossier"),rs.getString("BLiv_Fournisseur"),rs.getDate("BLiv_Date")));
							

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