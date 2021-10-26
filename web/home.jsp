

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="all">
                    <h1>Welcome <b style="color: blue;">${sessionScope.user.user}</b></h1>
                    <p style="color: red"> ${warning}
                </div>
            </div>
        </div>
    </body>
</html>
