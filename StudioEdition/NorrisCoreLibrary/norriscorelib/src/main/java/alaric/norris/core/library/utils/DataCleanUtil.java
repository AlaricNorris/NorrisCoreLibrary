/**
 *  DataCleanUtil
 *  alaric.norris.core.library.utils
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/11/5         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 ClassName:      DataCleanUtil
 Function:       DataCleaner
 Contact:        Norris.sly@gmail.com
 @author AlaricNorris
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/11/5    17:20
 Modifications:  init
 ***************************************************************************************************
 */

public class DataCleanUtil {

    /**
     * cleanInternalCache
     * (Under dir:[/data/data/com.xxx.xxx/cache])
     * @param context context
     */
    public static void cleanInternalCache ( Context context ) {
        deleteFilesByDirectory( context.getCacheDir() );
    }

    /**
     * cleanDatabases
     * @param context context
     */
    public static void cleanDatabases ( Context context ) {
        deleteFilesByDirectory(
                new File( "/data/data/" + context.getPackageName() + "/databases" )
        );
    }

    /**
     * cleanSharedPreference
     * (Under dir:[/data/data/com.xxx.xxx/shared_prefs])
     * @param context context
     */
    public static void cleanSharedPreference ( Context context ) {
        deleteFilesByDirectory(
                new File( "/data/data/" + context.getPackageName() + "/shared_prefs" )
        );
    }

    /**
     * cleanDatabaseByName
     * @param context
     * @param dbName
     */
    public static void cleanDatabaseByName ( Context context, String dbName ) {
        context.deleteDatabase( dbName );
    }

    /**
     * cleanFiles
     * (Under dir:[/data/data/com.xxx.xxx/files])
     * @param context context
     */
    public static void cleanFiles ( Context context ) {
        deleteFilesByDirectory( context.getFilesDir() );
    }

    /**
     * cleanExternalCache
     * (Under dir:[/data/data/com.xxx.xxx/cache])
     * @param context context
     */
    public static void cleanExternalCache ( Context context ) {
        if ( Environment.getExternalStorageState().equals( Environment.MEDIA_MOUNTED ) ) {
            deleteFilesByDirectory( context.getExternalCacheDir() );
        }
    }

    /**
     * cleanCustomCache
     * Careful!Don't delete the wrong dir!
     * @param filePath  filePath
     */
    public static void cleanCustomCache ( String filePath ) {
        deleteFilesByDirectory( new File( filePath ) );
    }

    /**
     * cleanApplicationData
     * @param context   context
     * @param filepath  filepath
     */
    public static void cleanApplicationData ( Context context, String... filepath ) {
        cleanInternalCache( context );
        cleanExternalCache( context );
        cleanDatabases( context );
        cleanSharedPreference( context );
        cleanFiles( context );
        for ( String filePath : filepath ) {
            cleanCustomCache( filePath );
        }
    }

    /**
     * deleteFilesByDirectory
     * @param directory directory
     */
    private static void deleteFilesByDirectory ( File directory ) {
        try {
            if ( directory != null && directory.exists() && directory.isDirectory() ) {
                for ( File item : directory.listFiles() ) {
                    item.delete();
                }
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}

