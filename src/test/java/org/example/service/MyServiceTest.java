package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MyServiceTest {

    @Autowired
    private MyService testClass;

    public static Stream<Arguments> inputValues() {
        return Stream.of(
                        Arguments.of(new int[]{1, 2, 3}, 4),
                        Arguments.of(new int[]{-1, -2, -3}, 1),
                        Arguments.of(new int[]{}, 1)
                );
    }

    @Test
    void myTest() {
        final int result = testClass.myFunction();
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @MethodSource("inputValues")
    void someTest(int[] input, final int expected) {
        final int result = testClass.solution(input);
        assertThat(result).isEqualTo(expected);
    }

}