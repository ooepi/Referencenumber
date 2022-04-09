import org.junit.Test;

import static org.junit.Assert.*;

public class ReferenceValidatorTest {

    @Test
    public void CalculateReferenceNumberIsGreaterThanThree() {
        assertTrue(ReferenceValidator.calculateReferenceNumber(new int[]{1,2,3}).length() > 3);
    }

    @Test
    public void CalculateReferenceNumberIsLessThanTwenty() {
        assertTrue(ReferenceValidator.calculateReferenceNumber(new int[]{1,2,3,4,5,6,7,8,9,0}).length() < 20);
    }

    @Test
    public void CalculateReferenceNumberIsGroupedInFives(){
        String ref = ReferenceValidator.calculateReferenceNumber(new int[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8});
        assertEquals(' ', ref.charAt(4));
        assertEquals(' ', ref.charAt(10));
        assertEquals(' ', ref.charAt(16));
    }

    @Test
    public void CalculateReferenceNumberIsOnlyNumbersAndSpaces(){
        assertTrue(ReferenceValidator.calculateReferenceNumber(new int[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8}).matches("[0-9 ]+"));
    }

    @Test
    public void CalculateReferenceNumberIsCorrect(){
        assertEquals("1232", ReferenceValidator.calculateReferenceNumber(new int[]{1,2,3}));
    }



}
