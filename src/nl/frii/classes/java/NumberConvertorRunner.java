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

import nl.frii.classes.java.NumberSystemConverter.NumberSystem;

/**
 *
 * @author Thomas Boose
 */
public class NumberConvertorRunner {
    
    public static void main (String[] args) throws Exception {
        NumberSystemConverter lt2 = new NumberSystemConverter(NumberSystem.BINARY);
        NumberSystemConverter lt8 = new NumberSystemConverter(NumberSystem.OCTAL);
        NumberSystemConverter lt16 = new NumberSystemConverter(NumberSystem.HEXADECIMAL);
        NumberSystemConverter lt3 = new NumberSystemConverter(NumberSystem.TERNATE);
        
        System.out.println( lt2.fromString("00010100"));
        System.out.println( lt8.fromString("12347"));
        System.out.println( lt16.fromString("Af"));
        System.out.println( lt3.fromString("111"));
        
    }
}
