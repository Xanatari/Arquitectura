package com.ex01.controller;

import com.ex01.dto.Person;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.*;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/services")
public class Controller {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        for (int i = 0; i < 10; i++) {

            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullname("My wonderfull Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalario((person.getAge()*1000000)/3);

            persons.put(id, person);
        }
    }


    @GetMapping(value = "/getAllpersonsXML" , produces = APPLICATION_JSON_VALUE)
    public List<Person> getAllpersonsXML() {
        return new ArrayList<>(persons.values());

    }

    @GetMapping(value = "/getAllpersonsById/{id}" , produces = APPLICATION_JSON_VALUE)
    public Person getAllpersonsJsonId(@PathVariable("id" ) int id) {
        return persons.get(id);

    }

    @GetMapping(value = "/getSalaryById/{id}" , produces = APPLICATION_JSON_VALUE)
    public float getSalaryJsonId(@PathVariable("id" ) int id) {
        return persons.get(id).getSalario();

    }


    @PostMapping(value = "/savePerson" , produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Person setNewPerson(@RequestBody  Person person) {
        return persons.put(person.getId(), person);

    }
}
