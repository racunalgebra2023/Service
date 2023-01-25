package hr.algebra.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service( ) {

    val TAG = "MyService"
    var serviceRunning = false

    override fun onStartCommand( intent: Intent?, flags: Int, startId: Int ) : Int {
        if( !serviceRunning ) {
            Log.i(TAG, "Service started")
            BackgroundTask( this ).execute( 5 )
            serviceRunning = true
        } else {
            Toast
                .makeText( this, "Service already started", Toast.LENGTH_SHORT )
                .show( )
        }
        return START_STICKY
    }

    override fun onBind( p0: Intent? ): IBinder? {
        TODO( "Not yet implemented" )
    }

    override fun onDestroy( ) {
        Log.i( TAG, "onDestroy" )
        super.onDestroy( )
    }
}