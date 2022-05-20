<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<title>Buy</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post" action="/JavaWeb-20220418/servlet/cart/buy">
	  <fieldset>
	   <legend>BUY</legend>
	   <label for=name>品名:</label>
	   <select name="product">
	    <option value="iPhone">iPhone</option>
	    <option value="Android">Android</option>
	    <option value="Bubble 泡泡龍">Bubble 泡泡龍</option>
	    <option value="SuperMario 超級瑪莉兄弟">SuperMario 超級瑪莉兄弟</option>
	    <option value="Nintando 任天堂">Nintando 任天堂</option>
	   </select><p/>
	   <button type="submit" class="pure-button pure-button-primary">
         buy
       </button>
       <button type="button" 
               onclick="location.href='/JavaWeb-20220418/servlet/cart/view';"
               class="pure-button pure-button-primary">
        Cart
       </button>	  
	  </fieldset>
	</form>  
  
  
</body>
</html>