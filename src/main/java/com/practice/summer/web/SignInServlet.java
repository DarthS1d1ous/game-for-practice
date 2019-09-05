package com.practice.summer.web;


import com.practice.summer.model.jdbc.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        req.getRequestDispatcher("/WEB-INF/pages/signIn.jsp").forward(req, resp);
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.signIn(login, password).isPresent()) {
            resp.sendRedirect(req.getContextPath() + "/game");
        } else {
            req.setAttribute("error", "Incorrect data");
            req.getRequestDispatcher("/WEB-INF/pages/signIn.jsp").forward(req, resp);
        }
//        if (arrayListUserDao.findUser(login, password).isPresent()) {
//            resp.sendRedirect(req.getContextPath() + "/game");
//        } else if (login == null && password == null) {
//            req.getRequestDispatcher("/WEB-INF/pages/signIn.jsp").forward(req, resp);
//        } else {
//            req.setAttribute("error", "Incorrect data");
//            req.getRequestDispatcher("/WEB-INF/pages/signIn.jsp").forward(req, resp);
//        }
    }
}
