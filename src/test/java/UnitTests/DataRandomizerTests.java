package UnitTests;

import Helpers.DataRandomizer;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by james on 2/4/2019.
 */
public class DataRandomizerTests {

    @Test
    public void randomStringLengthTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaUpper, 10);
        Assert.assertTrue("The random string length wasn't 10.", randomString.length() == 10);
    }

    @Test
    public void alphaUpperTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaUpper, 10);
        Assert.assertTrue(org.apache.commons.lang3.StringUtils.isAllUpperCase(randomString));
    }

    @Test
    public void alphaLowerTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaLower, 10);
        Assert.assertTrue(org.apache.commons.lang3.StringUtils.isAllLowerCase(randomString));
    }

    @Test
    public void alphaUpperLowerTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaUpperLower, 10);
        Assert.assertTrue("The random string didn't contain at least 1 lower and 1 uppercase character.", randomString.matches("^(?=.*[a-z])(?=.*[A-Z]).+$"));
    }

    @Test
    public void alphaUpperNumericTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaUpperNumeric, 10);
        Assert.assertTrue("The random string didn't contain only upper and numeric characters.", randomString.matches("^(?=.*[A-Z])(?=.*[0-9]).+$"));
    }

    @Test
    public void alphaLowerNumericTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaLowerNumeric, 10);
        Assert.assertTrue("The random string didn't contain only lower and numeric characters.", randomString.matches("^(?=.*[a-z])(?=.*[0-9]).+$"));
    }

    @Test
    public void alphaUpperLowerNumericTest() {
        String randomString = DataRandomizer.createString(DataRandomizer.Type.AlphaUpperLowerNumeric, 10);
        Assert.assertTrue("The random string didn't contain alpha upper, lower, and numeric characters.", randomString.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$"));
    }
}
