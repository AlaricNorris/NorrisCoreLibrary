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

import alaric.norris.core.library.oxtip.GodMode;
import alaric.norris.core.library.oxtip.TipStrategy;
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
     *  defaultTag
     */
    public final String defaultTag;
    /**
     *  defaultSuffix
     */
    public final String defaultSuffix;

    /**
     * release version log switcher
     * true:    enable log
     * false:   disable log
     */
    public final boolean releaseSwitcher;

    /**
     * Log Strategy
     */
    public final TipStrategy defaultStrategy;
    private GodMode godMode;
    /**
     * Builder Mode constructor
     * @param inBuilder builder
     */
    private OxLogConfig ( Builder inBuilder ) {
        this.defaultTag = inBuilder.defaultTag;
        this.defaultSuffix = inBuilder.defaultSuffix;
        this.releaseSwitcher = inBuilder.releaseSwitcher;
        this.defaultStrategy = inBuilder.defaultStrategy;

    }
    public String getDefaultTag () {
        return defaultTag;
    }
    public String getDefaultSuffix () {
        return defaultSuffix;
    }
    public boolean isReleaseSwitcher () {
        return releaseSwitcher;
    }
    public TipStrategy getDefaultStrategy () {
        return defaultStrategy;
    }
    public GodMode getGodMode () {
        return godMode;
    }
    public void setGodMode ( GodMode godMode ) {
        this.godMode = godMode;
    }
    /**
     *  enable GodMode
     *  @param mode mode
     *  @return enable successed?
     */
    public boolean enableGodMode ( @GodMode.Mode int mode ) {
        setGodMode( new GodMode( mode ) );
        return true;
    }
    /**
     *  disable GodMode
     *  @return disable successed?
     */
    public boolean disableGodMode () {
        setGodMode( null );
        return true;
    }

    public static final class Builder {

        /**
         *
         */
        public String defaultTag = "OxLog";
        /**
         *
         */
        public String defaultSuffix = "OneShot";

        /**
         * release version log switcher
         * true:    enable log
         * false:   disable log
         */
        public boolean releaseSwitcher = true;

        public TipStrategy defaultStrategy = TipStrategy.DebugOnly;

        public Builder ( TipStrategy defaultStrategy ) {
            this.defaultStrategy = defaultStrategy;
        }

        public Builder defaultTag ( String defaultTag ) {
            this.defaultTag = defaultTag;
            return this;
        }
        public Builder defaultSuffix ( String defaultSuffix ) {
            this.defaultSuffix = defaultSuffix;
            return this;
        }
        public Builder releaseSwitcher ( boolean releaseSwitcher ) {
            this.releaseSwitcher = releaseSwitcher;
            return this;
        }
        public OxLogConfig build () {
            return new OxLogConfig( this );
        }
    }
}
