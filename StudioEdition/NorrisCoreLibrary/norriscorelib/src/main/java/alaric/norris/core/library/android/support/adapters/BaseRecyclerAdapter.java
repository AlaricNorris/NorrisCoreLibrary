/**
 *  BaseRecyclerAdapter
 *  com.alaric.norris.app.credit.points.ui.adapters
 * 	Function:  	${TODO}
 *  date            author
 *  2015/9/10      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.android.support.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;
/**
 *  ClassName:  BaseRecyclerAdapter
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  @contact Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *  @Date 2015     2015/9/10     16:06
 *  @see        ${TAGS}
 *	@Fields
 *	@Methods ${ENCLOSING_TYPE}
 * 	Modified By 	AlaricNorris		 2015/9/1016:06
 *	Modifications:	${TODO}
 */
public abstract class BaseRecyclerAdapter < VH extends RecyclerView.ViewHolder, T >
        extends RecyclerView.Adapter< VH > {

    protected Context mContext;
    protected List< T > mList;
    protected RecyclerViewOnItemClickLitener mRecyclerViewOnItemClickLitener;
    public BaseRecyclerAdapter ( Context inContext, List< T > inList ) {
        this.mContext = inContext;
        this.mList = inList;
    }
    public T getItemAtPosition ( int inPosition ) {
        if ( mList != null ) {
            return mList.get( inPosition );
        }
        return null;
    }
    public void setRecyclerViewOnItemClickLitener (
            RecyclerViewOnItemClickLitener mRecyclerViewOnItemClickLitener
    ) {
        this.mRecyclerViewOnItemClickLitener = mRecyclerViewOnItemClickLitener;
    }
    @Override
    public void onBindViewHolder ( final VH holder, int position ) {
        onBindViewHolderBase( holder, position );
        if ( mRecyclerViewOnItemClickLitener != null ) {
            holder.itemView.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick ( View v ) {
                            if ( mRecyclerViewOnItemClickLitener != null )
                                mRecyclerViewOnItemClickLitener.onItemClick(
                                        holder.itemView, holder.getLayoutPosition()
                                );
                        }
                    }
            );
            holder.itemView.setOnLongClickListener(
                    new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick ( View v ) {
                            if ( mRecyclerViewOnItemClickLitener != null )
                                mRecyclerViewOnItemClickLitener.onItemLongClick(
                                        holder.itemView, holder.getLayoutPosition()
                                );
                            return false;
                        }
                    }
            );
        }
    }
    protected abstract void onBindViewHolderBase ( VH holder, int position );

    @Override
    public int getItemCount () {
        return mList == null ? 0 : mList.size();
    }

}
