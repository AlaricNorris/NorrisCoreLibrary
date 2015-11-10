package alaric.norris.core.library.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * ScreenUtil
 * @author Jack Tony
 * @see "http://www.cnblogs.com/tianzhijiexian/p/4113937.html"
 * @see "http://www.cnblogs.com/tianzhijiexian/p/4127695.html"
 */
public class ScreenUtil {

    private ScreenUtil () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }

    /**
     * setFullScreen
     * @param activity activity
     */
    public static void setFullScreen ( Activity activity ) {
        activity.getWindow().addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN );
        activity.getWindow().addFlags( WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS );
    }

    /**
     * cancelFullScreen
     * @param activity activity
     */
    public static void cancelFullScreen ( Activity activity ) {
        activity.getWindow().clearFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN );
    }

    /**
     * isFullScreen
     * @param activity activity
     * @return true:is; false:not
     */
    public static boolean isFullScreen ( Activity activity ) {
        int flag = activity.getWindow().getAttributes().flags;
        if ( ( flag & WindowManager.LayoutParams.FLAG_FULLSCREEN ) ==
                WindowManager.LayoutParams.FLAG_FULLSCREEN ) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isVerticalScreen
     * @param activity activity
     * @return true:vertical; false:horizontal
     */
    public static boolean isVerticalScreen ( Activity activity ) {
        int flag = activity.getResources().getConfiguration().orientation;
        if ( flag == 0 ) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * getStatusBarHeight
     * @param context  context
     * @return StatusBarHeight
     */
    public static int getStatusBarHeight ( Context context ) {
        Class< ? > c = null;
        Object obj = null;
        java.lang.reflect.Field field = null;
        int x = 0;
        int statusBarHeight = 0;
        try {
            c = Class.forName( "com.android.internal.R$dimen" );
            obj = c.newInstance();
            field = c.getField( "status_bar_height" );
            x = Integer.parseInt( field.get( obj ).toString() );
            statusBarHeight = context.getResources().getDimensionPixelSize( x );
            return statusBarHeight;
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * getScreen_WH API13 required
     * @param activity  activity
     * @return int[0] = width,int[1] = height
     */
    @SuppressLint ( "NewApi" )
    public static int[] getScreen_WH ( Activity activity ) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize( size );
        return new int[]{ size.x , size.y };
    }

    /**
     * getScreen_wh in low API
     * @param activity  activity
     * @return int[0] = width,int[1] = height
     */
    @Deprecated
    public static int[] getScreen_wh ( Activity activity ) {
        int w = activity.getWindowManager().getDefaultDisplay().getWidth();
        int h = activity.getWindowManager().getDefaultDisplay().getHeight();
        return new int[]{ w , h };

    }

    /**
     * getScreenDensity
     * @param context   context
     * @return ScreenDensity
     */
    public static float getScreenDensity ( Context context ) {
        return context.getResources().getDisplayMetrics().density;
    }
    /**
     * getScreenWidth
     * @param context  context
     * @return ScreenWidth
     */
    public static int getScreenW ( Context context ) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * getScreenHeight
     * @param context  context
     * @return ScreenHeight
     */
    public static int getScreenH ( Context context ) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * getScreenWidth
     * @param context  context
     * @return ScreenWidth
     */
    public static int getScreenWidth ( Context context ) {
        WindowManager wm = ( WindowManager ) context.getSystemService( Context.WINDOW_SERVICE );
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics( outMetrics );
        return outMetrics.widthPixels;
    }

    /**
     * getScreenHeight
     * @param context  context
     * @return ScreenHeight
     */
    public static int getScreenHeight ( Context context ) {
        WindowManager wm = ( WindowManager ) context.getSystemService( Context.WINDOW_SERVICE );
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics( outMetrics );
        return outMetrics.heightPixels;
    }

    /**
     * transfer px to dip
     * @param context    context
     * @param pxValue   pxValue
     * @return dipValue
     */
    public static int px2dip ( Context context, float pxValue ) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return ( int ) ( pxValue / scale + 0.5f );
    }

    /**
     * transfer dip to px
     * @param context    context
     * @param dipValue   dipValue
     * @return pxValue
     */
    public static int dip2px ( Context context, float dipValue ) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return ( int ) ( dipValue * scale + 0.5f );
    }

    /**
     * transfer px to sp
     * @param context    context
     * @param pxValue   pxValue
     * @return spValue
     */
    public static int px2sp ( Context context, float pxValue ) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return ( int ) ( pxValue / fontScale + 0.5f );
    }

    /**
     * transfer sp to px
     * @param context    context
     * @param spValue   spValue
     * @return pxValue
     */
    public static int sp2px ( Context context, float spValue ) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return ( int ) ( spValue * fontScale + 0.5f );
    }
}
