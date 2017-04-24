package pl.edu.agh.soa.lab3.zad1.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class ParagraphTag extends BodyTagSupport {
    private String header;
    private String align;
    private boolean headerAlign;
    private String color;

    @Override
    public int doEndTag() throws JspException {
        BodyContent body = getBodyContent();
        String bodyText = body.getString();

        String currentAlign = "center";
        String currentHeaderAlign = "center";
        String currentColor = "black";

        if (!isNullOrEmpty(color)) {
            currentColor = color;
        }

        if (!isNullOrEmpty(align)) {
            currentAlign = align;
        }

        if (headerAlign) {
            currentHeaderAlign = currentAlign;
        }
        try {
            body.getEnclosingWriter().write("<h3 align=\"" + currentHeaderAlign + "\">" + header + "</h3>" +
                    "<p align=\"" + currentAlign + "\" style=\"color:" + currentColor + "\">" + bodyText + "</p>");
        } catch (IOException e) {
            throw new RuntimeException("Problem during render paragraph", e);
        }

        return EVAL_PAGE;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public boolean isHeaderAlign() {
        return headerAlign;
    }

    public void setHeaderAlign(boolean headerAlign) {
        this.headerAlign = headerAlign;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private boolean isNullOrEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}
