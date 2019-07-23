package de.klemensmorbe.vingenerator;

import de.klemensmorbe.vingenerator.internal.PartialVinGenerator;

import java.util.Objects;

public class VinGenerator {

	private static final String LEVEL_1_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LEVEL_2_ALPHABET = "0123456789ABCDEFGHJKLMNPRSTUVWXYZ";
	private static final String LEVEL_3_VIS_ALPHABET = "0123456789";
	private static final int WMI_SIZE = 3;
	private static final int VDS_SIZE = 6;
	private static final int VIS_SIZE = 8;

	private VinGenerator() {
	}

	public static String randomVin() {
		return randomVin(VinLevel.ONE);
	}

	public static String randomVin(final VinLevel vinLevel) {
		if (Objects.isNull(vinLevel)) {
			return "00000000000000000";
		}
		switch (vinLevel) {
			case ONE:
				return PartialVinGenerator.generate(LEVEL_1_ALPHABET, 17);
			case TWO:
				return PartialVinGenerator.generate(LEVEL_2_ALPHABET, 17);
			case THREE:
				return PartialVinGenerator.generate(LEVEL_2_ALPHABET, WMI_SIZE) +
						PartialVinGenerator.generate(LEVEL_2_ALPHABET, VDS_SIZE) +
						PartialVinGenerator.generate(LEVEL_3_VIS_ALPHABET, VIS_SIZE);
			case FOUR:
				// real WMI, real VDS and VIS (ISO 3779)
			case FIVE:
				// real WMI, real vehicle attributes, check digit, model year, plant code and sequential number
			default:
				return "00000000000000000";
		}
	}
}
