<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database Demo</title>
</head>
<body>
	<center>
		<h1>Image Upload to Database</h1>
		<form method="post" action="uplodaPhoto" enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>User Id:</td>
					<td><input type="number" name="id" size="50" /></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="name" size="50" /></td>
				</tr>
				<tr>
					<td>User Photo:</td>
					<td><input type="file" name="photo" size="50" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>