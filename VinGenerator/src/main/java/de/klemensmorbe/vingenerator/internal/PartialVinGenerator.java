package de.klemensmorbe.vingenerator.internal;

import java.util.Random;
import java.util.stream.Collectors;

public final class PartialVinGenerator {

    private static final int ZERO = 0;

    private static Random random = new Random();

    private PartialVinGenerator() {
    }

    public static String generate(final String alphabet, final int size) {
        return random.ints(size, ZERO, alphabet.length())
                     .boxed()
                     .map(integer -> alphabet.substring(integer, integer + 1))
                     .collect(Collectors.joining());
    }
}
