package Helpers;

/**
 * Created by james on 2/4/2019.
 */
public class DataRandomizer {

    public enum Type {
        AlphaUpper,
        AlphaLower,
        AlphaUpperLower,
        AlphaUpperNumeric,
        AlphaLowerNumeric,
        AlphaUpperLowerNumeric,
        Numeric
    }

    private static String _numeric = "1234567890";
    private static String _alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * <b>Description:</b> Creates a random string based off of the data enum type and the length provided.
     * @param type
     * @param length
     * @return
     */
    public static String createString(Type type, int length) {
        StringBuffer sb = new StringBuffer(length);

        switch (type) {
            case AlphaUpper:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*_alpha.length());
                    sb.append(_alpha.toUpperCase().charAt(index));
                }
                break;
            case AlphaLower:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*_alpha.length());
                    sb.append(_alpha.toLowerCase().charAt(index));
                }
                break;
            case AlphaUpperLower:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*_alpha.length()*2);
                    sb.append((_alpha.toUpperCase() + _alpha.toLowerCase()).charAt(index));
                }
                break;
            case AlphaUpperNumeric:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*(_alpha.length() + _numeric.length()));
                    sb.append((_alpha.toUpperCase() + _numeric).charAt(index));
                }
                break;
            case AlphaLowerNumeric:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*(_alpha.length() + _numeric.length()));
                    sb.append((_alpha.toLowerCase() + _numeric).charAt(index));
                }
                break;
            case AlphaUpperLowerNumeric:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*((_alpha.length()*2) + _numeric.length()));
                    sb.append((_alpha.toUpperCase() + _alpha.toLowerCase() +  _numeric).charAt(index));
                }
                break;
            case Numeric:
                for (int i = 0; i < length; i++) {
                    int index = (int)(Math.random()*_alpha.length());
                    sb.append(_numeric).charAt(index);
                }
                break;
            default:
                //TODO: add some logging here for broken shit
                break;
        }

        return sb.toString();
    }
}
