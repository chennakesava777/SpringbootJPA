package com.ckr.springbootjpa;

import com.ckr.springbootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;


    //@ResponseBody - but now we declared everything into a Rest Controller at class level
    // so no need of this annotation at each method level.
    //produces helps us to speicfy the data type that server going to respond either xml or json so on for client's request
    @GetMapping(path="aliens",produces = {"application/xml"})
    public List<Alien> getAliens(){
        List<Alien> aliens = repo.findAll();
        //int i = 9/0; --- to test the exceptions in logger
        return aliens;
    }


    @GetMapping("alien/{sid}")
    //@ResponseBody
    public Alien getAlien(@PathVariable("sid") int sid){

        Alien alien = repo.findById(sid).orElse(new Alien(0,""));
        return alien;
    }

    //in below method we are using consumes to specify the content type we are going to receive from client to server
    // we can mention this consumes or produces in MediaType.APPLICATION.JSON like this too instead of in "--"
    //@RequestBody helps in converting the content send from client side in any format like json or xml into Java objects
    @PostMapping(path = "alien",consumes = {"application/json"} )
    public Alien gaddAlien(@RequestBody Alien alien){

        repo.save(alien);
        return alien;
    }

}
