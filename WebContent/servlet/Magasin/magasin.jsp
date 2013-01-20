 <%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Magasin</title>
</head>
<body>
<center>
	<h1>MAGASIN</h1>
	<br>
	<form target="content" method="post" action="send_nouvelle_piece" >
	Remplissez entièrement les champs ci-dessus<br><br>
	<!--<a href="">Imprimer le code barre</a>-->
	<table class="tableau">
				
		<tr>
			<th class="case">Nom de la pièce</th>
			<td class="case"><input type="text" value="nomPiece"></td>
		</tr>
		
		<tr>
			<th class="case">Nom de l'assemblage pièce</th>
			<td class="case"><input type="text" value="nomAPiece"></td>
		</tr>
		
		<tr>
			<th class="case">Nom fournisseur</th>
			<td class="case"><input type="text" value="" name= "nomFournisseur"></td>
		</tr>
		
		<tr>
			<th class="case">Numéro dossier</th>
			<td class="case"><input type="text" value="" name= "numDossier"></td>
		</tr>
		
		<tr>
			<th class="case">Numéro référence</th>
			<td class="case"><input type="text" value="" name= "numReference"></td>
		</tr>
		
		<tr>
			<th class="case">Quantité</th>
			<td class="case"><input type="text" value="" name= "quantite"></td>
		</tr>
		
		<tr>
			<th rowspan="4"></th>
			<th class="case">Date de livraison (AAAA/MM/JJ)</th>
			<td class="case"><input type="text" value="" name= "dateLivraison"></td>
		</tr>			
		<tr>
			<td colspan="2"></th>
			<td><input type="submit" value="Enregistrer"></td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>