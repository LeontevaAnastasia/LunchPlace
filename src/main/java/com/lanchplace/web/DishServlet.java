package com.lanchplace.web;

import com.lanchplace.model.Dish;
import com.lanchplace.repository.DishRepository;
import com.lanchplace.util.DishUtil;
import com.lanchplace.web.dish.DishRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class DishServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DishServlet.class);

    private ConfigurableApplicationContext springContext;
    private DishRestController dishController;

    @Override
    public void init() {
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        dishController = springContext.getBean(DishRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // String id = request.getParameter("id");

        Dish dish = new Dish(
                request.getParameter("description"),
                Double.parseDouble(request.getParameter("price")));

        if (StringUtils.hasLength(request.getParameter("id"))) {
            dishController.update(dish, getId(request));
        } else {
            dishController.create(dish);
        }
        response.sendRedirect("dishes");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                int menuId = getMenuId(request);
                log.info("Delete {}", id);
                dishController.delete(id,menuId);
                response.sendRedirect("dishes");
                break;
            case "create":
            case "update":
                final Dish dish = "create".equals(action) ?
                        new Dish("", 100.40, null) :
                        dishController.get(getId(request),getMenuId(request));
                request.setAttribute("dish", dish);
                request.getRequestDispatcher("/dishForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                log.info("getAll");
                request.setAttribute("dishes",
                        dishController.getAll(getMenuId(request)));
                request.getRequestDispatcher("/dishes.jsp").forward(request, response);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    private int getMenuId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("menuId"));
        return Integer.parseInt(paramId);
    }
}
