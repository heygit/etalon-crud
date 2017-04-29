package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.dao.NoteDao;
import project.dao.UserDao;
import project.entity.Note;
import project.entity.User;

import java.util.Collections;


@Controller
@RequestMapping("")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private NoteDao noteDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "echo", method = RequestMethod.GET)
    @ResponseBody
    public Object echo(@RequestParam(value = "message") String message) {
        LOGGER.debug("Echo performed");
        noteDao.save(getNote());
        return "done";
    }

    private Note getNote() {
        String time = System.currentTimeMillis()+"";
        Note note = new Note();
        note.setName(time);
        note.setDetails(time);
        note.setCreated(1);

        final User author = getUser();
        note.setAuthor(author);

        final User editor = getUser();
        note.setEditors(Collections.singletonList(editor));
        return note;
    }

    private User getUser() {
        String time = System.currentTimeMillis()+"";
        User user = new User();
        user.setName(time);
        return user;
    }

}
