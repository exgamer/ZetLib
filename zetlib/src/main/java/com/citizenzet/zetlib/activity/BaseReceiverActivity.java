package com.citizenzet.zetlib.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract class BaseReceiverActivity extends BaseRestActivity {

//    protected String receiverAction = "myAction";

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "custom-event-name" is broadcasted.
    protected BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onReceiveMessage(context, intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
//        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
//                new IntentFilter(receiverAction));
        registerReceiver();
    }
    @Override
    protected void onDestroy() {
        // Unregister since the activity is about to be closed.
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        unregisterReceiver();
        super.onDestroy();
    }

    /**
     * actions on message received
     * @param context
     * @param intent
     */
    protected abstract void onReceiveMessage(Context context, Intent intent);

    protected abstract void registerReceiver();
    protected abstract void unregisterReceiver();
}
