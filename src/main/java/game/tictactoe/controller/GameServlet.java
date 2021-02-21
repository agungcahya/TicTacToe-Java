package game.tictactoe.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "GameServlet", urlPatterns = "/new-game")
public class GameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String player1 = request.getParameter("player1");
        String player2 = request.getParameter("player2");
        Integer boardSize = Integer.valueOf(request.getParameter("boardSize"));

        request.setAttribute("player1", player1);
        request.setAttribute("player2", player2);
        request.setAttribute("boardSize", boardSize);
        char[][] board = new char[boardSize][boardSize];
        request.setAttribute("board", board);
        RequestDispatcher rd=request.getRequestDispatcher("/game.jsp");
        rd.forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("gettt");
        response.setContentType("text/plain");
        response.getWriter().println("hello");
    }
}