<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add User</title>
    </head>
    <body>
        <h1>Create A New Todo Note</h1>
    
        <form:form action="${add_todo_url}" method="${method}" modelAttribute="todo">
            <form:label path="title">Enter Title: </form:label> <form:input type="text" path="title"/><br>
            <form:label path="description">Enter Description: </form:label> <form:input type="text" path="description"/><br>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>