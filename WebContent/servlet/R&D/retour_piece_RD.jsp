<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
    <%@ page import="Modele.Piece"%> 
    
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
		error="<br> Indiquez l'état de la pièce"+error;
		i=0;
	}
if(request.getParameter("commantaire") == null)
{
	error="<br> Notez un commentaire relatant l'état de la pièce"+error;
	i=0;
}
if (i!=0)
	{
		Boolean statut = (Boolean)request.getAttribute("statut");
		String commentaire= (String)request.getAttribute("commentaire");
		Piece piece = (Piece)request.getAttribute("piece");
		piece.setP_Statut(statut);
		piece.setP_Commentaire(commentaire);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModifierPieceRD");
		dispatcher.forward( request, response );
	}
%>	    