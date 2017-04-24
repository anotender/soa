package pl.edu.agh.soa.lab2.zad5.controller;

import pl.edu.agh.soa.lab2.zad5.model.Feedback;
import pl.edu.agh.soa.lab2.zad5.model.FeedbackStorage;
import pl.edu.agh.soa.lab2.zad5.utils.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet", value = "/list")
public class ListServlet extends HttpServlet {

    private final FeedbackStorage feedbackStorage;

    @Inject
    public ListServlet(FeedbackStorage feedbackStorage) {
        this.feedbackStorage = feedbackStorage;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object authenticated = request.getSession().getAttribute("authenticated");

        if (authenticated == null || !((Boolean) authenticated)) {
            response.sendRedirect("index.jsp");
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String comment = request.getParameter("comment");

        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(comment)) {
            feedbackStorage.getFeedbackList().add(new Feedback(name, email, comment));
        }

        request.getSession().setAttribute("feedbackList", feedbackStorage.getFeedbackList());
        response.sendRedirect("list.jsp");
    }

}
