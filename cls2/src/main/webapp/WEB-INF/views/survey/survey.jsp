<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey</title>
<link rel="stylesheet" type="text/css" href="/cls2/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls2/css/user.css">
<script type="text/javascript" src="/cls2/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<form method="POST" action="/cls2/survey/surveyProc.cls" id="frm" name="frm">
	</form>
	
	<div class="w3-content mxw750 w3-margin-top">
		<h1 class="w3-blue w3-padding w3-center w3-margin-top">${TITLE}</h1>
		<div class="w3-col w3-margin-top w3-padding">
<c:forEach var="data" items="${LIST}" varStatus="st">
			<div class="w3-margin-top w3-padding">
				<h3 class="" id="${data.qno}">${st.count}. ${data.body}</h3>
				<div class="pdl50">
		<c:forEach var="sub" items="${data.list}">
					<h5 class="">
						${sub.exno}) 
						<span>
							<input type="radio" name="${data.qno}" value="${sub.qno}">
						</span> 
						${sub.ex}
					</h5>
		</c:forEach>
				</div>
			</div>
</c:forEach>
			
		</div>
	</div>
</body>
</html>