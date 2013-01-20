<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="Modele.Assemblage"%> 
    <%@ page import="Modele.Piece"%> 
    <%@ page import="Modele.BonLivraison"%> 
    <%@ page import="Modele.BonLivraison"%>
    <%@ page import="Modele.Date"%>
    <%@ page import= "java.text.DateFormat"%>
    <%@ page import="java.util.Date"%>
    <%@ page import="java.text.SimpleDateFormat"%>
    
    
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
if(request.getParameter("nomPiece") == null)
	{
		error="<br> Veuillez rentrer le nom de la piece."+error;
		i=0;
	}

	if(request.getParameter("nomApiece") == null)
	{
		error="<br> Veuillez rentrer le nom de l'assemblage auquel elle appartiendra."+error;
		i=0;
	}
	if(request.getParameter("nomFournisseur") == null)
	{
		error="<br> Veuillez remplir tout les champs."+error;
		i=0;
	}
	if(request.getParameter("dateLivraison") == null)
	{
		error ="<br> Veuillez remplir tout les champs."+error;
		i=0;
	}
	
	if (i!=0)
	{
		String nom_piece = request.getParameter("nomPiece");
		String nom_asspiece = request.getParameter("nomApiece");
		String statut = request.getParameter("statut");
		
		Piece piece = new Piece(nom_piece, nom_asspiece, true);
		
		String designation = request.getParameter("nomPiece");
		String fournisseur = request.getParameter("fournisseur");
		String num_dossier= request.getParameter("numDossier");
		String num_reference = request.getParameter("numReference");
		Integer Quantite= (Integer) request.getAttribute("quantite");
		String s= request.getParameter("dateLivraison");	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date d = sdf.parse(s);
		Date dateLivraison = d ;
		BonLivraison bonLivraison = new BonLivraison(designation, Quantite, num_reference,num_dossier,fournisseur, d);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("EnregistrerPieceMagasin");
		dispatcher.forward( request, response );
	}					 
	else
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("magasin.jsp");
		dispatcher.forward( request, response );
	}
	
		
%>