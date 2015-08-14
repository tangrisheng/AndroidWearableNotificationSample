package demo.wearable.trs.com.wearabledemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_VOICE_REPLY = "extra_voice_reply";

    Button notificationButton;
    Button notificationOldButton;
    Button wearableOnlyButton;
    Button bigStyleButton;
    Button featuresButton;
    Button voiseInputButton;
    Button preDefinedButton;
    Button pagesButton;
    Button stackingButton;
    Button summaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCtrl();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void initCtrl() {
        notificationButton = (Button) findViewById(R.id.btn_notification);
        notificationButton.setOnClickListener(this);

        notificationOldButton = (Button) findViewById(R.id.btn_notification_old);
        notificationOldButton.setOnClickListener(this);

        wearableOnlyButton = (Button) findViewById(R.id.btn_wearable_only);
        wearableOnlyButton.setOnClickListener(this);

        bigStyleButton = (Button) findViewById(R.id.btn_bigstyle);
        bigStyleButton.setOnClickListener(this);

        featuresButton = (Button) findViewById(R.id.btn_features);
        featuresButton.setOnClickListener(this);

        voiseInputButton = (Button) findViewById(R.id.btn_voise_input);
        voiseInputButton.setOnClickListener(this);

        preDefinedButton = (Button) findViewById(R.id.btn_pre_defined);
        preDefinedButton.setOnClickListener(this);

        pagesButton = (Button) findViewById(R.id.btn_pages);
        pagesButton.setOnClickListener(this);

        stackingButton = (Button) findViewById(R.id.btn_stacking);
        stackingButton.setOnClickListener(this);

        summaryButton = (Button) findViewById(R.id.btn_summary);
        summaryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_notification:
                showNotification();
                break;
            case R.id.btn_notification_old:
                showNotificationOld();
                break;
            case R.id.btn_wearable_only:
                showWearableOnlyNotification();
                break;
            case R.id.btn_bigstyle:
                showBigStyleNotification();
                break;
            case R.id.btn_features:
                showFeaturesNotification();
                break;
            case R.id.btn_voise_input:
                showVoiseInputNotification();
                break;
            case R.id.btn_pre_defined:
                showPreDefinedNotification();
                break;
            case R.id.btn_pages:
                showPagesNotification();
                break;
            case R.id.btn_stacking:
                showStackingNotification();
                break;
            case R.id.btn_summary:
                showSummaryNotification();
                break;

        }
    }




    /**
     * wearable notification.
     */
    private void showNotification() {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("text");
        builder.setContentText("conten text");
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.sms));
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.sms);
        builder.addAction(R.drawable.sms, "text action", actionPendingIntent);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(0, builder.build());

    }


    private void showNotificationOld() {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("text");
        builder.setContentText("conten text old");
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.sms));
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.sms);
        builder.addAction(R.mipmap.ic_launcher, "text action old", actionPendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }

    private void showWearableOnlyNotification() {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);

        NotificationCompat.Action.Builder actionBuilder = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "wearable only", actionPendingIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("text");
        builder.setContentText("conten text");
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.sms));
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.sms);
        builder.extend(new NotificationCompat.WearableExtender().addAction(actionBuilder.build()));
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(0, builder.build());
    }

    private void showBigStyleNotification() {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText("This is big text.This is big text.This is big text.This is big text.This is big text.This is big text.This is big text.");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.sms));
        builder.setContentText("big text content text");

        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);

        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.addAction(R.mipmap.ic_launcher, "big text action", actionPendingIntent);
        builder.setStyle(bigTextStyle);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(2, builder.build());
    }

    private void showFeaturesNotification() {
        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
        wearableExtender.setHintHideIcon(true);
        wearableExtender.setBackground(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
//        wearableExtender.setBackground(BitmapFactory.decodeResource(getResources(), R.drawable.notification_bg));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentText("feature content text");
        builder.extend(wearableExtender);

        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(3, builder.build());
    }

    private void showVoiseInputNotification() {

        RemoteInput.Builder remoteInputBuilder = new RemoteInput.Builder(EXTRA_VOICE_REPLY);
        remoteInputBuilder.setLabel("voise input");

        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);
        NotificationCompat.Action.Builder actionBuilder = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "voise input action", actionPendingIntent);
        actionBuilder.addRemoteInput(remoteInputBuilder.build());

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setContentText("voise input content text");
        notificationBuilder.setContentTitle("voise content title");
        notificationBuilder.extend(new NotificationCompat.WearableExtender().addAction(actionBuilder.build()));

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(4, notificationBuilder.build());
    }

    private void showPreDefinedNotification() {
        RemoteInput.Builder remoteInputBuilder = new RemoteInput.Builder(EXTRA_VOICE_REPLY);
        remoteInputBuilder.setLabel("voise input");
        String[] replyChoises = getResources().getStringArray(R.array.reply_choises);
        remoteInputBuilder.setChoices(replyChoises);

        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);
        NotificationCompat.Action.Builder actionBuilder = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "voise input action", actionPendingIntent);
        actionBuilder.addRemoteInput(remoteInputBuilder.build());

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setContentText("voise input content text");
        notificationBuilder.setContentTitle("voise content title");
        notificationBuilder.extend(new NotificationCompat.WearableExtender().addAction(actionBuilder.build()));

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(4, notificationBuilder.build());
    }

    private void showPagesNotification() {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // Create builder for the main notification
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Page 1")
                        .setContentText("pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.pages1.")
                        .setContentIntent(pendingIntent);

        // Create a big text style for the second page
        NotificationCompat.BigTextStyle secondPageStyle = new NotificationCompat.BigTextStyle();
        secondPageStyle.setBigContentTitle("Page 2")
                .bigText("page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.page2.");

        // Create second page notification
        Notification secondPageNotification =
                new NotificationCompat.Builder(this)
                        .setStyle(secondPageStyle)
                        .build();

        // Extend the notification builder with the second page
        Intent actionIntent = new Intent();
        actionIntent.setClass(this, ThirdActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = notificationBuilder
                .extend(new NotificationCompat.WearableExtender()
                        .addPage(secondPageNotification))
                .addAction(R.mipmap.ic_launcher, "pages action", actionPendingIntent)
                .build();

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        // Issue the notification
        managerCompat.notify(5, notification);
    }

    private void showStackingNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Stacking notification");
        builder.setContentText("Stacking notification content text");
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setGroup("Group Key");

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        int id = (int) (Math.random() * 100.0);
        managerCompat.notify(id, builder.build());
    }

    private void showSummaryNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("summary notification title");
//        builder.setContentText("summary notification text");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.addLine("line 1");
        inboxStyle.addLine("line 2");
        inboxStyle.addLine("line 3");
        inboxStyle.setBigContentTitle("inbox content title");
        inboxStyle.setSummaryText("inbox summary text");
        builder.setStyle(inboxStyle);

        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
        wearableExtender.setBackground(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.extend(wearableExtender);

        builder.setGroup("Group summary notification");
        builder.setGroupSummary(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        int id = (int) (Math.random() * 100.0);
        managerCompat.notify(id, builder.build());
    }
}
