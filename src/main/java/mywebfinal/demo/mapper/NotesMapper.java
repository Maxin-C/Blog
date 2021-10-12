package mywebfinal.demo.mapper;

import mywebfinal.demo.domain.Notes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesMapper{

    List<Notes> listNotes();

    void addNotes(Notes notes);

}