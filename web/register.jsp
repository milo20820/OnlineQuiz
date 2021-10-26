

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <div class="title">
                        <h3>Registration Form</h3>
                    </div>
                    <div class="rg">
                        <form action="register" method="post">
                            <table>
                                <tr>
                                    <td>User Name:</td>
                                    <td><input type="text" name="user" required="true" value="${registerUser.user}"/></td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td><input type="password" name="pwd" required="true" value="${registerUser.pwd}"/></td>
                                </tr>
                                <tr>
                                    <td>User Type: </td>
                                    <td>
                                        <select name="role">
                                            <option value="0" ${registerUser.role == false ? "selected" : ""} selected>Teacher</option>
                                            <option value="1" ${registerUser.role == true ? "selected" : ""}>Normal User</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Email:</td>
                                    <td><input type="email" name="email" required="true" value="${registerUser.email}"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" name="submit" value="Register"/></td>
                                </tr>
                            </table>

                        </form>
                        <p style="color:red;"> ${noti} 
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
