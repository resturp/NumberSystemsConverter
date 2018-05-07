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

/**
 * Number system converter is a class that can be instantiated into a converter
 * that will convert from a String of digits into a long number based on the
 * specified number system
 *
 * @author Thomas Boose
 */
public class NumberSystemConverter {

    private NumberSystem ts;

    /**
     * Enum: enumeration of different number systems
     */
    public enum NumberSystem {
        BINARY(2),
        TERNATE(3),
        OCTAL(8),
        DECIMAL(10),
        HEXADECIMAL(16);

        private int numDigit;

        private NumberSystem(int digits) {
            this.numDigit = digits;
        }
    }

    public NumberSystemConverter(NumberSystem ts) {
        this.ts = ts;
    }

    /**
     * This method converts a String of digits to a long. This conversion is
     * based on the number system selected at instantiation.
     *
     * @param woord The word to convert
     *
     * @return The Long value
     *
     * @throws Exception If a digit is not valid within the Number system.
     */
    public long fromStringToLong(String woord) throws Exception {
        long value = 0;
        int index = 1;
        char[] mijnWoord = woord.toCharArray();

        for (char c : mijnWoord) {
            // Number systems with more then 10 digits
            // use alfabetic characters starting at A (= 10)
            // char 'a' > char 'A'.
            // so.. first convert 'a' and above to '9' + the surplus
            if (c >= 'a') {
                c = (char) (c + '9' + 1 - 'a');
            }
            // after that convert 'A' and above  to '9' + the surplus
            if (c >= 'A') {
                c = (char) (c + '9' + 1 - 'A');
            }

            // check if the digit is valid for this number system
            if (c >= '0' && c < '0' + ts.numDigit) {
                value = value * ts.numDigit;
                value = value + (c - '0');
            } else {
                throw new Exception("Illegal character in numeric string");
            }
        }
        return value;
    }
    
    /**
     * 
     * Static variant of the fromStringToLong method
     * 
     * @param word
     * @param ns
     * @return 
     *  the long integer value of a String, word in a given number system ns.
     * 
     * @throws Exception 
     *   When the string contains any char not valid as a digit given th ns.
     */
    public static long fromStringToLong (String word, NumberSystem ns) throws Exception {
        NumberSystemConverter nsc = new NumberSystemConverter(ns);
        return nsc.fromStringToLong(word);
    }

    /**
     * This method converts a String of digits and 0 or 1 decimal sign to a
     * double value. The conversion is based on the number system selected at
     * instantiation. Use a dot . or comma , for decimal separation,
     *
     * @param woord The word to convert
     *
     * @return The Double value
     *
     * @throws Exception If a digit is not valid within the Number system.
     */
    public double fromStringToDouble(String word) throws Exception {
        String[] parts = word.split("\\,|\\.");
        double value = fromStringToLong(parts[0]);
        if (parts.length > 1) {
            double unit = Math.pow(ts.numDigit, -1 * parts[1].length());
            value += unit * fromStringToLong(parts[1]);
        }
        return value;
    }

    /**
     * 
     * Static variant of the fromStringToDouble method
     * 
     * @param word
     * @param ns
     * @return 
     *  the double value of a String, word in a given number system ns.
     * 
     * @throws Exception 
     *   When the string contains any char not valid as a digit given th ns.
     */
    public static double fromStringToDouble (String word, NumberSystem ns) throws Exception {
        NumberSystemConverter nsc = new NumberSystemConverter(ns);
        return nsc.fromStringToDouble(word);
    }
    
    /**
     * This method converts a Long to a String of digits. This conversion is
     * based on the number system selected at instantiation.
     *
     * @param woord The long value to convert
     *
     * @return The String representing this value
     *
     */
    public String fromLongToString(long woord) {

        if (woord == 0) {
            return "0";
        } else {
            String value = "";
            while (woord > 0) {
                char nc;
                nc = (char) ('0' + (char) woord % ts.numDigit);

                if (nc > '9') {
                    nc = (char) ('A' - ':' + nc);
                }
                value = "" + nc + value;
                woord = woord / ts.numDigit;
            }
            return value;
        }

    }
    
     /**
     * 
     * Static variant of the fromLongToString method
     * 
     * @param word
     * @param ns
     * @return 
     *  the String representation of a long value given a number system ns.
     * 
     */
    public static String fromLongToString (long word, NumberSystem ns) {
        NumberSystemConverter nsc = new NumberSystemConverter(ns);
        return nsc.fromLongToString(word);
    }
    
    /**
     * This method converts a String of digits and 0 or 1 decimal sign to a
     * double value. The conversion is based on the number system selected at
     * instantiation. Use a dot . or comma , for decimal separation,
     *
     * @param woord The word to convert
     *
     * @return The Double value
     *
     * @throws Exception If a digit is not valid within the Number system.
     */
    public String fromDoubleToString(Double word) {
        String[] arr= String.valueOf(word).split("\\.");
        
        String toReturn = fromLongToString(Long.valueOf(arr[0])) + ".";
        word = word - Math.floor(word); 
         
        while (word > 0) {
            word = word *  ts.numDigit;
            toReturn += String.valueOf(word).split("\\.")[0];
            word = word - Math.floor(word);    
        }
        return toReturn;
    }
    
     /**
     * 
     * Static variant of the fromDoubleToString method
     * 
     * @param word
     * @param ns
     * @return 
     *  the String representation of a long value given a number system ns.
     * 
     */
    public static String fromDoubleToString (double word, NumberSystem ns) {
        NumberSystemConverter nsc = new NumberSystemConverter(ns);
        return nsc.fromDoubleToString(word);
    }

}
