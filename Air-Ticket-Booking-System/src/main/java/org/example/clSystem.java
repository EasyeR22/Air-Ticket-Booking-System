package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
public class clSystem {
    String destination,departure;
    Map<String,Integer> times = new HashMap<>();

    public clSystem(String destination,String departure,Map<String,Integer> times){
        this.destination = destination;
        this.departure = departure;
        this.times = times;
    }
}
