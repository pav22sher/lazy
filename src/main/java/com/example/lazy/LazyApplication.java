package com.example.lazy;

import com.example.lazy.dao.ManRepository;
import com.example.lazy.model.Address;
import com.example.lazy.model.Man;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LazyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyApplication.class, args);
    }

    @Autowired
    private ManRepository manRepository;

    @PostConstruct
    private void init() {
        //initDb();

        //LazyInitializationException
        //Man man1 = manRepository.getEntityById1(11L);
        //Address address1 = man1.getAddress();
        //System.out.println(address1);

        //JOIN FETCH
        //Man man2 = manRepository.getEntityById2(11L);
        //Address address2 = man2.getAddress();
        //System.out.println(address2);

        //Entity Graph
        //Man man3 = manRepository.getEntityById3(11L);
        //Address address3 = man3.getAddress();
        //System.out.println(address3);
    }


    private void initDb() {
        manRepository.deleteAll();
        List<Man> mans = new ArrayList<>();

        Man man1 = new Man();
        man1.setFirstName("FirstName1");
        man1.setLastName("LastName1");
        Address address1 = new Address();
        address1.setCity("City1");
        address1.setStreet("Street1");
        man1.setAddress(address1);
        mans.add(man1);

        Man man2 = new Man();
        man2.setFirstName("FirstName2");
        man2.setLastName("LastName2");
        Address address2 = new Address();
        address2.setCity("City2");
        address2.setStreet("Street2");
        man2.setAddress(address2);
        mans.add(man2);

        manRepository.saveAllAndFlush(mans);
    }

}
