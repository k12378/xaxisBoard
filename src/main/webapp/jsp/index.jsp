<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="Ko">
<head>
	<meta charset="utf8">
	<title>Hello Ext</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<!-- 	
	<link rel="stylesheet" type="text/css" href="css/ext-all.css" />
	<script type="text/javascript" src="extjs/ext-debug.js"></script>
	<script type="text/javascript" src="app/app.js"></script>
 -->
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url : "/xaxisBoard/category/item/update/000000001/",
		type : "post",
		data : {"categoryName" : encodeURIComponent("카테고리11")},
		dataType: "json",
		error : function(jqXHR, textStatus, errorThrown){
			alert(textStatus);
		},
		success : function(responseData){
			alert( responseData["responseData"]["result"] );	
		}
	});
});
</script>
</body>
</html>