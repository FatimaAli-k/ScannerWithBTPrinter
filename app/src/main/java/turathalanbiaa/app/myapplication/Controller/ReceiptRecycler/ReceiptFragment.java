//package turathalanbiaa.app.myapplication.Controller.ReceiptRecycler;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.coordinatorlayout.widget.CoordinatorLayout;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import turathalanbiaa.app.myapplication.Model.SellMenuItem;
//import turathalanbiaa.app.myapplication.R;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//
//import java.util.ArrayList;
//
//public class ReceiptFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
//    String code;
//
//    CoordinatorLayout coordinatorLayout;
//     MyRecyclerViewAdapter adapter;
//
//
//
//    //    MyRecyclerViewAdapter adapter;
//ArrayList<SellMenuItem> menuItems = new ArrayList<>();
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.sell_menu_activity_layout, container,false);
//
//
//        // data to populate the RecyclerView with
////        ArrayList<String> menuItems = new ArrayList<>();
////        menuItems.add(code);
////        menuItems.add("434r3");
////        menuItems.add("r43r");
////        menuItems.add("343r");
////        menuItems.add("ffrf3");
//
//
//
//        prepareItemData();
//        // set up the RecyclerView
//
//        RecyclerView recyclerView = view.findViewById(R.id.items_recycler_view);
//        coordinatorLayout = view.findViewById(R.id.coordinator_layout);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//      adapter= new MyRecyclerViewAdapter( getContext(), menuItems);
//        adapter.setClickListener(this);
//        recyclerView.setAdapter(adapter);
//
//        FloatingActionButton addItem;
//        addItem=view.findViewById(R.id.add_item_floBtn);
//        addItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //add item
////                Intent intent = new Intent(getBaseContext(), ScanActivity.class);
////                startActivity(intent);
//                Toast.makeText(getContext(), "addnew " , Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
//        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
//
//
//return view;
//    }
//
//    @Override
//    public void onItemClick(View view, int position) {
//        Toast.makeText(getContext(), "You clicked row number " + position, Toast.LENGTH_SHORT).show();
//    }
//    private void prepareItemData() {
//        //code = getIntent().getStringExtra("code");
//        SellMenuItem item=new SellMenuItem();
//        item.setItem_count(1);
//        item.setItem_name("name");
//        item.setItem_price(435);
//        menuItems.add(item);
//
//       item=new SellMenuItem();
//        item.setItem_count(2);
//        item.setItem_name("name frefre");
//        item.setItem_price(5000);
//        menuItems.add(item);
//
//        item=new SellMenuItem();
//        item.setItem_count(5);
//        item.setItem_name("name");
//        item.setItem_price(500000);
//        menuItems.add(item);
//
//
//
//
//
//    }
//    /**
//     * callback when recycler view is swiped
//     * item will be removed on swiped
//     * undo option will be provided in snackbar to restore the item
//     */
//
//    @Override
//    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
//        if (viewHolder instanceof MyRecyclerViewAdapter.ViewHolder) {
//            // get the removed item name to display it in snack bar
//            String name = menuItems.get(viewHolder.getAdapterPosition()).getItem_name();
//
//            // backup of removed item for undo purpose
//            final SellMenuItem deletedItem = menuItems.get(viewHolder.getAdapterPosition());
//            final int deletedIndex = viewHolder.getAdapterPosition();
//
//            // remove the item from recycler view
//           adapter.removeItem(viewHolder.getAdapterPosition());
//
//            // showing snack bar with Undo option
//            Snackbar snackbar = Snackbar
//                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
//            snackbar.setAction("UNDO", new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    // undo is selected, restore the deleted item
//                    adapter.restoreItem(deletedItem, deletedIndex);
//                }
//            });
//            snackbar.setActionTextColor(Color.YELLOW);
//            snackbar.show();
//        }
//    }
//}