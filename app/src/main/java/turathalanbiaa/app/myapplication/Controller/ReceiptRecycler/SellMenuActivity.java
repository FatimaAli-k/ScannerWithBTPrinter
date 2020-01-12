package turathalanbiaa.app.myapplication.Controller.ReceiptRecycler;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import turathalanbiaa.app.myapplication.Controller.volley.AppController;
import turathalanbiaa.app.myapplication.JsonDataExample;
import turathalanbiaa.app.myapplication.MainActivity;
import turathalanbiaa.app.myapplication.Model.SellMenu;
import turathalanbiaa.app.myapplication.Model.SellMenuItem;
import turathalanbiaa.app.myapplication.R;
import turathalanbiaa.app.myapplication.ScanActivity;
import turathalanbiaa.app.myapplication.blutooth.Printer_Main_Activity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SellMenuActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
    String code;

    //class not in use
    CoordinatorLayout coordinatorLayout;
    MyRecyclerViewAdapter adapter;

    private static String TAG = SellMenuActivity.class.getSimpleName();


    // Progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;


    //    MyRecyclerViewAdapter adapter;
    ArrayList<SellMenuItem> menuItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_menu_activity_layout);
        String code = getIntent().getStringExtra("code");

//        String customerName= getIntent().getStringExtra("CustomerName");
//        //get name from database
//        TextView customer=findViewById(R.id.customer_name);
//        customer.setText(customerName);


        // data to populate the RecyclerView with
//        ArrayList<String> menuItems = new ArrayList<>();
//        menuItems.add(code);
//        menuItems.add("434r3");
//        menuItems.add("r43r");
//        menuItems.add("343r");
//        menuItems.add("ffrf3");

        //json

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        //
        getJsonItemsData();


        //prepareItemData();
        // set up the RecyclerView

        RecyclerView recyclerView = findViewById(R.id.items_recycler_view);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter= new MyRecyclerViewAdapter(this, menuItems);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        FloatingActionButton addItem;
        addItem=findViewById(R.id.add_item_floBtn);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add item
                Intent intent = new Intent(getBaseContext(), ScanActivity.class);
                //2 for item
                intent.putExtra("ScanFor",2);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "addnew " , Toast.LENGTH_SHORT).show();

            }
        });

        Button closeCustomer=findViewById(R.id.close_customerBtn);
        closeCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //clear customer info
//                Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                startActivity(intent);

//
                String str="";
//
                            for(int i=0;i<menuItems.size();i++){

                                str+= "\n....................................\n "+menuItems.get(i).getItem_count()+"X "+
                                        menuItems.get(i).getItem_name()+"\t"+menuItems.get(i).getItem_price()+"IQD ";
                            }
                            Toast.makeText(getApplicationContext(),
                                    " "+str, Toast.LENGTH_LONG).show();
            }
        });


        Button confirmCustomer=findViewById(R.id.confirm_customerBtn);
        confirmCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send data to db
                //go to print activity
                try {

                Intent intent = new Intent(getBaseContext(), Printer_Main_Activity.class);

                intent.putExtra("PrintItems",menuItems);
                startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "oh//"+e,
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);




    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked row number " + position, Toast.LENGTH_SHORT).show();
    }


    SellMenuItem item=new SellMenuItem();
//    private void prepareItemData() {
//        //code = getIntent().getStringExtra("code");
//
//
//        item.setItem_count(1);
//        item.setItem_name("حذاء رياضي قياس M ازرق");
//        item.setItem_price(15000);
//        menuItems.add(item);
//
//        item=new SellMenuItem();
//        item.setItem_count(2);
//        item.setItem_name("long winter hoodie, black with detachable sleeves");
//        item.setItem_price(2000);
//        menuItems.add(item);
//
//        item=new SellMenuItem();
//        item.setItem_count(5);
//        item.setItem_name("name");
//        item.setItem_price(500000);
//        menuItems.add(item);
//
//    }

    String url="https://jsonblob.com/api/c343b7e4-34c8-11ea-ad35-d729c7db8fd8";
    private void getJsonItemsData(){

        showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        try {
                            // Parsing json array response
                            // loop through each json object

                            String jsonResponse="";
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonItem = (JSONObject) response
                                        .get(i);

                                String name = jsonItem.getString("name");
                                int price= jsonItem.getInt("price");
                                int count= jsonItem.getInt("count");


                                jsonResponse += "Name: " + name + "\n\n";
                                jsonResponse += "Email: " + price + "\n\n";
                                jsonResponse += "Home: " + count + "\n\n";


                                 item=new SellMenuItem();
                                item.setItem_count(count);
                                item.setItem_name(name);
                                item.setItem_price(price);
                                menuItems.add(item);

                            }

//                            String str="";
//
//
//
//                            for(int i=0;i<menuItems.size();i++){
//
//                                str+= "\n....................................\n "+menuItems.get(i).getItem_count()+"X "+
//                                        menuItems.get(i).getItem_name()+"\t"+menuItems.get(i).getItem_price()+"IQD ";
//                            }
//                            Toast.makeText(getApplicationContext(),
//                                    " "+str, Toast.LENGTH_LONG).show();
                            adapter.notifyDataSetChanged();

//                            txtResponse.setText(jsonResponse);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    /**
     * callback when recycler view is swiped
     * item will be removed on swiped
     * undo option will be provided in snackbar to restore the item
     */

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof MyRecyclerViewAdapter.ViewHolder) {
            // get the removed item name to display it in snack bar
            String name = menuItems.get(viewHolder.getAdapterPosition()).getItem_name();

            // backup of removed item for undo purpose
            final SellMenuItem deletedItem = menuItems.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            adapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    adapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }
}