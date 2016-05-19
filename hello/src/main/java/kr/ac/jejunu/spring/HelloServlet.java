package kr.ac.jejunu.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by neo-202 on 2016-05-19.
 */
@Controller
public class HelloServlet extends GenericServlet {

    private final static Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void init() throws ServletException {
        logger.info("-------- init --------");
        super.init();
    }

    @Override
    public void destroy() {
        logger.info("-------- destroy --------");
        super.destroy();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("-------- service --------");
        res.getWriter().println("<h1>Hello!!!</h1>");
    }
}
