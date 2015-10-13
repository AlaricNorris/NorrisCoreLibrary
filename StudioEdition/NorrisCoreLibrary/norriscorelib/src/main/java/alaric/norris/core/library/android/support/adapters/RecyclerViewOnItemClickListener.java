/**
 *  RecyclerViewOnItemClickListener
 *  com.alaric.norris.app.credit.points.ui.listeners
 * 	Function: 	${TODO}
 *  date            author
 *  2015/9/6      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */

package alaric.norris.core.library.android.support.adapters;

import android.view.View;

/**
 * custom click/long click listener
 */
public interface RecyclerViewOnItemClickListener {
    /**
     * simple click
     * @param view          the view holds the click event
     * @param position      position in list
     */
    void onItemClick ( View view, int position );

    /**
     * long click
     * @param view          the view holds the click event
     * @param position      position in list
     */
    void onItemLongClick ( View view, int position );
}
