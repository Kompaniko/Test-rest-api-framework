package com.scrollTest.api.tests;

import helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

public class TestPatchPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPatchPerson() {

        String id = personServiceHelper.updatePerson(43).jsonPath()
                .getString("id");
        System.out.println(id);
        assertNotNull(id, "Updated");
    }
}
