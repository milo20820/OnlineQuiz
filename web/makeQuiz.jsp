

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz</title>
        <link href="css/makeQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div class="noti" style="color: red;">${noti}</div>
                    <div class="ques">
                        <form action="makeQuiz" method="post">
                            <table border="0">
                                <tr>
                                    <td>Question:</td>
                                    <td><textarea name="question" rows="4" maxlength="50">${question != null ? question : ""}</textarea></td>                       
                                </tr>
                                <tr>
                                    <td>Option1:</td>
                                    <td><textarea name="ans_1" rows="3" maxlength="50">${ans_1 != null ? ans_1 : ""}</textarea></td>                       
                                </tr>
                                <tr>
                                    <td>Option2:</td>
                                    <td><textarea name="ans_2" rows="3" maxlength="50">${ans_2 != null ? ans_2 : ""}</textarea></td>                       
                                </tr>
                                <tr>
                                    <td>Option3:</td>
                                    <td><textarea name="ans_3" rows="3" maxlength="50">${ans_3 != null ? ans_3 : ""}</textarea></td>                       
                                </tr>
                                <tr>
                                    <td>Option4:</td>
                                    <td><textarea name="ans_4" rows="3"maxlength="50">${ans_4 != null ? ans_4 : ""}</textarea></td>                       
                                </tr>
                                <tr>
                                    <td>Answer(s):</td>
                                    <td>
                                        <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="1" ${true_ans == 1 ? "checked" : ""}/> Option 1
                                        <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="2" ${true_ans == 2 ? "checked" : ""}/> Option 2
                                        <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="3" ${true_ans == 3 ? "checked" : ""}/> Option 3
                                        <input type="checkbox" name="true_ans" onclick="isChecked(this)" value="4" ${true_ans == 4 ? "checked" : ""}/> Option 4
                                    </td>
                                </tr>
                                <tr></tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Save" /></td>
                                </tr>

                            </table>


                        </form>
                    </div>
                    <script>
                        function isChecked(checkbox) {
                            var checkboxs = document.getElementsByName("true_ans");
                            checkboxs.forEach((chk) => {
                                if (chk !== checkbox)
                                    chk.checked = false;

                            });
                        }
                    </script>
                </div>
            </div>
        </div>

    </body>
</html>
