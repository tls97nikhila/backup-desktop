package com.stackroute.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemoClass {

        public static void main(String args[]){
            List <Employee> list= new ArrayList<>();

         list.add(new Employee(12,"Sai","Cauveri"));
         list.add  ( new Employee(13,"Sri","Cabil"));
          list.add  ( new Employee(17,"Satya","David"));
            list.add (new Employee(22,"Saandy","Mittal"));
            list.add (new Employee(42,"Suketh","Bisha"));
        list.sort((Employee e1,Employee e2)-> e1.getLastName().compareTo(e2.getLastName()));

        System.out.println(list);
            Stream<Employee> stream=list.stream();
            List <Employee> nameList= stream.filter(listitem->listitem.getLastName().startsWith("C")).collect(Collectors.toList());
            System.out.println("Names with last name staring with C");
            System.out.println(nameList);

        }

}
