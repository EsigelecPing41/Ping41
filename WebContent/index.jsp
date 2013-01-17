<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <link rel="stylesheet" href="css/css.css" />
    </head>
    <body>
 <% 
	HttpSession ses = request.getSession(true);
	String erreur = (String)ses.getAttribute("LIB_ERREUR");
	if(erreur == "" || erreur== null){erreur="";}
%>
	    <center>
		    <br><img src="servlet/img/SKFTracability.jpg" width="60%"><br><br><br>
			<form method="POST" action="connexionOperateur">
			<table>
				<tr>
					<th colspan="2">
						<%=erreur %>
					</th>
				</tr>
				<tr>
					<td>
						Login : 
					</td>
					<td>
						<input type="text" name="login">
					</td>
				</tr>
				<tr>
					<td>
						MDP :
					</td>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
			</table>
			<input type="submit" value="OK">
				
				 
				
			</form>
		</center>
    </body>
</html>

