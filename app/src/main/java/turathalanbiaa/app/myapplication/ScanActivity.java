package turathalanbiaa.app.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import turathalanbiaa.app.myapplication.Controller.ReceiptRecycler.SellMenuActivity;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.barcode.BarcodeReader;
import turathalanbiaa.app.myapplication.Model.SellMenuItem;

public class ScanActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    //1 for menu, 2 for item
    Integer scanFor;
    String sellMenuId;

    BarcodeReader barcodeReader;
    ArrayList<SellMenuItem> menuItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        setContentView(R.layout.scan);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
        scanFor=getIntent().getIntExtra("ScanFor",0);
        if(scanFor==2) {
            menuItems = (ArrayList<SellMenuItem>) getIntent().getSerializableExtra("Items");
        }
//        sellMenuId = getIntent().getStringExtra("sellMenuId");



//        Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
//        intent.putExtra("Items",menuItems);
//        intent.putExtra("code","99999999");
//            startActivity(intent);

//        if(scanFor==2) {
//
//            Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
//            intent.putExtra("code","222");
//            intent.putExtra("Items", menuItems);
////        intent.putExtra("sellMenuId",sellMenuId);
//
//            startActivity(intent);
//        }
//
//        //scan for menu id, send menu code and scan for =1 so sellMenuActivity an fetch json array instead
//        else if(scanFor==1){
//            try {
//                Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
//                intent.putExtra("code", "111");
//                intent.putExtra("ScanFor", 2);
//
//                startActivity(intent);
//            }catch (Exception e){
//                Toast.makeText(getApplicationContext(), "// "+e , Toast.LENGTH_SHORT).show();
//
//            }
//        }


    }
    @Override
    public void onScanned(Barcode barcode) {
//        // single barcode scanned
        barcodeReader.playBeep();


// if scanning for item return item barcode, previous menu items and sell menu id
        if(scanFor==2) {

            Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
            intent.putExtra("code", barcode.displayValue);
            intent.putExtra("Items", menuItems);
//        intent.putExtra("sellMenuId",sellMenuId);

            startActivity(intent);
        }

        //scan for menu id, send menu code and scan for =1 so sellMenuActivity an fetch json array instead
        else if(scanFor==1){
            Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
            intent.putExtra("code", barcode.displayValue);
            intent.putExtra("ScanFor",2);

            startActivity(intent);
        }


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
