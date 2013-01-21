<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Modele.Piece"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="../../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Métrologie</title>
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
	<h1>Métrologie</h1><br>
	<p></p>
	<form target="content" method="post" action="enregistrerPieceMetrologie">
	<table class="tableau">
		<tr>
			<th class="case"><b>Pièce</b></th>
			<th class="case">N° code barre</th>
			<td class="case"><%=piece.getP_CodeBarre() %></td>
			<input type="hidden" name="num_piece" value=<%=piece.getP_CodeBarre() %>>
		</tr>
		<tr>
			<td rowspan="7"></th>
		
		</tr>
		<tr>
			<th class="case">Nom de la pièce</th>
			<td class="case"><%=piece.getP_Nom() %></td>
		</tr>
		<tr>
			<th class="case">Nom de l'assemblage assossier à la pièce</th>
			<td class="case"><%=piece.getP_A_Nom() %></td>
		</tr>
		<tr>
			<th class="case">Etat de la pièce</th>
			<td class="case"><input type="checkbox" name="statut" value="1"> OK<input type="checkbox" name="EtatPiece" value="0"> KO</td>
		</tr>
		<tr>
			<th class="case">Commentaire</th>
			<td class="case"><textarea name="Commentaire"></textarea></td>
		</tr>
		<tr>
			<!-- <th><a href="javascript:document.getElementById('fiche_anomalie').style.display='block'">Generer fiche anomalie</a></th> -->
			<!--  <td><i>Aucune fiche anomalie disponible</i></td> -->
		</tr>
		<tr>
			<td colspan="2">
			<%-- <div id="fiche_anomalie" style="display:none ;">
				<table>
					<tr>
						<th>Fiche Anomalie</th>
					</tr>
					<tr>
						<th><input type="text"></th>
					</tr>
					<tr>
						<th><input type="text"></th>
					</tr>
					<tr>
						<th><input type="text"></th>
					</tr>
					<tr>
						<th><a href="javascript:document.getElementById('fiche_anomalie').style.display='none'">Fermer</a></th>
					</tr>--%>
				</table>
			</div>
			</td>
		</tr>
		<tr>
			<td colspan="2"></th>
			<td><input type="submit" value="Enregistrer"></td>
		</tr>
	</table>
	</form>
	</center>
<%
	}
%>
</body>
</html>