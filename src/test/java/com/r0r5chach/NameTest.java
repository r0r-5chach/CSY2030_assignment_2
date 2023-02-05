package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Name;
/**
 * Class that defines the test for com.r0r5chach.competitor.Name
 * @author r0r5chach
 */
public class NameTest {
    /**
     * Tests Name.Name(String, String)
     */
    @Test
    public void nameFNameLNameTest() {
        Name n = new Name("Joshua", "Perry");
        assertEquals("Joshua", n.getFirstName());
        assertEquals("", n.getMiddleName());
        assertEquals("Perry", n.getLastName());
    }
    /**
     * Tests Name.Name(String, String, String)
     */
    @Test
    public void nameFNameMNameLNameTest() {
        Name n = new Name("Joshua", "Luke", "Perry");
        assertEquals("Joshua", n.getFirstName());
        assertEquals("Luke", n.getMiddleName());
        assertEquals("Perry", n.getLastName());
    }
    /**
     * Tests Name.Name(String)
     */
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
    /**
     * Tests Name.setFirstName(String)
     */
    @Test
    public void nameSetFirstNameTest() {
        Name n = new Name("Joshua Luke Perry");

        n.setFirstName("Bradley");
        assertEquals("Bradley", n.getFirstName());
    }
    /**
     * Tests Name.setLastName(String)
     */
    @Test
    public void nameSetLastNameTest() {
        Name n = new Name("Joshua Luke Perry");

        n.setLastName("Gordon-Taylor");
        assertEquals("Gordon-Taylor", n.getLastName());
    }
    /**
     * Tests Name.getFistAndLastName()
     */
    @Test
    public void nameGetFirstAndLastNameTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Joshua Perry", n.getFirstAndLastName());
    }
    /**
     * Tests Name.getLastCommaFirst()
     */
    @Test
    public void nameGetLastCommaFirstTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Perry, Joshua", n.getLastCommaFirst());
    }
    /**
     * Tests Name.getFullName()
     */
    @Test
    public void nameGetFullNameTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("Joshua Luke Perry", n.getFullName());
        n.setMiddleName("");
        assertEquals("Joshua Perry", n.getFullName());
    }
    /**
     * Tests Name.getInitials()
     */
    @Test
    public void nameGetInitialsTest() {
        Name n = new Name("Joshua Luke Perry");
        assertEquals("JLP", n.getInitials());
        n.setMiddleName("");
        assertEquals("JP", n.getInitials());
    }
    /**
     * Tests Name.getFirstName()
     */
    @Test
    public void nameGetFirstNameTest() {
        //Already tested in nameFNameLNameTest()
    }
    /**
     * Tests Name.getMiddleName()
     */
    @Test
    public void nameGetMiddleNameTest() {
        //Already tested in nameFNameMNameLNameTest()
    }
    /**
     * Tests Name.getLastName()
     */
    @Test
    public void nameGetLastNameTest() {
        //Already tested in nameFullNameTest()
    }
    /**
     * Tests Name.setMiddleName(String)
     */
    @Test
    public void nameSetMiddleNameTest() {
        //Already tested in nameGetFullNameTest()
    }
}