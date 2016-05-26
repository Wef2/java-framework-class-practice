package kr.ac.jejunu.spring;

import kr.ac.jejunu.HelloModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by neo-202 on 2016-05-19.
 */
@Controller
@RequestMapping("/spring")
@SessionAttributes("helloModel")
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("hello")
    public void hello(Model model) {
        model.addAttribute("Hello World!!");
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String hello2(@PathVariable String name, Model model) {
        model.addAttribute("Hello World!, " + name);
        return "/spring/hello";
    }

    @RequestMapping("/{hello:[a-z]+}/{name:[a-z]+")
    public String hello3(@PathVariable String hello, @PathVariable String name, Model model) {
        model.addAttribute(hello + " !! " + name);
        return "/spring/hello";
    }

    @RequestMapping("/hi/{hello}")
    public String hello4(@PathVariable String hello, @MatrixVariable String name, Model model) {
        model.addAttribute(hello + " ! " + name);
        return "/spring/hello";
    }

    @RequestMapping("/helloworld")
    public String hello5(@RequestParam String hello, @RequestParam String name, Model model) {
        model.addAttribute(hello + " !! " + name);
        return "/spring/hello";
    }

    @RequestMapping("/hellomodel")
    public String hello5(HelloModel helloModel) {
        logger.info("****** " + helloModel.getHello() + helloModel.getName() + " ******");
        return "/spring/hellomodel";
    }

    @RequestMapping("/hellocookie")
    public String hello6(HelloModel helloModel, @CookieValue(value = "name", defaultValue = "test") String name, HttpServletResponse response) {
        helloModel.setName(name);
        if ("test".equals(name))
            response.addCookie(new Cookie("name", "henry"));
        else
            response.addCookie(new Cookie("name", "test"));
        return "/spring/hellomodel";
    }

    @RequestMapping("/hellosession")
    public String hello7(HelloModel helloModel, HttpSession session) {
        String name = (String) session.getAttribute("name");
        helloModel.setName(name);
        if ("test".equals(name))
            session.setAttribute("name", "henry");
        else
            session.setAttribute("name", "test");
        return "/spring/hellomodel";
    }

    @ModelAttribute("helloModel")
    public HelloModel model() {
        return new HelloModel();
    }

    @RequestMapping("/sessionattribute")
    public String hello8(HelloModel helloModel) {
        helloModel.setHello("Hello");
        helloModel.setName("Test");
        return "/spring/hellomodel";
    }

    @RequestMapping("/sessionattributeavlue")
    public String hello9(HelloModel helloModel) {
        return "/spring/hellomodel";
    }

}
