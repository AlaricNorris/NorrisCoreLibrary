/**
 *  a
 *  alaric.norris.core.library.ue.ui
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/12/22         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.ue.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
/**
 ClassName:     UniversalBaseActivity
 Function:       ${TODO}  ADD FUNCTION
 Contact:        Norris.sly@gmail.com
 @author         AlaricNorris
 @version        Ver 1.0
 @since          I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/12/22    13:51
 Modifications:  ${TODO}
 ***************************************************************************************************
 */
public class UniversalBaseActivity extends AppCompatActivity
        implements View.OnTouchListener, GestureDetector.OnGestureListener {

    protected ProgressDialog mProgressDialog;
    protected GestureDetector mGestureDetector;
    protected int verticalMinDistance = 100;
    protected int minVelocity = 0;
    /**
     *  dismissProgressDialog
     */
    public void dismissProgressDialog () {
        if ( mProgressDialog != null && mProgressDialog.isShowing() )
            mProgressDialog.dismiss();
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        extractBundleData();
        setupGesture();
    }
    protected void setupGesture () {

        if ( isNeedGesture() ) {
            mGestureDetector = new GestureDetector( ( GestureDetector.OnGestureListener ) this );
            getWindow().getDecorView().setOnTouchListener( this );
        }
    }
    protected boolean isNeedGesture () {
        return false;
    }
    protected void extractBundleData () {
    }
    @Override
    public boolean onTouch ( View v, MotionEvent event ) {
        return mGestureDetector.onTouchEvent( event );
    }
    @Override
    public boolean onDown ( MotionEvent e ) {
        return false;
    }
    @Override
    public void onShowPress ( MotionEvent e ) {

    }
    @Override
    public boolean onSingleTapUp ( MotionEvent e ) {
        return false;
    }
    @Override
    public boolean onScroll ( MotionEvent e1, MotionEvent e2, float distanceX, float distanceY ) {
        return false;
    }
    @Override
    public void onLongPress ( MotionEvent e ) {

    }
    @Override
    public boolean onFling ( MotionEvent e1, MotionEvent e2, float velocityX, float velocityY ) {
        if ( isNeedGesture() )
            if ( Math.abs( e1.getX() - e2.getX() ) > Math.abs( e1.getY() - e2.getY() ) )
                if ( e1.getX() - e2.getX() > verticalMinDistance &&
                        Math.abs( velocityX ) > minVelocity ) {

                    // 切换Activity
                    // Intent intent = new Intent(ViewSnsActivity.this, UpdateStatusActivity.class);
                    // startActivity(intent);
                    Toast.makeText( this, "向左手势", Toast.LENGTH_SHORT ).show();
                }
                else if ( e2.getX() - e1.getX() > verticalMinDistance &&
                        Math.abs( velocityX ) > minVelocity ) {
                    onGestureBack();
                }

        return false;
    }
    protected void onGestureBack () {
        onBackPressed();
    }

    public static final class EB_Event_Void {

    }
}