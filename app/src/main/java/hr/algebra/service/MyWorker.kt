package hr.algebra.service

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker( ctx: Context, params: WorkerParameters ) : Worker( ctx, params )  {

    val TAG = "MyWorker"
    val handler = Handler( Looper.getMainLooper( ) )

    override fun doWork( ): Result {
        val taskCount = inputData.getInt( MY_EXTRA, -1 )
        handleAction( taskCount )
        return Result.success( )
    }

    private fun handleAction( taskCount : Int ) {
        for( i in 0 until taskCount!! ) {
            Log.i( TAG, i.toString( ) )
            Thread.sleep( 4000 )
            handler.post {
                Toast
                    .makeText( applicationContext, "$i of $taskCount done.", Toast.LENGTH_SHORT )
                    .show()
            }
        }
    }
}