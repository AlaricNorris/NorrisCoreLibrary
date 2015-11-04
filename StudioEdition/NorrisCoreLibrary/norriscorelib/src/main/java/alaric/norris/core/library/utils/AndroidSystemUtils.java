/**
 *  AndroidSystemUtils
 *  alaric.norris.core.library.utils
 *  Function:   ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/10/23      AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
/**
 *  ClassName:  AndroidSystemUtils
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  Contact:    Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *  ************************************************************************************************************************************************************************************************************
 *  Modified By     AlaricNorris        2015/10/2316:07
 *  Modifications:  ${TODO}
 *  ************************************************************************************************************************************************************************************************************
 */
public class AndroidSystemUtils {

    private AndroidSystemUtils () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }
    /**
     * get Version Name
     * @param inContext context
     * @return Version Name
     */
    public static String getAppVersionName ( Context inContext ) {
        try {
            PackageManager manager = inContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo( inContext.getPackageName(), 0 );
            String version = info.versionName;
            return version;
        }
        catch ( Exception e ) {
            e.printStackTrace();
            return "Get Version Code";
        }
    }
    /**
     * get Version Code
     * @param inContext context
     * @return Version Code
     */
    public static int getAppVersionCode ( Context inContext ) {
        try {
            PackageManager manager = inContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo( inContext.getPackageName(), 0 );
            return info.versionCode;
        }
        catch ( Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  get meta-data from manifest
     * @param inContext context
     * @param inMetaKey key
     * @return
     */
    public static String getMetaData ( Context inContext, String inMetaKey ) {
        String metaValue = "";
        try {
            ApplicationInfo info = inContext.getPackageManager().getApplicationInfo(
                    inContext.getPackageName(), PackageManager.GET_META_DATA
            );

            metaValue = info.metaData.getString( inMetaKey );
            Log.i( "nrs", "metaValue" + metaValue );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return metaValue;
    }

    /**
     *
     */
    @Deprecated
    public static < T > T getMetaData ( Context inContext, String inMetaKey, T t ) {
        T metaValue = null;
        try {
            ApplicationInfo info = inContext.getPackageManager().getApplicationInfo(
                    inContext.getPackageName(), PackageManager.GET_META_DATA
            );
            metaValue = ( T ) info.metaData.getString( inMetaKey );
            Log.i( "nrs", "metaValue:" + metaValue );

        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return metaValue;
    }

    /**
     *  check if this app has the Permission
     * @param inContext             context
     * @param inPermissionName      Permission Name
     * @return true:has    false:don't
     */
    public static boolean checkPermission ( Context inContext, String inPermissionName ) {
        return ( PackageManager.PERMISSION_GRANTED == inContext.getPackageManager().checkPermission(
                inPermissionName, inContext.getPackageName()
        ) );
    }
}
