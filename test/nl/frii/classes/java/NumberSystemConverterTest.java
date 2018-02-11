/*
 * The MIT License
 *
 * Copyright 2017 Thomas Boose.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package nl.frii.classes.java;

import nl.frii.classes.java.NumberSystemConverter.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Start Test project for  
 * @author Thomas Boose
 */
public class NumberSystemConverterTest {

    NumberSystemConverter myBinConverter = new NumberSystemConverter(NumberSystem.BINARY);
    NumberSystemConverter myDecimalConverter = new NumberSystemConverter(NumberSystem.DECIMAL);

    @Test
    public void TestConvert0ToBinNumber() throws Exception {
        assertEquals("0 should be 0", 0l, myBinConverter.fromString("0"));
    }

    @Test
    public void TestConvert01ToBinNumber() throws Exception {
        assertEquals("01 should be 1", 1, myBinConverter.fromString("01"));
    }

    @Test
    public void TestConvert001ToBinNumber() throws Exception {
        assertEquals("001 should be 1", 1, myBinConverter.fromString("001"));
    }

    @Test
    public void TestConvert10ToBinNumber() throws Exception {
        assertEquals("10 should be 2", 2, myBinConverter.fromString("10"));
    }

        @Test
    public void TestConvert0ToDecNumber() throws Exception {
        assertEquals("0 should be 0", 0, myDecimalConverter.fromString("0"));
    }

    @Test
    public void TestConvert01ToDecNumber() throws Exception {
        assertEquals("01 should be 1", 1, myDecimalConverter.fromString("01"));
    }

    @Test
    public void TestConvert001ToDecNumber() throws Exception {
        assertEquals("001 should be 1", 1, myDecimalConverter.fromString("001"));
    }

    @Test
    public void TestConvert10ToDecNumber() throws Exception {
        assertEquals("Decimal 10 should be 10", 10, myDecimalConverter.fromString("10"));
    }

    @Test
    public void TestConvert9234837635ToDecNumber() throws Exception {
        assertEquals("9234837635 should be 9234837635", 9234837635l, myDecimalConverter.fromString("9234837635"));
    }

    
}
