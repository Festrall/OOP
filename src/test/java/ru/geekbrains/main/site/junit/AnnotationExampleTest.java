package ru.geekbrains.main.site.junit;

import org.junit.jupiter.api.*;

import java.util.Random;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnnotationExampleTest {


    @Disabled
    @Test
    public void test01(){
        assertTrue(true);
    }

    @DisplayName("Проверка истинности имени")
    @Test
    public void test02(){
        assertTrue(true);
    }

    @RepeatedTest(20)
    @DisplayName("проверка истинности значения")
    @Test
    public void test03(){
        int x = new Random().nextInt(20);
        assertTrue(x>10);
    }

    @Timeout(2)
    @Test
    public void test04() throws InterruptedException{
        sleep(1900);
        assertTrue(true);

    }

}
