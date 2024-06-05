<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form Example</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/upload.file" method="post" enctype="multipart/form-data">
		<input type="text" placeholder="메세지" name="message"><br>
		첨부파일: <input type="file" name="file1" multiple><br>
		첨부파일: <input type="file" name="file2" multiple><br>
		첨부파일: <input type="file" name="file3" multiple><br>
		<button>등록</button>
	</form>
	<fieldset>
		<legend> File list </legend>
		<div id="filelist">
			<c:forEach var="i" items="${list }">
				<div>${i.seq }.
					<a href="/download.file?sysname=${i.sysname}&oriname=${i.oriname}">${i.oriname}</a>
				</div>
			</c:forEach>
		</div>
	</fieldset>
	<a href="/list.file"><button>파일 목록 불러오기</button></a>
</body>
</html>
