package mywebfinal.demo.controller;

import mywebfinal.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/notes
@RestController
@RequestMapping("notes")
public class NotesController {


    @Autowired
    private NotesService notesService;


    @RequestMapping("list")
    public Object listNotes(){
        return notesService.listNotes();
    }

    @RequestMapping("add")
    public void addNotes(@RequestBody String notesInfo){
        notesService.addNotes(notesInfo);
    }
}
