package com.ckr.springbootjpa;

import com.ckr.springbootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }


    //Model attribute at method level
    @ModelAttribute
    public void modelData(Model m){
        m.addAttribute("name", "Students");
    }



    @GetMapping("getStudents")
    public String getStudents(Model m){
      m.addAttribute("result", repo.findAll());
        return "showAliens";
    }

    @GetMapping("getStudentByID")
    public String getStudentByID(@RequestParam int sid, Model m){
      m.addAttribute("result", repo.getOne(sid));
        return "showAliens";
    }

    @GetMapping("getStudentByName")
    public String getStudentByName(@RequestParam String sname, Model m){
        m.addAttribute("result", repo.find(sname));
        return "showAliens";
    }

    @PostMapping("addStudent")
    public String addStudent(@ModelAttribute Alien a)
    {
        repo.save(a);
        return "result";
    }
}
