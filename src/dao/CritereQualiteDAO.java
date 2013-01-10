package dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import Modele.CritereQualite;
	import dao.Connexion;

		public class CritereQualiteDAO 
		{

			private static Connection con;
			
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static CritereQualiteDAO singleton;
			private  CritereQualiteDAO() throws Exception
			{
				Connexion connect;
				connect = new Connexion();
				con = connect.getConnection();	
			}

			public static CritereQualiteDAO getInstance() throws Exception
			{
				if(CritereQualiteDAO.singleton==null)
					singleton=new CritereQualiteDAO();
				return singleton;
			}
				
						/**
						 * Permet d'ajouter un Critere Qualite dans la table Critere Qualite
						 * @param a CritereQualite � ajouter
						 * @return le nombre de lignes ajout�es dans la table
						 */
						public static int ajouter(CritereQualite c)
						{

							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("INSERT INTO CritereQualiteDAO (CrQ_libelle,CrQ_resultat) VALUES (?,?)");
								ps.setString(1,c.getCrQ_libelle());
								ps.setBoolean(2,c.getCrQ_resultat());
								
								//on execute la requete 
								retour=ps.executeUpdate();
								
							} 
							catch (Exception ee) 
							{
								ee.printStackTrace();
							} 
							finally 
							{
								//fermeture du getConnection().preparedStatement et de la connexion
								try {if (ps != null)ps.close();} catch (Exception t) {}
							}
							return retour;				
						}


						/**
						* Permet de modifier le libelle d'un critere dans la table Critere Qualite
						* @param le libelle du critere � modifier 
						* @return nombre de lignes modifi�es dans la table CritereQualite
						*/
						public int modifierLibelle (int CrQ_ID ,String CrQ_libelle)				
						{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE CritereQualite SET CrQ_libelle=? WHERE CrQ_ID=?");
								ps.setString(1,CrQ_libelle);
								ps.setInt(2,CrQ_ID);
								
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
						* Permet de modifier le resultat d'un critere dans la table Critere Qualite
						* @param le resultat � modifier 
						* @return nombre de lignes modifi�es dans la table CritereQualite
						*/
						public int modifierResultat (int CrQ_ID ,boolean CrQ_resultat)				
						{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("UPDATE CritereQualite SET CrQ_resultat=? WHERE CrQ_ID=?");
								ps.setBoolean(1,CrQ_resultat);
								ps.setInt(2,CrQ_ID);
								
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
						 * Permet de supprimer un Critere de Qualite dans la table CritereQualite
						 * @param critere Qualite � supprimer
						 *@return null si aucun Critere Qualite ne correspond dans la table CritereQualite 
						 */
						public int supprimer(int CrQ_ID)
						{
							PreparedStatement ps=null;
							int retour=0;
							
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("DELETE FROM CritereQualite WHERE CrQ_ID=?");
								ps.setInt(1, CrQ_ID);
					
								//on execute la requete 
								retour=ps.executeUpdate();

							}
							catch (Exception ee)
							{
								ee.printStackTrace();
							} 
							finally 
							{
								//fermeture du rs,preparedStatement et de la connexion
								
								try {if (ps != null)ps.close();} catch (Exception t) {}
							}
							return retour;
						
						}	
						
						/**
						 * Permet de r�cup�rer un Critere de Qualite a partir de son ID
						 * @param l'ID du Critere de Qualite
						 * @return le Critere de Qualite
						 * @return null si aucun Critere de Qualite ne correspond � cet ID
						 */
						public CritereQualite getCritereQualite(int CrQ_ID)
						{					
							PreparedStatement ps = null;
							ResultSet rs = null;
							CritereQualite CritereQualiteRetourne = null;
						
							//connexion a la base de donnees
							try 
							{	
								ps = con.prepareStatement("SELECT * FROM CritereQualite WHERE CrQ_ID =?");
								ps.setInt(1,CrQ_ID);
											
								//on execute la requete 
								rs = ps.executeQuery();
								if(rs.next())
									CritereQualiteRetourne = new CritereQualite(rs.getInt("CrQ_ID"),rs.getString("CrQ_libelle"),rs.getBoolean("CrQ_resultat"));
							}
							catch (Exception e) 
							{
								e.printStackTrace();
							} 
							finally 
							{
								try 
								{
									if (rs != null)
									rs.close();
								} 
								catch (Exception t)
								{
								}
								
								try 
								{
									if (ps != null)
										ps.close();
								} 
								catch (Exception t) 
								{	
								}
							}
							return CritereQualiteRetourne;
						}
						
						
						/**
						 * Permet de r�cup�rer un Critere de Qualite a partir de son libelle
						 * @param le libelle du Critere de Qualite
						 * @return le Critere de Qualite
						 * @return null si aucun Critere de Qualite ne correspond � ce libelle
						 */
						public CritereQualite getCritereQualite(String CrQ_libelle)
						{					
							PreparedStatement ps = null;
							ResultSet rs = null;
							CritereQualite CritereQualiteRetourne = null;
						
							//connexion a la base de donnees
							try 
							{	
								ps = con.prepareStatement("SELECT * FROM CritereQualite WHERE CrQ_libelle =?");
								ps.setString(1,CrQ_libelle);
											
								//on execute la requete 
								rs = ps.executeQuery();
								if(rs.next())
									CritereQualiteRetourne = new CritereQualite(rs.getInt("CrQ_ID"),rs.getString("CrQ_libelle"),rs.getBoolean("CrQ_resultat"));
							}
							catch (Exception e) 
							{
								e.printStackTrace();
							} 
							finally 
							{
								try 
								{
									if (rs != null)
									rs.close();
								} 
								catch (Exception t)
								{
								}
								
								try 
								{
									if (ps != null)
										ps.close();
								} 
								catch (Exception t) 
								{	
								}
							}
							return CritereQualiteRetourne;
						}
						
						/**
						 * Permet de r�cup�rer tous les Criteres de Qualite de la table
						 * @return la liste des Criteres de Qualite
						 */
						public List<CritereQualite> getListCritereQualite()
						{
							PreparedStatement ps = null;
							ResultSet rs = null;
							List<CritereQualite> retour =new ArrayList<CritereQualite>();
						
							//connexion a la base de donn�es
							try {
								ps = con.prepareStatement("SELECT * FROM CritereQualite");
														
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new CritereQualite(rs.getInt("CrQ_ID"),rs.getString("CrQ_libelle"),rs.getBoolean("CrQ_resultat")));
								

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
						 * Permet de r�cup�rer tous les Criteres de Qualite ayant un resultat precis (ok ou ko)
						 * @return la liste des Criteres de Qualite concernes
						 */
						public List<CritereQualite> getListCritereQualite(Boolean CrQ_resultat)
						{
							PreparedStatement ps = null;
							ResultSet rs=null;
							List<CritereQualite> retour=new ArrayList<CritereQualite>();
						
							//connexion a la base de donn�es
							try 
							{
								ps = con.prepareStatement("SELECT * FROM CritereQualite WHERE CrQ_resultat=" +CrQ_resultat);
														
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new CritereQualite(rs.getInt("CrQ_ID"),rs.getString("CrQ_libelle"),rs.getBoolean("CrQ_resultat")));

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
						
	/**					//main permettant de tester la classe
						public static void main(int[] args){
							CritereQualiteDAO CritereQualiteDAO=new CritereQualiteDAO();
							
							System.out.println("\n********************");
							System.out.println("Test de la m�thode ajouter");
							System.out.println("********************");
							
							//test de la m�thode ajouter
							CritereQualite a=new CritereQualite();
							int retour= dao.CritereQualiteDAO.ajouter(a);
							System.out.println(retour+ " lignes ajout�es");

							
							
							System.out.println("\n********************");
							System.out.println("Test de la m�thode supprimer");
							System.out.println("********************");
							
							//test de la m�thode supprimer
							int CrQ_ID = 0;
							int retour1= CritereQualiteDAO.supprimer(CrQ_ID);
							System.out.println(retour1+ " lignes supprim�es");
							
							
							System.out.println("\n********************");
							System.out.println("Test de la m�thode getCritereQualiteDAO avec CrQ_ID");
							System.out.println("********************");
							
							//test de la m�thode getCritereQualite avec CrQ_ID
							CritereQualiteDAO a2=dao.CritereQualiteDAO.getCritereQualiteDAO(CrQ_ID);
							System.out.println(a2);

							
												
							
							System.out.println("\n********************");
							System.out.println("Test de la m�thode getListCritereQualiteDAO");
							System.out.println("********************");
							
							//test de la m�thode getListCritereQualiteDAO
							List<CritereQualiteDAO> liste=CritereQualiteDAO.getListCritereQualiteDAO();
							System.out.println(liste);
							
						}**/
		       
			}






