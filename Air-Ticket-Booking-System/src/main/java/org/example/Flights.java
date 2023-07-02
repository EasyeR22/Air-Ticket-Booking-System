package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*
Almaty -> Astana: (1.5 hours)
  Every day (5:00 12k, 8:00 12k, 11:00 12k, 15:00 15k, 20:00 20k)

 Astana -> Almaty:
 	Every day (7:00 12k, 10:00 12k, 13:00 15k, 17:00 15k, 22:00 20k)

 */
public class Flights {
    Map<String, Integer> fl1 = new HashMap<String, Integer>(){{
        put("05:00",12000);
        put("08:00",12000);
        put("11:00",12000);
        put("15:00",15000);
        put("20:00",20000);
    }};
    Map<String, Integer> fl2 = new HashMap<String, Integer>(){{
        put("07:00",12000);
        put("10:00",12000);
        put("13:00",15000);
        put("17:00",15000);
        put("22:00",20000);
    }};

    clSystem flight1 = new clSystem("Almaty","Astana",fl1);
    clSystem flight2 = new clSystem("Astana","Almaty",fl2);

    ArrayList<clSystem> flightss = new ArrayList<>();
    public void addFlights(){
        flightss.add(flight1);
        flightss.add(flight2);
    }
}
