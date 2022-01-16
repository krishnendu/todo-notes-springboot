<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Todos</title>
    </head>
    <body>
        <h1>All your todo notes</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Completed</th>
                    <th>User</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.title}</td>
                        <td>${todo.description}</td>
                        <td>${todo.completed}</td>
                        <td>${todo.user.userName}</td>
                        <td><a href="/todo/${todo.id}/complete">Set as Completed</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>