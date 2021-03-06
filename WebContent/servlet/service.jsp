<%--*****************************************************
* Module : Vue
* Fichier : index
* Description : Fichier JSP permettant d'afficher la page centrale
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
<link rel="stylesheet" href="../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SKF Traceability Tools</title>
</head>
<FRAMESET class="frame" border="1" COLS="170px,700px">
	<FRAMESET border="1" ROWS="75%,25%">
		<% 
			HttpSession ses = request.getSession(true);
			String idService = (String)ses.getAttribute("id");
		%>
		<FRAME Noresize Scrolling="NO" SRC="listePieceParService?id=<%=idService%>" NAME="menu_gauche">
		<!-- <FRAME Noresize Scrolling="NO" SRC="etatDouchette?etat=1" NAME="menu_gauche_bas"> -->
	</FRAMESET>
	<% 
		String dossier = (String)ses.getAttribute("dossier");
		if(dossier == "" || dossier== null){dossier="Accueil";}
		String lien = "servlet/"+dossier+"/";
		String scanner = (String)ses.getAttribute("scan");
		if(scanner != null ){if(scanner.equals("1") ){lien="servlet/ScannerCodeBarre/scanner.jsp";}}
	%>
	<FRAME Noresize SRC="<%=lien%>" NAME="page">
</FRAMESET>
		
		
	</FRAMESET>
<!--</FRAMESET>-->

