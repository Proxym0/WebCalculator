package by.tms.web;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/operations/all")
public class GetAllOperationsServlet extends HttpServlet {
    CalculatorService calculatorService=new CalculatorService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for (Operation operation:calculatorService.showHistory()) {
            resp.getWriter().append(operation.toString()).append('\n');
            
        }
    }
}
