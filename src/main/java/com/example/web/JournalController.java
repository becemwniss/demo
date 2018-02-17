package com.example.web;

import com.example.domain.Journal;
import com.example.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {
    @Autowired
    JournalRepository repo;

    // C commit from develop
//    @RequestMapping("/")
//    public String index(Model model){
//        model.addAttribute("journal", repo.findAll());
//        return "index";
//    }

//    @RequestMapping(value="/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    public @ResponseBody
//    List<Journal> getJournal(){
//        return repo.findAll();
//    }

    //refresh commit
    // A commit form master

    // B commit from master

}
