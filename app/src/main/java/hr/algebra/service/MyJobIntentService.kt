package hr.algebra.service

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.JobIntentService

class MyJobIntentService : JobIntentService( ) {

    val TAG = "MyJobIntentService"
    val handler = Handler( Looper.getMainLooper( ) )

    override fun onHandleWork( intent: Intent ) {
        Log.i( TAG, "MyJobIntentService started..." )
        if( intent?.action== MY_ACTION )
            handleAction( intent.getIntExtra( MY_EXTRA, -1 ) )
    }

    private fun handleAction( taskCount : Int ) {
        for( i in 0 until taskCount!! ) {
            Log.i( TAG, i.toString( ) )
            Thread.sleep( 2000 )
            handler.post {
                Toast
                    .makeText( this, "$i of $taskCount done.", Toast.LENGTH_SHORT )
                    .show( )
            }
        }
    }

    override fun onDestroy() {
        Log.i( TAG, "Work done..." )
    }
}