package de.klemensmorbe.vingenerator;

/**
 * Describes the different validity stages of the generated VINs, the higher levels include all the restrictions of the levels below it.
 */
public enum VinLevel {
    /**
     * Describes a generated VIN with the most basic settings as in a completely random string of alphanumeric characters only following the correct length of a VIN.
     */
    ONE,

    /**
     * Describes a generated VIN as a completely random string of characters from a reduced alphabet excluding misleading characters.
     */
    TWO,

    /**
     * Describes a generated VIN as a composition of three completely random substrings (WMI, VDS + VIS) from their respective reduced alphabets.
     */
    THREE,

    /**
     * Describes a generated VIN with valid WMI, VDS and VIS sections (following ISO 3779).
     */
    FOUR,

    /**
     * Describes a generated VIN with valid vehicle attributes, model year, plant code, sequential number and check digit (following ISO 3779).
     */
    FIVE
}
