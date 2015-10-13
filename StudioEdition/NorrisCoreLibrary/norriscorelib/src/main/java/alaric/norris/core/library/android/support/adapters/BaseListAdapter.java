/**
 *  BaseListAdapter
 *  alaric.norris.core.library.android.support.adapters
 * 	Function: 	${TODO}
 *  date            author
 *  *****************************************************
 *  2015/10/13      AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.android.support.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;
/**
 *  ClassName:  BaseListAdapter
 *  Function:   ${TODO}  ADD FUNCTION
 *  Reason:     ${TODO}  ADD REASON
 *  @author AlaricNorris
 *  Contact:    Norris.sly@gmail.com
 *  @version Ver 1.0
 *  @Date 2015     2015/10/13     9:49
 *  @see        ${TAGS}
 *	@Fields
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *	************************************************************************************************************************************************************************************************************
 *	@Methods ${ENCLOSING_TYPE}
 *	************************************************************************************************************************************************************************************************************
 * 	Modified By 	AlaricNorris		 2015/10/139:49
 *	Modifications:	${TODO}
 *	************************************************************************************************************************************************************************************************************
 */
public abstract class BaseListAdapter < VH extends RecyclerView.ViewHolder, T >
        extends BaseRecyclerAdapter< VH, T > {

    /**
     * Constructor method
     * @param inContext context
     * @param inList    list
     */
    public BaseListAdapter ( Context inContext, List< T > inList ) {
        super( inContext, inList );
    }

    /**
     * @formatter:on clear the list
     */
    public void clear () {
        mList.clear();
    }

    /**
     * add into the list
     * @param list      new list to add
     * @return true:success
     */
    public boolean addAll ( List< ? extends T > list ) {
        return mList.addAll( list );
    }

    /**
     * clear the lsit and add new list
     * @param list      new list to add
     * @return true:success
     */
    public boolean reload ( List< ? extends T > list ) {
        mList.clear();
        return mList.addAll( list );
    }
    /**
     * is the list empty
     * @return true:empty
     */
    public boolean isEmpty () {
        return mList == null ? true : mList.isEmpty();
    }
    /**
     * the length of the list
     * @return length
     */
    public int getCount () {
        return getItemCount();
    }

    /**
     * getItem at position
     * @param i      itemposition
     * @return itemObject
     */
    public T getItem ( int i ) {
        return mList.get( i );
    }

    public void addItem ( T t ) {
        mList.add( t );
    }

    public T remove ( int i ) {
        return mList.remove( i );
    }

    public long getItemId ( int id ) {
        return id;
    }

    public List< T > getList () {
        return mList;
    }

}
