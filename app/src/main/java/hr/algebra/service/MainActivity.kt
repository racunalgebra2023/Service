package hr.algebra.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.JobIntentService
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate( savedInstanceState : Bundle?) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        startServiceButton.setOnClickListener {
            startService( Intent( this, MyService::class.java ) )
        }

        testButton.setOnClickListener {
            Toast
                .makeText( this, "Testing...", Toast.LENGTH_SHORT )
                .show( )
        }

        stopService.setOnClickListener {
            stopService( Intent( this, MyService::class.java ) )
        }

        startIntentService.setOnClickListener {
            startService( Intent( this, MyIntentService::class.java ).apply {
                action = MY_ACTION
                putExtra( MY_EXTRA, 5 )
            } )
        }

        startJobIntentService.setOnClickListener {
            val intent = Intent( this, MyJobIntentService::class.java ).apply {
                action = MY_ACTION
                putExtra( MY_EXTRA, 5 )
            }
            JobIntentService.enqueueWork( this, MyJobIntentService::class.java, 101, intent )
        }

        startMyWork.setOnClickListener {
            val data  = Data.Builder( ).putInt( MY_EXTRA, 5 ).build( )
            val request = OneTimeWorkRequestBuilder< MyWorker >( )
                                .setInputData( data )
                                .build( )
            WorkManager
                .getInstance( this )
                .enqueue( request )
        }
    }
}