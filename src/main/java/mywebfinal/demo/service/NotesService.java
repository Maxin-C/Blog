package mywebfinal.demo.service;

import mywebfinal.demo.domain.Notes;

import java.util.List;

public interface NotesService {

    List<Notes> listNotes();

    void addNotes(String notesInfo);
}
