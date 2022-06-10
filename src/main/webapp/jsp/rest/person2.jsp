<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<title>Person</title>
<script>
	function doGet() {
		const xhttp = new XMLHttpRequest();
		// Server 回應
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
		}
		// 表單資料
		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		// 組合參數
		var args = "id=" + id + "&name=" + name + "&age=" + age;
		// 開啟連線
		xhttp.open("GET", "/JavaWeb-20220418/rest2/person?" + args, true); // true 非同步, false 同步
		// 傳送
		xhttp.send();
	}
	function doPost() {
		const xhttp = new XMLHttpRequest();
		// Server 回應
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
		}
		// 表單資料
		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		// 組合參數
		var args = "id=" + id + "&name=" + name + "&age=" + age;
		// 開啟連線
		xhttp.open("POST", "/JavaWeb-20220418/rest2/person", true); // true 非同步, false 同步
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		// 傳送
		xhttp.send(args);
	}
	function doPut() {
		const xhttp = new XMLHttpRequest();
		// Server 回應
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
		}
		// 表單資料
		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		// 組合參數
		var args = "id=" + id + "&name=" + name + "&age=" + age;
		// 開啟連線
		xhttp.open("PUT", "/JavaWeb-20220418/rest2/person", true); // true 非同步, false 同步
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		// 傳送
		xhttp.send(args);
	}
	function doDelete() {
		const xhttp = new XMLHttpRequest();
		// Server 回應
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
		}
		// 表單資料
		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		// 組合參數
		var args = "id=" + id + "&name=" + name + "&age=" + age;
		// 開啟連線
		xhttp.open("DELETE", "/JavaWeb-20220418/rest2/person", true); // true 非同步, false 同步
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		// 傳送
		xhttp.send(args);
	}
</script>
</head>
<body style="padding: 20px">

	<form class="pure-form">
		<fieldset>
			<legend>Person form</legend>
			<table>
				<tr>
					<td align="right">Id: </td>
					<td><input type="number" id="id" name="id" value="1" /></td>	
				</tr>
				<tr>
					<td align="right">Name: </td>
					<td><input type="text" id="name" name="name" value="John" /></td>	
				</tr>
				<tr>
					<td align="right">Age: </td>
					<td><input type="number" id="age" name="age" value="18" /></td>	
				</tr>
			</table>
			<p />
			<button type="button" onclick="doGet()" class="pure-button pure-button-primary">
				GET</button>
			<button type="button" onclick="doPost()" class="pure-button pure-button-primary">
				POST</button>
			<button type="button" onclick="doPut()" class="pure-button pure-button-primary">
				PUT</button>
			<button type="button" onclick="doDelete()" class="pure-button pure-button-primary">
				DELETE</button>
		</fieldset>		
	</form>
	<pre>
		<div id="demo"></div>
	</pre>
</body>
</html>