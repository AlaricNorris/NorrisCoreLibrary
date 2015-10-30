/**
 *  OLConfigdeprecated
 *  alaric.norris.core.library.oxlog
 *  Function:   config class
 *  date            author
 *  *****************************************************
 *  2015/10/29      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxlog;

import alaric.norris.core.library.oxtip.GodMode;
import alaric.norris.core.library.oxtip.TipStrategy;
/**
 *  ClassName:  OLConfigdeprecated
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
public class OLConfig {

    /**
     *
     */
    public final String defaultTag;
    /**
     *
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
    private OLConfig ( Builder inBuilder ) {
        this.defaultTag = inBuilder.defaultTag;
        this.defaultSuffix = inBuilder.defaultSuffix;
        this.releaseSwitcher = inBuilder.releaseSwitcher;
        this.defaultStrategy = inBuilder.defaultStrategy;

    }
    public GodMode getGodMode () {
        return godMode;
    }
    public void setGodMode ( GodMode godMode ) {
        this.godMode = godMode;
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
        public OLConfig build () {
            return new OLConfig( this );
        }
    }

}
