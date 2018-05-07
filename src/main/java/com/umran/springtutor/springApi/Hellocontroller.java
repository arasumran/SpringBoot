package com.umran.springtutor.springApi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.List;


@RestController
public class Hellocontroller {
    @Autowired
    private CycleService cycleservice;


    @RequestMapping(value = {"/", "/home"})
    public String home()
    {
        return "You Are In Home Page";
    }


    @RequestMapping("/get-cycle")
    public List<CycleDecs> getAllCycleDesc()

    {
        return cycleservice.getTop();

    }
    @RequestMapping("/get-cycle/{id}")
    public CycleDecs getByid(@PathVariable("id") int id)
    {
        return cycleservice.getById(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/get-cycle")
    public void addCycle(@RequestBody CycleDecs cycledesc)
    {
        ObjectMapper  mapper = new ObjectMapper();

        cycleservice.addCycle(cycledesc);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/get-cycle/{id}")
    public void updateCycle(@RequestBody CycleDecs cycledesc, @PathVariable int id)
    {

        cycleservice.updateCycle(id, cycledesc);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "get-cycle/{id}")
    public void deleteCycle(@PathVariable  int id)
    {
        cycleservice.deleteCycle(id);
    }

}
