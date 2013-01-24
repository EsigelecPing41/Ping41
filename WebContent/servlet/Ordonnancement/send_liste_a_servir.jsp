<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="java.util.ArrayList"%> 
    <%@ page import="java.util.Iterator"%> 
    <%@ page import="Modele.Ordonnancement"%>   
<%@ page import="java.text.SimpleDateFormat"%>   
<%@ page import="java.util.Date"%> 

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Ordonnancement> listOrdo = new ArrayList<Ordonnancement>();


String suivi = (String)request.getAttribute("suivi");
if((String)request.getAttribute("article1")!=null && (String)request.getAttribute("nb_a_fabr1")!=null && (String)request.getAttribute("ste1")!=null && (String)request.getAttribute("num_cmd1")!=null && (String)request.getAttribute("ref_cde1")!=null && (String)request.getAttribute("date_cde1")!=null && (String)request.getAttribute("mise_fab1")!=null && (String)request.getAttribute("delai_prv1")!=null&& (String)request.getAttribute("delai_dde1")!=null&& (String)request.getAttribute("fam_gest1")!=null&&(String)request.getAttribute("Ord_NumDossier")!=null&&(String)request.getAttribute("Ord_CodeGPAO")!=null &&(String)request.getAttribute("Ord_IndNomenclature")!=null &&(String)request.getAttribute("Ord_NumSerie")!=null &&(String)request.getAttribute("Ord_ComInterne")!=null)
{
	
	String Ord_NumSerie1 = (String)request.getAttribute("Ord_NumSerie1");
	
	String pieceNom1 = (String)request.getAttribute("article1");
	Integer nb_a_fabr1 = (Integer)request.getAttribute("nb_a_fabr1");
	String ste1 = (String)request.getAttribute("ste1");
	String num_cmd1 = (String)request.getAttribute("num_cmd1");
	String ref_cde1 = (String)request.getAttribute("ref_cde1");
	String code_client1 = (String)request.getAttribute("code_client1");
	
	
		
	String cde1 = (String)request.getAttribute("date_cde1");
	String fab1 = (String)request.getAttribute("mise_fab1");
	String prv1 = (String)request.getAttribute("delai_prv1");
	String dde1 = (String)request.getAttribute("delai_dde1");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	Date date_cde1 = sdf.parse(cde1);
	Date date_fab1 = sdf.parse(fab1);
	Date date_prv1 = sdf.parse(prv1);
	Date date_dde1 = sdf.parse(dde1);
	
	String fam_gest1 = (String)request.getAttribute("fam_gest1");
	
	String Ord_NumDossier1 = (String)request.getAttribute("Ord_NumDossier1");
	String Ord_CodeGPAO1 = (String)request.getAttribute("Ord_CodeGPAO1");
	String Ord_IndNomenclature1 = (String)request.getAttribute("Ord_IndNomenclature1");
	//String Ord_NumSerie1 = (String)request.getAttribute("Ord_NumSerie1");
	String Ord_ComInterne1 = (String)request.getAttribute("Ord_ComInterne1");
	
	String Ord_NumAffaire1 = (String)request.getAttribute("Ord_NumAffaire1");
	String Ord_Of1 = (String)request.getAttribute("Ord_Of1");	
	
	
	/*num commande?*/
	Ordonnancement ordonnancement = new Ordonnancement(Ord_NumSerie1,pieceNom1,nb_a_fabr1,ste1,code_client1,date_cde1,date_fab1,date_prv1,date_dde1,fam_gest1,Ord_NumDossier1, Ord_CodeGPAO1,Ord_IndNomenclature1,Ord_ComInterne1,Ord_NumAffaire1,Ord_Of1);    
   // public Ordonnancement(String Ord_NumSerie,   String Ord_Designation, int Ord_QteFab,Ord_Ste,Ord_CodeClient,Ord_DelaiCde,MFab,DelaiPrv,DelaiDde,Ord_FamGest,rd_NumDossier, Ord_CodeGPAO, Ord_IndNomenclature,tring Ord_ComInterne,String Ord_NumAffaire,   String Ord_Of)
	
	
	listOrdo.add(0, ordonnancement);		
}


