package alaric.norris.core.library.utils;
import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * PreferenceUtil
 * @author lmj623565791
 * @see "http://blog.csdn.net/lmj623565791/article/details/38965311"
 */
public class PreferenceUtil {

    private PreferenceUtil () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }
    /**
     * SharedPreferences Name
     * @param context context
     * @return PreferenceName
     */
    private static String getPreferenceName ( Context context ) {
        return context.getPackageName() + "_preferences";
    }

    /**
     * putAndApply
     * @param context   context
     * @param key       key
     * @param object    object
     */
    public static void putAndApply ( Context context, String key, Object object ) {
        SharedPreferences sp =
                context.getSharedPreferences( getPreferenceName( context ), Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();

        if ( object instanceof String ) {
            editor.putString( key, ( String ) object );
        }
        else if ( object instanceof Integer ) {
            editor.putInt( key, ( Integer ) object );
        }
        else if ( object instanceof Boolean ) {
            editor.putBoolean( key, ( Boolean ) object );
        }
        else if ( object instanceof Float ) {
            editor.putFloat( key, ( Float ) object );
        }
        else if ( object instanceof Long ) {
            editor.putLong( key, ( Long ) object );
        }
        else {
            editor.putString( key, object.toString() );
        }

        SharedPreferencesCompat.apply( editor );
    }

    /**
     * get
     * @param context       context
     * @param key           key
     * @param defaultObject defaultObject
     * @return
     */
    public static Object get ( Context context, String key, Object defaultObject ) {
        SharedPreferences sp =
                context.getSharedPreferences( getPreferenceName( context ), Context.MODE_PRIVATE );

        if ( defaultObject instanceof String ) {
            return sp.getString( key, ( String ) defaultObject );
        }
        else if ( defaultObject instanceof Integer ) {
            return sp.getInt( key, ( Integer ) defaultObject );
        }
        else if ( defaultObject instanceof Boolean ) {
            return sp.getBoolean( key, ( Boolean ) defaultObject );
        }
        else if ( defaultObject instanceof Float ) {
            return sp.getFloat( key, ( Float ) defaultObject );
        }
        else if ( defaultObject instanceof Long ) {
            return sp.getLong( key, ( Long ) defaultObject );
        }
        else {
            return null;
        }
    }

    /**
     * remove
     * @param context   context
     * @param key       key
     */
    public static void remove ( Context context, String key ) {
        SharedPreferences sp =
                context.getSharedPreferences( getPreferenceName( context ), Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        editor.remove( key );
        SharedPreferencesCompat.apply( editor );
    }

    /**
     * clear
     * @param context   context
     */
    public static void clear ( Context context ) {
        SharedPreferences sp =
                context.getSharedPreferences( getPreferenceName( context ), Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply( editor );
    }

    /**
     * contains
     * @param context   context
     * @param key       key
     * @return true:contains; false not
     */
    public static boolean contains ( Context context, String key ) {
        SharedPreferences sp =
                context.getSharedPreferences( getPreferenceName( context ), Context.MODE_PRIVATE );
        return sp.contains( key );
    }

    /**
     * getAll
     */
    public static Map< String, ? > getAll ( Context context ) {
        SharedPreferences sp =
                context.getSharedPreferences( getPreferenceName( context ), Context.MODE_PRIVATE );
        return sp.getAll();
    }

    /**
     * SharedPreferencesCompat.apply
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {

        private static final Method sApplyMethod = findApplyMethod();

        /**
         * Reflect to find apply method
         * @return Method
         */
        @SuppressWarnings ( { "unchecked" , "rawtypes" } )
        private static Method findApplyMethod () {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod( "apply" );
            }
            catch ( NoSuchMethodException e ) {
            }

            return null;
        }

        /**
         * if has apply run
         * otherwise commit
         * @param editor    editor
         */
        public static void apply ( SharedPreferences.Editor editor ) {
            try {
                if ( sApplyMethod != null ) {
                    sApplyMethod.invoke( editor );
                    return;
                }
            }
            catch ( IllegalArgumentException expected ) {
            }
            catch ( IllegalAccessException expected ) {
            }
            catch ( InvocationTargetException expected ) {
            }
            editor.commit();
        }
    }

}