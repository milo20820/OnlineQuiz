

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/OnlineQuiz/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <div class="prev"></div>
            <div class="menu">
                <div class="mn">
                    <ul >
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="numberQuiz.jsp">Take Quiz</a></li>
                        <li><a href="makeQuiz">Make Quiz</a></li>
                        <li><a href="manageQuiz">Manage Quiz</a></li>          
                            <c:if test="${not empty sessionScope.user}">
                            <li><a href="logout">Logout</a></li>
                            </c:if>
                    </ul>
                </div>

            </div>
        </div>

    </body>
</html>
