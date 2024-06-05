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
		<h2 class="mb-4">회원가입</h2>
		<form action="/signup.members">
			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="id" name="id"
						placeholder="아이디" onkeyup="addressInput()">
					영문 대소문자로 이루어진 아이디로 입력해주세요.
				</div>
				<div class="col-sm-2">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal"
						onclick="clickEvent()">Launch demo modal</button>
				</div>
			</div>
			<!-- 비밀번호 -->
			<div class="form-group row">
				<label for="pwd" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" name="pwd"
						placeholder="비밀번호" onkeyup="addressInput()">
				</div>
			</div>
			<!-- 비밀번호 확인 -->
			<div class="form-group row">
				<label for="pwdConfirm" class="col-sm-2 col-form-label">비밀번호
					확인</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwdConfirm"
						name="pwdConfirm" placeholder="비밀번호 확인" onkeyup="enterkey()">
				</div>
			</div>
			<!-- 이름 -->
			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="이름" onkeyup="addressInput()">
				</div>
			</div>
			<!-- 번호 -->
			<div class="form-group row">
				<label for="phone" class="col-sm-2 col-form-label">번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" name="phone"
						placeholder="번호" onkeyup="addressInput()">
				</div>
			</div>
			<!-- 이메일 -->
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="이메일" onkeyup="addressInput()">
				</div>
			</div>
			<!-- 우편번호 -->
			<div class="form-group row">
				<label for="sample6_postcode" class="col-sm-2 col-form-label">우편번호</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="sample6_postcode"
						name="postCode" placeholder="우편번호">
				</div>
				<div class="col-sm-2">
					<input type="button" class="btn btn-primary"
						onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				</div>
			</div>
			<!-- 주소1 -->
			<div class="form-group row">
				<label for="sample6_address" class="col-sm-2 col-form-label">주소1</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="sample6_address"
						name="addr1" placeholder="주소">
				</div>
			</div>
			<!-- 주소2 -->
			<div class="form-group row">
				<label for="sample6_detailAddress" class="col-sm-2 col-form-label">주소2</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="sample6_detailAddress"
						name="addr2" placeholder="상세주소">
				</div>
			</div>
			<div class="form-group row">
				<label for="sample6_extraAddress" class="col-sm-2 col-form-label">참고항목</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="sample6_extraAddress"
						placeholder="참고항목" name="extraAddr">
				</div>
				<div class="col-sm-2 ">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary"
						onclick="addressInput()" id="addrInputButton">주소 입력</button>
				</div>
			</div>

			<!-- 제출 버튼 -->
			<div class="form-group row">
				<div class="col-sm-10 offset-sm-2">
					<button type="submit" class="btn btn-success" id="register"
						disabled="disabled">회원가입</button>
				</div>
			</div>
		</form>

		<div class="modal" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" id="reject" class="btn btn-secondary"
							data-bs-dismiss="modal" onclick="modalClosingEvent()">아니요</button>
						<button type="button" id="confirm" class="btn btn-primary"
							onclick="modalClosingEvent()">예</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" charset="utf-8">
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document.getElementById("sample6_extraAddress").value = extraAddr;

							} else {
								document.getElementById("sample6_extraAddress").value = '';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample6_postcode').value = data.zonecode;
							document.getElementById("sample6_address").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("sample6_detailAddress")
									.focus();
						}
					}).open();
		}
$("#id").on("click", function(enterKey){
	let id = $("#id")
})
		function enterkey() {
				console.log(pwdInput.val());
				console.log(pwdConfirmInput.val());
				if (pwdInput.val() === pwdConfirmInput.val()) {
					console.log("비밀번호 일치함");
					isPwdConfirmTrue = 'true'
					console.log('status ==== ' + isPwdConfirmTrue)
				} else {
					console.log("비밀번호 비일치함");
					isPwdConfirmTrue = 'false'
					console.log('status ==== ' + isPwdConfirmTrue)
				}
			}

		function clickEvent() {
			console.log("모달 이벤트");
			let modal = document.querySelector("#exampleModal");
			console.log(modal);
			modal.setAttribute('style', 'display:block');
			$.ajax({
				url : "/isDuplicated.members",
				method : "post",
				dataType : "text",
				data : {
					id : $("#id").val()
				},
				success : function(cmd) {
					if (cmd === 'true') {
						console.log('true');
						$(".modal-body").append("<h5>중복된 아이디 입니다.</h5>");
						isIdDuplicated = 'true';
						console.log('status ==== ' + isIdDuplicated)
					} else if (cmd === 'false') {
						console.log('false');
						$(".modal-body").append(
								"<h5>중복되지 않은 아이디입니다. 사용하시겠습니까?</h5>");
						isIdDuplicated = 'false';
						console.log('status ==== ' + isIdDuplicated)
					}
				}
			})
		}

		function modalClosingEvent() {
			console.log("모달 닫끼이");
			let modal = document.querySelector("#exampleModal");
			console.log(modal);
			modal.setAttribute('style', 'display:none');
			$(".modal-body *").remove();
		}

		let isIdDuplicated;
		let isPwdConfirmTrue;
		let idInput = $("#id")
		let pwdInput = $("#pwd")
		let pwdConfirmInput = $("#pwdConfirm")
		let nameInput = $("#name")
		let phoneInput = $("#phone")
		let emailInput = $("#email")
		let postCodeInput = $("#sample6_postcode");

		function addressInput() {
			console.log(idInput.val());
			if (isIdDuplicated === 'false' && isPwdConfirmTrue === 'true'
					&& idInput.val() !== '' && pwdInput.val() !== ''
					&& pwdConfirmInput.val() !== '' && nameInput.val() !== ''
					&& phoneInput.val() !== '' && emailInput.val() !== ''
					&& postCodeInput.val() !== '') {
				console.log("입력 준비 완료!")
				$("#register").removeAttr('disabled');
			}

		}
		
		
	</script>
	<script type="text/javascript" charset="utf-8">
		
	</script>
</body>
</html>
