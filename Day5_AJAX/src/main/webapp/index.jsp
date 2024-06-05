<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
</head>
<body>
	<fieldset>
		<legend>request</legend>
		<button id="ajax01">요청 확인</button>
	</fieldset>
</body>
<script type="text/javascript">
	$("#ajax01").on("click", function() {
		$.ajax({
			url : "/exam01.ajax"
		})
	})
</script>
<fieldset>
	<legend>request</legend>
	<button id="ajax02">요청 확인</button>
</fieldset>
<script>
	$("#ajax02").on("click", function() {
		$.ajax({
			url : "/exam02.ajax",
			type: "get",
			data : {
				key1 : "orange",
				key2 : "red"
			}
		})
	})
</script>
<fieldset>
	<legend>응답 받아보기</legend>
	<button id="ajax03">요청 확인</button>
</fieldset>
<script>
	$("#ajax03").on("click", function() {
		$.ajax({
			url : "/exam03.ajax",
		}).done(function(resp){
			console.log(resp);
		}); 
		//서버로부터 정상적인 응답이 들어왔을때 실행되는 콜백
		//서버로부터의 정상적인 데이터는 콜백의 매개변수로 전달됨.
	})
</script>
</html>