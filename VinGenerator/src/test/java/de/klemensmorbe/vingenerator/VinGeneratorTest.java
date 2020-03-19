package de.klemensmorbe.vingenerator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class VinGeneratorTest {

	private static final String LEVEL_1_VIN_PATTERN = "[A-Z0-9]{17}";
	private static final String LEVEL_2_VIN_PATTERN = "[A-HJ-NPR-Z0-9]{17}";
	private static final String LEVEL_3_VIN_PATTERN = "[A-HJ-NPR-Z0-9]{9}[0-9]{8}";

	@Test
	void whenRandomVinGivenNullLevelThenReturnLevelOneVin() {
		final var result = new VinGenerator().withLevel(null).generate();

		assertThat(result, matchesPattern(LEVEL_1_VIN_PATTERN));
	}

	@Test
	void whenRandomVinThenReturnLevelOneVin() {
		final var result = new VinGenerator().generate();

		assertThat(result, matchesPattern(LEVEL_1_VIN_PATTERN));
	}

	@Test
	void whenRandomVinGivenLevenOneThenReturnLevelOneVin() {
		final var result = new VinGenerator().withLevel(VinLevel.ONE).generate();

		assertThat(result, matchesPattern(LEVEL_1_VIN_PATTERN));
	}

	@Test
	void whenRandomVinGivenLevenTwoThenReturnLevelTwoVin() {
		final var result = new VinGenerator().withLevel(VinLevel.TWO).generate();

		assertThat(result, matchesPattern(LEVEL_2_VIN_PATTERN));
	}

	@Test
	void whenRandomVinGivenLevenThreeThenReturnLevelThreeVin() {
		final var result = new VinGenerator().withLevel(VinLevel.THREE).generate();

		assertThat(result, matchesPattern(LEVEL_3_VIN_PATTERN));
	}


}
