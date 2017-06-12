package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project.service.NoteService;


@Controller
@RequestMapping("")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final NoteService noteService;

    @Autowired
    public MainController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "lock", method = RequestMethod.GET)
    @ResponseBody
    public Object lock() {
        LOGGER.debug("Echo performed");
        noteService.updateNote();
        return "done";
    }

    @RequestMapping(value = "echo", method = RequestMethod.GET)
    @ResponseBody
    public Object echo() {
        LOGGER.debug("Echo performed");
        noteService.createNotes(false);
        try {
            noteService.createNotes(true);
        } catch (Throwable ex) {
        }
        noteService.createNotes(false);
        return "done";
    }


}
