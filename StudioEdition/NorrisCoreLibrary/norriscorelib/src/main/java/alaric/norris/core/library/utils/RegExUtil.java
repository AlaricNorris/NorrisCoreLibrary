/**
 *  RegExUtil
 *  alaric.norris.core.library.utils
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/11/5         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

/**
 ClassName:      RegExUtil
 Function:       ${TODO}  ADD FUNCTION
 Contact:        Norris.sly@gmail.com
 @author AlaricNorris
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/11/5    15:39
 Modifications:  ${TODO}
 ***************************************************************************************************
 */
public class RegExUtil {


    private RegExUtil () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }
    /**
     * Phone Number
     */
    public static final String PHONENUMBER =
            "^(((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0-9])|(18[0,2,3,5-9]))[0-9]{8})|(123456)$";

    /**
     * Telephone Number
     */
    public static final String TELPHONE = "^//(?(//d{3})//)?[- ]?(//d{6})[- ]?(//d{4})$";

    /**
     * Account
     */
    public static final String ACCOUNT = "^[A-Za-z0-9]{6,16}$";

    /**
     * Password
     */
    public static final String PASSWORD = "^[A-Za-z0-9]{6,16}$";

    /**
     * Digital
     */
    public static final String DIGITAL = "[^0-9]";
}
