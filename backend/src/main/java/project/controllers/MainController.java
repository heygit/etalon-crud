package project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.dao.TakDao;
import project.entities.Tak;


@Controller
@RequestMapping("")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    TakDao takRepository;

    @RequestMapping(value = "echo", method = RequestMethod.GET)
    @ResponseBody
    public Object echo(@RequestParam(value = "message") String message) {
        LOGGER.debug("Echo performed");
        int version = 2;
        String time = System.currentTimeMillis() + "--v" + version;
        takRepository.save(new Tak(time, time));
        return takRepository.findAll();
    }

}
