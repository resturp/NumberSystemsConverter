/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.frii.classes.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static nl.frii.classes.java.NumberSystemConverter.*;
import nl.frii.classes.java.NumberSystemConverter.*;


/**
 *
 * @author thomas
 */
public class NumberSystemConverterStaticTests {
    
    
    @Test
    public void testStaticMethodCall() {
        assertEquals("we should be able to call the convertor in a static way", "1", fromLongToString(1, NumberSystem.BINARY));
    }
}
