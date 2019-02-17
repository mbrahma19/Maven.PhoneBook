package com.zipcodewilmington.phonebook;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private static TreeMap<String, ArrayList<String>> phonebook = new TreeMap<String, ArrayList<String>>();

    public PhoneBook() {

    }

    /**
     *
     * @param name
     * @return
     */
    private Boolean hasEntry(String name){
        if(phonebook.containsKey(name)){
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @param name
     * @param phoneNumbers
     */
    public void newPhoneBookEntry(String name, ArrayList<String> phoneNumbers){

        if(hasEntry(name)==false){
            phonebook.put(name, phoneNumbers);
        }else {
            System.out.println("Cannot add a new entry for " + name + ". Entry already exists");
        }
    }

    /**
     *
     * @param name
     */
    public void removeRecord(String name){
        if(hasEntry(name)){
            phonebook.remove(name);
        }else {
            System.out.println("Cannot remove an entry that does not exist.");
        }
    }

    /**
     * Returns the ArrayList related to the inputted key(name) in the phonebook map
     * @param name
     * @return ArrayList<String
     */
    private ArrayList<String> getArrayListFor(String name){
        return phonebook.get(name);
    }

    /**
     * Methods adds a new number to the existing
     * @param name
     * @param phoneNumber
     */
    public void addNewNumber(String name, String phoneNumber){

        if(hasEntry(name)){
            ArrayList<String> previousNumbers = getArrayListFor(name);
            previousNumbers.add(phoneNumber);

            removeRecord(name);

            newPhoneBookEntry(name,previousNumbers);

        }else {
            System.out.println("Cannot add a new number to a name that does not exist. Please add a new entry first.");
        }
    }

    /**
     *
     * @param name
     * @return
     */

    public String lookup(String name){

        if(hasEntry(name)==true) {
            return getArrayListFor(name).toString();
        }else{return null;}
    }

    /**
     *
     * @param phoneNumber
     * @return
     */
    public String reverseLookup(String phoneNumber){
        String result = "";
        Set<Map.Entry<String,ArrayList<String>>> setMap = getSetVersionOfPhonebook();

        for(Map.Entry entry : setMap){
            ArrayList<String> currList = (ArrayList<String>)entry.getValue();
            if (currList.contains(phoneNumber)) {

                result = String.valueOf(entry.getKey());

            }
        }
        return result;
    }

    /**
     *
     * @param name
     * @param phoneNumberToRemove
     */

    public void removePhoneNumber(String name, String phoneNumberToRemove){

        if(hasEntry(name)){
            ArrayList<String> newNumbers = new ArrayList<String>();

            for(String s : getArrayListFor(name)){
                if(!s.equals(phoneNumberToRemove)){
                    newNumbers.add(s);
                }
            }

            removeRecord(name);

            newPhoneBookEntry(name,newNumbers);

        }else {
            System.out.println("Cannot remove a number to a name that does not exist. Please add a new entry first.");
        }

    }

    /**
     *
     * @return
     */

    public String listNamesAndNumbers(){
        String finalList = "";

        Set<Map.Entry<String,ArrayList<String>>> setMap = getSetVersionOfPhonebook();

        for(Map.Entry entry : setMap){
           ArrayList<String> currList = (ArrayList<String>)entry.getValue();
            String currKey = String.valueOf(entry.getKey());
            finalList = finalList + currKey + " " + currList.toString() + "\n";
        }

        return finalList;
    }

    /**
     *
     * @return
     */
    public String listNames(){
        String finalList = "";
        Set<Map.Entry<String,ArrayList<String>>> setMap = getSetVersionOfPhonebook();

        for(Map.Entry entry : setMap){
            String currKey = String.valueOf(entry.getKey());
            finalList = finalList + currKey + "\n";
        }

        return finalList;
    }

    private Set<Map.Entry<String, ArrayList<String>>> getSetVersionOfPhonebook(){
        return phonebook.entrySet();
    }
    /**
     *
     */
    public void display(){
        System.out.println(listNamesAndNumbers());
    }


}
