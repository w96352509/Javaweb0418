
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<title>Guestbook</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post" action="/JavaWeb-20220418/guestbook/${ button_name }">
		<fieldset>
			<legend>Guestbook Form</legend>
			<input type="hidden" name="id" value="${ guestbook.id }" />
			姓名: <input type="text" name="username" value="${ guestbook.username }" placeholder="請輸入 username" /><p /> 
			內容: <input type="text" name="content" value="${ guestbook.content }" placeholder="請輸入內容" /><p /> 
			<button type="submit" class="pure-button pure-button-primary">${ button_name }</button>
		</fieldset>
	</form>
	<form class="pure-form">
		<fieldset>
			<legend>Guestbook List</legend>
			<table class="pure-table pure-table-bordered">
				<thead>
					<th>id</th><th>姓名</th><th>內容</th><th>留言時間</th><th>修改</th><th>刪除</th>
				</thead>
				<tbody>
					<c:forEach var="guestbook" items="${ guestbooks }">
						<tr>
							<td>${ guestbook.id }</td>
							<td>${ guestbook.username }</td>
							<td>${ guestbook.content }</td>
							<td>${ guestbook.createtime }</td>
							<td><a href="/JavaWeb-20220418/guestbook/get?id=${ guestbook.id }">修改</a></td>
							<td><a href="/JavaWeb-20220418/guestbook/delete?id=${ guestbook.id }">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>	
	</form>
</body>
</html>