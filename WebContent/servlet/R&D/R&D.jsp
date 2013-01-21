<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Modele.Piece"%> 
<html>
<head>
<link rel="stylesheet" href="../../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>R&D</title>
</head>
<body>

<% 
	Piece piece = (Piece)request.getAttribute("piece");
	if(piece== null){
%>
	Erreur avec la piece
<%
	}else{
%>

	<center>
	<h1> R&D </h1><br><br>
	<form>
	<table class="tableau">
		<tr>
			<th class="case"><b>Pièce </b></th>
			<th class="case">N° Code Barre</th>
			<td class="case"><%=piece.getP_CodeBarre() %></td>
		</tr>
		<tr>
			<td rowspan="4"></th>
			<th class="case"> </th>
			<td class="case"><%=piece.getP_Nom() %></td>
		</tr>
		<tr>
			<th class="case">Etat de la pièces</th>
			<td class="case">
				<input type="radio" name="statut" value="1"> OK
				<input type="radio" name="statut" value="0"> KO
			</td>
		</tr>
		
		<tr>
			<th class="case">Commentaire</th>
			<td class="case"><textarea name="Commentaire"></textarea></td>
		</tr>
		<tr> <br> </tr>
		<%-- <tr>
			<th></th>
			<th class="case"> Fiche Anomalie</th>
			<!-- <td rowspan="4"></th>-->
			<td class="case"> <input type="radio" name="choix" value="2"> Accepte <br>
			<input type="radio" name="choix" value="2"> Modifier<br>
			<input type="radio" name="choix" value="2"> Retourner au fournisseur 
			</td>

		</tr>--%>
			
			
	</table>
	<br>
	<input type="submit" value="Enregistrer">
	</form>
	</center>
<%} %></body>
</html>