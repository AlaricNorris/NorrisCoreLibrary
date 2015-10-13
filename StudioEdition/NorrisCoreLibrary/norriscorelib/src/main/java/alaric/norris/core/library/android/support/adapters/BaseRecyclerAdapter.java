/**
 *  BaseRecyclerAdapter
 *  com.alaric.norris.app.credit.points.ui.adapters
 * 	Function:  	BaseAdapter in universe
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
 * Common base RecyclerAdapter
 * Features:    with click/long click listener
 * @param <VH>  Custom ViewHolder
 * @param <Entity>   Custom Class
 */
public abstract class BaseRecyclerAdapter < VH extends RecyclerView.ViewHolder, Entity >
        extends RecyclerView.Adapter< VH > {

    /**
     * the context
     */
    protected Context mContext;
    /**
     * the list
     */
    protected List< Entity > mList;
    /**
     * click listener
     */
    protected RecyclerViewOnItemClickListener mRecyclerViewOnItemClickListener;
    /**
     * Constructor method
     * @param inContext context
     * @param inList    list
     */
    public BaseRecyclerAdapter ( Context inContext, List< Entity > inList ) {
        this.mContext = inContext;
        this.mList = inList;
    }
    /**
     * get an object from the list
     * @param inPosition location in list
     * @return Entity    the object
     */
    public Entity obtainItemAtPosition ( int inPosition ) {
        if ( mList != null ) {
            return mList.get( inPosition );
        }
        return null;
    }
    /**
     * set the click listener for adapter
     * @param mRecyclerViewOnItemClickLitener custom listener
     */
    public void setRecyclerViewOnItemClickListener (
            RecyclerViewOnItemClickListener mRecyclerViewOnItemClickLitener
    ) {
        this.mRecyclerViewOnItemClickListener = mRecyclerViewOnItemClickLitener;
    }
    @Override
    public void onBindViewHolder ( final VH holder, int position ) {
        onBindViewHolderBase( holder, position );
        if ( mRecyclerViewOnItemClickListener != null ) {
            holder.itemView.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick ( View v ) {
                            if ( mRecyclerViewOnItemClickListener != null )
                                mRecyclerViewOnItemClickListener.onItemClick(
                                        holder.itemView, holder.getLayoutPosition()
                                );
                        }
                    }
            );
            holder.itemView.setOnLongClickListener(
                    new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick ( View v ) {
                            if ( mRecyclerViewOnItemClickListener != null )
                                mRecyclerViewOnItemClickListener.onItemLongClick(
                                        holder.itemView, holder.getLayoutPosition()
                                );
                            return false;
                        }
                    }
            );
        }
    }
    /**
     * the base method called in #onBindViewHolder()
     * extracted for child to overload
     * @param holder        the viewholder passed in #onBindViewHolder()
     * @param position      the position passed in #onBindViewHolder()
     */
    protected abstract void onBindViewHolderBase ( VH holder, int position );

    @Override
    public int getItemCount () {
        return mList == null ? 0 : mList.size();
    }

}
