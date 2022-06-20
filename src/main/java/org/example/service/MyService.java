package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class MyService {

    public int myFunction() {
        return 0;
    }

    public int solution(int[] input) {
        // write your code in Java SE 11
        return Arrays.stream(input)
                .filter(value -> value > 0)
                .boxed()
                .sorted()
                .distinct()
                .reduce(0, (subtotal, element) -> {
                    if (subtotal + 1 != element) {
                        return subtotal;
                    }
                    return subtotal + 1;
                }) + 1;
    }

}
