<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자유 게시판 글 작성하기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body class="h-100">
	<div class="container mt-5">
		<!-- 글 작성 섹션 -->
		<div class="row mb-3">
			<div class="col">
				<div class="p-3 bg-light text-center">
					<p class="h3">자유 게시판 글 작성하기</p>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="border rounded p-3">
					<div class="mb-3">
						<label for="postTitle" class="form-label">제목</label> <input
							type="text" class="form-control" id="postTitle" name="title"
							value="${post.title}" maxlength='30' required readonly>
					</div>
					<div class="mb-3">
						<label for="postContent" class="form-label">내용</label>
						<textarea class="form-control" id="postContent" name="contents"
							rows="10" required readonly>${post.contents}</textarea>
					</div>
					<div class="d-flex justify-content-end" id="button-div">
						<button type="button" class="m-2 btn btn-secondary"
							id="toPostList-button"
							onclick="location.href='/mainBoard.boards'">목록으로</button>
						<c:if test="${userId eq writer}">
							<button type="button" class="m-2 btn btn-success"
								onclick="updatePost()" id="updatePost-button">수정</button>
							<button type="button" class="m-2 btn btn-danger"
								onclick="deletePost()" id="deletePost-button">삭제</button>
							<button type="submit" class="m-2 btn btn-primary"
								id="insertPost-button"
								onclick="location.href='/board/boardInput.jsp'">새로운 글
								작성하기</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>

		<!-- 덧글 섹션 -->
		<div class="row mb-3">
			<div class="col">
				<div class="p-3 bg-light text-center">
					<p class="h4">덧글</p>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="border rounded p-3">
					<div class="mb-3">
						<textarea class="form-control" id="replyContents"
							name="replyContents" rows="3" placeholder="덧글을 입력하세요" required></textarea>
					</div>
					<div class="d-flex justify-content-end">
						<button type="submit" class="m-2 btn btn-primary"
							onclick="insertReply()">덧글 작성</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 덧글 목록 -->
		<c:if test="${not empty replyList}">
			<div class="row mb-3">
				<div class="col">
					<div class="border border-2 rounded p-3">
						<c:forEach var="replyList" items="${replyList}">
							<div class="mb-3 border-bottom pb-3">
								<p>
									<strong>${replyList.writer}</strong> <small class="text-muted">${replyList.writer_date}</small>
								</p>
								<p>${replyList.contents}</p>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</body>

<script>
	function updatePost() {
		$("#updatePost-button").remove();
		$("#toPostList-button").remove();
		$("#insertPost-button").remove();
		$("#button-div").append("<button id="+"updateConfirm-button>");
		$("#button-div").append("<button id="+"updateCancel-button>");

		$("#updateConfirm-button").html('수정 완료');
		$("#updateCancel-button").html('수정 취소');
		
		$("#updateConfirm-button").attr('class', 'm-2 btn btn-success');
		$("#updateCancel-button").attr('class', 'm-2 btn btn-primary');
		$("#updateConfirm-button").attr('onclick', 'updateConfirm()');
		$("#updateCancel-button").attr('onclick', 'updateCancelConfirm()');
		
		$('#postContent').attr("readonly", false);
		$('#postTitle').attr("readonly", false)
	}

function deletePost(){
	const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: "btn btn-success m-1",
		    cancelButton: "btn btn-danger m-1"
		  },
		  buttonsStyling: false
		});
		swalWithBootstrapButtons.fire({
		  title: "수정을 완료하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonText: "수정 완료",
		  cancelButtonText: "되돌아가기",
		  reverseButtons: true
		}).then((result) => {
		  if (result.isConfirmed) {
			location.href="/deletePost.boards?postId=${post.seq}";
		    swalWithBootstrapButtons.fire({
		      title: "Deleted!",
		      text: "Your file has been deleted.",
		      icon: "success"
		    });
		    
		  } else if (
		    /* Read more about handling dismissals below */
		    result.dismiss === Swal.DismissReason.cancel
		  ) {
		  }
		});
}
function updateConfirm(){
	const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: "btn btn-success m-1",
		    cancelButton: "btn btn-danger m-1"
		  },
		  buttonsStyling: false
		});
		swalWithBootstrapButtons.fire({
		  title: "수정을 완료하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonText: "수정 완료",
		  cancelButtonText: "되돌아가기",
		  reverseButtons: true
		}).then((result) => {
		  if (result.isConfirmed) {
			  location.href="/updatePost.boards?title="+$("#postTitle").val()+"&contents="+$("#postContent").val();
		    swalWithBootstrapButtons.fire({
		      title: "Deleted!",
		      text: "Your file has been deleted.",
		      icon: "success"
		    });
		    
		  } else if (
		    /* Read more about handling dismissals below */
		    result.dismiss === Swal.DismissReason.cancel
		  ) {
		  }
		});
}

function insertReply(){
	const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: "btn btn-success m-1",
		    cancelButton: "btn btn-danger m-1"
		  },
		  buttonsStyling: false
		});
		swalWithBootstrapButtons.fire({
		  title: "수정을 완료하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonText: "수정 완료",
		  cancelButtonText: "되돌아가기",
		  reverseButtons: true
		}).then((result) => {
		  if (result.isConfirmed) {
			  location.href="/insert.reply?replyContents="+$("#replyContents").val();
		    swalWithBootstrapButtons.fire({
		      title: "Deleted!",
		      text: "Your file has been deleted.",
		      icon: "success"
		    });
		    
		  } else if (
		    /* Read more about handling dismissals below */
		    result.dismiss === Swal.DismissReason.cancel
		  ) {
		  }
		});
}
</script>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</html>
