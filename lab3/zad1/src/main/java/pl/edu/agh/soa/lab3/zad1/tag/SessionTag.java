package pl.edu.agh.soa.lab3.zad1.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SessionTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        String login = String.valueOf(session.getAttribute("login"));

        try {
            if (login == null || "null".equals(login)) {
                //login
                pageContext.getOut().write("<form method=\"post\" action=\"session\">\n" +
                        "    <input type=\"text\" name=\"login\" placeholder=\"login\" required/>\n" +
                        "    <input type=\"password\" name=\"password\" placeholder=\"password\" required>" +
                        "    <button type=\"submit\">Zaloguj</button>\n" +
                        "</form>");
            } else {
                //logout
                pageContext.getOut().write("<a href=\"session\">Wyloguj</a>");
            }
        } catch (Exception ignored) {
        }

        return EVAL_PAGE;
    }
}
