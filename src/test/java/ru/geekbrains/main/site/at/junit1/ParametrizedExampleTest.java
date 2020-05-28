package ru.geekbrains.main.site.at.junit1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ParametrizedExampleTest {

    public static Stream<String> stringGenerator() {
        return Stream.of("Courses", "Tests", "Blogs");
    }

    public static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of(100, -100, 0),
                Arguments.of(-1, 100, 99),
                Arguments.of(0, 100, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("stringGenerator")
    public void title(String title) {
        assertNotNull(title);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test02_data.csv", numLinesToSkip = 1)
    public void calc(int a, int b, int result) {
        assertEquals(result, a + b);
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    public void calc2(int a, int b, int result) {
        assertEquals(result, a + b);
    }


}

