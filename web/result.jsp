

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link href="css/result.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div class="score">
                        <c:if test="${finish >= 0.5}">
                            Your score <b style="color: blue;">${finish * 10}(${finish * 100}%) - PASS</b> 
                        </c:if>
                        <c:if test="${finish < 0.5}">
                            Your score <b style="color: blue;">${finish * 10}(${finish * 100}%) - FAILT</b> 
                        </c:if>
                    </div>
                    <div class="other">
                        <p>Take another test&nbsp;<button><a href="numberQuiz.jsp">Start</a></button>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
