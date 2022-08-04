package project;

import org.junit.Test;

public class InvalidRegistrationTest {
    InvalidRegistration invalidRegistration=new InvalidRegistration();

    @Test
    public void enterValues() throws InterruptedException {
        invalidRegistration.connect();
        invalidRegistration.enterValues();
        invalidRegistration.quit();
    }
}
