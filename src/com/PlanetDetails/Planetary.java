package com.PlanetDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Planetary {
	
	 String planetname;
     List<String> surfaceGasses;
     int numberOfMoons;
     boolean planethasRings;

    public Planetary(String planetname, List<String> surfaceGasses, int numberOfMoons, boolean planethasRings) {
        this.planetname = planetname;
        this.surfaceGasses = surfaceGasses;
        this.numberOfMoons = numberOfMoons;
        this.planethasRings = planethasRings;
    }

    //method to retrieve count of moons of all planets having rings 
    public static int countOfMoons(List<Planetary> planets)
    {
    	int totalmoons= 0; 
    	for (Planetary planet : planets) {
    		if ( planet.planethasRings)
    		{
    			totalmoons+= planet.numberOfMoons;
    		}
    	}
    	return totalmoons;
    }
  //method to retrieve the gas that is found on maximum planets
    
    public static String getCommonGas (List<Planetary> planets)
    {
    	Map<String, Integer> gasCount = new HashMap<>();
    	 for (Planetary planet : planets) {
             for (String gas : planet.surfaceGasses) {
                 gasCount.put(gas, gasCount.getOrDefault(gas, 0) + 1);
             }
         }

         String mostCommonGas = null;
         int maxOccurrences = 0;

         for (Map.Entry<String, Integer> entry : gasCount.entrySet()) {
             if (entry.getValue() > maxOccurrences) {
                 mostCommonGas = entry.getKey();
                 maxOccurrences = entry.getValue();
             }
         }

         return mostCommonGas;
     }

     public static void main(String[] args) {
         List<Planetary> planets = new ArrayList<>();
         planets.add(new Planetary("Mercury", List.of(), 0, false));
         planets.add(new Planetary("Venus", List.of("Carbon dioxide", "Nitrogen"), 0, false));
         planets.add(new Planetary("Earth", List.of("Nitrogen", "Oxygen"), 1, false));
         planets.add(new Planetary("Jupiter", List.of("Hydrogen", "Helium"), 79, true));
         planets.add(new Planetary("Saturn", List.of("Hydrogen", "Helium"), 83, true));
         planets.add(new Planetary("Uranus", List.of("Hydrogen", "Helium", "Methane"), 27, true));
         
         int totalMoonsWithRings = countOfMoons(planets);
         System.out.println("Total moons of planets with rings: " + totalMoonsWithRings);

         String mostCommonGas = getCommonGas(planets);
         System.out.println("The gas found on maximum planets is: " + mostCommonGas);
     }
    	
    }
    