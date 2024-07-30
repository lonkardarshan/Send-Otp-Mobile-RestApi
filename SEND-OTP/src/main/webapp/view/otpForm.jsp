<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OTP Validation</title>
</head>
<body>
    <h2>OTP Validation Form</h2>
    <form action="/validateOtp" method="post">
        Mobile Number: <input type="text" name="mobileNumber" required><br>
        OTP: <input type="text" name="otp" required><br>
        <input type="submit" value="Validate OTP">
    </form>
</body>
</html>
