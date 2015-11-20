package prj5;

/**
 * enumeration limiting representations
 * of data to MAJOR, HOBBY, or REGION. 
 * The reason compareToMethod for
 * song does not use this is each 
 * comparison should be ordered in 
 * alphanumeric order, of which
 * String's compareTo method is already
 * defined.
 * @author Chris Dare cdare77
 * @version 11/18/2015
 */
public enum Representation {
    /**
     * public static finals which constrict possibilities
     * to only 3 options and prevent IllegalArgumentException
     * from being thrown
     */
    MAJOR, HOBBY, REGION;
}
