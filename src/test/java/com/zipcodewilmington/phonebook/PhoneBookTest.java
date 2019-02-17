package com.zipcodewilmington.phonebook;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {


    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void removeEntryTest(){
        //given
        String name = "Abraham Lincoln";
        String phoneNumber = "345-555-0000";
        ArrayList<String> phoneNumberList = new ArrayList<String>();
        phoneNumberList.add(phoneNumber);
        PhoneBook testPhoneBook = new PhoneBook();
        //when
        testPhoneBook.newPhoneBookEntry(name, phoneNumberList);
        testPhoneBook.removeRecord(name);
        String actual = testPhoneBook.lookup(name);

        //then
        Assert.assertEquals(null,actual);

    }

    @Test
    public void addNewNumberTest(){
        //given
        String name = "Brandon James";
        String phoneNumber = "614-222-3434";
        String phoneNumber2 = "302-111-2222";
        ArrayList<String> phoneNumberList = new ArrayList<String>();
        phoneNumberList.add(phoneNumber);
        phoneNumberList.add(phoneNumber2);
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.newPhoneBookEntry(name, phoneNumberList);
        String expected = "[614-222-3434, 302-111-2222, 561-561-5615]";
        //when
        testPhoneBook.addNewNumber(name,"561-561-5615");
        String actual = testPhoneBook.lookup(name);

        //then
        Assert.assertEquals(expected,actual);
        testPhoneBook.removeRecord(name);
    }

    @Test
    public void removeNumberTest(){
        //given
        String name = "Brandon James";
        String expected = "[614-222-3434, 302-111-2222]";

        String phoneNumber = "614-222-3434";
        String phoneNumber2 = "302-111-2222";
        String phoneNumber3 = "561-561-5615";

        ArrayList<String> phoneNumberList = new ArrayList<String>();
        phoneNumberList.add(phoneNumber);
        phoneNumberList.add(phoneNumber2);
        phoneNumberList.add(phoneNumber3);

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.newPhoneBookEntry(name, phoneNumberList);

        //when
        testPhoneBook.removePhoneNumber(name,"561-561-5615");
        String actual = testPhoneBook.lookup(name);

        //then
        Assert.assertEquals(expected,actual);
        testPhoneBook.removeRecord(name);
    }



    @Test
    public void addNewEntryTest(){
        //given
        String name = "Mridu Brahma";
        String phoneNumber = "302-544-2763";
        String phoneNumber2 = "302-111-2223";
        ArrayList<String> mriduPhoneNumberList = new ArrayList<String>();
        mriduPhoneNumberList.add(phoneNumber);
        mriduPhoneNumberList.add(phoneNumber2);
        PhoneBook testPhoneBook = new PhoneBook();

        //when
        testPhoneBook.newPhoneBookEntry(name, mriduPhoneNumberList);
        String actual = testPhoneBook.lookup(name);

        //then
        Assert.assertEquals("[302-544-2763, 302-111-2223]",actual);
        testPhoneBook.removeRecord(name);
    }

    @Test
    public void reverseLookUpTest(){
        //given
        String expected = "Marshilla Brahma";
        String name = "Marshilla Brahma";
        String phoneNumber = "302-544-2763";
        ArrayList<String> phoneNumberList = new ArrayList<String>();
        phoneNumberList.add(phoneNumber);
        PhoneBook testPhoneBook = new PhoneBook();

        //when
        testPhoneBook.newPhoneBookEntry(name,phoneNumberList);
        String actual = testPhoneBook.reverseLookup(phoneNumber);

        //then
        Assert.assertEquals(expected,actual);
        testPhoneBook.removeRecord(name);
    }

    @Test
    public void listNamesAndNumbersTest(){
        String expected = "Brandon James [302-111-2222, 614-222-3434]\n" +
                "Marci Brahma [302-544-2763]\n" +
                "Mridu Matera [302-544-2763, 302-111-2223]\n";


        String name = "Brandon James";
        ArrayList<String> number  = new ArrayList<String>();
        number.add("302-111-2222");
        number.add("614-222-3434");

        String name2 = "Mridu Matera";
        ArrayList<String> number2  = new ArrayList<String>();
        number2.add("302-544-2763");
        number2.add("302-111-2223");

        String name3 = "Marci Brahma";
        ArrayList<String> number3  = new ArrayList<String>();
        number3.add("302-544-2763");


        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.newPhoneBookEntry(name,number);
        newPhoneBook.newPhoneBookEntry(name2,number2);
        newPhoneBook.newPhoneBookEntry(name3,number3);

        String actual = newPhoneBook.listNamesAndNumbers();
        newPhoneBook.display();

        Assert.assertEquals(expected, actual);
        newPhoneBook.removeRecord(name);
        newPhoneBook.removeRecord(name2);
        newPhoneBook.removeRecord(name3);
    }

    @Test
    public void listNamesTest(){
        String expected = "Brandon James\n" +
                "Marci Brahma\n" +
                "Mridu Matera\n";


        String name = "Brandon James";
        ArrayList<String> number  = new ArrayList<String>();


        String name2 = "Mridu Matera";
        ArrayList<String> number2  = new ArrayList<String>();

        String name3 = "Marci Brahma";
        ArrayList<String> number3  = new ArrayList<String>();


        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.newPhoneBookEntry(name,number);
        newPhoneBook.newPhoneBookEntry(name2,number2);
        newPhoneBook.newPhoneBookEntry(name3,number3);

        String actual = newPhoneBook.listNames();

        Assert.assertEquals(expected, actual);
        newPhoneBook.removeRecord(name);
        newPhoneBook.removeRecord(name2);
        newPhoneBook.removeRecord(name3);
    }
}



