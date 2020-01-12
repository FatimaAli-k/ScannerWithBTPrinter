//package turathalanbiaa.app.myapplication;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import turathalanbiaa.app.myapplication.Controller.ReceiptRecycler.SellMenuActivity;
//
//public class ChooseCustomerFragment extends Fragment {
//
//    Button newCustomer,oldCustomer;
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.main_activity, container,false);
//
//        //String code = getIntent().getStringExtra("code");
//
//        //loadFragment(new ItemsListRecyclerViewFrag());
//       // TextView EmpName=view.findViewById(R.id.employee_name);
//        newCustomer = view.findViewById(R.id.new_customer);
//
//
//
//        newCustomer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //crete new customer and new receipt in db
//                //scan item and add it
//                Intent intent = new Intent(getContext(), SellMenuActivity.class);
//
//
//                startActivity(intent);
//            }
//
//        });
//       oldCustomer = view.findViewById(R.id.old_customer);
//
//        oldCustomer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //scan for customer id, retrieve items
//
//                Intent intent = new Intent(getContext(), ScanActivity.class);
//                //1 for menu
//                intent.putExtra("ScanFor", 1);
//
//                startActivity(intent);
//            }
//
//        });
//
//
//
//return view;
//
//
//    }
//
//
////    private boolean loadFragment(Fragment fragment) {
////        //switching fragment
////        if (fragment != null) {
////            getSupportFragmentManager()
////                    .beginTransaction()
////                    .replace(R.id.fragment_container, fragment)
////                    .commit();
////            return true;
////        }
////
////        return false;
////    }
//}
