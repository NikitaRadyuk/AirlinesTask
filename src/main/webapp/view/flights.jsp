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
    <td>aircraftCode</td>
    <td>flightId</td>
    <td>flightNo</td>
    <td>scheduledDeparture</td>
    <td>scheduledDepartureLocal</td>
    <td>scheduledArrival</td>
    <td>scheduledArrivalLocal</td>
    <td>scheduledDuration</td>
    <td>departureAirport</td>
    <td>departureAirportName</td>
    <td>departureCity</td>
    <td>arrivalAirport</td>
    <td>arrivalAirportName</td>
    <td>arrivalCity</td>
    <td>status</td>
    <td>aircraftCode</td>
    <td>actualDeparture</td>
    <td>actualDepartureLocal</td>
    <td>actualArrival</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${data}" var="item">
    <tr>
      <td>${item.aircraftCode}</td>
      <td>${item.flightId}</td>
      <td>${item.flightNo}</td>
      <td>${item.scheduledDeparture}</td>
      <td>${item.scheduledDepartureLocal}</td>
      <td>${item.scheduledArrival}</td>
      <td>${item.scheduledArrivalLocal}</td>
      <td>${item.scheduledDuration}</td>
      <td>${item.departureAirport}</td>
      <td>${item.departureAirportName}</td>
      <td>${item.departureCity}</td>
      <td>${item.arrivalAirport}</td>
      <td>${item.arrivalAirportName}</td>
      <td>${item.arrivalCity}</td>
      <td>${item.status}</td>
      <td>${item.aircraftCode}</td>
      <td>${item.actualDeparture}</td>
      <td>${item.actualDepartureLocal}</td>
      <td>${item.actualArrival}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>