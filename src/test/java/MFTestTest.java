import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MFTestTest {

    MFTest mfTest = new MFTest();

    @Test
    public void emptyArrayForEmptyString(){
        Object[] topThreeWords = mfTest.topThreeWords("");
        assertThat(topThreeWords.length, is(0));
    }

    @Test
    public void inputContainsOnlySpecialChar(){
        Object[] topThreeWords = mfTest.topThreeWords("//-;:)");
        assertThat(topThreeWords.length, is(0));
    }
    @Test //Test assumption says word is string of letters (A to Z)
    public void inputContainsOnlyNumbers(){
        Object[] topThreeWords = mfTest.topThreeWords("//-;:)");
        assertThat(topThreeWords.length, is(0));
    }

    @Test
    public void inputContainsOneWord(){
        Object[]  topThreeWords = mfTest.topThreeWords("hi");
        assertThat(topThreeWords.length, is(1));
    }

    @Test
    public void inputContainsTwoWords(){
        Object[]  topThreeWords = mfTest.topThreeWords("hi bye");
        assertThat(topThreeWords.length, is(2));
    }

    @Test
    public void inputContainsTwoSameWords(){
        Object[]  topThreeWords = mfTest.topThreeWords("hi hi");
        assertThat(topThreeWords.length, is(1));
    }
    @Test
    public void inputContainsTwoSameWordsAndNumbers(){
        Object[]  topThreeWords = mfTest.topThreeWords("hi hi 123 345 hi");
        assertThat(topThreeWords.length, is(1));
    }

    @Test
    public void inputContainsNumbers(){
        Object[]  topThreeWords = mfTest.topThreeWords("123 345 789");
        assertThat(topThreeWords.length, is(0));
    }

    @Test
    public void inputContainsTwoSameWordsWithSpecialChar(){
        Object[]  topThreeWords = mfTest.topThreeWords("hi hi:");
        assertThat(topThreeWords.length, is(1));
    }

    @Test
    public void inputContainsTwoSameWordsWithApostrophes(){
        Object[]  topThreeWords = mfTest.topThreeWords("hi hi'");
        assertThat(topThreeWords.length, is(2));
        assertTrue(Arrays.asList(topThreeWords).contains("hi'"));
        assertTrue(Arrays.asList(topThreeWords).contains("hi"));
    }

    @Test
    public void testInputOne(){


        String input = "In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance " +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                "coursing. An olla of rather more beef than mutton, a salad on most" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                "on Sundays, made away with three-quarters of his income.";

        Object[] actual = mfTest.topThreeWords(input);
        Object[] expected = {"a", "of", "on"};

        assertThat(actual.length, is(3));
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testInputTwo(){

        String input = "e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e";

        Object[] actual = mfTest.topThreeWords(input);
        Object[] expected = {"e", "ddd", "aa"};

        assertThat(actual.length, is(3));
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testInputThree(){

        String input = " //wont won't won't";

        Object[] actual = mfTest.topThreeWords(input);
        Object[] expected = {"won't", "wont"};

        assertThat(actual.length, is(2));
        assertArrayEquals(actual, expected);
    }


    @Test
    public void testLargerInput(){


        String input = "In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance " +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                "coursing. An olla of rather more beef than mutton, a salad on most" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                "on Sundays, made away with three-quarters of his income " +
                "In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance " +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                "coursing. An olla of rather more beef than mutton, a salad on most" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                "on Sundays, made away with three-quarters of his income " +
                "In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance " +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                "coursing. An olla of rather more beef than mutton, a salad on most" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                "on Sundays, made away with three-quarters of his income " +
                "In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance " +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                "coursing. An olla of rather more beef than mutton, a salad on most" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                "on Sundays, made away with three-quarters of his income "+
                "aa aa aa aa aa aa aa aa b b b b b b b b b c c c c c c c c c c c c c c c c c c c c";

                Object[] actual = mfTest.topThreeWords(input);
        Object[] expected = {"a", "of", "c"};

        assertThat(actual.length, is(3));
        assertArrayEquals(expected, actual);
    }
}
