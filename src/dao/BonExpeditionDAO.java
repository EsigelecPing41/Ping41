package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modele.BonExpedition;
import dao.Connexion;


			/**
			 * Classe d'accès aux données contenues dans la table Bon de Expedition
			 * */

				public class BonExpeditionDAO {
					private static Connection con;
					
					//singleton attribut permettant de mettre en oeuvre le design pattern singleton
					private static BonExpeditionDAO singleton;
					private  BonExpeditionDAO() throws Exception
					{
						Connexion connect;
						connect = new Connexion();
						con = connect.getConnection();	
					}

					public BonExpeditionDAO getInstance() throws Exception
					{
						if(BonExpeditionDAO.singleton==null)
							singleton=new BonExpeditionDAO();
						return singleton;
						}
					
				
					/**
					 * Permet d'ajouter un BonExpedition 
					 * @param a BonExpedition à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(BonExpedition b)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO BonExpedition(BExp_Designation,BExp_Reference,BExp_NumDossier,BExp_Client,BExp_Date) VALUES (?,?,?,?,?)");
							ps.setString(1,b.getBExp_Designation());
							ps.setString(2,b.getBExp_Reference());
							ps.setString(3,b.getBExp_NumDossier());
							ps.setString(4,b.getBExp_Client());
							ps.setDate(5,b.getBExp_Date());

							
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
					* @param designation à modifier 
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierDesignation(int BExp_ID ,String BExp_Designation)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonExpedition SET BExp_Designation=? WHERE BExp_ID=?");
							ps.setString(1,BExp_Designation);
							ps.setInt(2,BExp_ID);
							
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
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierReference (int BExp_ID ,String BExp_Reference)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonExpedition SET BExp_Reference=? WHERE BExp_ID=?");
							ps.setString(1,BExp_Reference);
							ps.setInt(2,BExp_ID);
							
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
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierNumDossier (int BExp_ID ,String BExp_NumDossier)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonExpedition SET BExp_NumDossier=? WHERE BExp_ID=?");
							ps.setString(1,BExp_NumDossier);
							ps.setInt(2,BExp_ID);
							
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
					* Permet de modifier le code client
					* @param code à modifier 
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierClient(int BExp_ID ,String BExp_Client)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonExpedition SET BExp_Client=? WHERE BExp_ID=?");
							ps.setString(1,BExp_Client);
							ps.setInt(2,BExp_ID);
							
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
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierDate(int BExp_ID ,Date BExp_Date)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonExpedition SET BExp_Date=? WHERE BExp_ID=?");
							ps.setDate(1,(java.sql.Date) BExp_Date);
							ps.setInt(2,BExp_ID);
							
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
					 * Permet de supprimer un BonExpedition dans la table BonExpedition
					 * @param BExp_ID du Bon  à supprimer
					 *@return null si aucun Bon ne correspond à cet ID du BonExpedition
					 */
					public int supprimer(int BExp_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de données
						try {
							ps = con.prepareStatement("DELETE FROM BonExpedition WHERE BExp_ID=?");
							ps.setInt(1, BExp_ID);
				
										
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
					 * @param BExp_ID est l'ID du Bon à récupérer
					 * @return le Bon
					 * @return null si aucun Bon ne correspond à cet ID
					 */
					public static BonExpedition getBonExpedition(int BExp_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						BonExpedition retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM BonExpedition WHERE BExp_ID=?");
							ps.setInt (1,BExp_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new BonExpedition(rs.getInt("BExp_ID"),rs.getString("BExp_Designation"),rs.getString("BExp_Reference"),rs.getString("BExp_NumDossier"),rs.getString("BExp_Client"),rs.getDate("BExp_Date"));
							

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
					 * Permet de récupérer tous les Bons d'Expedition de la table
					 * @return la liste des Bons d'Expedition
					 */
					public List<BonExpedition> getListBonExpedition()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonExpedition> retour=new ArrayList<BonExpedition>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonExpedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonExpedition(rs.getInt("BExp_ID"),rs.getString("BExp_Designation"),rs.getString("BExp_Reference"),rs.getString("BExp_NumDossier"),rs.getString("BExp_Client"),rs.getDate("BExp_Date")));
							

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