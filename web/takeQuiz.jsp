

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doing Quiz</title>
        <link rel="stylesheet" type="text/css" href="css/takeQuiz.css">

    </head>
    <body>

        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div class="title-time">
                        <h3>Welcome <b style="color: blue;">${sessionScope.user.user}</b></h3> 
                        <div class="time">
                            <p id="time"></p>
                        </div>

                        <script>
                            var countDownDate = new Date().getTime() + ${time} * 1000;

                            var now = new Date().getTime();
                            var distance = countDownDate - now - 1;
                            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                            document.getElementById("time").innerHTML = "Time remaining : <b style=\"color: red;\"> " + minutes + ":" + seconds + "</b>";

                            function timeCount() {
                                 now = new Date().getTime();
                                 distance = countDownDate - now -1;
                                 minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                 seconds = Math.floor((distance % (1000 * 60)) / 1000);

                                document.getElementById("time").innerHTML = "Time remaining : <b style=\"color: red;\"> " + minutes + ":" + seconds + "</b>";

                                document.getElementById("timee").value = Math.round((distance - 1) / 1000);
                                if (distance < 0) {
                                    clearInterval(x);
                                    document.getElementById("time").innerHTML = "Time out";
                                    window.location = "takeQuiz?timeout=1";
                                }
                            }

                            var x = setInterval(timeCount, 1000);
                        </script>
                    </div>
                    <div class="ques">
                        <c:if test="${not empty sessionScope.quiz}">

                            <form action="takeQuiz?n=${n}" method="post">
                                <p> ${quiz.get(n).q_name}
                                <p> <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="1" />${quiz.get(n).ans_1}
                                <p> <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="2" />${quiz.get(n).ans_2}
                                <p> <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="3" />${quiz.get(n).ans_3}
                                <p> <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="4" />${quiz.get(n).ans_4}
                                    <input type="hidden" name="timee" id="timee" value="${time}">
                                <p> <input type="submit" value="Next">  
                            </form>

                            <script>
                                function isChecked(checkbox) {
                                    var checkboxs = document.getElementsByName("true_ans");
                                    checkboxs.forEach((chk) => {
                                        if (chk !== checkbox)
                                            chk.checked = false;

                                    });
                                }
                            </script>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
