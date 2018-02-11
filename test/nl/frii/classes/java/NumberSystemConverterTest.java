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
    NumberSystemConverter myTernateConverter = new NumberSystemConverter(NumberSystem.TERNATE);

    @Test
    public void TestConvert0ToBinNumber() throws Exception {
        assertEquals("0 bin should be 0 dec", 0l, myBinConverter.fromStringToLong("0"));
    }

    @Test
    public void TestConvert01ToBinNumber() throws Exception {
        assertEquals("01 bin should be 1 dec", 1, myBinConverter.fromStringToLong("01"));
    }

    @Test
    public void TestConvert001ToBinNumber() throws Exception {
        assertEquals("001 bin should be 1 dec", 1, myBinConverter.fromStringToLong("001"));
    }

    @Test
    public void TestConvert10ToBinNumber() throws Exception {
        assertEquals("10 bin should be 2 dec", 2, myBinConverter.fromStringToLong("10"));
    }

        @Test
    public void TestConvert0ToDecNumber() throws Exception {
        assertEquals("0 should be 0", 0, myDecimalConverter.fromStringToLong("0"));
    }

    @Test
    public void TestConvert01ToDecNumber() throws Exception {
        assertEquals("01 should be 1", 1, myDecimalConverter.fromStringToLong("01"));
    }

    @Test
    public void TestConvert001ToDecNumber() throws Exception {
        assertEquals("001 should be 1", 1, myDecimalConverter.fromStringToLong("001"));
    }

    @Test
    public void TestConvert10ToDecNumber() throws Exception {
        assertEquals("Decimal 10 should be 10", 10, myDecimalConverter.fromStringToLong("10"));
    }

    @Test
    public void TestConvert9234837635ToDecNumber() throws Exception {
        assertEquals("9234837635 should be 9234837635", 9234837635l, myDecimalConverter.fromStringToLong("9234837635"));
    }
    
    @Test
    public void TestConvert01221ToDecNumber() throws Exception {
        assertEquals("01221 ter should be 52 dec", 52, myTernateConverter.fromStringToLong("01221"));
    }
    
    @Test
    public void TestConvertBin101_01ToDecNumber() throws Exception {
        assertEquals("101.01 should be approx 5.25", 5.25, myBinConverter.fromStringToDouble("101.01"),0.000001);
    }
    
    @Test
    public void TestConvertTer1221_1ToDecNumber() throws Exception {
        assertEquals("1221,1 ter should be 52.33333", 52.333333333333, myTernateConverter.fromStringToDouble("1221,1"),0.000001);
    }
    

    
}
