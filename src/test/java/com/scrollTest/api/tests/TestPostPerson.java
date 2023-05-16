package com.scrollTest.api.tests;

import helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestPostPerson {


    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){

        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPOSTCreatePerson() {

       String id =  personServiceHelper.CreatePerson().jsonPath().getString("id");
       System.out.println(id);
       assertNotNull(id,"Person list is not null");



    }
}
