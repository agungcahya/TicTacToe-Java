package game.tictactoe.controller;

import game.tictactoe.model.Game;
import game.tictactoe.model.Player;
import game.tictactoe.service.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/turn")
public class PlayerTurnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = (Game) request.getSession().getAttribute("game");
        Integer row = Integer.valueOf(request.getParameter("rowPosition"));
        Integer col = Integer.valueOf(request.getParameter("colPosition"));
        GameService gameService = new GameService();
        game = gameService.setMark(row, col, game);
        Player winner = gameService.checkWinner(row, col, game);
        if (winner == null) {
            game.setActivePlayer(gameService.changePlayer(game));
        } else {
            game.setWinner(winner);
        }
        request.getSession().setAttribute("game", game);
        RequestDispatcher rd=request.getRequestDispatcher("/game.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
