package by.tms.web;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "WebCalculator", value = "/calc")
public class WebCalculator extends HttpServlet {
    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        Optional<Operation> calculator = calculatorService.calculator(new Operation(a, b, type));
        if (calculator.isPresent()) {
            Operation operation = calculator.get();
            resp.getWriter().println("Result = " + operation.getResult());
        } else {
            resp.getWriter().println("Operation not found!");
        }
    }
}

