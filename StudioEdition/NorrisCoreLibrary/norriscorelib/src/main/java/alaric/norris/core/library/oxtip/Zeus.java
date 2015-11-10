/**
 *  Zeus
 *  alaric.norris.core.library.oxlog
 *  Function:       Zeus
 *  date            author
 *  *****************************************************
 *  2015/10/30         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxtip;

import android.support.annotation.IntDef;
/**
 ClassName:      Zeus
 Function:       Zeus is a class that can enable/disable the OxLog to Log or not.
 @author AlaricNorris
 Contact:        Norris.sly@gmail.com
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/10/30    10:01
 Modifications:  init
 ***************************************************************************************************
 */
public class Zeus {
    /**
     * In any case, Zeus need tip
     */
    public static final int ZEUS_ENABLE_ALL = 0x8888;
    /**
     * Despite the Mutable, Zeus need tip
     */
    public static final int ZEUS_ENABLE_ALL_BUT_MUTE = 0x4444;
    /**
     * In any case, Zeus doesn't need tip
     */
    public static final int ZEUS_DISABLE_ALL = ~ 0x8888;
    @Mode
    public int Mode;

    public Zeus ( @Mode int mode ) {
        Mode = mode;
    }
    @IntDef ( { ZEUS_ENABLE_ALL , ZEUS_ENABLE_ALL_BUT_MUTE , ZEUS_DISABLE_ALL } )
    public @interface Mode {}
}
