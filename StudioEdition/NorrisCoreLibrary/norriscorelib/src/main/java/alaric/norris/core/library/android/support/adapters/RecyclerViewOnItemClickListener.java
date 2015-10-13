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
    void onItemClick ( View view, int position );

    void onItemLongClick ( View view, int position );
}
