

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div class="title">
                        <h3>Login Form</h3>
                    </div>
                    <div class="lg">
                        <p style="color:red;"> ${noti} </p>
                        <form action="login" method="POST">
                            <table>
                                <tr>
                                    <td>Username</td>
                                    <td><input type="text" name="user" value="${user}"/></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type="password" name="pwd" value="${pwd}"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" name="submit" value="Sign In"/> <a href="register.jsp">Register</a></td>
                                </tr>
                            </table>
                           
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
