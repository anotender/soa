package pl.edu.agh.soa.lab2.zad5.controller;

import pl.edu.agh.soa.lab2.zad5.model.Feedback;
import pl.edu.agh.soa.lab2.zad5.model.FeedbackStorage;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "EditFeedbackServlet", value = "/editFeedback")
public class EditFeedbackServlet extends HttpServlet {

    private final FeedbackStorage feedbackStorage;

    @Inject
    public EditFeedbackServlet(FeedbackStorage feedbackStorage) {
        this.feedbackStorage = feedbackStorage;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Optional<Feedback> feedback = feedbackStorage
                .getFeedbackList()
                .stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (feedback.isPresent()) {
            req.setAttribute("feedback", feedback.get());
        } else {
            req.setAttribute("error", "Nie znaleziono");
        }

        req.getRequestDispatcher("feedback-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String comment = req.getParameter("komentarz");

        feedbackStorage.getFeedbackList()
                .stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .ifPresent(f -> {
                    f.setComment(comment);
                    f.setEmail(email);
                    f.setName(name);
                });

        resp.sendRedirect("list");
    }
}
