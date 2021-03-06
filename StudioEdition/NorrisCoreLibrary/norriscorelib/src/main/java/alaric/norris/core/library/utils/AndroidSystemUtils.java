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

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import alaric.norris.core.library.oxtip.ol.OxLog;
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
    public static < T > T getMetaDataT ( Context inContext, String inMetaKey ) {
        T metaValue = null;
        try {
            ApplicationInfo info = inContext.getPackageManager().getApplicationInfo(
                    inContext.getPackageName(), PackageManager.GET_META_DATA
            );
            metaValue = ( T ) info.metaData.getString( inMetaKey );
            OxLog.i( "metaValue:" + metaValue );
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

    /**
     *  getPermissionList
     * @param inContext             context
     * @return PermissionList
     * example:
     * [android.permission.INTERNET,
     * android.permission.READ_PHONE_STATE,
     * android.permission.READ_CONTACTS,
     * android.permission.READ_EXTERNAL_STORAGE ]
     */
    public static String[] getPermissionList ( Context inContext ) {
        String[] permissionStrings = new String[]{ "" };
        try {
            permissionStrings = inContext.getPackageManager().getPackageInfo(
                    inContext.getPackageName(), PackageManager.GET_PERMISSIONS
            ).requestedPermissions;
        }
        catch ( PackageManager.NameNotFoundException e ) {
            e.printStackTrace();
        }
        return permissionStrings;
    }

    /**
     * Copy string to clipboard
     * @param content   content
     * @param context   context
     */
    public static void copy2ClipBoard ( String content, Context context ) {
        // 得到剪贴板管理器
        ClipboardManager mClipboardManager =
                ( ClipboardManager ) context.getSystemService( Context.CLIPBOARD_SERVICE );
        mClipboardManager.setPrimaryClip( ClipData.newPlainText( null, ( content.trim() ) ) );
    }
}
