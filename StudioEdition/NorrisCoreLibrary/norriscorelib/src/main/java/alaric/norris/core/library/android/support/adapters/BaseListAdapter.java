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
 *  @since I used to be a programmer like you, then I took an arrow in the knee
 *	************************************************************************************************************************************************************************************************************
 * 	Modified By 	AlaricNorris		 2015/10/139:49
 *	Modifications:	${TODO}
 *	************************************************************************************************************************************************************************************************************
 */
public abstract class BaseListAdapter < VH extends RecyclerView.ViewHolder, Entity >
        extends BaseRecyclerAdapter< VH, Entity > {

    /**
     * Constructor method
     * @param inContext context
     * @param inList    list
     */
    public BaseListAdapter ( Context inContext, List< Entity > inList ) {
        super( inContext, inList );
    }

    /**
     * clear the list
     */
    public void clear () {
        mList.clear();
    }

    /**
     * add into the list
     * @param list      new list to add
     * @return true:success
     */
    public boolean addAll ( List< ? extends Entity > list ) {
        return mList.addAll( list );
    }

    /**
     * clear the lsit and add new list
     * @param list      new list to add
     * @return true:success
     */
    public boolean reload ( List< ? extends Entity > list ) {
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
     * @param i     itemposition
     * @return itemObject
     */
    public Entity getItem ( int i ) {
        return mList.get( i );
    }

    /**
     * addItem
     * @param entity     new item to add
     */
    public void addItem ( Entity entity ) {
        mList.add( entity );
    }

    /**
     * removeItem by position
     * @param i     position
     * @return removed Item
     */
    public Entity remove ( int i ) {
        return mList.remove( i );
    }
    /**
     * removeItem by object
     * @param entity     object
     * @return true:remove success
     */
    public boolean remove ( Entity entity ) {
        return mList.remove( entity );
    }

    /**
     * getItemID
     * @param position  itemPosition
     * @return itemID
     */
    public long getItemId ( int position ) {
        return position;
    }

    /**
     * get the list
     * @return the list
     */
    public List< Entity > getList () {
        return mList;
    }

}
