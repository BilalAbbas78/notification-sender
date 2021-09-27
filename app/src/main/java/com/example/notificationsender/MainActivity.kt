package com.example.notificationsender

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.btnPressMe)
        var txtTitle = findViewById<EditText>(R.id.txtTitle)
        var txtText = findViewById<EditText>(R.id.txtText)

        val CHANNEL_ID = "ABC";

        btn.setOnClickListener(){

            var builder = NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(txtTitle.text)
                    .setContentText(txtText.text)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)


            val channel = NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_DEFAULT)

            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            with(NotificationManagerCompat.from(this)){
                notify(1, builder.build())
            }

        }
    }
}