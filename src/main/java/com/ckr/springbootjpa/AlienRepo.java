package com.ckr.springbootjpa;

import com.ckr.springbootjpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

    //List<Alien> findBySnameOrderBySidDesc(String sname);//DSL - Domain Specific Language the Jpa provides the queries
    //DSL should start with getBy or findBy<Variablename><Condition>

    @Query("from Alien where sname= :name order by sid desc")
    List<Alien> find(@Param("name") String sname); // writing our own queries format
}
