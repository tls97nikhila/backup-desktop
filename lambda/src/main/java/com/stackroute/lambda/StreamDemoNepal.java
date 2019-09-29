package com.stackroute.lambda;

import java.util.ArrayList;
import java.util.List;

public class StreamDemoNepal {

        public static void main(String args[]) {

            List<String> places = new ArrayList<>(); //list for taking places

            places.add("Nepal, Kathmandu");
            places.add("Nepal, Pokhara");
            places.add("India, Delhi");
            places.add("USA, New York");
            places.add("Africa, Nigeria");

            System.out.println("\nThe places in Nepal are: \n");

            places.stream()    //prints the places in Nepal
                    .filter((p) -> p.startsWith("Nepal"))
                    .forEach((p) -> System.out.println(p.substring(p.indexOf(",")+2)));

        }

}

