package com.stackroute.springbootneo4jexample1.listener;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.dao.UserDao; //repository
//import com.stackroute.model.DAOUser;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class KafkaConsumer {
    @Autowired
    UserRepository userRepository;
   User user;
    @KafkaListener(topics = "kafka-Example4")
    public void consume(String message) throws IOException {
        System.out.println(message);
        //User obj = new ObjectMapper().readValue(user, User.class);
       // System.out.println(bcryptEncoder.encode(obj.getPassword()));
        //obj.setPassword(bcryptEncoder.encode(obj.getPassword()));
       // userRepository.save(obj);
    }
}