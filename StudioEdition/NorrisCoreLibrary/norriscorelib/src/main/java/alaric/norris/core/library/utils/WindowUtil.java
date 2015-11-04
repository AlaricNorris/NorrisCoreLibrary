package alaric.norris.core.library.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * WindowUtil
 * @author Jack Tony
 * @see "http://www.cnblogs.com/tianzhijiexian/p/4113937.html"
 * @see "http://www.cnblogs.com/tianzhijiexian/p/4127695.html"
 */
public class WindowUtil {

    private WindowUtil () {
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
     * getWindow_WH API13 required
     * @param activity  activity
     * @return int[0] = width,int[1] = height
     */
    @SuppressLint ( "NewApi" )
    public static int[] getWindow_WH ( Activity activity ) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize( size );
        return new int[]{ size.x , size.y };
    }

    /**
     * getWindow_wh in low API
     * @param activity  activity
     * @return int[0] = width,int[1] = height
     */
    @Deprecated
    public static int[] getWindow_wh ( Activity activity ) {
        int w = activity.getWindowManager().getDefaultDisplay().getWidth();
        int h = activity.getWindowManager().getDefaultDisplay().getHeight();
        return new int[]{ w , h };

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
     *
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

}
