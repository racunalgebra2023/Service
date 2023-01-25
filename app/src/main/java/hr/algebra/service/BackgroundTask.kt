package hr.algebra.service

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast

class BackgroundTask( private val context : Context) : AsyncTask<Int, Int, String>( ) {

    private val TAG = "BackgroundTask"

    override fun doInBackground( vararg params: Int? ) : String {
        val taskCount = params[0]
        for( i in 0 until taskCount!! ) {
            Log.i( TAG, i.toString( ) )
            publishProgress( ( ( i+1 )*100.toDouble( )/taskCount ).toInt( ) )
            Thread.sleep( 4000 )
        }
        return "Finished"
    }

    override fun onProgressUpdate( vararg values: Int? )  {
        val progress = values[0]
        Toast
            .makeText( context, "$progress% done.", Toast.LENGTH_SHORT )
            .show( )
    }

    override fun onPostExecute( result: String? ) {
        Toast
            .makeText( context, result, Toast.LENGTH_SHORT )
            .show( )
    }
}