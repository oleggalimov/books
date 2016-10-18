<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Добавить книгу</title>

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
    <c:if test="${not empty message}">
        Книга добавлена! <br/>

    </c:if>
       <form action="${pageContext.request.contextPath}/saveBook" method="post">

           <table>
               <tr><td>Заголовок</td><td><input type="text" name="BOOK_TITLE" required="true" autofocus="true"></td></tr>
               <tr><td>Автор</td><td><input type="text" name="AUTOR" required="true" autofocus="true"></td></tr>
               <tr><td>Издатель</td><td><input type="text" name="izdatel" required="true" autofocus="true"></td></tr>

               <tr><td>Полка</td><td><input type="number" name="BOOK_SHELF" required="true" autofocus="true"></td></tr>
               <tr><td>Комната</td><td><input type="number" name="BOOK_ROOM" required="true" autofocus="true"></td></tr>
               <tr><td><input type="submit" value="Добавить"> </td></tr>
           </table>

       </form>
	



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