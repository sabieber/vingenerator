package de.klemensmorbe.vingenerator;

import de.klemensmorbe.vingenerator.internal.PartialVinGenerator;

import java.util.Objects;

/**
 * Generates VINs (short for vehicle identification number) with varous degrees of validity indicated by {@link VinLevel}.
 */
public class VinGenerator {

    private static final String FALLBACK_VIN = "00000000000000000";
    private static final String LEVEL_1_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LEVEL_2_ALPHABET = "0123456789ABCDEFGHJKLMNPRSTUVWXYZ";
    private static final String LEVEL_3_VIS_ALPHABET = "0123456789";

    /**
     * Total length of a VIN.
     */
    private static final int VIN_SIZE = 17;

    /**
     * Length of the world manufacturer identifier of a VIN.
     */
    private static final int WMI_SIZE = 3;

    /**
     * Length of the vehicle descriptor section of a VIN.
     */
    private static final int VDS_SIZE = 6;

    /**
     * Length of the vehicle identifier section of a VIN.
     */
    private static final int VIS_SIZE = 8;

    private VinLevel level = VinLevel.ONE;

    /**
     * Specifies the abstraction level of VIN generation to be used. This is set to level 1 by default.
     *
     * @param level the level to be used when finally generating the VIN
     * @return the generator itself for fluid method calls
     */
    public VinGenerator withLevel(VinLevel level) {
        this.level = level;
        return this;
    }

    /**
     * Generates a random VIN following the set abstraction level.
     *
     * @return the generated VIN
     */
    public String generate() {
        if (Objects.isNull(level)) {
            return FALLBACK_VIN;
        }
        switch (level) {
            case ONE:
                return PartialVinGenerator.generate(LEVEL_1_ALPHABET, VIN_SIZE);
            case TWO:
                return PartialVinGenerator.generate(LEVEL_2_ALPHABET, VIN_SIZE);
            case THREE:
                return PartialVinGenerator.generate(LEVEL_2_ALPHABET, WMI_SIZE) + PartialVinGenerator.generate(
                        LEVEL_2_ALPHABET,
                        VDS_SIZE) + PartialVinGenerator.generate(LEVEL_3_VIS_ALPHABET, VIS_SIZE);
            case FOUR:
                // TODO
            case FIVE:
                // TODO
            default:
                return FALLBACK_VIN;
        }
    }
}
