/**
 *  Back2TopHelper
 *  com.alaric.norris.app.credit.points.ui.helpers
 * 	Function： 	${TODO}
 *  date            author
 *  ──────────────────────────────────
 *  2015/9/22      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.android.support.helpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 *  ClassName:  Back2TopHelper
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  @contact Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *  @Date 2015     2015/9/22     13:34
 *  @see        ${TAGS}
 *  ──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods ${ENCLOSING_TYPE}
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	AlaricNorris		 2015/9/2213:34
 *	Modifications:	${TODO}
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class Back2TopHelper {
    public static boolean applyFeatures ( final RecyclerView inRecyclerView, final View inView )
            throws InvalidLayoutManagerException {
        return applyFeatures( inRecyclerView, inView, true );
    }
    /**
     * apply "Back 2 Top" Features to RecyclerView
     * @param inRecyclerView
     * @param inView
     * @return
     * @throws InvalidLayoutManagerException
     */
    public static boolean applyFeatures (
            final RecyclerView inRecyclerView, final View inView, final boolean isSmooth
    ) throws InvalidLayoutManagerException {
        if ( inRecyclerView.getLayoutManager() == null ) {
            throw new InvalidLayoutManagerException( "LayoutManager is null!" );
        }
        if ( inRecyclerView.getLayoutManager() instanceof LinearLayoutManager ||
                inRecyclerView.getLayoutManager() instanceof GridLayoutManager ) {
            inView.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick ( View v ) {
                            inView.setVisibility( View.GONE );
                            if ( isSmooth )
                                inRecyclerView.smoothScrollToPosition( 0 );
                            else
                                back2Top( inRecyclerView );
                        }
                    }
            );
            RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {

                @Override
                public void onScrollStateChanged ( RecyclerView recyclerView, int newState ) {
                    super.onScrollStateChanged( recyclerView, newState );
                    // TODO Auto-generated method stub
                    if ( recyclerView.getAdapter() == null ||
                            recyclerView.getAdapter().getItemCount() == 0 ) {
                        inView.setVisibility( View.GONE );
                        return;
                    }
                    switch (newState) {
                        // 当不滚动时
                        case RecyclerView.SCROLL_STATE_IDLE:// 是当屏幕停止滚动时
                            // 区分LayoutManager类型，从而调用API
                            if ( recyclerView.getLayoutManager() instanceof LinearLayoutManager ) {
                                // 判断滚动到顶部
                                if ( ( ( LinearLayoutManager ) recyclerView.getLayoutManager() ).findFirstVisibleItemPosition() ==
                                        0 ) {
                                    inView.setVisibility( View.GONE );
                                }
                                else {
                                    if ( recyclerView.getChildCount() > 0 )
                                        inView.setVisibility( View.VISIBLE );
                                }
                            }
                            else if ( recyclerView.getLayoutManager() instanceof GridLayoutManager ) {
                                // 判断滚动到顶部
                                if ( ( ( GridLayoutManager ) recyclerView.getLayoutManager() ).findFirstVisibleItemPosition() ==
                                        0 ) {
                                    inView.setVisibility( View.GONE );
                                }
                                else {
                                    if ( recyclerView.getChildCount() > 0 )
                                        inView.setVisibility( View.VISIBLE );
                                }
                            }
                            break;
                        case RecyclerView.SCROLL_STATE_DRAGGING:
                        case RecyclerView.SCROLL_STATE_SETTLING:
                            inView.setVisibility( View.GONE );
                            break;
                    }
                }
                @Override
                public void onScrolled ( RecyclerView recyclerView, int dx, int dy ) {
                    super.onScrolled( recyclerView, dx, dy );
                }
            };
            inRecyclerView.addOnScrollListener( listener );
            return true;
        }
        throw new InvalidLayoutManagerException( "Customized LayoutManager is not supported!" );
    }

    private static void back2Top ( final RecyclerView inRecyclerView ) {
        int currentFirstVisibleItem = 1;
        final RecyclerView.LayoutManager layoutManager = inRecyclerView.getLayoutManager();
        if ( layoutManager instanceof LinearLayoutManager ) {
            currentFirstVisibleItem =
                    ( ( LinearLayoutManager ) layoutManager ).findFirstVisibleItemPosition();
        }
        else if ( layoutManager instanceof GridLayoutManager ) {
            currentFirstVisibleItem =
                    ( ( GridLayoutManager ) layoutManager ).findFirstVisibleItemPosition();
        }
        else {
            inRecyclerView.smoothScrollToPosition( 0 );
            return;
        }
        ValueAnimator animator = ValueAnimator.ofInt( currentFirstVisibleItem, 0 );
        animator.setTarget( inRecyclerView );
        animator.addListener(
                new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd ( Animator animation ) {
                        super.onAnimationEnd( animation );
                        inRecyclerView.smoothScrollToPosition( 0 );
                    }
                }
        );
        animator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate ( ValueAnimator animation ) {
                        if ( ( Integer ) animation.getAnimatedValue() ==
                                ( ( LinearLayoutManager ) layoutManager ).findFirstVisibleItemPosition() ) {
                            return;
                        }
                        inRecyclerView.smoothScrollToPosition(
                                ( Integer ) animation.getAnimatedValue()
                        );
                    }
                }
        );
        animator.setInterpolator( new AccelerateDecelerateInterpolator() );
        animator.setDuration( 500 ).start();
    }

}