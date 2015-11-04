/**
 *  GodMode
 *  alaric.norris.core.library.oxlog
 *  Function:       GodMode
 *  date            author
 *  *****************************************************
 *  2015/10/30         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxtip;

import android.support.annotation.IntDef;
/**
 ClassName:      GodMode
 Function:       GodMode
 @author AlaricNorris
 Contact:        Norris.sly@gmail.com
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/10/30    10:01
 Modifications:  init
 ***************************************************************************************************
 */
public class GodMode {
    public static final int GOD_ENABLE_ALL = 0x8888;
    public static final int GOD_DISABLE_ALL = ~ 0x8888;
    @Mode
    public int Mode;

    public GodMode ( @Mode int mode ) {
        Mode = mode;
    }
    @IntDef ( { GOD_ENABLE_ALL , GOD_DISABLE_ALL } )
    public @interface Mode {}
}
