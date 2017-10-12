package GenerateSequence;


        import java.text.DecimalFormat;
        import java.text.FieldPosition;
        import java.text.Format;
        import java.text.NumberFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;

public class GenerateSequenceUtil {

    /** The FieldPosition. */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

    /** This Format for format the data to special format. */
    private final static Format dateFormat = new SimpleDateFormat("MMddHHmmssS");

    /** This Format for format the number to special format. */
    private final static NumberFormat numberFormat = new DecimalFormat("0000");

    /** This int is the sequence number ,the default value is 0. */
    private static int seq = 0;

    private static final int MAX = 999999999;

    /**
     * ʱ���ʽ�������
     * @return String
     */
    public static synchronized String generateSequenceNo() {

        Calendar rightNow = Calendar.getInstance();

        StringBuffer sb = new StringBuffer();

        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);

        numberFormat.format(seq, sb, HELPER_POSITION);

        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }
        String str = sb.toString();
        int year = rightNow.get(Calendar.YEAR);
        str=year+str;
        return str;
    }
}
