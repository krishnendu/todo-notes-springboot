<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add User</title>
    </head>
    <body>
        <h1>Register to create Todo Notes</h1>
    
        <form:form action="${add_user_url}" method="${method}" modelAttribute="users">
            <form:label path="userName">Enter Username: </form:label> <form:input type="text" path="userName"/>
            <form:label path="password">Enter Password: </form:label> <form:input type="text" path="password"/>
            <form:label path="roles">Role: </form:label> <form:input type="text" path="roles"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>