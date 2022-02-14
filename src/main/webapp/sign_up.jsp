<%--
  Created by IntelliJ IDEA.
  User: mtriston
  Date: 03.11.2021
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Sign Up</title>
</head>
<body>
    <div class="container mx-auto" style="width: 80vw">
        <h1 class="text-center p-3">Sign Up</h1>
        <form action="${pageContext.request.contextPath}/signUp" method="POST">
            <div class="mb-3">
                <label for="firstNameInput" class="form-label">First name</label>
                <input
                        value="${param.firstName}"
                        type="text"
                        placeholder="Enter first name"
                        name="firstName"
                        class="form-control"
                        id="firstNameInput"
                        required>
                <span class="text-danger">${errors.firstName}</span>
            </div>
            <div class="mb-3">
                <label for="lastNameInput" class="form-label">Last name</label>
                <input
                        value="${param.lastName}"
                        type="text"
                        placeholder="Enter last name"
                        name="lastName"
                        class="form-control"
                        id="lastNameInput"
                        required>
                <span class="text-danger">${errors.lastName}</span>
            </div>
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
                <span class="text-danger">${errors.phoneNumber}</span>
            </div>
            <div class="mb-3">
                <label for="passwordInput" class="form-label">Password</label>
                <input
                        value="${param.password}"
                        type="password"
                        placeholder="Enter password"
                        name="password"
                        class="form-control"
                        id="passwordInput"
                        required>
                <span class="text-danger">${errors.password}</span>
            </div>
            <input type="submit" class="btn btn-primary" value="Sign Up">
        </form>
    </div>
</body>
</html>
