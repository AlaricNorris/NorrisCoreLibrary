/**
 *  InvalidLayoutManagerException
 *  com.alaric.norris.app.credit.points.ui.helpers
 *  Function:   ${TODO}
 *  date            author
 *  2015/9/22      AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.android.support.helpers;

/**
 *  ClassName:  InvalidLayoutManagerException
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  contact Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 */
public class InvalidLayoutManagerException extends Exception {
    public InvalidLayoutManagerException () {
    }
    public InvalidLayoutManagerException ( String detailMessage ) {
        super( detailMessage );
    }
    public InvalidLayoutManagerException ( String detailMessage, Throwable throwable ) {
        super( detailMessage, throwable );
    }
    public InvalidLayoutManagerException ( Throwable throwable ) {
        super( throwable );
    }
}
