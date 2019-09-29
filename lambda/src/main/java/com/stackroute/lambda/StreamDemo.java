package com.stackroute.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String args[]){
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Shekars");
        memberNames.add("Aman");
        memberNames.add("ahanas");
        memberNames.add("Sharukh");
        memberNames.add("Salmon");
        memberNames.add("Hana");
        memberNames.add("Lokesh");
        Stream<String> stream=memberNames.stream();

        List <String> nameList= stream.filter(listitem->listitem.startsWith("A")).collect(Collectors.toList());
        System.out.println(nameList);
        System.out.println("----------ALL CAPS------------");
        memberNames.stream().forEach(item-> System.out.println(item.toUpperCase()));
        System.out.println("---------ends with S----------");
        memberNames.stream().map((item)->item.toUpperCase())
                            .filter((item)->item.startsWith("S"))
                            .sorted()
                            .forEach((item)-> System.out.println(item));
        System.out.println("----------Starts with H----------");
        memberNames.stream()
                .filter((item)->item.endsWith("h"))
                .sorted()
                .forEach((item)-> System.out.println(item));
       String s= memberNames.stream()
               .filter(item->item.startsWith("S"))
               .findFirst()
               .get();
        System.out.println("first name starting with s :" + s);
        List <Integer> evenNum= new ArrayList<>();
        evenNum.add(19);
        evenNum.add(42);
        evenNum.add(22);
        evenNum.add(24);
        evenNum.add(15);
        evenNum.add(21);
        evenNum.add(10);
        evenNum.add(2);
        System.out.println("-----even Numbers in List-----");
        evenNum.stream()
                .filter(n-> n%2==0)
                .forEach(n-> System.out.println(n));

    }
}
