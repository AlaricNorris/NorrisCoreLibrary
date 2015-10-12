/**
 *  RecyclerViewOnItemClickLitener
 *  com.alaric.norris.app.credit.points.ui.listeners
 * 	Function： 	${TODO} 
 *  date            author
 *  ──────────────────────────────────
 *  2015/9/6      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */

package alaric.norris.core.library.android.support.adapters;

import android.view.View;
/**
 *  ClassName:  RecyclerViewOnItemClickLitener
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author     AlaricNorris 
 *  @contact    Norris.sly@gmail.com
 *  @version    Ver 1.0
 *  @since      I used to be a programmer like you, then I took an arrow in the knee 
 *  @Date       2015     2015/9/6     9:50
 *  @see        ${TAGS}
 *  ──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields     
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods    ${ENCLOSING_TYPE}
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	AlaricNorris		 2015/9/69:50
 *	Modifications:	${TODO}
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */

public interface RecyclerViewOnItemClickLitener {
    void onItemClick ( View view, int position );

    void onItemLongClick ( View view, int position );
}
