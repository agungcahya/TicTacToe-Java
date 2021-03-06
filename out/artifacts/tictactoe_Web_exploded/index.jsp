<%--
  Created by IntelliJ IDEA.
  User: agung
  Date: 20/02/2021
  Time: 21.06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
    <title>Tic Tac Toe</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6  mx-auto">
            <h1 align="center">Tic Tac Toe!</h1>
            <div class="card">
                <div class="card-body">
                    <form name="gameForm" method="post" action="new-game">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="mode" value="single" onclick="singlePlayer()" disabled>
                            <label class="form-check-label" >Single Player</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="mode" value="multi" onclick="multiPlayer()" checked>
                            <label class="form-check-label" >Multi Player</label>
                        </div>
                        <br>
                        <div class="form-group">
                            <label for="inputPlayer1" class="col-form-label">Player 1</label>
                            <div class="col">
                                <input type="text" class="form-control" id="inputPlayer1" placeholder="Player name" name="player1">
                            </div>
                        </div>
                        <div class="form-group" id="formPlayer2" style="display: none">
                            <label for="inputPlayer2" class="col-form-label">Player 2</label>
                            <div class="col">
                                <input type="text" class="form-control" id="inputPlayer2" placeholder="Player name" name="player2">
                            </div>
                        </div>
                        <br>
                        <div class="form-group">
                            <input type="range" id="boardSizeSlider" name="boardSize" min="3" max="13" step="2" value="3">
                            <p>Size: <span id="boardSize"></span></p>
                        </div>
                        <div class="form-group row">
                            <div class="col" style="text-align: center">
                                <button type="submit" class="btn btn-primary">Play</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var slider = document.getElementById("boardSizeSlider");
    var output = document.getElementById("boardSize");
    output.innerHTML = slider.value + "x" + slider.value;
    slider.oninput = function() {
        output.innerHTML = this.value + "x" + this.value;
    };

    function multiPlayer() {
        document.getElementById("formPlayer2").style.display = 'block';
    }
    function singlePlayer() {
        document.getElementById("formPlayer2").style.display = 'none';
    }

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
