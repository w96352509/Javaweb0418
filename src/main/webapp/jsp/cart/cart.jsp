<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<title>Cart</title>
</head>
<body style="padding: 20px">
	<form class="pure-form"  action="/JavaWeb-20220418/servlet/cart/buy">
	  <fieldset>
	   <legend>Cart</legend>
	   
	   
       <button type="button" 
               onclick="location.href='/JavaWeb-20220418/servlet/cart/claer';"
               class="pure-button pure-button-primary">
        Clear
       </button>
       
       <button type="button" 
               onclick="location.href='/JavaWeb-20220418/jsp/cart/buy.jsp';"
               class="pure-button pure-button-primary">
        Back
       </button>
      </fieldset>
    </form>  
  
</body>
</html>