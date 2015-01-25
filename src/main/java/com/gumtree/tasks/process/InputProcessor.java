package com.gumtree.tasks.process;

import com.gumtree.tasks.domain.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sameer on 25/01/2015.
 */
public class InputProcessor {


    public InputProcessor() {

    }

    public List<Person> process(InputStream inputStream) throws IOException {
        List<Person> personList = new ArrayList<Person>();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while((line = in.readLine()) != null) {
            personList.add(createPerson(line));
        }
        return personList;
    }

    private Person createPerson(String line) {
        String[] tokens = line.split(",");
        if(tokens == null || tokens.length != 3) {
          throw new RuntimeException("Invalid Input");
        }
        return new Person(tokens[0], tokens[1], tokens[2]);
    }


}
