<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

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
              <li><a href="${pageContext.request.contextPath}/about.html">О проекте</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
    
    
   <div class="container">
    
      <h1>Java Spring MVC(JavaConfig)</h1>
      <h2>Простое приложение для книжек</h2>

	
	<a href="${pageContext.request.contextPath}/newBook.html">Добавить книгу</a> <br/><br/>
	<a href="${pageContext.request.contextPath}/showAll">Посмотреть список всех книг</a><br/><br/>
       <a href="${pageContext.request.contextPath}/bookBy.html">Посмотреть список всех книг по автору</a><br/><br/>
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