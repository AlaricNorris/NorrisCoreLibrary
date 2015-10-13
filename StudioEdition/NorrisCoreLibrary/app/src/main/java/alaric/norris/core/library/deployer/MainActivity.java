package alaric.norris.core.library.deployer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import alaric.norris.core.library.android.support.adapters.BaseRecyclerAdapter;
import alaric.norris.core.library.utils.ClickUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings ) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    class TestAdapter extends BaseRecyclerAdapter< TestAdapter.ViewHolder, String > {
        /**
         * Constructor method

         * @param inContext context
         * @param inList    list
         */
        public TestAdapter ( Context inContext, List< String > inList ) {
            super( inContext, inList );
        }
        @Override
        protected void onBindViewHolderBase ( ViewHolder holder, int position ) {
            ClickUtil.isFastDoubleClick();

        }
        @Override
        public ViewHolder onCreateViewHolder ( ViewGroup viewGroup, int i ) {
            return null;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder ( View itemView ) {
                super( itemView );
            }
        }

    }

}
