/**
 *  OLConfigdeprecated
 *  alaric.norris.core.library.oxlog
 * 	Function: 	${TODO}
 *  date            author
 *  *****************************************************
 *  2015/10/29      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.oxlog;

import alaric.norris.core.library.oxtip.TipStrategy;
/**
 *  ClassName:  OLConfigdeprecated
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  Contact:    Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *	************************************************************************************************************************************************************************************************************
 * 	Modified By 	AlaricNorris		 2015/10/2917:12
 *	Modifications:	${TODO}
 *	************************************************************************************************************************************************************************************************************
 */
public class OLConfigdeprecated {

    /**
     *
     */
    public String defaultTag = "";
    /**
     *
     */
    public String defaultSuffix = "";

    /**
     * release version log switcher
     * true:    enable log
     * false:   disable log
     */
    public boolean releaseSwitcher = true;

    public TipStrategy defaultStrategy = TipStrategy.DebugOnly;

    private OLConfigdeprecated () {

    }


}
