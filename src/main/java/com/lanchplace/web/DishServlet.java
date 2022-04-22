package com.lanchplace.web;

import com.lanchplace.model.Dish;
import com.lanchplace.repository.DishRepository;
import com.lanchplace.repository.inmemory.InMemoryDishRepository;
import com.lanchplace.util.DishUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class DishServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DishServlet.class);

    private DishRepository dishRepository;

    @Override
    public void init() {
        dishRepository = new InMemoryDishRepository();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Dish dish = new Dish(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("restaurant"),
                request.getParameter("description"),
                Double.parseDouble(request.getParameter("price")),
                LocalDate.parse(request.getParameter("date")));

        log.info(dish.isNew() ? "Create {}" : "Update {}", dish);
        dishRepository.save(dish);
        response.sendRedirect("dishes");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                log.info("Delete {}", id);
                dishRepository.delete(id);
                response.sendRedirect("dishes");
                break;
            case "create":
            case "update":
                final Dish dish = "create".equals(action) ?
                        new Dish("","", 100,LocalDate.now()) :
                        dishRepository.get(getId(request));
                request.setAttribute("dish", dish);
                request.getRequestDispatcher("/dishForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                log.info("getAll");
                request.setAttribute("dishes",
                        DishUtil.todayMenu(dishRepository.getAllDishes()));
                request.getRequestDispatcher("/dishes.jsp").forward(request, response);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
