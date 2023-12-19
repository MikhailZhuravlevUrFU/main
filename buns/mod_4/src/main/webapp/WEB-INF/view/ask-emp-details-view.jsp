<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h2>Dear Employee, Please enter your details</h2>

<br>
<br>

<%--<form action="showDetails" method="get">--%>
<%--    <input type="text" name="employeeName"--%>
<%--           placeholder="Write your name"/>--%>

<%--    <input type="submit"/>--%>

<%--</form>--%>

<form:form action="showDetails" modelAttribute="employee">

    Name <form:input path="name"></form:input>
    <form:errors path="name"></form:errors>
    <br><br>
    Surname <form:input path="surname"></form:input>
    <form:errors path="surname"></form:errors>
    <br><br>
    Salary <form:input path="salary"></form:input>
    <form:errors path="salary"></form:errors>
    <br><br>
    Department <form:select path="department">
<%--    <form:option value="Information Technologi" label="IT"></form:option>--%>
<%--    <form:option value="Human Resources" label="HR"></form:option>--%>
<%--    <form:option value="Sales" label="Sales"></form:option>--%>
    <form:options items="${employee.departments}"></form:options>
</form:select>
    <br><br>
    Witch car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"></form:radiobuttons>
<%--    BMW <form:radiobutton path="carBrand" value="BMW"></form:radiobutton>--%>
<%--    Audi <form:radiobutton path="carBrand" value="Audi"></form:radiobutton>--%>
<%--    Mercedes-Benz <form:radiobutton path="carBrand" value="Mercedes-Benz"></form:radiobutton>--%>
    <br><br>
    Foreign Languages(s)
    <form:checkboxes path="languages" items="${employee.languagesList}"></form:checkboxes>
<%--    EN <form:checkbox path="languages" value="English"></form:checkbox>--%>
<%--    DE <form:checkbox path="languages" value="Deutch"></form:checkbox>--%>
<%--    FR <form:checkbox path="languages" value="French"></form:checkbox>--%>
    <br><br>
    Phone Number: <form:input path="phoneNumber"></form:input>
    <form:errors path="phoneNumber"></form:errors>
    <br><br>
    Email: <form:input path="email"></form:input>
    <form:errors path="email"></form:errors>
    <br><br>


    <input type="submit" value="OK">

</form:form>

</body>
</html>