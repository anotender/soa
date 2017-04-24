package pl.edu.agh.soa.lab3.zad1.tag;

import pl.edu.agh.soa.lab3.zad1.model.UserStorage;

import javax.inject.Inject;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ActiveUsersTag extends SimpleTagSupport {

    private String sort;
    private String color;

    @Inject
    private UserStorage userStorage;

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("<table border=\"1\"><thead><tr><th>login</th><th>data</th></thead><tbody>");

        userStorage
                .getActiveUsers()
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if ("asc".equals(sort)) {
                        return o1.getValue().compareTo(o2.getValue());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }

                })
                .forEach(e -> {
                    try {
                        getJspContext().getOut().write("<tr>");
                        getJspContext().getOut().write("<td>" + e.getKey() + "</td>");
                        getJspContext().getOut().write("<td style=\"color:" + color + ";\">" + e.getValue().toString() + "</td>");
                        getJspContext().getOut().write("</tr>");
                    } catch (Exception ignored) {
                    }
                });

        getJspContext().getOut().write("</tbody></table>");
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
