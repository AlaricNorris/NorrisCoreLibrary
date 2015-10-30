package alaric.norris.core.library.oxtip;
/**
 *  TipStrategy
 *  alaric.norris.core.library.oxlog
 * 	Function:       Tip Strategy
 *  date            author
 *  *****************************************************
 *  2015/10/29      365
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
public enum TipStrategy {
    /**
     *  Only when BuildConfig.DEBUG = true
     */
    DebugOnly,
    /**
     *  Only when BuildConfig.DEBUG = false
     */
    ReleaseOnly,
    /**
     *  When DEBUG log
     *  When Release depend on switch
     */
    SwitchableRelease,
    /**
     *  Always debug/release
     */
    Always
}
