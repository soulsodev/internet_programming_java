<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
  <h1>Login</h1>
  <form method="post" action="j_security_check" class="form">
   <div class="row" > <label>Username</label> <input type="text" name="j_username" class="input_field"/></div>
    <div class="row"><label>Password</label> <input type="password" name="j_password"class="input_field"/></div>
    <input type="submit" class="btn_link" value="Sign in"/>
  </form>
</div>
</body>
</html>
