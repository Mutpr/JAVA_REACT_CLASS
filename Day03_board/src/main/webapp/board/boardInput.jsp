<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body class="border h-100">
	<div class="container">
		<div class="row-10">
			<div class="col">
				<div class="p-3 bg-light justify-content-center d-flex">
					<p class="h3">자유 게시판 글 작성하기</p>
				</div>
			</div>
		</div>
		<form action='/insertPost.boards'>
			<div class="row-10 border border-2 rounded m-3">
				<div class="p-3">
					<input class="w-100 h-100 border-0" type="text" name="title" maxlength='30'>
				</div>
			</div>
			<div class="row-10 border rounded p-3 m-3" style="height: 500px">
				<textarea class="w-100 h-100 border-0" name="contents"></textarea>
			</div>
			<div class="p-3 justify-content-end d-flex">
				<button type="button" class="m-2 btn btn-primary"
					onclick="location.href='/mainBoard.boards'">목록으로</button>
				<button type="submit" class="m-2 btn btn-primary">작성하기</button>
			</div>
		</form>
	</div>
</body>
</html>
