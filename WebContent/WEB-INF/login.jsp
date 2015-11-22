<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base_url" value="http://localhost:8080/Ecommerce"></c:set>
<!DOCTYPE html>
<html >
<head>
	<meta charset="UTF-8">
	<title>Admin login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css">   
</head>

<body>
	<div class="login-wrap">
		<h2>Login</h2>
		<form action="j_security_check" method="post">
			<div class="form">
				<input type="text" placeholder="Username" name="j_username" />
				<input type="password" placeholder="Password" name="j_password" />
				<button> Sign in </button>
			</div>
		</form>
	</div>
</body>
</html>
