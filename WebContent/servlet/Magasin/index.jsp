<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Magasin</title>
</head>
<body>
<center>
<br><br>
<a href="nouvelle_piece.html">Generer un nouveau code-barre</a><br>
<form action="detail_piece" method="POST">
Num�ro de s�rie de la pi�ce :<br><input type="text" name="num_piece"><a href="javascript:document.getElementById('scanner').style.display='block';document.getElementById('manuel').style.display='none'"><img src="../img/douchette.jpg" width="20px"></a>
<div id="scanner" style="display : none;background-color:grey;">
Scanner le code bar<br><input type="submit" value="Simule la r�cup�ration via la douchette"></a><br><a href="javascript:document.getElementById('scanner').style.display='none';document.getElementById('manuel').style.display='block'">Annuler</a>
</div>
<div id="manuel">
<input type="submit" value="Valider"></a>
</div>
</form>
<h2>Liste des pi�ces actuellement au magasin</h2>
<ul>
<li><a href="detail_piece">Piece 1</a></li>
<li><a href="detail_piece">Piece 2</a></li>
<li><a href="detail_piece">Piece 3</a></li>
<li><a href="detail_piece">Piece 4</a></li>
<li><a href="detail_piece">Piece 5</a></li>
<li><a href="detail_piece">Piece 6</a></li>
<li><a href="detail_piece">Piece 7</a></li>
</ul>
</center>
</body>
</html>