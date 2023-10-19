<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Аэропорты</title>
</head>
<body>
<table border="1">
  <thead>
  <tr>
    <td>Код</td>
    <td>Наименование</td>
    <td>Город</td>
    <td>Координаты</td>
    <td>Таймзона</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${data}" var="item">
    <tr>
      <td>${item.airportCode}</td>
      <td>${item.airportName}</td>
      <td>${item.city}</td>
      <td>${item.point}</td>
      <td>${item.timezone}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>