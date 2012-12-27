<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scanner</title>
</head>
<body>
<center>
<%
	HttpSession ses = request.getSession(true);
	String id = (String)ses.getAttribute( "lib" );
	String lib = "";
	if( null != id && !id.equals( "" ) )
	{
		lib = id;	
	}
	id = (String)ses.getAttribute( "action" );
	String action = "";
	if( null != id && !id.equals( "" ) )
	{
		action = id;	
	}
	id = (String)ses.getAttribute( "menu" );
	boolean menu = false;
	if( null != id && !id.equals( "" ) && !id.equals( "0" ) )
	{
		menu = true;
	}
	id = (String)ses.getAttribute( "erreur" );
	String erreur = "";
	if( null != id && !id.equals( "" ) && !id.equals( "0" ) )
	{
		erreur = id;
	}
%>
<h1><%=lib %></h1>
<br><br>
<form method="post" action="../../<%=action %>" >
Numéro de série de la pièce :<br>
<%=erreur %>
<input type="text" name="num_piece"><a href="javascript:document.getElementById('scanner').style.display='block';document.getElementById('manuel').style.display='none'"><img src="../img/douchette.jpg" width="20px"></a>
<input type="hidden" name="Lieu" value="Magasin">

<div id="scanner" style="display : none;background-color:grey;">
Scanner le code bar<br><input type="submit" value="Simule la récupération via la douchette"></a><br><a href="javascript:document.getElementById('scanner').style.display='none';document.getElementById('manuel').style.display='block'">Annuler</a>
</div>
<div id="manuel">
<input type="submit" value="Valider"></a>
</div>
</form>
</ul>
</center>
<%
	if(menu){
		String val = "../"+lib+"/menu.jsp";
%>
<jsp:include page="<%=val%>"/>

<%
	}
%>
</body>
</html>