package hr.algebra.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import android.widget.Toast

const val MY_ACTION = "com.algebra.services.action.MY_ACTION"
const val MY_EXTRA = "com.algebra.services.extra.INT_EXTRA"


class MyIntentService : IntentService( "MyIntentService" ) {

    val TAG = "MyIntentService"

    override fun onHandleIntent( intent: Intent? ) {
        Log.i( TAG, "MyIntentService started..." )
        if( intent?.action== MY_ACTION )
            handleAction( intent.getIntExtra( MY_EXTRA, -1 ) )
    }

    private fun handleAction( taskCount : Int ) {
        for( i in 0 until taskCount!! ) {
            Log.i( TAG, i.toString( ) )
            Thread.sleep( 4000 )
            Toast
                .makeText( this, "$i of $taskCount done.", Toast.LENGTH_SHORT )
                .show( )
        }
    }

    override fun onDestroy( ) {
        Log.i( TAG, "Gotovo..." )
    }
}