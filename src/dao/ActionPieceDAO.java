package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.ActionPiece;
import Modele.Operateur;



/**
 * Classe d'accès aux données contenues dans la table Action
 * */

public class ActionPieceDAO {

			private static final Date AP_Date = null;
			private static Connection con;
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static ActionPieceDAO singleton;
			private  ActionPieceDAO() throws Exception
			{
				Connexion connect;
				connect = new Connexion();
				con = connect.getConnection();	
			}

			public ActionPieceDAO getInstance() throws Exception
			{
				if(ActionPieceDAO.singleton==null)
					singleton=new ActionPieceDAO();					
				return singleton;
			}
		
				/**
				 * Permet d'ajouter une Date d'Action dans la table Action
				 * @param a l'Action à ajouter
				 * @return le nombre de lignes ajoutées dans la table
				 */
				public static int ajouter(Modele.ActionPiece a)
				{

					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("INSERT INTO ActionPiece (AP_Date ,AP_IDPiece, AP_IDOperateur, AP_IDOperation) VALUES (?,?,?,?)");
						ps.setDate(1,(Date) a.getA_Date());
						ps.setInt(2,a.getAP_IDPiece());
						ps.setInt(3,a.getA_IDOperateur());
						ps.setInt(4,a.getA_IDOperation());
						
						
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
				public int supprimer(Date AP_Date)
				{
					PreparedStatement ps=null;
					int retour=0;
					
					//connexion a la base de données
					try {
						ps = con.prepareStatement("DELETE FROM Action WHERE AP_Date=?");
						ps.setDate(1,AP_Date);
			
									
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
				 * @param AP_Date la date de l'Action à récupérer
				 * @return l'Action
				 * @return null si aucune Action ne correspond à cette date
				 */
				public static ActionPiece getActionPiece(Date AP_Date)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionPiece retour=null;
				
					//connexion a la base de données
					try {

						ps = con.prepareStatement("SELECT * FROM Action WHERE AP_Date LIKE ?");
						ps.setDate(1,AP_Date);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionPiece (AP_Date, 0, 0, 0);
						

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
				public List<ActionPiece> getListActionPiece()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionPiece> retour=new ArrayList<ActionPiece>();
				
					//connexion a la base de données
					try {
						ps = con.prepareStatement("SELECT * FROM Action");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionPiece (null, 0, 0, 0));
						

					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						//fermeture du rs,preparedStatement et de la connexion
						try {if (rs != null)rs.close();} catch (Exception t) {}
						try {if (ps != null)ps.close();} catch (Exception t) {}
					}
					return retour;
				
				}
				
				
			/*	
				//main permettant de tester la classe
				public static void main(int[] args){
					ActionPieceDAO ActionDAO;
					try {
						ActionDAO = new ActionPieceDAO();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode ajouter");
					System.out.println("********************");
					
					//test de la méthode ajouter
					ActionPiece a=new ActionPiece();
					int retour= ActionPieceDAO.ajouter(a);
					System.out.println(retour+ " lignes ajoutées");

					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode supprimer");
					System.out.println("********************");
					
					//test de la méthode supprimer
					int as=2;
					int retour1= ActionDAO.supprimer(AP_Date);
					System.out.println(retour1+ " lignes supprimées");
					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getActionPiece avec AP_Piece");
					System.out.println("********************");
					
					//test de la méthode getAction avec AP_Date
					ActionPiece a2=ActionPieceDAO.getActionPiece(AP_Date);
					System.out.println(a2);

					
										
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getListActionPiece");
					System.out.println("********************");
					
					//test de la méthode getListActionPiece
					List<ActionPiece> liste=ActionDAO.getListActionPiece();
					System.out.println(liste);
					
				}         */
	}

