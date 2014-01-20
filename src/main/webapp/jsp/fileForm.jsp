<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>File Upload Test Form</title>
</head>
<body>
	<h1>File Upload Form</h1>
	<form method="post" action="./upload.do" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="file" name="file" />
		<input type="file" name="file" />
		<input type="file" name="file" />		
		<input type="submit" value="전송" />
	</form>
</body>
</html>