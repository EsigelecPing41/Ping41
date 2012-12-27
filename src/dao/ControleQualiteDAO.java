package dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import Modele.ControleQualite;
import dao.Connexion;

		/**
		 * Classe d'accès aux données contenues dans la table Controle Qualite
		 * */

		public class ControleQualiteDAO {
			private static Connection con;
			
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static ControleQualiteDAO singleton;
			private  ControleQualiteDAO() throws Exception
			{
				Connexion connect;
				connect = new Connexion();
				con = connect.getConnection();	
			}
			public ControleQualiteDAO getInstance() throws Exception
			{
				if(ControleQualiteDAO.singleton==null)
					singleton=new ControleQualiteDAO();
				return singleton;
			}
						/**
						 * Permet d'ajouter un Controle Qualite dans la table Controle Qualite
						 * @param a ControleQualite à ajouter
						 * @return le nombre de lignes ajoutées dans la table
						 */
						public static int ajouter(ControleQualite a)
						{

							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try {

								ps = con.prepareStatement("INSERT INTO ControleQualiteDAO (CQ_Resultat,CQ_ID,CQ_CrQ_ID,CQ_O_ID,CQ_A_ID) VALUES (?,?,?,?,?)");
								ps.setInt(1,a.getCQ_Resultat());
								ps.setInt(2,a.getCQ_ID());
								ps.setInt(3,a.getCQ_CrQ_ID());
								ps.setInt(4,a.getCQ_O_ID());
								ps.setInt(5,a.getCQ_A_ID());

								
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
						* Permet de modifier le resultat du controle qualite dans la table ControleQualite
						* @param CQ_Resultat le resultat du controle qualite à modifier et le nouvel assemblage
						* @return nombre de lignes modifiées dans la table ControleQualite
						*/
						public int modifierResultat(int CQ_ID ,int CQ_Resultat)
						{
								PreparedStatement ps = null;
								int retour=0;
							
								//connexion a la base de données
								try 
								{
									ps = con.prepareStatement("UPDATE ControleQualite SET CQ_Resultat=? WHERE CQ_ID=?");
									ps.setInt(1,CQ_Resultat);
									ps.setInt(2,CQ_ID);
									
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
						* Permet de modifier l'operateur du controle qualite dans la table ControleQualite
						* @param CQ_O_ID de l'operateur du controle qualite à modifier et le nouvel assemblage
						* @return nombre de lignes modifiées dans la table ControleQualite
						*/
						public int modifierOperateur(int CQ_ID ,int CQ_O_ID)
						{
								PreparedStatement ps = null;
								int retour=0;
							
								//connexion a la base de données
								try 
								{
									ps = con.prepareStatement("UPDATE ControleQualite SET CQ_O_ID=? WHERE CQ_ID=?");
									ps.setInt(1,CQ_O_ID);
									ps.setInt(2,CQ_ID);
									
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
						* Permet de modifier le Critere Qualite d'un assemblage dans la table ControleQualite
						* @param CQ_CrQ_ID de le Critere Qualitede l'assemblage à modifier et le nouvel assemblage
						* @return nombre de lignes modifiées dans la table ControleQualite
						*/
						public int modifierCritereQualite(int CQ_ID ,int CQ_CrQ_ID)
						{
								PreparedStatement ps = null;
								int retour=0;
							
								//connexion a la base de données
								try 
								{
									ps = con.prepareStatement("UPDATE ControleQualite SET CQ_CrQ_ID=? WHERE CQ_ID=?");
									ps.setInt(1,CQ_CrQ_ID);
									ps.setInt(2,CQ_ID);
									
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
						* Permet de modifier le Controle Qualite d'un assemblage dans la table ControleQualite
						* @param CQ_A_ID de le Controle Qualite de l'assemblage à modifier et le nouvel assemblage
						* @return nombre de lignes modifiées dans la table ControleQualite
						*/
						public int modifierAssemblage(int CQ_ID ,int CQ_A_ID)
						{
								PreparedStatement ps = null;
								int retour=0;
							
								//connexion a la base de données
								try 
								{
									ps = con.prepareStatement("UPDATE ControleQualite SET CQ_A_ID=? WHERE CQ_ID=?");
									ps.setInt(1,CQ_A_ID);
									ps.setInt(2,CQ_ID);
									
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
						 * Permet de supprimer un Controle de Qualite dans la table ControleQualite
						 * @param CQ_ID du Controle Qualite à supprimer
						 *@return null si aucun Controle Qualite ne correspond à ce CQ_Resultat du Controle Qualite 
						 */
						public int supprimer(int CQ_ID)
						{
							PreparedStatement ps=null;
							int retour=0;
							
							//connexion a la base de données
							try {
								ps = con.prepareStatement("DELETE FROM ControleQualite WHERE CQ_ID=?");
								ps.setInt(1, CQ_ID);
					
											
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
						 * Permet de récupérer un Controle de Qualite 
						 * @param CQ_ID est l'ID du Controle de Qualite
						 * @return le Controle de Qualite
						 * @return null si aucun Controle de Qualite ne correspond à cet ID
						 */
						public static ControleQualiteDAO getControleQualiteDAO(int CQ_ID)
						{					
							PreparedStatement ps = null;
							ResultSet rs=null;
							ControleQualiteDAO retour=null;
						
							//connexion a la base de données
							try {

								ps = con.prepareStatement("SELECT * FROM ControleQualite WHERE CQ_ID LIKE ?");
								ps.setInt(1,CQ_ID);
											
								//on execute la requete 
								rs=ps.executeQuery();
								if(rs.next())
									retour=new ControleQualiteDAO ();
								

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
						 * Permet de récupérer tous les Controles de Qualite de la table
						 * @return la liste des Controles de Qualite
						 */
						public List<ControleQualiteDAO> getListControleQualiteDAO()
						{
							PreparedStatement ps = null;
							ResultSet rs=null;
							List<ControleQualiteDAO> retour=new ArrayList<ControleQualiteDAO>();
						
							//connexion a la base de données
							try {
								ps = con.prepareStatement("SELECT * FROM ControleQualite");
														
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new ControleQualiteDAO ());
								

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
						 * Permet de récupérer tous les Controles de Qualite de la table pour UN assemblage
						 * @return la liste des Controles de Qualite
						 */
						public List<ControleQualiteDAO> getListControleQualiteDAO(int CQ_ID)
						{
							PreparedStatement ps = null;
							ResultSet rs=null;
							List<ControleQualiteDAO> retour=new ArrayList<ControleQualiteDAO>();
						
							//connexion a la base de données
							try {
								ps = con.prepareStatement("SELECT * FROM ControleQualite");
														
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new ControleQualiteDAO ());
								

							} catch (Exception ee) {
								ee.printStackTrace();
							} finally {
								//fermeture du rs,preparedStatement et de la connexion
								try {if (rs != null)rs.close();} catch (Exception t) {}
								try {if (ps != null)ps.close();} catch (Exception t) {}
							}
							return retour;
						
						}

							
						
			
						
	/**					//main permettant de tester la classe
						public static void main(int[] args){
							ControleQualiteDAO ControleQualiteDAO=new ControleQualiteDAO();
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode ajouter");
							System.out.println("********************");
							
							//test de la méthode ajouter
							ControleQualite a=new ControleQualite();
							int retour= dao.ControleQualiteDAO.ajouter(a);
							System.out.println(retour+ " lignes ajoutées");

							
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode supprimer");
							System.out.println("********************");
							
							//test de la méthode supprimer
							intCQ_Resultat= null;
							int retour1= ControleQualiteDAO.supprimer(CQ_Resultat);
							System.out.println(retour1+ " lignes supprimées");
							
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode getControleQualiteDAO avec CQ_Resultat");
							System.out.println("********************");
							
							//test de la méthode getControleQualite avec CQ_Resultat
							ControleQualiteDAO a2=dao.ControleQualiteDAO.getControleQualiteDAO(CQ_Resultat);
							System.out.println(a2);

							
												
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode getListControleQualiteDAO");
							System.out.println("********************");
							
							//test de la méthode getListControleQualiteDAO
							List<ControleQualiteDAO> liste=ControleQualiteDAO.getListControleQualiteDAO();
							System.out.println(liste);
							
						}**/
		       
			}




