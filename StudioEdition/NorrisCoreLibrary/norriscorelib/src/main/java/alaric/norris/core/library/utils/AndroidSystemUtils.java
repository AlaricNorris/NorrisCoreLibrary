/**
 *  AndroidSystemUtils
 *  alaric.norris.core.library.utils
 * 	Function: 	${TODO}
 *  date            author
 *  *****************************************************
 *  2015/10/23      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/**
 *  ClassName:  AndroidSystemUtils
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  Contact:    Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *	************************************************************************************************************************************************************************************************************
 * 	Modified By 	AlaricNorris		 2015/10/2316:07
 *	Modifications:	${TODO}
 *	************************************************************************************************************************************************************************************************************
 */
public class AndroidSystemUtils {

    /**
     * 获取版本号
     * @param inContext
     * @return 当前应用的版本号
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
            return "获取版本信息异常";
        }
    }
    /**
     * 获取版本号
     * @param inContext
     * @return 当前应用的版本码
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
}
