<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Поиск книг</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="https://github.com/oleggalimov/bokks/"><b>Этот проект на Гитхаб</b></a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/">Домашняя</a></li>
                    <li><a href="${pageContext.request.contextPath}/promo.html">О проекте</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<br/>
<div class="container">
    <h3>Поиск книги</h3>
    <form action="${pageContext.request.contextPath}/allBooksByAutor" method="post">

        <table>
            <tr><td>Автор </td><td><input type="text" name="AUTOR"  autofocus="true"></td></tr>
            <tr><td>Издательство </td><td><input type="text" name="IZDATEL"  autofocus="true"></td></tr>

            <tr><td><input type="submit" value="Искать"> </td></tr>
        </table>

    </form>
</div>




<div class="container">
    <c:if test="${not empty listofbooks}">
Найдено: <c:out value="${counts}"></c:out>
        <br/>
        <table class="table table-striped">
            <c:forEach var="currentBook" items="${listofbooks}">
                <tr><td><strong>Заголовок</strong></td><td><c:out value="${currentBook.BOOK_TITLE}"></c:out></td></tr>
                <tr><td>Автор</td><td><c:out value="${currentBook.autor}"></c:out></td></tr>
                <tr><td>Издатель</td><td><c:out value="${currentBook.izdatel}"></c:out></td></tr>
                <tr><td>Полка</td><td><c:out value="${currentBook.BOOK_SHELF}"></c:out></td></tr>
                <tr><td>Комната</td><td><c:out value="${currentBook.BOOK_ROOM}"></c:out></td></tr>
                <tr><td>Статус</td><td>
                    <c:if test="${currentBook.BOOK_STATUS eq 1}">
                        На полке
                    </c:if>
                    <c:if test="${currentBook.BOOK_STATUS eq 0}">
                        Книга выдана
                    </c:if>

                </td></tr>
                <tr><td>Идентификатор</td><td><c:out value="${currentBook.id}"></c:out></td></tr>
                <tr><td></td><td></td></tr>
                <br/>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${ empty listofbooks}">
Книга не найдена!
    </c:if>

    <br/>





</div> <!-- /container -->


<br/>
<br/>
<div class="container">
    <address style="background-color: #dedef8;box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
        <strong>  Oleg Galimov</strong> <br/>
        <a href="mailto:o.d.galimov@yandex.ru"><i>  o.d.galimov@yandex.ru</i></a> <br/>
        2016 г.

    </address>

</div>

</body>
</html>