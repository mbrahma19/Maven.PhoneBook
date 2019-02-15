package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private static TreeMap<String, ArrayList> phonebook = new TreeMap<String, ArrayList>();

    public PhoneBook(){

    }

    private Boolean hasEntry(String name){
        if(phonebook.containsKey(name)){
            return true;
        }else {
            return false;
        }
    }

    public void newPhoneBookEntry(String name, ArrayList<String> phoneNumbers){

        if(!hasEntry(name)){
            phonebook.put(name, phoneNumbers);
        }else {
            System.out.println("Cannot add a new entry for " + name + ". Entry already exists");
        }
    }

    public void removeRecord(String name){
        if(hasEntry(name)){
            phonebook.remove(name);
        }else {
            System.out.println("Cannot remove an entry that does not exist.");
        }
    }

    private ArrayList<String> getArrayListFor(String name){
        return phonebook.get(name);
    }

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


    public String lookup(String name){
        return String.format("The phone numbers for %s are %s", name, getArrayListFor(name));
    }

    public String reverseLookup(String phoneNumber){

        return null;

    }

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

    public String listNamesAndNumbers(){
        String finalList = "";
        return finalList;
    }

    public String listNames(){

        return null;
    }

    public void display(){
        System.out.println(listNamesAndNumbers());
    }


}
