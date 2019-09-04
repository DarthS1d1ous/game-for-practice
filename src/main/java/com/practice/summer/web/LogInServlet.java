package com.practice.summer.web;

import com.practice.summer.model.user.ArrayListUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogInServlet extends HttpServlet {
    private ArrayListUserDao arrayListUserDao;

    @Override
    public void init() {
        this.arrayListUserDao = ArrayListUserDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/logIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(arrayListUserDao.addUser(login,password)){
            resp.sendRedirect(req.getContextPath() + "/signIn");
        } else {
            req.setAttribute("error", "User already exists");
            req.getRequestDispatcher("/WEB-INF/pages/logIn.jsp").forward(req, resp);
        }
    }
}
