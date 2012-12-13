<%--*****************************************************
* Module : Vue
* Fichier : etatDouchette
* Description : Fichier JSP permettant d'afficher l'etat connecte ou non de la douchette
* Projet : SKF Traceability
* Auteur : GC
* Date : 13/12/12
* Version : 0.5
******************************************************--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	HttpSession ses = request.getSession(true);
	Boolean etat = (Boolean)ses.getAttribute("etatDouchette");
	if(etat){
%>
	la douchette est connecte
<% 
	}else{
%>
	<center>
		Veuillez connecter la douchette<br>
		<img src="servlet/img/douchette.jpg" width="20%"><br>
		<a href="/SKFTraceability/connexionDouchette">Simuler la connexion</a>
	</center>
<% 
	}
%>
</body>
</html>