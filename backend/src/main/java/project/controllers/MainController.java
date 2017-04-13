package project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.services.Printer;


@Controller
@RequestMapping("")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private Printer printer;

    @Autowired
    public MainController(Printer printer) {
        this.printer = printer;
    }

    @RequestMapping(value = "echo", method = RequestMethod.GET)
    @ResponseBody
    public String echo(@RequestParam(value = "message") String message) {
        LOGGER.debug("Echo performed");
        return printer.print();
    }

}