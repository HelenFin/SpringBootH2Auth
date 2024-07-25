package org.example.service;

import org.example.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    public NoteService() {
        add("Note:", "The Note about my plans");
        add("Note:", "The Note about relationships");
        add("Note:", "The Note about my dreams");
    }

    public Note add(String title, String content) {
        long id = random.nextLong();
        while (notes.containsKey(id) || id < 0) {
            id = random.nextLong();
        }
        Note note = new Note(id, title, content);
        notes.put(id, note);
        return note;
    }


    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = random.nextLong();
        while (notes.containsKey(id) || id < 0) {
            id = random.nextLong();
        }
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        notes.remove(id);
    }

    public void update(Note note) {
        notes.put(note.getId(), note);
    }

    public Note getById(long id) {
        return notes.get(id);
    }
}

