/*
Giacomo Usai 14/02/20

Input:
-totalCrates, an int representing the total number of packing crates in the facility (N)
-allLocations, a list where each element consists of a pair of int representing the x, y coordinates of the packing crates;
-truckCapacity, an int representing the numb of packing crates that will be moved to the new facility (M)
Output:
-return a list of int where each element of the list represents the c,y coordinates of the packing crates the will be moved
to the new facility.
Note: You begin at the truck's location [0, 0].
The distance of the truck from a warehouse location (x,y) is the square root of x^2+y^2.
If there are ties then return any locations as long as you satisfy returning M points.

 */

import java.util.ArrayList;
import java.util.Collections;

public class Amzn_DistanceTruck {



    public static void main(String [] args){

        final int totalCrates = 3;
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(3);
        a2.add(4);
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(-1);
        // Here aList is an ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> allLocations = new ArrayList<ArrayList<Integer> >(totalCrates);
        allLocations.add(a1);
        allLocations.add(a2);
        allLocations.add(a3);
        System.out.println("MAIN: allLocation= " + allLocations);

        int truckCapacity = 2;
        System.out.println("MAIN: SOLUTION= " +
        distance(allLocations, totalCrates, truckCapacity)
        );

    }


    public static ArrayList<ArrayList<Integer>> distance(ArrayList<ArrayList<Integer>> allLocations, int totalCrates, int truckCapacity) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer> >(truckCapacity);
        ArrayList<Float> dist = new ArrayList<>(totalCrates);

        if(truckCapacity <= 0) return solution;
        //find the dist for every location
        for (int i = 0; i < totalCrates; i++) {
            dist.add((float) Math.sqrt(Math.pow(allLocations.get(i).get(0), 2) + Math.pow(allLocations.get(i).get(1), 2)));
            System.out.println("dist[" + i + "]=" + dist.get(i));
        }

        //pick up the best location
        for (int i = 0; i < truckCapacity; i++) {
            solution.add(allLocations.get(dist.indexOf(Collections.min(dist))));
            dist.remove(Collections.min(dist));
        }

        return solution;
    }

}
