package ru.geekbrains.example.junit1;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestExampleTest {


    @Test
    public void Equals() {
        int a = 5;
        Object object = new Object();
        Object object1 = object;
        assertThat(a, equalTo(5));
        assertThat(object, notNullValue());
        assertThat(object1, sameInstance(object1));
    }

    @Test
    public void count() {
        int a = 0;
        double a1 = 1.444;
        int b = 1;
        int c = -100;
        Integer z = 100;
        assertThat(a, lessThan(b));
        assertThat(c, greaterThan(-101));
        assertThat(a, lessThanOrEqualTo(0));
        assertThat(a1, closeTo(1.4, 0.1));
        assertThat(z, instanceOf(Number.class));
    }

    @Test
    public void textCase() {
        String a = "FILM";
        String b = "film";
        assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    public void multyCase() {
        int a = 0;

        assertThat(a, allOf(
                lessThan(10),
                lessThanOrEqualTo(0)
        ));
    }

    @Test
    public void uniqueCase() {
        int a = 0;

        assertThat(a, anyOf(
                lessThan(-1),
                lessThanOrEqualTo(0)
        ));
    }

    @Test
    public void unique2Case() {
        int a = 0;

        assertThat(a, not(anyOf(
                lessThan(-1),
                lessThanOrEqualTo(-10)
        )));
    }

}
