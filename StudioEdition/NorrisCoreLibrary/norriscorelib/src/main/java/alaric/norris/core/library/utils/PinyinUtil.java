package alaric.norris.core.library.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * PinYin Util
 */
public class PinyinUtil {
    private static final boolean DEBUG = true;
    private PinyinUtil () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }
    /**
     * turn Chinese into PinYin
     * @param src   chinese
     * @return String
     */
    public static String getPinYin ( String src ) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[ t1.length ];

        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType( HanyuPinyinCaseType.LOWERCASE );
        t3.setToneType( HanyuPinyinToneType.WITHOUT_TONE );
        t3.setVCharType( HanyuPinyinVCharType.WITH_V );
        String t4 = "";
        int t0 = t1.length;
        try {
            for ( int i = 0 ; i < t0 ; i++ ) {
                // check is Chinese

                // System.out.println(t1[i]);

                if ( Character.toString( t1[ i ] ).matches( "[\\u4E00-\\u9FA5]+" ) ) {
                    // restore N pinyin to t2
                    t2 = PinyinHelper.toHanyuPinyinStringArray( t1[ i ], t3 );

                    // extract first Pinyin append after t4
                    t4 += t2[ 0 ];

                }
                else {
                    // if not Chinese extract string and append after t4

                    t4 += Character.toString( t1[ i ] );
                }
            }
        }
        catch ( BadHanyuPinyinOutputFormatCombination e ) {
            e.printStackTrace();
        }
        return t4.toUpperCase();
    }

    /**
     * get the Capital character's PinYin of Chinese
     *
     * @param str
     * @return String
     */
    public static String getCapitalPinYin ( String str ) {
        String convert = "";
        for ( int j = 0 ; j < str.length() ; j++ ) {
            char word = str.charAt( j );

            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray( word );
            if ( pinyinArray != null ) {
                convert += pinyinArray[ 0 ].toUpperCase().charAt( 0 );
            }
            else {
                convert += word;
            }
        }
        return convert.toUpperCase();
    }

    /**
     * turn Chinese into ASCII code
     *
     * @param cnStr
     * @return String
     */
    public static String getCnASCII ( String cnStr ) {
        StringBuffer strBuf = new StringBuffer();

        byte[] bGBK = cnStr.getBytes();
        for ( int i = 0 ; i < bGBK.length ; i++ ) {
            strBuf.append( Integer.toHexString( bGBK[ i ] & 0xff ) );
        }
        return strBuf.toString();
    }
}
