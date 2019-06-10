package com.citizenzet.zetlib.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;


/**
 * Created by citizenzet on 11/4/16.
 */

public abstract class BaseFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    protected static final String TAG = "FCM Service";

    private NotificationManager mNotificationManager;
    private static final String ADMIN_CHANNEL_ID = "ADMIN_CHANNEL";

    protected  String serviceMessage = "SERVICE_MESSAGE";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage==null && remoteMessage.getData()==null &&  remoteMessage.getData().size()==0){
            return;
        }
        notify(remoteMessage.getData());
        final Intent i = new Intent();
        i.setAction(serviceMessage);
        sendBroadcast(i);
        setupBroadcast(remoteMessage.getData());
    }

//    protected void setupBroadcast(Map<String, String> data){
//        Intent intent = new Intent("new_push");
//        // You can also include some extra data.
//        intent.putExtra("message", "This is my message!");
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//    }
    protected abstract void setupBroadcast(Map<String, String> data);



//    protected void setupNotificationBuilder(NotificationCompat.Builder mBuilder, Map<String, String> data){
//        mBuilder.setSmallIcon(R.mipmap.ic_launcher)
//        .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
//        .setAutoCancel(true)
//        .setColor(getResources().getColor(R.color.colorAccent))
//        .setLights(0xFFe2c500, 100, 100)
//        .setContentTitle(title)
//        .setGroup("olimp_menu")
//        .setDefaults(Notification.DEFAULT_ALL)
//        .setContentText(msg);
//    }
    protected abstract void setupNotificationBuilder(NotificationCompat.Builder mBuilder, Map<String, String> data);

//    protected void setupNotification(NotificationCompat.BigTextStyle notification, Map<String, String> data){
//        notification.bigText(msg).build();
//    }
    protected abstract void setupNotification(NotificationCompat.BigTextStyle notification, Map<String, String> data);

//
//    protected void getResultIntent(){
//            Intent resultIntent = new Intent(this, MainActivity.class);
//              resultIntent.putExtra("updateContent", true);
//    }
    protected abstract Intent getResultIntent();

    private void notify(Map<String, String> data) {
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //Setting up Notification channels for android O and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setupChannels();
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, ADMIN_CHANNEL_ID);
        setupNotificationBuilder(mBuilder, data);
        Intent resultIntent = getResultIntent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,
                resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        NotificationCompat.BigTextStyle notificationBuild = new NotificationCompat.BigTextStyle(mBuilder);
        setupNotification(notificationBuild, data);
        Notification notification = notificationBuild.build();
        mNotificationManager.notify(getNotificationId(), notification);
    }

    protected Integer getNotificationId(){
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupChannels(){
        CharSequence adminChannelName = "admin";
        String adminChannelDescription = "admin";

        NotificationChannel adminChannel;
        adminChannel = new NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_DEFAULT);
        adminChannel.setDescription(adminChannelDescription);
        adminChannel.enableLights(true);
        adminChannel.setLightColor(Color.RED);
        adminChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        adminChannel.enableVibration(true);
        if (mNotificationManager != null) {
            mNotificationManager.createNotificationChannel(adminChannel);
        }
    }

    protected void wakeUp(String tag){
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = pm.isScreenOn();
        if(isScreenOn==false)
        {
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK |PowerManager.ACQUIRE_CAUSES_WAKEUP |PowerManager.ON_AFTER_RELEASE, tag);
            wl.acquire(10000);
            PowerManager.WakeLock wl_cpu = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, tag);

            wl_cpu.acquire(10000);
        }
    }
}