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
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="card">
					<div class="card-header text-center">
						<h3>로그인</h3>
					</div>
					<div class="card-body">
						<c:choose>
							<c:when test="${userId == null}">
								<form action="/login.members" method="post">
									<div class="mb-3">
										<input type="text" class="form-control" placeholder="아이디"
											name="id" required>
									</div>
									<div class="mb-3">
										<input type="password" class="form-control" placeholder="패스워드"
											name="pw" required>
									</div>
									<div class="d-grid gap-2">
										<button type="submit" class="btn btn-primary">Login</button>
										<button type="button" class="btn btn-secondary" id="signup"
											onclick="location.href='/members/signup.jsp'">Signup</button>
									</div>
								</form>
							</c:when>
							<c:otherwise>
								<div class="d-flex gap-3  justify-content-center row">
									<button type="button" class="btn btn-primary m-1" onclick="location.href='/mainBoard.boards'">게시판</button>
									<button type="button" class="btn btn-success m-1" onclick="location.href='/members/myPage.jsp'">마이페이지</button>
									<button type="button" class="btn btn-danger m-1">로그아웃</button>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>
