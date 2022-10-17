package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicJunit
{
    // SETUP - CLEAN UP
    @BeforeEach
    public void setup()
    {
        System.out.println("setup");
    }

    @AfterEach
    public void cleanup()
    {
        System.out.println("clean up");
    }
    // TESTS
    @Test
    public void verifySmth()
    {
        System.out.println("test 1");
    }

    @Test
    public void verifySmth2()
    {
        System.out.println("test 2");
    }
}
