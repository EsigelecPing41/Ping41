package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.ActionAssemblage;
import Modele.Connexion;
import Modele.Operateur;

/**
 * Classe d'accès aux données contenues dans la table Action
 * */

public class ActionAssemblageDAO {

			private static final Date AA_Date = null;
			private static Connexion con;
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static ActionAssemblageDAO singleton;
			private  ActionAssemblageDAO()
			{
				con = new Connexion();
			}

			public ActionAssemblageDAO getInstance()
			{
				if(ActionAssemblageDAO.singleton==null)
					singleton=new ActionAssemblageDAO();
				return singleton;
			}
		
				/**
				 * Permet d'ajouter une Date d'Action dans la table Action
				 * @param a l'Action à ajouter
				 * @return le nombre de lignes ajoutées dans la table
				 */
				public static int ajouter(ActionAssemblage a)
				{

					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de données
					try {

						ps = con.getConnection().prepareStatement("INSERT INTO ActionAssemblageDAO (AA_Date ,AA_IDAssemblage, AA_IDOperateur, AA_IDOperation) VALUES (?,?,?,?)");
						ps.setDate(1,(Date) a.getAA_Date());
						ps.setInt(2,a.getAA_IDAssemblage());
						ps.setInt(3,a.getAA_IDOperateur());
						ps.setInt(4,a.getAA_IDOperateur());
						
						
						//on execute la requete 
						retour=ps.executeUpdate();
						

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du getConnection().preparedStatement et de la connexion
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}


				/**
				 * Permet de supprimer une Date d'Action dans la table Action
				 * @param DateAction l'id de l'Action  à supprimer
				 *@return null si aucune Action ne correspond à cette date
				 */
				public int supprimer(Date AA_Date)
				{
					PreparedStatement ps=null;
					int retour=0;
					
					//connexion a la base de données
					try {
						ps = con.getConnection().prepareStatement("DELETE FROM Action WHERE AA_Date=?");
						ps.setDate(1,AA_Date);
			
									
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
				 * Permet de récupérer une date d'une Action 
				 * @param AA_Date la date de l'Action à récupérer
				 * @return l'Action
				 * @return null si aucune Action ne correspond à cette date
				 */
				public static ActionAssemblageDAO getActionAssemblageDAO(Date AA_Date)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionAssemblageDAO retour=null;
				
					//connexion a la base de données
					try {

						ps = con.getConnection().prepareStatement("SELECT * FROM Action WHERE AA_Date LIKE ?");
						ps.setDate(1,AA_Date);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionAssemblageDAO ();
						

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
				 * Permet de récupérer toutes les dates des Actions de la table
				 * @return la liste des Actions
				 */
				public List<ActionAssemblageDAO> getListActionAssemblageDAO()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionAssemblageDAO> retour=new ArrayList<ActionAssemblageDAO>();
				
					//connexion a la base de données
					try {
						ps = con.getConnection().prepareStatement("SELECT * FROM Action");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionAssemblageDAO ());
						

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du rs,preparedStatement et de la connexion
						try {if (rs != null)rs.close();} catch (Exception t) {}
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}
				
				
				
				//main permettant de tester la classe
				public static void main(int[] args){
					ActionAssemblageDAO ActionAssemblageDAO=new ActionAssemblageDAO();
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode ajouter");
					System.out.println("********************");
					
					//test de la méthode ajouter
					ActionAssemblage a=new ActionAssemblage();
					int retour= ActionAssemblageDAO.ajouter(a);
					System.out.println(retour+ " lignes ajoutées");

					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode supprimer");
					System.out.println("********************");
					
					//test de la méthode supprimer
					int as=2;
					int retour1= ActionAssemblageDAO.supprimer(AA_Date);
					System.out.println(retour1+ " lignes supprimées");
					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getActionAssemblageDAO avec AP_Piece");
					System.out.println("********************");
					
					//test de la méthode getAction avec AA_Date
					ActionAssemblageDAO a2=ActionAssemblageDAO.getActionAssemblageDAO(AA_Date);
					System.out.println(a2);

					
										
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getListActionAssemblageDAO");
					System.out.println("********************");
					
					//test de la méthode getListActionAssemblageDAO
					List<ActionAssemblageDAO> liste=ActionAssemblageDAO.getListActionAssemblageDAO();
					System.out.println(liste);
					
				}        
	}