if((String)request.getAttribute("article2")!=null && (String)request.getAttribute("nb_a_fabr2")!=null && (String)request.getAttribute("ste2")!=null && (String)request.getAttribute("num_cmd2")!=null && (String)request.getAttribute("ref_cde2")!=null && (String)request.getAttribute("date_cde2")!=null && (String)request.getAttribute("mise_fab2")!=null && (String)request.getAttribute("delai_prv2")==null&& (String)request.getAttribute("delai_dde2")!=null&& (String)request.getAttribute("fam_gest2")!=null)
{
	
	String Ord_NumSerie2 = (String)request.getAttribute("Ord_NumSerie2");
	
	String pieceNom2 = (String)request.getAttribute("article2");
	Integer nb_a_fabr2 = (Integer)request.getAttribute("nb_a_fabr2");
	String ste2 = (String)request.getAttribute("ste2");
	String num_cmd2 = (String)request.getAttribute("num_cmd2");
	String ref_cde2 = (String)request.getAttribute("ref_cde2");
	String code_client2 = (String)request.getAttribute("code_client2");

	
	
	String cde2 = (String)request.getAttribute("date_cde2");
	String fab2 = (String)request.getAttribute("mise_fab2");
	String prv2 = (String)request.getAttribute("delai_prv2");
	String dde2 = (String)request.getAttribute("delai_dde2");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	Date date_cde2 = sdf.parse(cde2);
	Date date_fab2 = sdf.parse(fab2);
	Date date_prv2 = sdf.parse(prv2);
	Date date_dde2 = sdf.parse(dde2);
	

	String fam_gest2 = (String)request.getAttribute("fam_gest2");

	String Ord_NumDossier2 = (String)request.getAttribute("Ord_NumDossier2");
	String Ord_CodeGPAO2 = (String)request.getAttribute("Ord_CodeGPAO2");
	String Ord_IndNomenclature2 = (String)request.getAttribute("Ord_IndNomenclature2");
	//String Ord_NumSerie2 = (String)request.getAttribute("Ord_NumSerie2");
	String Ord_ComInterne2 = (String)request.getAttribute("Ord_ComInterne2");
	
	String Ord_NumAffaire2 = (String)request.getAttribute("Ord_NumAffaire2");
	String Ord_Of2 = (String)request.getAttribute("Ord_Of2");
	
	
	Ordonnancement ordonnancement = new Ordonnancement(Ord_NumSerie2,pieceNom2,nb_a_fabr2,ste2,code_client2,date_cde2,date_fab2,date_prv2,date_dde2,fam_gest2,Ord_NumDossier2, Ord_CodeGPAO2,Ord_IndNomenclature2,Ord_ComInterne2,Ord_NumAffaire2,Ord_Of2);    
	listOrdo.add(1, ordonnancement);
}

if((String)request.getAttribute("article3")!=null && (String)request.getAttribute("nb_a_fabr3")!=null && (String)request.getAttribute("ste3")!=null && (String)request.getAttribute("num_cmd3")!=null && (String)request.getAttribute("ref_cde3")!=null && (String)request.getAttribute("date_cde3")!=null && (String)request.getAttribute("mise_fab3")!=null && (String)request.getAttribute("delai_prv3")==null&& (String)request.getAttribute("delai_dde3")!=null&& (String)request.getAttribute("fam_gest3")!=null)
{
	String Ord_NumSerie3 = (String)request.getAttribute("Ord_NumSerie3");
	
	String pieceNom3 = (String)request.getAttribute("article3");
	Integer nb_a_fabr3 = (Integer)request.getAttribute("nb_a_fabr3");
	String ste3 = (String)request.getAttribute("ste3");
	String num_cmd3 = (String)request.getAttribute("num_cmd3");
	String ref_cde3 = (String)request.getAttribute("ref_cde3");
	String code_client3 = (String)request.getAttribute("code_client3");
	
	String cde3 = (String)request.getAttribute("date_cde3");
	String fab3 = (String)request.getAttribute("mise_fab3");
	String prv3 = (String)request.getAttribute("delai_prv3");
	String dde3 = (String)request.getAttribute("delai_dde3");
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	Date date_cde3 = sdf.parse(cde3);
	Date date_fab3 = sdf.parse(fab3);
	Date date_prv3 = sdf.parse(prv3);
	Date date_dde3 = sdf.parse(dde3);
	
	String Ord_NumDossier3 = (String)request.getAttribute("Ord_NumDossier3");
	String Ord_CodeGPAO3 = (String)request.getAttribute("Ord_CodeGPAO3");
	String Ord_IndNomenclature3 = (String)request.getAttribute("Ord_IndNomenclature3");
	//String Ord_NumSerie3 = (String)request.getAttribute("Ord_NumSerie3");
	String Ord_ComInterne3 = (String)request.getAttribute("Ord_ComInterne3");
	
	String Ord_NumAffaire3 = (String)request.getAttribute("Ord_NumAffaire3");
	String Ord_Of3 = (String)request.getAttribute("Ord_Of3");
	
	String fam_gest3 = (String)request.getAttribute("fam_gest3");
	Ordonnancement ordonnancement = new Ordonnancement(Ord_NumSerie3,pieceNom3,nb_a_fabr3,ste3,num_cmd3,date_cde3,date_fab3,date_prv3,date_dde3,fam_gest3,Ord_NumDossier3, Ord_CodeGPAO3,Ord_IndNomenclature3,Ord_ComInterne3,Ord_NumAffaire3,Ord_Of3);    
	listOrdo.add(2, ordonnancement);
}


RequestDispatcher dispatcher = request.getRequestDispatcher("LancerListeAServir");


request.setAttribute("listOrdo",listOrdo);
request.setAttribute("suivi",suivi);
dispatcher.forward( request, response );	






%>
</body>
</html>