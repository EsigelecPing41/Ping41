<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/SKFTraceability/css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ordonnancement - Liste à Servir</title>
</head>
<body>
<center>
<h1>Ordonnancement</h1>
<h2>Liste à servir</h2>

<form action="ListesDesManquants.jsp">
	<table>
	<tr>
		<td>
			<table class="tableau">Ord_NumSerie
				<tr>
					<th class="case">
						NumSerie
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumSerie1">
					</td>
				</tr>
				<tr>
					<th class="case">
						Article
					</th>
					<td class="case">
						<input value="" type="text" name="article1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Quantité à fabriquer
					</th>
					<td class="case">
						<input value="" type="text" name="nb_a_fabr1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Sté
					</th>
					<td class="case">
						<input value="" type="text" name="ste1">
					</td>
				</tr>
						<tr>
					<th class="case">
						N° de Cde
					</th>
					<td class="case">
						<input value="" type="text" name="num_cmd1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Code Client
					</th>
					<td class="case">
						<input value="" type="text" name="code_client1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Réf. Cde Clt
					</th>
					<td class="case">
						<input value="" type="text" name="ref_cde1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Date Cde
					</th>
					<td class="case">
						<input value="" type="text" name="date_cde1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Mise en Fab.
					</th>
					<td class="case">
						<input value="" type="text" name="mise_fab1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Délai Prv
					</th>
					<td class="case">
						<input value="" type="text" name="delai_prv1">
					</td>
				</tr>
						<tr>
					<th class="case">
						Délai Ddé
					</th>
					<td class="case">
						<input value="" type="text" name="delai_dde1">
					</td>
				</tr>
				<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="fam_gest1">
					</td>
				</tr>
								<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumDossier1">
					</td>
				</tr>
								<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_CodeGPAO1">
					</td>
				</tr>
								<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_IndNomenclature1">
					</td>
				</tr>
								<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumSerie1">
					</td>
				</tr>
								<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_ComInterne1">
					</td>
				</tr>
								<tr>
					<th class="case">
						NumAffaire
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumAffaire1">
					</td>
				</tr>								<tr>
					<th class="case">
						Of
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_Of1">
					</td>
				</tr>			
				String Ord_NumAffaire,   String Ord_Of
			</table>
		<td>
			<table id="tableau2" class="tableau"  style="visibility: hidden;">
								<tr>
					<th class="case">
						NumSerie
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumSerie2">
					</td>
				</tr>
				<tr>
					<th class="case">
						Article
					</th>
					<td class="case">
						<input value="" type="text" name="article2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Quantité à fabriquer
					</th>
					<td class="case">
						<input value="" type="text" name="nb_a_fabr2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Sté
					</th>
					<td class="case">
						<input value="" type="text" name="ste2">
					</td>
				</tr>
						<tr>
					<th class="case">
						N° de Cde
					</th>
					<td class="case">
						<input value="" type="text" name="num_cmd2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Code Client
					</th>
					<td class="case">
						<input value="" type="text" name="code_client2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Réf. Cde Clt
					</th>
					<td class="case">
						<input value="" type="text" name="ref_cde2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Date Cde
					</th>
					<td class="case">
						<input value="" type="text" name="date_cde2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Mise en Fab.
					</th>
					<td class="case">
						<input value="" type="text" name="mise_fab2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Délai Prv
					</th>
					<td class="case">
						<input value="" type="text" name="delai_prv2">
					</td>
				</tr>
						<tr>
					<th class="case">
						Délai Ddé
					</th>
					<td class="case">
						<input value="" type="text" name="delai_dde2">
					</td>
				</tr>
				<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="fam_gest2">
					</td>
				</tr>
												<tr>
					<th class="case">
						NumAffaire
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumAffaire2">
					</td>
				</tr>								<tr>
					<th class="case">
						Of
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_Of2">
					</td>
			</table>
		</td>
		<td>
			<table id="tableau3" class="tableau"  style="visibility: hidden;">
				<tr>
					<th class="case">
						NumSerie
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumSerie3">
					</td>
				</tr>
				<tr>
					<th class="case">
						Article
					</th>
					<td class="case">
						<input value="" type="text" name="article3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Quantité à fabriquer
					</th>
					<td class="case">
						<input value="" type="text" name="nb_a_fabr3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Sté
					</th>
					<td class="case">
						<input value="" type="text" name="ste3">
					</td>
				</tr>
						<tr>
					<th class="case">
						N° de Cde
					</th>
					<td class="case">
						<input value="" type="text" name="num_cmd3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Code Client
					</th>
					<td class="case">
						<input value="" type="text" name="code_client3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Réf. Cde Clt
					</th>
					<td class="case">
						<input value="" type="text" name="ref_cde3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Date Cde
					</th>
					<td class="case">
						<input value="" type="text" name="date_cde3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Mise en Fab.
					</th>
					<td class="case">
						<input value="" type="text" name="mise_fab3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Délai Prv
					</th>
					<td class="case">
						<input value="" type="text" name="delai_prv3">
					</td>
				</tr>
						<tr>
					<th class="case">
						Délai Ddé
					</th>
					<td class="case">
						<input value="" type="text" name="delai_dde3">
					</td>
				</tr>
				<tr>
					<th class="case">
						Fam. Gest
					</th>
					<td class="case">
						<input value="" type="text" name="fam_gest3">
					</td>
				</tr>
												<tr>
					<th class="case">
						NumAffaire
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_NumAffaire3">
					</td>
				</tr>								<tr>
					<th class="case">
						Of
					</th>
					<td class="case">
						<input value="" type="text" name="Ord_Of3">
					</td>
			</table>
		</td>
	</tr>
</table>

	<input type="submit" value="Liste des manquants"> 
	<input type="submit" value="Nouvelle liste a servir"> 
	
</form>
<input type="submit" onclick="javascript:ajouter();" value="Ajouter une liste" >
<input type="submit" onclick="javascript:enlever();" value="Enlever une liste" >

</center>
</body>
</html>

<script>
i = 1;
function ajouter() 
{
	i++;
	if(i==2)
		{
			document.getElementById("tableau2").style.visibility = "visible";
		}
	else if(i==3)
		{
		document.getElementById("tableau3").style.visibility = "visible";
		}
	else
		{
			alert('Vous ne pouvez pas afficher plus de 3 listes à servir. Veuillez cliquer sur nouvelle page de liste à servir');
			i--;
		}
	
	
	

}
function enlever() 
{
	i--;
	if(i==2)
		{
		document.getElementById("tableau3").style.visibility = "hidden";
		}
	else if(i==1)
		{
		document.getElementById("tableau2").style.visibility = "hidden";
		}
	else
		{
		i++;
		alert("Vous ne pouvez pas afficher moins de 1 liste à servir. Si vous souhaitez passer au liste des manquants veuillez cliquer sur l'icone correspondante");
		}
}

</script> 
   