package com.r0r5chach;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Name;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

    @Test
    public void nameTestFNameLName() {
        Name n = new Name("Joshua", "Perry");
        assertEquals("Joshua", n.getFirstName());
        assertEquals("", n.getMiddleName());
        assertEquals("Perry", n.getLastName());
    }

    @Test
    public void nameTestFNameMNameLName() {
        Name n = new Name("Joshua", "Luke", "Perry");
        assertEquals("Joshua", n.getFirstName());
        assertEquals("Luke", n.getMiddleName());
        assertEquals("Perry", n.getLastName());
    }

    @Test
    public void nameFullNameTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Joshua", n.getFirstName());
        assertEquals("Luke", n.getMiddleName());
        assertEquals("Perry", n.getLastName());

        n = new Name("Joshua Perry");
        assertEquals("Joshua", n.getFirstName());
        assertEquals("", n.getMiddleName());
        assertEquals("Perry", n.getLastName());
    }

    @Test
    public void nameSetFirstNameTest() {
        Name n = new Name("Joshua Luke Perry");

        n.setFirstName("Bradley");
        assertEquals("Bradley", n.getFirstName());
    }

    @Test
    public void nameSetLastNameTest() {
        Name n = new Name("Joshua Luke Perry");

        n.setLastName("Gordon-Taylor");
        assertEquals("Gordon-Taylor", n.getLastName());
    }

    @Test
    public void nameGetFirstAndLastNameTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Joshua Perry", n.getFirstAndLastName());
    }

    @Test
    public void nameGetLastCommaFirstTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Perry, Joshua", n.getLastCommaFirst());
    }

    @Test
    public void nameGetFullNameTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Joshua Luke Perry", n.getFullName());
        n.setMiddleName("");
        assertEquals("Joshua Perry", n.getFullName());
    }

    @Test
    public void nameGetInitialsTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("JLP", n.getInitials());
        n.setMiddleName("");
        assertEquals("JP", n.getInitials());
    }


    @Test
    public void nameGetFirstNameTest() {
        //Already tested in nameFNameLNameTest()
    }

    @Test
    public void nameGetMiddleNameTest() {
        //Already tested in nameFNameMNameLNameTest()
    }

    @Test
    public void nameGetLastNameTest() {
        //Already tested in nameFullNameTest()
    }

    @Test
    public void nameSetMiddleNameTest() {
        //Already tested in nameGetFullNameTest()
    }
}
