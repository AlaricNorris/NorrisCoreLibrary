/**
 *  OxLogConfig
 *  alaric.norris.core.library.oxlog
 *  Function:   config class
 *  date            author
 *  *****************************************************
 *  2015/10/29      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxtip.ol;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import alaric.norris.core.library.oxtip.Zeus;
/**
 *  ClassName:  OxLogConfig
 *  Function:   config class
 *  @author AlaricNorris
 *  Contact:    Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *	************************************************************************************************************************************************************************************************************
 * 	Modified By 	AlaricNorris		 2015/10/2917:12
 *	Modifications:	init
 *	************************************************************************************************************************************************************************************************************
 */
public class OxLogConfig {
    /**
     *  Only when BuildConfig.DEBUG = true
     */
    public static final int TIP_STRATEGY_DEBUG_ONLY = 0x1111;
    /**
     *  Only when BuildConfig.DEBUG = false
     */
    public static final int TIP_STRATEGY_RELEASE_ONLY = 0x2222;
    /**
     *  When DEBUG log
     *  When Release depend on switch
     */
    public static final int TIP_STRATEGY_SWITCHABLE_RELEASE = 0x3333;
    /**
     *  Always debug/release
     */
    public static final int TIP_STRATEGY_ALWAYS = 0x4444;
    /**
     *  DefaultTag
     */
    public final String DefaultTag;
    /**
     *  DefaultSuffix
     */
    public final String DefaultSuffix;

    /**
     *  Reference to BuildConfig.Debug
     */
    public final boolean BuildConfig_Debug;
    /**
     * Log Strategy
     */
    @TipStrategy
    public final int DefaultStrategy;
    /**
     * release version log switcher
     * true:    enable log
     * false:   disable log
     */
    private boolean ReleaseSwitcher;
    /**
     * The list of suffix to mute
     */
    @NonNull
    private ArrayList< String > Mutable = new ArrayList< String >();
    /**
     * Zeus
     */
    private Zeus mZeus;
    /**
     * Builder Mode constructor
     * @param inBuilder builder
     */
    private OxLogConfig ( Builder inBuilder ) {
        this.DefaultTag = inBuilder.DefaultTag;
        this.DefaultSuffix = inBuilder.DefaultSuffix;
        this.ReleaseSwitcher = inBuilder.ReleaseSwitcher;
        this.DefaultStrategy = inBuilder.DefaultStrategy;
        this.BuildConfig_Debug = inBuilder.BuildConfig_Debug;
    }
    /**
     * check the ReleaseSwitcher
     * @return true:on ; false:off
     */
    public boolean isReleaseSwitcher () {
        return ReleaseSwitcher;
    }
    /**
     * turn on/off the release switcher
     * @param releaseSwitcher
     */
    public void setReleaseSwitcher ( boolean releaseSwitcher ) {
        this.ReleaseSwitcher = releaseSwitcher;
    }
    @TipStrategy
    public int getDefaultStrategy () {
        return DefaultStrategy;
    }
    public Zeus getZeus () {
        return mZeus;
    }
    public void setZeus ( Zeus zeus ) {
        this.mZeus = zeus;
    }
    /**
     *  enable Zeus
     *  @param mode mode
     *  @return enable successed?
     */
    public boolean enableGodMode ( @Zeus.Mode int mode ) {
        setZeus( new Zeus( mode ) );
        return true;
    }
    /**
     *  disable Zeus
     *  @return disable successed?
     */
    public boolean disableGodMode () {
        setZeus( null );
        return true;
    }
    /**
     *  isMatchMutable(does the suffix match one of the Mutable )
     * @param suffix    suffix
     * @return true:mute ; false:not mute
     */
    public boolean isMatchMutable ( String suffix ) {
        if ( Mutable.size() > 0 && Mutable.contains( suffix ) )
            return true;
        return false;
    }
    /**
     * Mute a specific suffix
     * @param suffix
     */
    public OxLogConfig muteSuffix ( String suffix ) {
        Mutable.add( suffix );
        return this;
    }
    /**
     *  deMuteAll
     */
    public OxLogConfig deMute () {
        Mutable.clear();
        return this;
    }
    @IntDef ( {
                      TIP_STRATEGY_DEBUG_ONLY , TIP_STRATEGY_RELEASE_ONLY ,
                      TIP_STRATEGY_SWITCHABLE_RELEASE , TIP_STRATEGY_ALWAYS
              } )
    public @interface TipStrategy {}

    public static final class Builder {

        /**
         *
         */
        public String DefaultTag = OxLog.OX_TAG;
        /**
         *
         */
        public String DefaultSuffix = OxLog.OX_SUFFIX;
        /**
         *
         */
        public boolean BuildConfig_Debug = true;

        /**
         * release version log switcher
         * true:    enable log
         * false:   disable log
         */
        public boolean ReleaseSwitcher = true;

        @TipStrategy
        public int DefaultStrategy = TIP_STRATEGY_DEBUG_ONLY;

        /**
         * Builder Constructor
         * @param isDebug           Reference to BuildConfig.Debug
         * @param defaultStrategy   defaultStrategy
         */
        public Builder ( boolean isDebug, @TipStrategy int defaultStrategy ) {
            this.BuildConfig_Debug = isDebug;
            this.DefaultStrategy = defaultStrategy;
        }

        public Builder defaultTag ( String defaultTag ) {
            this.DefaultTag = defaultTag;
            return this;
        }
        public Builder defaultSuffix ( String defaultSuffix ) {
            this.DefaultSuffix = defaultSuffix;
            return this;
        }
        public Builder releaseSwitcher ( boolean releaseSwitcher ) {
            this.ReleaseSwitcher = releaseSwitcher;
            return this;
        }
        public OxLogConfig build () {
            return new OxLogConfig( this );
        }
    }
}
