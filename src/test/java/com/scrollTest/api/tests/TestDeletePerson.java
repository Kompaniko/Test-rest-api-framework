package com.scrollTest.api.tests;

import helpers.PersonServiceHelper;
import model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestDeletePerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){

        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testDeletePerson() {

        personServiceHelper.deletePerson(3);
    }

}
