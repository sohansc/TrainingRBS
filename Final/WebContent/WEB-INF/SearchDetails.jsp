<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    
        <%@ page import="rbs.module.transaction.model.Transaction" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
	<h1 align="center">Transactions</h1>
        <p>

        <%

        ArrayList<Transaction> resultSet = (ArrayList<Transaction>) request.getAttribute("resultSet");
        if(resultSet!=null){
            for(Transaction arr: resultSet){  
                out.println("<br/>" + arr.getTransactionId() + " " + .getPCANo()+ " " + type.getIP());  
                }  
            } 
        %>
</body>
</html>