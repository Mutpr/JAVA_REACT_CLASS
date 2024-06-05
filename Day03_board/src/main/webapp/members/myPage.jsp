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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>

<style>
</style>

<body class="border h-100">
	<div class="container">
		<div class="row-10">
			<div class="col">
				<div class="p-3 bg-light justify-content-center d-flex">
					<p class="h3">내 정보</p>
				</div>
			</div>
		</div>
		<div class="row-10">
			<table class="table table-hover align-items-center">
				<tbody>
					<tr>
						<th scope="col">아이디</th>
						<td id="myPage-username">${userInfo.id}</td>
					</tr>
					<tr>
						<th scope="col">비밀번호</th>
						<td id="pwd">
							<button type="button" class="btn btn-primary">비밀번호 수정하기</button>
						</td>
					</tr>
					<tr>
						<th scope="col">이름</th>
						<td id="myPage-name">${userInfo.name}</td>
					</tr>
					<tr>
						<th scope="col">번호</th>
						<td id="myPage-phone">${userInfo.phone}</td>
					</tr>
					<tr>
						<th scope="col">이메일</th>
						<td id="myPage-email">${userInfo.email}</td>
					</tr>
					<tr>
						<th scope="col">우편번호</th>
						<td id="zipcode-td">
							<div id="zipcode">${userInfo.zipcode}</div>
							<div id="myPage-zipcode" class="row"></div>
						</td>
					</tr>
					<tr>
						<th scope="col">기본 주소</th>
						<td id="myPage-addr1">${userInfo.address1}</td>
					</tr>
					<tr>
						<th scope="col">상세 주소</th>
						<td id="myPage-addr2">${userInfo.address2}</td>
					</tr>
					<tr>
						<th scope="col">가입일자</th>
						<td id="myPage-joinDate">${userInfo.join_date}</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div id="button-div" class="p-3 justify-content-end d-flex">
			<button type="button" id="updateButton" class="btn btn-primary m-1"
				onclick='myPageUpdate()'>회원 정보 수정하기</button>
			<button type="button" id="deleteButton" class="btn btn-primary m-1"
				onclick='myPageDelete()'>회원 탈퇴</button>
		</div>
		<div class="p-3 justify-content-end d-flex"></div>
	</div>
</body>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" charset="utf-8">


function myPageUpdate(){
	$("#myPage-name").wrapInner("<input class="+"form-control id="+"update-name"+" name="+"update-name"+" value='${userInfo.name}'>");
	$("#myPage-phone").wrapInner("<input class="+"form-control id="+"update-phone"+" name="+"update-phone"+" value='${userInfo.phone}'>");
	$("#myPage-email").wrapInner("<input class="+"form-control id="+"update-email"+" name="+"update-email"+" value='${userInfo.email}'>");
	
	$("#zipcode").empty();
	$("#myPage-zipcode").append("<div id="+"zipcode-input-div class="+"col-sm-8>");
	$("#myPage-zipcode").append("<div id="+"zipcode-button-div class="+"col-sm-2>");
	$("#zipcode-input-div").wrapInner("<input class="+"form-control id="+"update-zipcode"+" name="+"update-zipcode"+" value='${userInfo.zipcode}'>");
	$("#zipcode-button-div").wrapInner("<input id="+"zipcode-Button type="+"button onclick="+"sample6_execDaumPostcode()"+ " value='우편번호 찾기'>");
	$("#zipcode-Button").attr("class","btn btn-primary");
	
	$("#myPage-addr1").wrapInner("<input class="+"form-control id="+"update-addr1"+" name="+"update-addr1"+" value='${userInfo.address1}'>");
	$("#myPage-addr2").wrapInner("<input class="+"form-control id="+"update-addr2"+" name="+"update-addr2"+" value='${userInfo.address2}'>");
	
	$("#updateButton").remove();
	$("#deleteButton").remove();
	
	$("#button-div").append("<button id="+"confirm-button>수정 완료");
	let confirmButton =$("#confirm-button");
	confirmButton.attr("class","btn btn-primary m-1");
	confirmButton.attr("onclick","updateConfirm()")
	
	$("#button-div").append("<button id="+"deny-button>수정 취소");
	let denyButton =$("#deny-button");
	denyButton.attr("class","btn btn-primary m-1");
	denyButton.attr("onclick","denyConfirm()");
	
	
}

function myPageDelete(){
	const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: "btn btn-success m-1",
		    cancelButton: "btn btn-danger m-1"
		  },
		  buttonsStyling: false
		});
		swalWithBootstrapButtons.fire({
		  title: "Are you sure?",
		  text: "You won't be able to revert this!",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonText: "Yes, delete it!",
		  cancelButtonText: "No, cancel!",
		  reverseButtons: true
		}).then((result) => {
		  if (result.isConfirmed) {
				location.href="/delete.members?id=${userInfo.id}";
		    swalWithBootstrapButtons.fire({
		      title: "Deleted!",
		      text: "Your file has been deleted.",
		      icon: "success"
		    });
		    
		  } else if (
		    /* Read more about handling dismissals below */
		    result.dismiss === Swal.DismissReason.cancel
		  ) {
		    swalWithBootstrapButtons.fire({
		      title: "Cancelled",
		      text: "Your imaginary file is safe :)",
		      icon: "error"
		    });
		  }
		});

}

function denyConfirm(){
	console.log("denyConfirm");
	const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: "btn btn-success m-1",
		    cancelButton: "btn btn-danger m-1"
		  },
		  buttonsStyling: false
		});
		swalWithBootstrapButtons.fire({
		  title: "취소하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonText: "수정을 취소합니다",
		  cancelButtonText: "되돌아가기",
		  reverseButtons: true
		}).then((result) => {
			  if (result.isConfirmed) {
					location.reload();
				  } else if (
				    /* Read more about handling dismissals below */
				    result.dismiss === Swal.DismissReason.cancel
				  ) {
				  }
				});
}
function updateConfirm(){
	console.log("updateConfirm");
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
			  console.log($("#update-email").val())
				location.href="/update.members?update-name="+$("#update-name").val()
						+"&update-phone="+$("#update-phone").val()
						+"&update-email="+$("#update-email").val()
						+"&update-zipcode="+$("#update-zipcode").val()
						+"&update-addr1="+$("#update-addr1").val()
						+"&update-addr2="+$("#update-addr2").val();
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
						document.getElementById("update-addr2").value = extraAddr;

					} else {
						document.getElementById("update-addr2").value = '';
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('update-zipcode').value = data.zonecode;
					document.getElementById("update-addr1").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("update-addr2")
							.focus();
				}
			}).open();
}
</script>
</html>