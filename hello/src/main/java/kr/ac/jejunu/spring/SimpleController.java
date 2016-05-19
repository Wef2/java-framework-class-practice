package kr.ac.jejunu.spring;

/**
 * Created by Kim on 2016-05-13.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("abc")
public class SimpleController implements org.springframework.web.servlet.mvc.Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("simple");
        modelAndView.addObject("abc", "Hello, World!");
        return modelAndView;
    }
}