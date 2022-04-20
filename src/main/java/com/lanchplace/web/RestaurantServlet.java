package com.lanchplace.web;

import com.lanchplace.util.DishUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestaurantServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RestaurantServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("getAll");
        request.setAttribute("restaurants", DishUtil.getRestaurant());
        request.getRequestDispatcher("/restaurant.jsp").forward(request, response);
    }


}
