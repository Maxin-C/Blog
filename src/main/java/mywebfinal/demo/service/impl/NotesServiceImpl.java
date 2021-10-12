package mywebfinal.demo.service.impl;

import com.google.gson.Gson;
import mywebfinal.demo.domain.Notes;
import mywebfinal.demo.mapper.NotesMapper;
import mywebfinal.demo.service.NotesService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)
@MapperScan(basePackages = "mywebfinal.demo", annotationClass = Repository.class)
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesMapper notesMapper;

    @Override
    public List<Notes> listNotes() {

        return notesMapper.listNotes();
    }

    public void addNotes(String notesInfo){
        Notes notes = parseToNotes(notesInfo);
        notesMapper.addNotes(notes);
    }

    private Notes parseToNotes(String notesInfo) {
        Gson gson = new Gson();
        Map notesInfoM = new HashMap<String, String>();
        notesInfoM = gson.fromJson(notesInfo, notesInfoM.getClass());
        if(notesInfoM.containsKey("title") && notesInfoM.containsKey("description") && notesInfoM.containsKey("text")){
            Notes notes = new Notes();
            notes.setTitle((String) notesInfoM.get("title"));
            notes.setDescription((String) notesInfoM.get("description"));
            notes.setText((String) notesInfoM.get("text"));
            notes.setCreateTime(new Date());
            return notes;
        }else{
            return null;
        }
    }
}