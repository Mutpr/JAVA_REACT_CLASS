<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>index.jsp</title>
<style>
div {
	border: 2px solid black;
}

#main {
	width: 1000px;
	height: 300px;
	display: flex;
}

#sub-main {
	width: 1000px;
	height: 150px;
	display: flex;
	flex-direction: row;
}

#sub {
	width: 500px;
	height: 150px;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<div id="main">
		<div id="sub-main">
			<div id="sub">
				<button onclick="location.href='/inputview.jsp'">INPUT!</button>
			</div>
			<div id="sub">
				<button onclick="location.href='/selectAll.jsp'">OUTPUT!</button>
			</div>
		</div>
	</div>
</body>
</html>