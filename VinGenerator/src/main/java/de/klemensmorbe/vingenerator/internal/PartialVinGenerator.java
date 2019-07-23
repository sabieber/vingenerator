package de.klemensmorbe.vingenerator.internal;

import java.util.Random;
import java.util.stream.Collectors;

public final class PartialVinGenerator {

	private static final int ZERO = 0;

	private PartialVinGenerator() {
	}

	public static String generate(final String alphabet, final int size) {
		return new Random().ints(size, ZERO, alphabet.length())
				.boxed()
				.map(integer -> alphabet.substring(integer, integer + 1))
				.collect(Collectors.joining());
	}
}
