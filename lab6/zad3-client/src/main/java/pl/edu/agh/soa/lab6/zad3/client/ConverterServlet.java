package pl.edu.agh.soa.lab6.zad3.client;

import pl.edu.agh.soa.lab6.zad3.ejb.Converter;
import pl.edu.agh.soa.lab6.zad3.ejb.ConverterImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

@WebServlet(name = "ConverterServlet", value = "/convert")
public class ConverterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double temp = Double.parseDouble(request.getParameter("temp"));
        String direction = request.getParameter("direction");

        final Converter converter;
        try {
            converter = lookupRemoteConverter();
        } catch (NamingException e) {
            e.printStackTrace();
            return;
        }

        double result = "CF".equals(direction) ? converter.cels2Fahr(temp) : converter.fahr2Cels(temp);

        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private Converter lookupRemoteConverter() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        final String appName = "";
        final String moduleName = "zad3-ejb";
        final String distinctName = "";
        final String beanName = ConverterImpl.class.getSimpleName();
        final String viewClassName = Converter.class.getName();

        return (Converter) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }
}
