<%--
  Created by IntelliJ IDEA.
  User: mtriston
  Date: 03.11.2021
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Sign In</title>
</head>
<body>
<div class="container mx-auto" style="width: 80vw">
    <h1 class="text-center p-3">Sign In</h1>
    <form action="${pageContext.request.contextPath}/signIn" method="POST">
        <div class="mb-3">
            <label for="phoneNumberInput" class="form-label">Phone number</label>
            <input
                    value="${param.phoneNumber}"
                    type="tel"
                    placeholder="Enter phone number"
                    name="phoneNumber"
                    class="form-control"
                    id="phoneNumberInput"
                    required>
        </div>
        <div class="mb-3">
            <label for="passwordInput" class="form-label">Password</label>
            <input
                    type="password"
                    placeholder="Enter password"
                    name="password"
                    class="form-control"
                    id="passwordInput"
                    required>
        </div>
        <input type="submit" class="btn btn-primary" value="Sign In">
    </form>
    <p class="text-danger text-center">${error}</p>
    <a href="/signUp" class="link-primary">Not registered yet?</a>
</div>
</body>
</html>
