package Controlleur;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AssemblageDAO;
import dao.LieuDAO;
import dao.LocalisationAssemblageDAO;

import Modele.Assemblage;
import Modele.Date;
import Modele.Lieu;
import Modele.LocalisationAssemblage;
import Modele.Operateur;

import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code128;

public class GenererAssemblage extends HttpServlet {
	 JBarcodeBean bb;
	    public static final int LABEL_BOTTOM = 0;
	 
	    public void init(ServletConfig conf) throws ServletException {
	        super.init(conf);
	        bb = new JBarcodeBean();
	        bb.setCodeType(new Code128());
	        bb.setLabelPosition(LABEL_BOTTOM);
	    }
	 
	    public void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    	System.out.println("genererassemblage.java");
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	response.setContentType("image/gif");
	    	//OutputStream out = response.getOutputStream();
	    	HttpSession session = request.getSession();
	    	System.out.println("genererassemblage.java");
	    	
	    	Operateur operateur =(Operateur) session.getAttribute("sessionUtilisateur");
	    	
	    	System.out.println(operateur.getO_Nom());
	    	
	    	String designationPiece = (String)request.getAttribute("designation_de_la_piece");
	    	String nDossierDeDefinition = (String) request.getAttribute("no_dossier_def");
	    	String codeGPAO = (String) request.getAttribute("code_gpao");
	    	String ind_nomencl = (String) request.getAttribute("ind_nomencl");
	    	String no_serie = (String) request.getAttribute("no_serie");
	    	String ordre_de_fabrication = (String)request.getAttribute("ordre_fabrication");
	    	String num_affaire = (String)request.getAttribute("num_affaire");
	    	String code_client = (String)request.getAttribute("numero_client");
	    	AssemblageDAO assemblageDAO;
	    	Assemblage assemblage = null;
			try {
				assemblageDAO = AssemblageDAO.getInstance();
				assemblage = new Assemblage(no_serie,code_client,nDossierDeDefinition,codeGPAO,assemblageDAO.RecupererListeOperation(designationPiece), assemblageDAO.RecupererListePieces(designationPiece),ind_nomencl,designationPiece,ordre_de_fabrication,num_affaire);
				assemblage.setA_NumSerie(assemblage.genererNumAssemblage()); 
		        assemblage.setA_CodeBarre(assemblage.getA_NumSerie());
			
		        //assemblageDAO.ajouter(assemblage);
	    	//creation d'un nouvel assemblage
	    	//aller chercher dans la base de donnée la liste des pièces et la liste des opérations
	    	//mettre à jour le lieu 
	    	//comment savoir si on est en fabrication ?
	    	
	    	
	        //le code barre et le numéro de série sont insérés
	       
	       
	        	LocalisationAssemblageDAO locDAO =  LocalisationAssemblageDAO.getInstance();
				LieuDAO lieuDAO =  LieuDAO.getInstance();
			    Lieu lieu = lieuDAO.getLieu(4); // ordonnancement;
			    java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
			    System.out.println(dateNow);
			    System.out.println(lieu.getL_ID());
			    System.out.println(assemblage.getA_ID());
			    
			    //LocalisationAssemblage locAssemblage = new LocalisationAssemblage(0, dateNow, operateur.getO_ID(), lieu.getL_ID(), assemblage.getA_ID());
			    //locDAO.ajouter(locAssemblage);
			    //l'assemblage est localisé à l'ordonnancement
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        bb.setCode(assemblage.getA_CodeBarre());//numero de la piece.
        	request.setAttribute("codebarre", bb);
        	RequestDispatcher dispatcher;
        	//dispatcher = request.getRequestDispatcher("/servlet/Ordonnancement/afficherCodeBarre.jsp");
        	//dispatcher.forward( request, response );
        	}
}
