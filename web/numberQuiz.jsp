

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz</title>
        <link href="css/numberQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="questionDAO" class="dao.QuestionDAO" />
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div id="div2-left">
                        <h3>Welcome <b style="color: blue">${sessionScope.user.user}</b></h3>
                    </div>
                    <div id="div3">
                        <p class="notice">${notice}</p>
                        <h4>Total question: ${questionDAO.countQuest()}</h4>
                        <form action="takeQuiz" method="post">
                            <p> Enter number of questions: </p>
                            <p> <input type="text" name="number"/> 
                            <p> <input type="submit" value="Start"/>   
                        </form> 
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
