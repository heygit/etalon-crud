package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthController {

    @RequestMapping(value = "checkCard", method = RequestMethod.GET)
    public void session(ModelMap model) {
        model.addAttribute("status", "notfound");
    }
}
