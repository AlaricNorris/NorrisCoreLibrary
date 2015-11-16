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

    public static final String OX_TAG = "OxLog";
    public static final String OX_SUFFIX = "OneShot";
    @NonNull
    public static OxLogConfig mConfig =
            new OxLogConfig.Builder( true, OxLogConfig.TIP_STRATEGY_DEBUG_ONLY ).defaultTag(
                    OX_TAG
            ).defaultSuffix( OX_SUFFIX ).releaseSwitcher( false ).build().muteSuffix( "" ).deMute();
    /**
     * private constructor
     */
    private OxLog () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "OxLog class cannot be instantiated" );
    }
    // Smart way to Log V
    public static void v ( String logInfo ) {
        v( logInfo, mConfig.DefaultSuffix, mConfig.DefaultStrategy );
    }
    public static void v ( String logInfo, String tagSuffix ) {
        v( logInfo, tagSuffix, mConfig.DefaultStrategy );
    }
    public static void v ( String logInfo, int inStrategy ) {
        v( logInfo, mConfig.DefaultSuffix, inStrategy );
    }
    public static void v ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUG_ONLY:
                    if ( mConfig.BuildConfig_Debug )
                        Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_RELEASE_ONLY:
                    if ( ! mConfig.BuildConfig_Debug )
                        Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLE_RELEASE:
                    if ( mConfig.BuildConfig_Debug )
                        Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    else if ( mConfig.isReleaseSwitcher() )
                        Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.v( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }

    // Smart way to Log D
    public static void d ( String logInfo ) {
        d( logInfo, mConfig.DefaultSuffix, mConfig.DefaultStrategy );
    }
    public static void d ( String logInfo, String tagSuffix ) {
        d( logInfo, tagSuffix, mConfig.DefaultStrategy );
    }
    public static void d ( String logInfo, int inStrategy ) {
        d( logInfo, mConfig.DefaultSuffix, inStrategy );
    }
    public static void d ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUG_ONLY:
                    if ( mConfig.BuildConfig_Debug )
                        Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_RELEASE_ONLY:
                    if ( ! mConfig.BuildConfig_Debug )
                        Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLE_RELEASE:
                    if ( mConfig.BuildConfig_Debug )
                        Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    else if ( mConfig.isReleaseSwitcher() )
                        Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.d( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }
    // Smart way to Log I
    public static void i ( String logInfo ) {
        i( logInfo, mConfig.DefaultSuffix, mConfig.DefaultStrategy );
    }
    public static void i ( String logInfo, String tagSuffix ) {
        i( logInfo, tagSuffix, mConfig.DefaultStrategy );
    }
    public static void i ( String logInfo, int inStrategy ) {
        i( logInfo, mConfig.DefaultSuffix, inStrategy );
    }
    public static void i ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUG_ONLY:
                    if ( mConfig.BuildConfig_Debug )
                        Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_RELEASE_ONLY:
                    if ( ! mConfig.BuildConfig_Debug )
                        Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLE_RELEASE:
                    if ( mConfig.BuildConfig_Debug )
                        Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    else if ( mConfig.isReleaseSwitcher() )
                        Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.i( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }

    // Smart way to Log W
    public static void w ( String logInfo ) {
        w( logInfo, mConfig.DefaultSuffix, mConfig.DefaultStrategy );
    }
    public static void w ( String logInfo, String tagSuffix ) {
        w( logInfo, tagSuffix, mConfig.DefaultStrategy );
    }
    public static void w ( String logInfo, int inStrategy ) {
        w( logInfo, mConfig.DefaultSuffix, inStrategy );
    }
    public static void w ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUG_ONLY:
                    if ( mConfig.BuildConfig_Debug )
                        Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_RELEASE_ONLY:
                    if ( ! mConfig.BuildConfig_Debug )
                        Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLE_RELEASE:
                    if ( mConfig.BuildConfig_Debug )
                        Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    else if ( mConfig.isReleaseSwitcher() )
                        Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.w( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }

    // Smart way to Log E
    public static void e ( String logInfo ) {
        e( logInfo, mConfig.DefaultSuffix, mConfig.DefaultStrategy );
    }
    public static void e ( String logInfo, String tagSuffix ) {
        e( logInfo, tagSuffix, mConfig.DefaultStrategy );
    }
    public static void e ( String logInfo, int inStrategy ) {
        e( logInfo, mConfig.DefaultSuffix, inStrategy );
    }
    public static void e ( String logInfo, String tagSuffix, int inStrategy ) {
        if ( mConfig.getZeus() == null ) {
            if ( mConfig.isMatchMutable( tagSuffix ) )
                return;
            switch (inStrategy) {
                case OxLogConfig.TIP_STRATEGY_DEBUG_ONLY:
                    if ( mConfig.BuildConfig_Debug )
                        Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_RELEASE_ONLY:
                    if ( ! mConfig.BuildConfig_Debug )
                        Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_SWITCHABLE_RELEASE:
                    if ( mConfig.BuildConfig_Debug )
                        Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    else if ( mConfig.isReleaseSwitcher() )
                        Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case OxLogConfig.TIP_STRATEGY_ALWAYS:
                    Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;

            }
        }
        else
            switch (mConfig.getZeus().Mode) {
                case Zeus.ZEUS_ENABLE_ALL:
                    Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_ENABLE_ALL_BUT_MUTE:
                    if ( mConfig.isMatchMutable( tagSuffix ) )
                        return;
                    Log.e( mConfig.DefaultTag + tagSuffix, logInfo );
                    return;
                case Zeus.ZEUS_DISABLE_ALL:
                    return;
            }
    }
}
