<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List"%> 
    <%@ page import="Modele.Assemblage"%> 
    <%@ page import="Modele.Piece"%> 
    <%@ page import="Modele.BonLivraison"%> 
    <%@ page import="Modele.BonLivraison"%>
    <%@ page import= "java.text.DateFormat"%>
    <%@ page import="java.util.Date"%>
    <%@ page import="java.text.SimpleDateFormat"%>
 <%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
    
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
if(request.getParameter("statut") == null)
	{
		error="<br> Indiquez l'�tat de la pi�ce"+error;
		i=0;
	}
if (i!=0)
	{
		Boolean statut = (Boolean)request.getAttribute("statut");
		String commentaire= (String)request.getAttribute("commentaire");
		Piece piece = (Piece)request.getAttribute("piece");
		piece.setP_Statut(statut);
		piece.setP_Commentaire(commentaire);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Metrologie");
		dispatcher.forward( request, response );
	}
%>	    