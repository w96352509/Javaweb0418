<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<script type="text/javascript">
	function doGet() {
		const xhttp = new XMLHttpRequest();
		// Server 回應
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
		}
		// 開啟連線
		xhttp.open("GET", "/JavaWeb-20220418/rest/person", true); // true 非同步
		// 傳送
		xhttp.send();
	}
</script>
<title>Person</title>
</head>
<body style="padding: 20px">
	<form class="pure-form">
		<button type="button" onclick="doGet()" class="pure-button pure-button-primary">
			GET</button>
		<button type="button" class="pure-button pure-button-primary">
			POST</button>
		<button type="button" class="pure-button pure-button-primary">
			PUT</button>
		<button type="button" class="pure-button pure-button-primary">
			DELETE</button>
	</form>
	<pre>
	  <div id="demo"></div>
	</pre>
</body>
</html>