/**
 *  DesityUtil
 *  alaric.norris.core.library.utils
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/11/5         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.content.Context;
import android.util.Log;
/**
 ClassName:      DesityUtil
 Function:       ${TODO}  ADD FUNCTION
 Contact:        Norris.sly@gmail.com
 @author AlaricNorris
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/11/5    17:17
 Modifications:  ${TODO}
 ***************************************************************************************************
 */

public class DensityUtil {

    public static float density = 0;
    public static float densityDpi = 240;
    public static float dpiRange = 50;

    public static void init ( Context context ) {
        density = context.getResources().getDisplayMetrics().density;
        densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        dpiRange = ( densityDpi - 72 ) / 3;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px ( Context context, float dpValue ) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return ( int ) ( dpValue * scale + 0.5f );
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px ( float dpValue ) {
        if ( density == 0 ) {
            Log.e( "DensityUtil", "Before you use this method, you must initialize the class" );
            throw new NullPointerException(
                    "Before you use this method, you must initialize the class"
            );
        }
        return ( int ) ( dpValue * density + 0.5f );
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip ( Context context, float pxValue ) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return ( int ) ( pxValue / scale + 0.5f );
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip ( float pxValue ) {
        if ( density == 0 ) {
            Log.e( "DensityUtil", "Before you use this method, you must initialize the class" );
            throw new NullPointerException(
                    "Before you use this method, you must initialize the class"
            );
        }
        return ( int ) ( pxValue / density + 0.5f );
    }
}
