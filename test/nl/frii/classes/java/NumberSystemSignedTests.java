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

import static org.junit.Assert.*;
import nl.frii.classes.java.NumberSystemConverter.NumberSystem;

/**
 *
 * @author thomas
 */
public class NumberSystemSignedTests {
    
NumberSystemConverter myBinConverter = new NumberSystemConverter(NumberSystem.BINARY);

    @Test
    public void testSignedBinairyNumber() throws Exception {
        assertEquals("-1010 bin should be -10.",-10, myBinConverter.fromStringToLong("-1010"));
    }
}
