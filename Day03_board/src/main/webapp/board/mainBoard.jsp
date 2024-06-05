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
<style>
</style>

<body class="border h-100">
	<div class="container">
		<div class="row-10">
			<div class="col">
				<div class="p-3 bg-light justify-content-center d-flex">
					<p class="h3">자유 게시판</p>
				</div>
			</div>
		</div>
		<div class="row-10">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">작성자</th>
						<th scope="col">제목</th>
						<th scope="col">날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${postList}">
						<tr>
							<td>${list.seq}</td>
							<td>${list.writer}</td>
							<td onclick="location.href='/selectPost.boards?postId=${list.seq}'">${list.title}</td>
							<td>${list.write_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">6</a></li>
				<li class="page-item"><a class="page-link" href="#">7</a></li>
				<li class="page-item"><a class="page-link" href="#">8</a></li>
				<li class="page-item"><a class="page-link" href="#">9</a></li>
				<li class="page-item"><a class="page-link" href="#">10</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
		<div class="p-3 justify-content-end d-flex">
			<button type="button" class="btn btn-primary"
				onclick="location.href='/board/boardInput.jsp'">작성하기</button>
		</div>
	</div>
</body>

</html>