package alaric.norris.core.library.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.CheckBox;

import alaric.norris.core.library.R;

public class BackgroundSelectorUtil {

    private BackgroundSelectorUtil () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }
    public static StateListDrawable getPressedSelector (
            Context context, int idPressed, int idNormal
    ) {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = idNormal == - 1 ? null : context.getResources().getDrawable( idNormal );
        Drawable pressed =
                idPressed == - 1 ? null : context.getResources().getDrawable( idPressed );
        bg.addState(
                new int[]{ android.R.attr.state_pressed , android.R.attr.state_pressed }, pressed
        );
        bg.addState(
                new int[]{ android.R.attr.state_pressed , android.R.attr.state_focused }, pressed
        );
        bg.addState( new int[]{ }, normal );
        return bg;
    }

    public static StateListDrawable getSelectedSelector (
            Context context, int idSelected, int idNormal
    ) {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = idNormal == - 1 ? null : context.getResources().getDrawable( idNormal );
        Drawable selected =
                idSelected == - 1 ? null : context.getResources().getDrawable( idSelected );
        bg.addState(
                new int[]{ android.R.attr.state_pressed , android.R.attr.state_selected }, selected
        );
        bg.addState( new int[]{ }, normal );
        return bg;
    }

    public static StateListDrawable getCheckeddSelector (
            Context context, int idChecked, int idNormal
    ) {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = idNormal == - 1 ? null : context.getResources().getDrawable( idNormal );
        Drawable selected =
                idChecked == - 1 ? null : context.getResources().getDrawable( idChecked );
        bg.addState( new int[]{ android.R.attr.state_checked }, selected );
        bg.addState( new int[]{ }, normal );
        return bg;
    }

    public static SpannableString getContentColor (
            Context context, String quoto, String message
    ) {
        SpannableString sp = new SpannableString( quoto + message );
        sp.setSpan(
                new ForegroundColorSpan(
                        context.getResources().getColor( R.color.forum_inactive_color )
                ), 0, quoto.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        );
        sp.setSpan(
                new ForegroundColorSpan(
                        context.getResources().getColor( R.color.forum_active_color )
                ), quoto.length(), sp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        return sp;
    }

    public static SpannableString getContentColor ( Context context, int quotoId, int messageId ) {
        return getContentColor(
                context, context.getString( quotoId ), context.getString( messageId )
        );
    }

    public static SpannableString getContentColor ( Context context, int quotoId, String message ) {
        return getContentColor( context, context.getString( quotoId ), message );
    }

    public static void setRightCheckBoxDrawable ( Context context, int drawableId, CheckBox box ) {
        Drawable drawable = context.getResources().getDrawable( drawableId ); // /
        drawable.setBounds( 0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight() );
        box.setCompoundDrawables( null, null, drawable, null );
    }
}
