package ru.geekbrains.main.site.at.junit1;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionExampleTest {


    @Test
    public void testEquals() {
        assertEquals(1.5, 1.5, "This element are equal");
    }

    @Test
    public void arrayEquals() {
        int[] a = {0, 1};
        int[] b = {0, 1};
        assertArrayEquals(a, b);
    }

    @Test
    public void textNullNotNull() {
        String a = null;
        String b = "String not null";
        assertNull(a);
        assertNotNull(b);
    }

    @Test
    public void arrayException() {
        final List<Integer> myList = Arrays.asList(0, 1, 2);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            myList.get(100);
        });
    }

    @Test
    public void timeDuration() {
        assertTimeout(Duration.ofMillis(700), () -> {
            sleep(600);
        });
    }
}
