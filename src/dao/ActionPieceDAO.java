package CoucheDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import CoucheDTO.ActionPiece;
import CoucheDTO.Connexion;
import CoucheDTO.Operateur;

/**
 * Classe d'acc�s aux donn�es contenues dans la table Action
 * */

public class ActionPieceDAO {

			private static final Date AP_Date = null;
			private static Connexion con;
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static ActionPieceDAO singleton;
			private  ActionPieceDAO()
			{
				con = new Connexion();
			}

			public ActionPieceDAO getInstance()
			{
				if(ActionPieceDAO.singleton==null)
					singleton=new ActionPieceDAO();
				return singleton;
			}
		
				/**
				 * Permet d'ajouter une Date d'Action dans la table Action
				 * @param a l'Action � ajouter
				 * @return le nombre de lignes ajout�es dans la table
				 */
				public static int ajouter(ActionPiece a)
				{

					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de donn�es
					try {

						ps = con.getConnection().prepareStatement("INSERT INTO ActionPiece (AP_Date ,AP_IDPiece, AP_IDOperateur, AP_IDOperation) VALUES (?,?,?,?)");
						ps.setDate(1,(Date) a.getAP_Date());
						ps.setInt(2,a.getAP_IDPiece());
						ps.setInt(3,a.getAP_IDOperateur());
						ps.setInt(4,a.getAP_IDOperation());
						
						
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
				 * @param DateAction l'id de l'Action  � supprimer
				 *@return null si aucune Action ne correspond � cette date
				 */
				public int supprimer(Date AP_Date)
				{
					PreparedStatement ps=null;
					int retour=0;
					
					//connexion a la base de donn�es
					try {
						ps = con.getConnection().prepareStatement("DELETE FROM Action WHERE AP_Date=?");
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
				 * Permet de r�cup�rer une date d'une Action 
				 * @param AP_Date la date de l'Action � r�cup�rer
				 * @return l'Action
				 * @return null si aucune Action ne correspond � cette date
				 */
				public static ActionPiece getActionPiece(Date AP_Date)
				{					
					PreparedStatement ps = null;
					ResultSet rs=null;
					ActionPiece retour=null;
				
					//connexion a la base de donn�es
					try {

						ps = con.getConnection().prepareStatement("SELECT * FROM Action WHERE AP_Date LIKE ?");
						ps.setDate(1,AP_Date);
									
						//on execute la requete 
						rs=ps.executeQuery();
						if(rs.next())
							retour=new ActionPiece ();
						

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
				 * Permet de r�cup�rer toutes les dates des Actions de la table
				 * @return la liste des Actions
				 */
				public List<ActionPiece> getListActionPiece()
				{
					PreparedStatement ps = null;
					ResultSet rs=null;
					List<ActionPiece> retour=new ArrayList<ActionPiece>();
				
					//connexion a la base de donn�es
					try {
						ps = con.getConnection().prepareStatement("SELECT * FROM Action");
												
						//on execute la requete 
						rs=ps.executeQuery();
						//on parcourt les lignes du resultat
						while(rs.next())
							retour.add(new ActionPiece ());
						

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
					ActionPieceDAO ActionDAO=new ActionPieceDAO();
					
					System.out.println("\n********************");
					System.out.println("Test de la m�thode ajouter");
					System.out.println("********************");
					
					//test de la m�thode ajouter
					ActionPiece a=new ActionPiece();
					int retour= ActionPieceDAO.ajouter(a);
					System.out.println(retour+ " lignes ajout�es");

					
					
					System.out.println("\n********************");
					System.out.println("Test de la m�thode supprimer");
					System.out.println("********************");
					
					//test de la m�thode supprimer
					int as=2;
					int retour1= ActionDAO.supprimer(AP_Date);
					System.out.println(retour1+ " lignes supprim�es");
					
					
					System.out.println("\n********************");
					System.out.println("Test de la m�thode getActionPiece avec AP_Piece");
					System.out.println("********************");
					
					//test de la m�thode getAction avec AP_Date
					ActionPiece a2=ActionPieceDAO.getActionPiece(AP_Date);
					System.out.println(a2);

					
										
					
					System.out.println("\n********************");
					System.out.println("Test de la m�thode getListActionPiece");
					System.out.println("********************");
					
					//test de la m�thode getListActionPiece
					List<ActionPiece> liste=ActionDAO.getListActionPiece();
					System.out.println(liste);
					
				}         
	}

