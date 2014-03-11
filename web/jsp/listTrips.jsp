<%-- 
    Document   : listTrips
    Created on : Jan 6, 2012, 7:42:11 PM
    Author     : bargenson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Trips</title>
        <style>
            table {
                width: 80%; 
                margin: auto;
                border-collapse: collapse;
            }
            
            table tr td, table tr th {
                text-align: center;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <center>
                <form method="POST">
                    <label for="filterdeparture">Departure:</label>
                    <select id="filterdeparture" name="filterdeparture">
                        <option></option>
                        <c:forEach items="${stations}" var="station">
                            <option value="${station.id}" ${station.id == filterdeparture ? 'selected' : ''}>
                                <c:out value="${station.name} (${station.city})"/>
                            </option>
                        </c:forEach>
                    </select>
                    <label for="filterarrival">Arrival:</label>
                    <select id="filterarrival" name="filterarrival">
                        <option></option>
                        <c:forEach items="${stations}" var="station">
                            <option value="${station.id}" ${station.id == filterarrival ? 'selected' : ''}>
                                <c:out value="${station.name} (${station.city})"/>
                            </option>
                        </c:forEach>
                    </select>
                    <label for="filterhighestprice">Highest Price:</label>
                    <input type="text" name="filterhighestprice" id="filterhighestprice" value="${filterhighestprice}" />
                    <input type="submit" value="filter" />
                </form>
            </center>
    
        <c:choose>
            <c:when test="${not empty trips}">
                <table>
                    <tr>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${trips}" var="trip">
                        <tr>
                            <c:url value="/admin/trips/delete" var="deleteTripUrl">
                                <c:param name="id" value="${trip.id}" />
                            </c:url>
                            <c:url value="/buyTrip" var="buyTripUrl" >
                                <c:param name="id" value="${trip.id}" />
                            </c:url>

                            <td><c:out value="${trip.departureStation.name}" /></td>
                            <td><c:out value="${trip.arrivalStation.name}" /></td>
                            <td><c:out value="€${trip.price}" /></td>
                            <td>
                                <a href="${buyTripUrl}">Buy it!</a>
                                <c:if test="${not empty user}">
                                    <a href="${deleteTripUrl}">Delete</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
            <center><p>No Trips found.</p></center>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${not empty user}">
            <c:url value="/admin/trips/add" var="addTripUrl" />
            <a href="${addTripUrl}">Add a new trip</a>
        </c:if>
    </body>
</html>
