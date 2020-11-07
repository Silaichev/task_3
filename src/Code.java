import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code {

    public static final String zeros = "(^0+)";
    public static final String units = "(^1+)";
    static final Pattern patternZeros = Pattern.compile(zeros);
    static final Pattern patternUnits = Pattern.compile(units);
    static Matcher matcher;

    public static String coding(String text) {

        StringBuffer sb = new StringBuffer();

        String binary;
        for (int i = 0; i < text.length(); i++) {
            binary = Integer.toBinaryString(text.charAt(i));

            //Need to see char and binary view
            System.out.println(text.charAt(i) + " " + binary);

            sb.append(binaryToCode(binary)).append(" ");
        }
        return sb.toString();
    }

    static String binaryToCode(String binary) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        matcher = patternUnits.matcher(binary);
        //Units
        if (matcher.find()) {
            sb.append("0 ");
            //Zeros
        } else {
            matcher = patternZeros.matcher(binary);
            if (matcher.find()) {
                sb.append("00 ");
            }
        }

        while (count < matcher.group().length()) {
            sb.append("0");
            count++;
        }

        if (binary.length() == count) {
            return sb.toString();
        } else {
            return sb.append(" ").toString() + binaryToCode(binary.substring(count));
        }
    }



}
