package turathalanbiaa.app.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import turathalanbiaa.app.myapplication.Controller.ReceiptRecycler.SellMenuActivity;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class ScanActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    //1 for menu, 2 for item
    Integer scanFor;

    BarcodeReader barcodeReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        setContentView(R.layout.scan);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
        scanFor=getIntent().getIntExtra("ScanFor",0);

    }
    @Override
    public void onScanned(Barcode barcode) {
//        // single barcode scanned
        barcodeReader.playBeep();




            Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
            intent.putExtra("code", barcode.displayValue);
        //intent.putExtra("LoadReceiptFragment", 1);
            startActivity(intent);

    }

    @Override
    public void onScannedMultiple(List<Barcode> list) {
        // multiple barcodes scanned
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
        // barcode scanned from bitmap image
    }

    @Override
    public void onScanError(String s) {
        // scan error
        Toast.makeText(getApplicationContext(), "Error occurred while scanning " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCameraPermissionDenied() {
        // camera permission denied
    }
}
