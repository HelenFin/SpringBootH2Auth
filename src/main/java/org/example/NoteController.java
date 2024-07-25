package org.example;

import org.example.entity.Note;
import org.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;


    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll(); // Використовуємо noteService для отримання нотаток
        model.addAttribute("notes", notes);
        return "notes-list";
    }



    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") long id) {
        ModelAndView mav = new ModelAndView("note-edit");
        mav.addObject("note", noteService.getById(id));
        return mav;
    }

    @PostMapping("/edit")
    public String updateNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
