//package com.citizenzet.zetlib.activity;
//
//import android.Manifest;
//import android.content.DialogInterface;
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.citizenzet.zetlib.helper.ActivityHelper;
//import com.google.zxing.Result;
//import com.olimp.menu.R;
//import com.olimp.menu.form.ClientForm;
//import com.olimp.menu.service.ClientService;
//
//import me.dm7.barcodescanner.zxing.ZXingScannerView;
//


//
// ДОБАВИТЬ В manifest
//
//<uses-feature
//        android:name="android.hardware.camera"
//        android:required="true" />
//<uses-permission android:name="android.permission.CAMERA" />
//<uses-feature android:name="android.hardware.camera.autofocus" />
//
//
//
// ДОБАВИТЬ в build.cradle
//
//        implementation 'me.dm7.barcodescanner:zxing:1.9'



//public class QrCodeScannerActivity extends BaseRestActivity implements ZXingScannerView.ResultHandler {
//
//    private static final int REQUEST_CAMERA = 1;
//    public ZXingScannerView mScannerView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setTitle("Наведите камеру на QR код");
//        Log.e("onCreate", "onCreate");
//
//        mScannerView = new ZXingScannerView(this);
//        setContentView(mScannerView);
//        int currentapiVersion = Build.VERSION.SDK_INT;
//        if (currentapiVersion >= Build.VERSION_CODES.M) {
//            if (checkPermission()) {
//                Toast.makeText(getApplicationContext(), "Permission already granted", Toast.LENGTH_LONG).show();
//
//            } else {
//                requestPermission();
//            }
//        }
//    }
//
//    private boolean checkPermission() {
//        return ( ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA ) == PackageManager.PERMISSION_GRANTED);
//    }
//
//    private void requestPermission() {
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
//    }
//
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_CAMERA:
//                if (grantResults.length > 0) {
//
//                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    if (cameraAccepted){
//                        Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access CAMERA", Toast.LENGTH_LONG).show();
//                    }else {
//                        Toast.makeText(getApplicationContext(), "Permission Denied, You cannot access and CAMERA", Toast.LENGTH_LONG).show();
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//                                showMessageOKCancel("You need to allow access to both the permissions",
//                                        new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                                    requestPermissions(new String[]{"CAMERA"},
//                                                            REQUEST_CAMERA);
//                                                }
//                                            }
//                                        });
//                                return;
//                            }
//                        }
//                    }
//                }
//                break;
//        }
//    }
//
//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new android.support.v7.app.AlertDialog.Builder(QrCodeScannerActivity.this)
//                .setMessage(message)
//                .setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", null)
//                .create()
//                .show();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        int currentapiVersion = Build.VERSION.SDK_INT;
//        if (currentapiVersion >= Build.VERSION_CODES.M) {
//            if (checkPermission()) {
//                if(mScannerView == null) {
//                    mScannerView = new ZXingScannerView(this);
//                    setContentView(mScannerView);
//                }
//                mScannerView.setResultHandler(this);
//                mScannerView.startCamera();
//            } else {
//                requestPermission();
//            }
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mScannerView.stopCamera();
//    }
//
//    @Override
//    public void handleResult(Result rawResult) {
//
////        final String result = rawResult.getText();
////        Log.e("QRCodeScanner", rawResult.getText());
////        Log.e("QRCodeScanner", rawResult.getBarcodeFormat().toString());
//        ClientForm clientForm = new ClientForm();
//        clientForm.setHash(rawResult.getText());
//        ClientService clientService = new ClientService();
//        clientService.setClientForm(clientForm);
//        clientService.init(this);
//        clientService.request();
//    }
//
//    @Override
//    public void onBackPressed() {
//        ActivityHelper.goToActivity(this, MainActivity.class, true, R.anim.fade_in, R.anim.fade_out);
//    }
//}
