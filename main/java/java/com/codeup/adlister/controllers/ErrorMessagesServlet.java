package java.java.com.codeup.adlister.controllers;//package com.codeup.adlister.controllers;
//
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "controllers.ErrorMessagesServlet", urlPatterns = "/errorMessages")
//public class ErrorMessagesServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//boolean IncorrectPassword = password.isEmpty();
//
//        if (!IncorrectPassword) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("/errorMessage");
//
//        } else {
//            response.sendRedirect("/login");
//        }
//    }
//
//}