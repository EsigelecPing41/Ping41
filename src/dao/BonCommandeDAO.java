package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modele.BonCommande;
import dao.Connexion;


			/**
			 * Classe d'accès aux données contenues dans la table Bon de Commande
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
					 * @param BonCommande à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(BonCommande b)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO BonCommande(BCom_Designation,BCom_Quantite,BCom_Reference,BCom_NumDossier,BCom_Fournisseur,BCom_Date) VALUES (?,?,?,?,?,?)");
							ps.setString(1,b.getBCom_Designation());
							ps.setInt(2,b.getBCom_Quantite());
							ps.setString(2,b.getBCom_Reference());
							ps.setString(3,b.getBCom_NumDossier());
							ps.setString(4,b.getBCom_Fournisseur());
							ps.setDate(5,b.getBCom_Date());

							
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
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierDesignation(int BCom_ID ,String BCom_Designation)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonCommande SET BCom_Designation=? WHERE BCom_ID=?");
							ps.setString(1,BCom_Designation);
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
					* Permet de modifier la quantite
					* @param id bon et quantite à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierQuantite(int BCom_ID ,int BCom_Quantite)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonCommande SET BCom_Quantite=? WHERE BCom_ID=?");
							ps.setInt(1,BCom_Quantite);
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
					* Permet de modifier la reference
					* @param reference à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierReference (int BCom_ID ,String BCom_Reference)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonCommande SET BCom_Reference=? WHERE BCom_ID=?");
							ps.setString(1,BCom_Reference);
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
					* Permet de modifier le num dossier
					* @param numero dossier à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierNumDossier (int BCom_ID ,String BCom_NumDossier)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonCommande SET BCom_NumDossier=? WHERE BCom_ID=?");
							ps.setString(1,BCom_NumDossier);
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
					* Permet de modifier le code fournisseur
					* @param code à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierFournisseur(int BCom_ID ,String BCom_Fournisseur)				
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
					* Permet de modifier la date
					* @param date à modifier 
					* @return nombre de lignes modifiées dans la table BonCommande
					*/
					public int modifierDate(int BCom_ID ,Date BCom_Date)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonCommande SET BCom_Date=? WHERE BCom_ID=?");
							ps.setDate(1,(java.sql.Date) BCom_Date);
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
					 * @param ID du Bon  à supprimer
					 *@return null si aucun Bon ne correspond à cet ID 
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
					 * Permet de récupérer un BonExpedition 
					 * @param ID du Bon à récupérer
					 * @return le Bon
					 * @return null si aucun Bon ne correspond à cet ID
					 */
					public static BonCommande getBonCommande(int ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						BonCommande retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM BonCommande WHERE BCom_ID=?");
							ps.setInt (1,ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new BonCommande(rs.getInt("BCom_ID"),rs.getString("BCom_Designation"),rs.getInt("BCom_Quantite"),rs.getString("BCom_Reference"),rs.getString("BCom_NumDossier"),rs.getString("BCom_Fournisseur"),rs.getDate("BCom_Date"));
							

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
					 * Permet de récupérer tous les Bons de de commande de la table
					 * @return la liste des BonCommande
					 */
					public List<BonCommande> getListBonCommande()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonCommande> retour=new ArrayList<BonCommande>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonCommande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonCommande(rs.getInt("BCom_ID"),rs.getString("BCom_Designation"),rs.getInt("BCom_Quantite"),rs.getString("BCom_Reference"),rs.getString("BCom_NumDossier"),rs.getString("BCom_Fournisseur"),rs.getDate("BCom_Date")));
							

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