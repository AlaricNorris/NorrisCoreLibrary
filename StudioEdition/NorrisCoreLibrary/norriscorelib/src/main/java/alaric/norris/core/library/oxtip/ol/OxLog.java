/**
 *  OxLog
 *  alaric.norris.core.library.oxlog
 * 	Function:       OxLog
 *  date            author
 *  *****************************************************
 *  2015/10/29      AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxtip.ol;

import android.support.annotation.NonNull;
import android.util.Log;

import alaric.norris.core.library.BuildConfig;
import alaric.norris.core.library.oxtip.Zeus;
/**
 ClassName:      OxLog
 Function:       OxLog
 @author AlaricNorris
 Contact:        Norris.sly@gmail.com
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ************************************************************************************************************************************************************************************************************
 Modified By 	AlaricNorris		 2015/10/2916:56
 Modifications:	init
 ************************************************************************************************************************************************************************************************************
 */
public class OxLog {

    @NonNull
    public static OxLogConfig mConfig =
            new OxLogConfig.Builder( OxLogConfig.TIP_STRATEGY_DEBUGONLY ).defaultTag( "OxLog" )
                                                                         .defaultSuffix( "OneShot" )
                                                                         .releaseSwitcher( true )
                                                                         .build()
                                                                         .muteSuffix( "" )
                                                                         .deMute();

    private OxLog () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "OxLog class cannot be instantiated" );
    }
    // Smart way to Log V
    public static void v ( String logInfo ) {
        v( logInfo, mConfig.defaultSuffix, mConfig.defaultStrategy );
    }
    public static void v ( String logInfo, String tagSuffix ) {
        v( logInfo, tagSuffix, mConfig.defaultStrategy );
    }
    public static void v ( String logInfo, int inStrategy ) {
        v( logInfo, mConfig.defaultSuffix, inStrategy );
    }
    public static void v ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUGONLY:
                    if ( BuildConfig.DEBUG )
                        Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    break;
                case OxLogConfig.TIP_STRATEGY_RELEASEONLY:
                    if ( ! BuildConfig.DEBUG )
                        Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLERELEASE:
                    if ( BuildConfig.DEBUG )
                        Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    else if ( mConfig.releaseSwitcher )
                        Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.v( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }

    // Smart way to Log D
    public static void d ( String logInfo ) {
        d( logInfo, mConfig.defaultSuffix, mConfig.defaultStrategy );
    }
    public static void d ( String logInfo, String tagSuffix ) {
        d( logInfo, tagSuffix, mConfig.defaultStrategy );
    }
    public static void d ( String logInfo, int inStrategy ) {
        d( logInfo, mConfig.defaultSuffix, inStrategy );
    }
    public static void d ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUGONLY:
                    if ( BuildConfig.DEBUG )
                        Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    break;
                case OxLogConfig.TIP_STRATEGY_RELEASEONLY:
                    if ( ! BuildConfig.DEBUG )
                        Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLERELEASE:
                    if ( BuildConfig.DEBUG )
                        Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    else if ( mConfig.releaseSwitcher )
                        Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.d( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }
    // Smart way to Log I
    public static void i ( String logInfo ) {
        i( logInfo, mConfig.defaultSuffix, mConfig.defaultStrategy );
    }
    public static void i ( String logInfo, String tagSuffix ) {
        i( logInfo, tagSuffix, mConfig.defaultStrategy );
    }
    public static void i ( String logInfo, int inStrategy ) {
        i( logInfo, mConfig.defaultSuffix, inStrategy );
    }
    public static void i ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUGONLY:
                    if ( BuildConfig.DEBUG )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    break;
                case OxLogConfig.TIP_STRATEGY_RELEASEONLY:
                    if ( ! BuildConfig.DEBUG )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLERELEASE:
                    if ( BuildConfig.DEBUG )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    else if ( mConfig.releaseSwitcher )
                        Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.i( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }

    // Smart way to Log W
    public static void w ( String logInfo ) {
        w( logInfo, mConfig.defaultSuffix, mConfig.defaultStrategy );
    }
    public static void w ( String logInfo, String tagSuffix ) {
        w( logInfo, tagSuffix, mConfig.defaultStrategy );
    }
    public static void w ( String logInfo, int inStrategy ) {
        w( logInfo, mConfig.defaultSuffix, inStrategy );
    }
    public static void w ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUGONLY:
                    if ( BuildConfig.DEBUG )
                        Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    break;
                case OxLogConfig.TIP_STRATEGY_RELEASEONLY:
                    if ( ! BuildConfig.DEBUG )
                        Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLERELEASE:
                    if ( BuildConfig.DEBUG )
                        Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    else if ( mConfig.releaseSwitcher )
                        Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.w( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }

    // Smart way to Log E
    public static void e ( String logInfo ) {
        e( logInfo, mConfig.defaultSuffix, mConfig.defaultStrategy );
    }
    public static void e ( String logInfo, String tagSuffix ) {
        e( logInfo, tagSuffix, mConfig.defaultStrategy );
    }
    public static void e ( String logInfo, int inStrategy ) {
        e( logInfo, mConfig.defaultSuffix, inStrategy );
    }
    public static void e ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUGONLY:
                    if ( BuildConfig.DEBUG )
                        Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    break;
                case OxLogConfig.TIP_STRATEGY_RELEASEONLY:
                    if ( ! BuildConfig.DEBUG )
                        Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLERELEASE:
                    if ( BuildConfig.DEBUG )
                        Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    else if ( mConfig.releaseSwitcher )
                        Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.e( mConfig.defaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }
}
