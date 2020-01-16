package turathalanbiaa.app.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import turathalanbiaa.app.myapplication.Controller.ReceiptRecycler.SellMenuActivity;
import turathalanbiaa.app.myapplication.Controller.SharedPrefrencesSession.SessionManager;
import turathalanbiaa.app.myapplication.blutooth.DeviceListActivity;
import turathalanbiaa.app.myapplication.blutooth.Printer_Main_Activity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String m_Text="";
    SessionManager session;
    Button newCustomer,oldCustomer,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        newCustomer = findViewById(R.id.new_customer);
        logout=findViewById(R.id.logout);
        TextView empName=findViewById(R.id.employee_name);

        session = new SessionManager(getApplicationContext());

        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManager.KEY_NAME);

        // email
       // String email = user.get(SessionManager.KEY_EMAIL);

        // displaying user data
        empName.setText(Html.fromHtml( name + "</b>"));


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();
            }

        });

        newCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crete new customer and new sell menu in db
                //retrieve sell menu id and send it to SellMenuActivity
                // String sellMenuId= getSellMenuId();

                Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
//                intent.putExtra("SellMenuId",sellMenuId);
                startActivity(intent);



            }

        });
        oldCustomer = findViewById(R.id.old_customer);

        oldCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scan for sell menu id, retrieve items

                Intent intent = new Intent(getBaseContext(), ScanActivity.class);
                //1 for sell menu id

                intent.putExtra("ScanFor", 1);

                startActivity(intent);
            }

        });

        Button printertest=findViewById(R.id.printertest);
        printertest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), JsonDataExample.class);
                startActivity(intent);
            }

        });


    }
//    public void getCustomerName(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Customer name");
//
//
//// Set up the input
//        final EditText input = new EditText(this);
//// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
//        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
//        builder.setView(input);
//
//// Set up the buttons
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                m_Text = input.getText().toString();
//                //create new customer + sell menu
//                Intent intent = new Intent(getBaseContext(), SellMenuActivity.class);
//                intent.putExtra("CustomerName", m_Text);
//                startActivity(intent);
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//
//            }
//        });
//
//        builder.show();
//    }
}
