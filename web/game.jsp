<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: agung
  Date: 21/02/2021
  Time: 15.16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
    <title>Tic Tac Toe</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-6  mx-auto">
            <h1 align="center">Tic Tac Toe!</h1>
            <p align="center">${game.activePlayer.name} turn!</p>
            <p align="center">${game.winner.name} !</p>
            <div class="container">
                <form id="turnForm" method="post" action="turn">
                    <input type="hidden" id="rowPosition" name="rowPosition">
                    <input type="hidden" id="colPosition" name="colPosition">
                    <table class="board">
                        <c:forEach items="${game.board.size}" var="row" varStatus="dataRow">
                            <tr>
                                <c:forEach items="${row}" var="col" varStatus="dataCol">
                                    <c:if test="${col == null}">
                                        <td class="tiles" onclick="playerTurn(${dataRow.index}, ${dataCol.index})"><h2>${col  }</h2></td>
                                    </c:if>
                                    <c:if test="${col != null}">
                                        <td class="tiles" ><h2>${col  }</h2></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function playerTurn(row, col) {
        console.log(row);
        console.log(col);
        document.getElementById("rowPosition").value = row;
        document.getElementById("colPosition").value = col;
        document.getElementById("turnForm").submit();

    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
