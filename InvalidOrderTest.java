package project;

import org.junit.Test;

public class InvalidOrderTest {
    InvalidOrder invalidOrder=new InvalidOrder();

    @Test
    public void InvalidOrderTest() throws InterruptedException {
        invalidOrder.connect();
        invalidOrder.orderProcess();
      //  invalidOrder.quit();
    }
}
