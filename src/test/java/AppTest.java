import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void getHelloWorld() {
        String expected = "Hello, World!";
        String actual = App.getHelloWorld();

        assertEquals(expected, actual);
    }
}
