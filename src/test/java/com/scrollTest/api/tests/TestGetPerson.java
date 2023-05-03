package com.scrollTest.api.tests;

import helpers.PersonServiceHelper;
import io.qameta.allure.Step;
import model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestGetPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){

        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGetAllPerson(){

        List<Person> personList = personServiceHelper.getAllPerson();
        assertNotNull(personList,"Person list is not empty");
        assertFalse(personList.isEmpty(),"Person list is not True");
    }
}
