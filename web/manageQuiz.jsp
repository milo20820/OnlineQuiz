

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Quiz</title>
        <link href="css/manageQuiz.css" rel="stylesheet" type="text/css"/>
        <style>
            .pagination {
                font-size: 12px;
                padding-bottom: 50px;
                display: flex;
                flex-direction: row;
                justify-content: flex-end;
                margin-right: 15px;
                margin-top: 15px;
            }

            .pagination__link {
                color: black;
                float: left;
                padding: 10px 14px;
                text-decoration: none;
            }

            .pagination--active {
                background-color:  #fff68f;
                color: #000;
                border-radius: 50%;
            }

            .pagination__link:hover:not(.pagination--active){
                background-color: #129cf3;
                border-radius: 50%;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div class="numQues">
                        <h3>Number of questions: ${total}</h3>
                    </div>
                    <div class="quess">
                        <table border="0">
                            <thead>
                                <tr>
                                    <th class="left">Question</th>
                                    <th>Date Created</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${items}" var="q">
                                    <tr>
                                        <td class="left">${q.q_name}</td>
                                        <td>${q.date_created}</td>  
                                        <td><button onclick="return confirm('are you sure?')"><a href="DeleteQ?id=${q.id}">Delete</a></button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="pagination">${pagination}</div>
                </div>
            </div>
        </div>

    </body>
</html>
