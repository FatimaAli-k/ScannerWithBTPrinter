package turathalanbiaa.app.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class test  extends AppCompatActivity {

    Button testbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        //String code = getIntent().getStringExtra("code");

        //loadFragment(new ItemsListRecyclerViewFrag());
        testbtn = findViewById(R.id.testBtn);

       testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crete new customer and new receipt in db
                //scan item and add it
//                Intent intent = new Intent(getBaseContext(), FragmentTestMainActivity.class);
//                intent.putExtra("LoadReceiptFragment", 1);
//                startActivity(intent);
            }

        });







    }}
