<%--*****************************************************
* Module : Vue
* Fichier : menu
* Description : Fichier JSP permettant d'afficher le menu
* Projet : SKF Traceability
* Auteur : GC
* Date : 13/12/12
* Version : 0.5
******************************************************--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Modele.Operateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<link rel="stylesheet" href="menu.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

<table class="menu2">
	<% 
		HttpSession ses = request.getSession(true);
		Operateur operateur = (Operateur)ses.getAttribute("sessionUtilisateur");
	%>
	<tr><td class="cellule_titre"><img src="../img/skf_ok.png" height="50px">
	Bonjour, <%=operateur.getO_Prenom()%> <%=operateur.getO_Nom()%>
	</td>
	</tr>
</table>
<table class="menu1">
	<tr>
		<% 
			for(int i=0;i<operateur.getO_Parametre().get_S_P_Menu();i++){
		%>
				<td><a id="m<%=i+1 %>" href="../../afficherService?id=<%=operateur.getO_Parametre().getMenu(i, 0)%>" target="page"><%=operateur.getO_Parametre().getMenu(i, 1)%></a></td>
		<%
			}
		%>
		<td><a id="m10" href="/SKFTraceability/deconnexionOperateur" target="_top">Déconnexion</a></td>
	</tr>
</table>


</body>
</html>