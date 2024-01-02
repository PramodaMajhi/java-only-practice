package com.cts.project;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyAssignment {
    // this is inner class for our custom sort
    private static class Person {
        String lName;
        String fName;
        String fullName;

        // create a constructor
        public Person(String fName, String lName) {
            this.fName = fName;
            this.lName = lName;
            this.fullName = lName + ", " + fName;
        }
        // generate getter setter


        public String getfName() {
            return fName;
        }

        public String getFullName() {
            return fullName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        // To print Person detail in console
        public String toString() {
            // Returning attributes of Person
            return this.lName + " " + this.fName + " " + " " + fullName;
        }
    }

    // Helper class to sort using comparator
    private static class SortBy implements Comparator<Person> {
        private int sortOption;
        // private List<Person> personList;
        public SortBy(int sortOption){
            this.sortOption = sortOption;
         //   this.orderBy = orderBy;
        }
        /*
        1 - First Name Ascending
        2 - First Name Descending
        3 - Last Name Ascending
        4 - Last Name Descending
        5 - Full Name Ascending
        6 - Full Name Descending
        */
        @Override
        public int compare(Person p1, Person p2) {
            // first name
            if(sortOption == 1){
                return p1.fName.compareTo(p2.fName);
            }else if(sortOption == 2){
                return p2.fName.compareTo(p1.fName);
            }else if(sortOption == 3){
                return p1.lName.compareTo(p2.lName);
            }
            else if(sortOption == 4){
                return p2.lName.compareTo(p1.lName);
            }
            else if(sortOption == 5){
                return p1.fullName.compareTo(p2.fullName);
            }
            else if(sortOption == 6){
                return p2.fullName.compareTo(p1.fullName);
            }else{
                return p1.lName.compareTo(p2.lName);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // File path is passed as parameter
        File file = new File(
                "/Users/pramoda/eclipse-workspace/JavaProject/src/com/cts/project/assignment.txt");
        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;

        List<Person> personList = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            String strs[] = st.split(",");

            String fName = strs[0];
            String lName = strs[1];
            Person person = new Person(fName, lName);
            personList.add(person);
            // we need to call our private function her
        }
        // Available sort options:
        /*
         1 - First Name Ascending
         2 - First Name Descending
         3 - Last Name Ascending
         4 - Last Name Descending
         5 - Full Name Ascending
         6 - Full Name Descending
         */

        //  iterating over entries to print them
//        System.out.println("Before sort");
//        for (int i = 0; i < personList.size(); i++)
//            System.out.println(personList.get(i));
        // Driver code
        Scanner scanner = new Scanner(System.in);
        int sortBy = scanner.nextInt();
        Collections.sort(personList, new SortBy(sortBy));

            //  iterating over entries to print them
            for (int i = 0; i < personList.size(); i++)
                System.out.println(personList.get(i));
    }
}
