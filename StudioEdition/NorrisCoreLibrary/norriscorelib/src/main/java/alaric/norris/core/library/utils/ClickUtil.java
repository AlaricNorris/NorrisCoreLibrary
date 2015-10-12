/**
 * 	ClickUtil.java
 * 	com.alaric.norris.game.ieue.utils
 * 	Function： 	TODO 
 *   ver     date      		author
 *   		 2013-12-15 		AlaricNorris
 *	Copyright (c) 2013, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;
/**
 *	ClassName:	ClickUtil
 *	Function: 	TODO ADD FUNCTION
 *	Reason:	 	TODO ADD REASON
 *    @author AlaricNorris        Norris.sly@gmail.com
 *	@version
 *	@since Ver 1.0		I used to be a programmer like you, then I took an arrow in the knee
 *	@Date 2013        2013-12-15		pm4:39:29
 *	@see
 */
public class ClickUtil {

    /**
     * 	long			:		DELTA_100
     *    @since Ver 1.0
     */
    public static final long DELTA_100 = 100;

    /**
     * 	long			:		DELTA_200
     *    @since Ver 1.0
     */
    public static final long DELTA_200 = 200;

    /**
     * 	long			:		DELTA_300
     *    @since Ver 1.0
     */
    public static final long DELTA_300 = 300;

    /**
     * 	long			:		DELTA_400
     *    @since Ver 1.0
     */
    public static final long DELTA_400 = 400;

    /**
     * 	long			:		DELTA_500
     *    @since Ver 1.0
     */
    public static final long DELTA_500 = 500;

    /**
     * 	long			:		DELTA_600
     *    @since Ver 1.0
     */
    public static final long DELTA_600 = 600;

    /**
     * 	long			:		DELTA_700
     *    @since Ver 1.0
     */
    public static final long DELTA_700 = 700;

    /**
     * 	long			:		DELTA_800
     *    @since Ver 1.0
     */
    public static final long DELTA_800 = 800;

    /**
     * 	long			:		mLastClickMillis
     *    @since Ver 1.0
     */
    private static long mLastClickMillis;

    /**
     *    @return
     *	@version Ver 1.0
     * 	@since I used to be a programmer like you, then I took an arrow in the knee
     */
    public static boolean isFastDoubleClick() {

        long mCurrentMillis = System.currentTimeMillis();
        long mDeltaMillis = mCurrentMillis - mLastClickMillis;
        mLastClickMillis = mCurrentMillis;
        if (0 < mDeltaMillis && mDeltaMillis < DELTA_100) {
            return true;
        }
        return false;
    }

    /**
     *    @param        inDeltaTime
     * 	@return
     *	@version Ver 1.0
     * 	@since I used to be a programmer like you, then I took an arrow in the knee 
     */
    public static boolean isFastDoubleClick(long inDeltaTime) {

        long mCurrentMillis = System.currentTimeMillis();
        long mDeltaMillis = mCurrentMillis - mLastClickMillis;
        mLastClickMillis = mCurrentMillis;
        if (0 < mDeltaMillis && mDeltaMillis < inDeltaTime) {
            return true;
        }
        return false;
    }
}