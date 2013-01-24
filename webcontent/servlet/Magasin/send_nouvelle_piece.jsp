<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="Modele.Assemblage"%> 
    <%@ page import="Modele.Piece"%> 
    <%@ page import="Modele.BonLivraison"%> 
    <%@ page import="Modele.BonLivraison"%>
    <%--@ page import="Modele.Date"--%>
    <%@ page import= "java.text.DateFormat"%>
    <%--@ page import="java.util.Date"--%>
    <%@ page import="java.text.SimpleDateFormat"%>
    <%@ page import = "java.sql.Date" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	int i=1;
	String error = "";
	if(request.getParameter("nomPiece") == null  || request.getParameter("nomPiece")=="")
	{
		error="<br> Veuillez rentrer le nom de la piece."+error;
		i=0;
	}

	if(request.getParameter("nomAPiece") == null  || request.getParameter("nomAPiece")=="")
	{
		error="<br> Veuillez rentrer le nom de l'assemblage auquel elle appartiendra."+error;
		i=0;
	}
	if(request.getParameter("nomFournisseur") == null  || request.getParameter("nomFournisseur")=="")
	{
		error="<br> Veuillez remplir le champs fournisseur."+error;
		i=0;
	}
	if(request.getParameter("dateLivraison") == null  || request.getParameter("dateLivraison")=="")
	{
		error ="<br> Veuillez remplir le champs date de livraison."+error;
		i=0;
	}
	
	
	if(request.getParameter("nomFournisseur") == null  || request.getParameter("nomFournisseur")=="")
	{
		error="<br> Veuillez rentrer le nom de l'assemblage auquel elle appartiendra."+error;
		i=0;
	}
	if(request.getParameter("numReference") == null  || request.getParameter("numReference")=="")
	{
		error="<br> Veuillez remplir le champs fournisseur."+error;
		i=0;
	}
	if(request.getParameter("quantite") == null  || request.getParameter("quantite")=="")
	{
		error ="<br> Veuillez remplir le champs date de livraison."+error;
		i=0;
	}
	if(request.getParameter("numDossier") == null  || request.getParameter("numDossier")=="")
	{
		error ="<br> Veuillez remplir le champs date de livraison."+error;
		i=0;
	}
	
	
	
	
	if (i!=0)
	{
		String nom_piece = request.getParameter("nomPiece");
		String nom_asspiece = request.getParameter("nomAPiece");
		//String statut = request.getParameter("statut");
		
		Piece piece = new Piece(nom_piece, nom_asspiece, true);
		
		String designation = request.getParameter("nomPiece");
		String fournisseur = request.getParameter("nomFournisseur");
		String num_dossier= request.getParameter("numDossier");
		String num_reference = request.getParameter("numReference");
		String Quantite2= request.getParameter("quantite");
		Integer Quantite = Integer.parseInt(Quantite2);
			//	Integer.getInteger(Quantite2);
		
		String dateLivraison2 = request.getParameter("dateLivraison");	
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
		java.util.Date dateLivraison3 = sdf.parse(dateLivraison2);
		
		java.sql.Date dateLivraison = new java.sql.Date(dateLivraison3.getTime());

		/*Date dateLivraison = new Date(request.getParameter("dateLivraison"));*/
		BonLivraison bonLivraison = new BonLivraison(designation, Quantite, num_reference,num_dossier,fournisseur, dateLivraison);
		request.setAttribute("piece", piece);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/enregistrerPieceMagasin");
		dispatcher.forward( request, response );
	}					 
	else
	{
		HttpSession ses = request.getSession(true);
		ses.setAttribute("error",error);
		RequestDispatcher dispatcher = request.getRequestDispatcher("magasin.jsp");
		dispatcher.forward( request, response );
	}
	
		
%>