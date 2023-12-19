<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Dear Employee, you are Welcome!</h2>
<br>
<br>

<%--Your name: ${param.employeeName}--%>

Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>
Languages(s):
<ul>

    <c:forEach var="lang" items="${employee.languages}">

        <li>${lang}</li>

    </c:forEach>

</ul>

Phone Number: ${employee.phoneNumber}
<br>
Email: ${employee.email}

</body>

</html>