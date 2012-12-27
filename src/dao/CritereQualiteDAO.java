package dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import Modele.CritereQualite;
	import dao.Connexion;

		/**
		 * Classe d'accès aux données contenues dans la table Critere Qualite
		 * */

		public class CritereQualiteDAO {

			private static Connection con;
			
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static CritereQualiteDAO singleton;
			private  CritereQualiteDAO() throws Exception
			{
				Connexion connect;
				connect = new Connexion();
				con = connect.getConnection();	
			}

			public CritereQualiteDAO getInstance() throws Exception
			{
				if(CritereQualiteDAO.singleton==null)
					singleton=new CritereQualiteDAO();
				return singleton;
			}
				
						/**
						 * Permet d'ajouter un Critere Qualite dans la table Critere Qualite
						 * @param a CritereQualite à ajouter
						 * @return le nombre de lignes ajoutées dans la table
						 */
						public static int ajouter(CritereQualite a)
						{

							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try {

								ps = con.prepareStatement("INSERT INTO CritereQualiteDAO (CrQ_ID,CrQ_libelle) VALUES (?,?)");
								ps.setInt(1,a.getCrQ_ID());
								ps.setString(1,a.getCrQ_libelle());
								
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
						* Permet de modifier le libelle d'un assemblage dans la table Critere Qualite
						* @param CrQ_libelle le libelle de l'assemblage à modifier et le nouvel assemblage
						* @return nombre de lignes modifiées dans la table ActionAssemblage
						*/
						public int modifierLibelle (int CrQ_ID ,String CrQ_libelle)				
						{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE ActionAssemblage SET CrQ_libelle=? WHERE CrQ_ID=?");
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
						 * Permet de supprimer un Critere de Qualite dans la table CritereQualite
						 * @param CrQ_ID du Critere Qualite à supprimer
						 *@return null si aucun Critere Qualite ne correspond à ce CrQ_ID du Critere Qualite 
						 */
						public int supprimer(int CrQ_ID)
						{
							PreparedStatement ps=null;
							int retour=0;
							
							//connexion a la base de données
							try {
								ps = con.prepareStatement("DELETE FROM CritereQualite WHERE CrQ_ID=?");
								ps.setInt(1, CrQ_ID);
					
											
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
						 * Permet de récupérer un Critere de Qualite 
						 * @param CrQ_ID est l'ID du Critere de Qualite
						 * @return le Critere de Qualite
						 * @return null si aucun Critere de Qualite ne correspond à cet ID
						 */
						public static CritereQualiteDAO getCritereQualiteDAO(int  CrQ_ID)
						{					
							PreparedStatement ps = null;
							ResultSet rs=null;
							CritereQualiteDAO retour=null;
						
							//connexion a la base de données
							try {

								ps = con.prepareStatement("SELECT * FROM CritereQualite WHERE CrQ_ID LIKE ?");
								ps.setInt(1,CrQ_ID);
											
								//on execute la requete 
								rs=ps.executeQuery();
								if(rs.next())
									retour=new CritereQualiteDAO ();
								

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
						 * Permet de récupérer tous les Criteres de Qualite de la table
						 * @return la liste des Criteres de Qualite
						 */
						public List<CritereQualiteDAO> getListCritereQualiteDAO()
						{
							PreparedStatement ps = null;
							ResultSet rs=null;
							List<CritereQualiteDAO> retour=new ArrayList<CritereQualiteDAO>();
						
							//connexion a la base de données
							try {
								ps = con.prepareStatement("SELECT * FROM CritereQualite");
														
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new CritereQualiteDAO ());
								

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
						 * Permet de récupérer tous les Criteres de Qualite pour UN libelle de la table
						 * @return la liste des Criteres de Qualite
						 */
						public List<CritereQualiteDAO> getListCritereQualiteDAO(String CrQ_ID)
						{
							PreparedStatement ps = null;
							ResultSet rs=null;
							List<CritereQualiteDAO> retour=new ArrayList<CritereQualiteDAO>();
						
							//connexion a la base de données
							try {
								ps = con.prepareStatement("SELECT * FROM CritereQualite");
														
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new CritereQualiteDAO ());
								

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
							CritereQualiteDAO CritereQualiteDAO=new CritereQualiteDAO();
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode ajouter");
							System.out.println("********************");
							
							//test de la méthode ajouter
							CritereQualite a=new CritereQualite();
							int retour= dao.CritereQualiteDAO.ajouter(a);
							System.out.println(retour+ " lignes ajoutées");

							
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode supprimer");
							System.out.println("********************");
							
							//test de la méthode supprimer
							int CrQ_ID = 0;
							int retour1= CritereQualiteDAO.supprimer(CrQ_ID);
							System.out.println(retour1+ " lignes supprimées");
							
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode getCritereQualiteDAO avec CrQ_ID");
							System.out.println("********************");
							
							//test de la méthode getCritereQualite avec CrQ_ID
							CritereQualiteDAO a2=dao.CritereQualiteDAO.getCritereQualiteDAO(CrQ_ID);
							System.out.println(a2);

							
												
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode getListCritereQualiteDAO");
							System.out.println("********************");
							
							//test de la méthode getListCritereQualiteDAO
							List<CritereQualiteDAO> liste=CritereQualiteDAO.getListCritereQualiteDAO();
							System.out.println(liste);
							
						}**/
		       
			}





