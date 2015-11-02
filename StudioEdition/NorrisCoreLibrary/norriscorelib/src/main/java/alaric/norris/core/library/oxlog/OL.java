/**
 *  OL
 *  alaric.norris.core.library.oxlog
 * 	Function:       OxLog
 *  date            author
 *  *****************************************************
 *  2015/10/29      AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxlog;

import android.util.Log;

import alaric.norris.core.library.BuildConfig;
import alaric.norris.core.library.oxtip.GodMode;
import alaric.norris.core.library.oxtip.TipStrategy;
/**
 @formatter:off ClassName:      OL
 @formatter:off Function:       OxLog
 @formatter:off @author         AlaricNorris
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ************************************************************************************************************************************************************************************************************
 @formatter:off Modified By 	AlaricNorris		 2015/10/2916:56
 @formatter:off Modifications:	init
 @formatter:off ************************************************************************************************************************************************************************************************************
 */
public class OL {

    public static OLConfig mConfig =
            new OLConfig.Builder( TipStrategy.DebugOnly ).defaultTag( "OxLog" )
                                                         .defaultSuffix( "OneShot" )
                                                         .releaseSwitcher( true )
                                                         .build();

    private OL () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "cannot be instantiated" );
    }
    public static void i ( String logInfo ) {
        i( logInfo, mConfig.defaultSuffix, mConfig.defaultStrategy );
    }
    public static void i ( String logInfo, String tagSuffix ) {
        i( logInfo, tagSuffix, mConfig.defaultStrategy );
    }
    public static void i ( String logInfo, TipStrategy inStrategy ) {
        i( logInfo, mConfig.defaultSuffix, inStrategy );
    }
    public static void i ( String logInfo, String tagSuffix, TipStrategy inStrategy ) {
        if ( mConfig.getGodMode() == null )
            switch (inStrategy) {
                case DebugOnly:
                    if ( BuildConfig.DEBUG )
                        if ( MuteHelper.Mute_Suffixs != null &&
                                MuteHelper.Mute_Suffixs.contains( tagSuffix ) )
                            return;
                        else
                            Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    break;
                case ReleaseOnly:
                    if ( ! BuildConfig.DEBUG )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case SwitchableRelease:
                    if ( BuildConfig.DEBUG )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    else if ( mConfig.releaseSwitcher )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Always:
                    Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;

            }
        else
            switch (mConfig.getGodMode().Mode) {
                case GodMode.GOD_ENABLE_ALL:
                    Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case GodMode.GOD_DISABLE_ALL:
                    return;
            }
    }

    /**
     *  enable GodMode
     *  @return enable successed?
     */
    public static boolean enableGodMode () {
        if ( mConfig == null )
            return false;
        mConfig.setGodMode( new GodMode( GodMode.GOD_ENABLE_ALL ) );
        return true;
    }
    /**
     *  disable GodMode
     *  @return disable successed?
     */
    public static boolean disableGodMode () {
        if ( mConfig == null )
            return true;
        mConfig.setGodMode( null );
        return true;
    }
}