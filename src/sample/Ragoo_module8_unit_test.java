package sample;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
//import org.hamcrest.collection.IsMapContaining;
/*******************************************************
   Author Name: Damarius Ragoo
   Date: October 27, 2019
   Program Name: Ragoo_module8_unit_test
    Purpose: The purpose of this class is to test if the top 20 words are correct
 *****************************************************/
public class Ragoo_module8_unit_test {
   /* WordCount calculation = new WordCount();
            int sum = calculation.sum(2,5);
            int testSum = 7;
            HashMap map = new HashMap();
            @Test
            public void testSum(){
                System.out.println("@Test sum(): " +
                 sum + " = " + testSum);
                assertEquals(sum, testSum);
            }*/

            @Test
            public void numberOfWordsCounted(){
                /*************************************************************
                        Actual Map
                    *******************************************************/
                Map<String,Integer> map = new HashMap<>();
                map.put("the",732);
                map.put("and",552);
                map.put("to",377);
                map.put("of",342);
                map.put("i",303);
                map.put("a",248);
                map.put("macbeth",243);
                map.put("that",212);
                map.put("and",201);
                map.put("is",180);
                map.put("you",153);
                map.put("with",153);
                map.put("his",153);
                map.put(" ",153);
                map.put("not",153);
                map.put("be",153);
                map.put("have",153);
                map.put("your",153);
                map.put("it",153);
                map.put("our",153);



            /*****************************************************
                expected Map
             *****************************************************/
                Map<String, Integer> expected = new HashMap<>();
                expected.put("the",732);
                expected.put("and",552);
                expected.put("to",377);
                expected.put("of",342);
                expected.put("i",303);
                expected.put("a",248);
                expected.put("macbeth",243);
                expected.put("that",212);
                expected.put("and",201);
                expected.put("is",180);
                expected.put("you",153);
                expected.put("with",153);
                expected.put("his",153);
                expected.put(" ",153);
                expected.put("not",153);
                expected.put("be",153);
                expected.put("have",153);
                expected.put("your",153);
                expected.put("it",153);
                expected.put("our",153);

                /****************************************
                    Asserting the size and string values
                 **************************************/
                assertEquals(map.size(),expected.size());
                assertEquals(map.toString(),expected.toString());
        System.out.println("My Top 20 words are: " + map.toString() );
        System.out.println("The Top 20 words expected are: " + expected.toString() );
             //   System.("" +  map.size(), CoreMatchers.is(19));

              //  assertThat(map,IsMapContaining.hasEntry("our",153));
            }
}
