<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Голосование</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/vote" method="POST">
  <label> Выберите артиста
    <c:forEach items="${artists}" var="item">
      <p><input type="radio" name="artist" value="${item.id}"> ${item.name}</p>
    </c:forEach>
  </label>
  <label> Выберите жанр
    <c:forEach items="${genres}" var="item">
      <p><input type="checkbox" name="genre" value="${item.id}"> ${item.name}</p>
    </c:forEach>
  </label>
  <label>Информация
    <textarea name="about"></textarea>
  </label>
  <p><input type="submit" value="Отправить"></p>
</form>
</body>
</html>