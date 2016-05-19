package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neo-202 on 2016-05-19.
 */
@Controller
public class HelloController {
    @RequestMapping("/spring/hello")
    public void hello(Model model){
        model.addAttribute("Hello World!!");
    }
}
