/**
 *  asdf
 *  alaric.norris.core.library.android.support.adapters
 * 	Function: 	${TODO}
 *  date            author
 *  *****************************************************
 *  2015/10/16      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.android.support.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
/**
 *  ClassName:  asdf
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  Contact:    Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *	************************************************************************************************************************************************************************************************************
 * 	Modified By 	AlaricNorris		 2015/10/1613:52
 *	Modifications:	${TODO}
 *	************************************************************************************************************************************************************************************************************
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();
    // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true;
    // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5;
    private int current_page = 1;

    private LinearLayoutManager mLinearLayoutManager;

    public EndlessRecyclerOnScrollListener ( LinearLayoutManager linearLayoutManager ) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled ( RecyclerView recyclerView, int dx, int dy ) {
        super.onScrolled( recyclerView, dx, dy );

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if ( loading ) {
            if ( totalItemCount > previousTotal ) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if ( ! loading &&
                ( totalItemCount - visibleItemCount ) <= ( firstVisibleItem + visibleThreshold ) ) {
            // End has been reached

            // Do something
            current_page++;

            onLoadMore( current_page );

            loading = true;
        }
    }

    public abstract void onLoadMore ( int current_page );
}