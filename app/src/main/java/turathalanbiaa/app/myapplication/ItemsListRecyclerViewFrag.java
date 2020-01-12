//package turathalanbiaa.app.myapplication;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class ItemsListRecyclerViewFrag extends Fragment {
//    public static Fragment newInstance() {
//        return new ItemsListRecyclerViewFrag();
//    }
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.items_recycler_view_frag, container,false);
//
//
//        String[] str=new String[5];
//        str[0]="حةلحق لقةثخحطةل قلةثسكلةقكسطل لقسلةنكط لقمسطةمط نلاقس";
//        str[1]="frf";
//        str[2]="vfvdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvx";
//        str[3]="dxvfx vfdxvfdxvxdxvfx vfdxvfdxvx";
//        str[4]="dxvfxnhnyn";
//
//        String[] str2=new String[5];
//        str2[0]="حةلحق لقةثخحطةل قلةثسكلةقكسطل لقسلةنكط لقمسطةمط نلاقحةلحق لقةثخحطةل قلةثسكلةقكسطل لقسلةنكط لقمسطةمط نلاق";
//        str2[1]="22frf";
//        str2[2]="evevvfvdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfxvfvdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfxvfvdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfxvfvdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvxdxvfx vfdxvfdxvx";
//        str2[3]="dxvfx vfdxvfdxvxdxvfx vfdxvfdxvx";
//        str2[4]="dxvfxnhnyn";
//
////        List<List<String>> listOfLists = new ArrayList<List<String>>();
////        listOfLists.add(new ArrayList<String>());
//
//        RecyclerView recyclerView = view.findViewById(R.id.items_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(new RecyclerViewAdapter(str,str2));
//        return view;
//
//    }
//    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
//        private FrameLayout mFrameLayout;
//        //private TextView question,answer;
//        public RecyclerViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//
//        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
//            super(inflater.inflate(R.layout.item_row,container,false));
//            mFrameLayout =itemView.findViewById(R.id.item_container);
////            question =itemView.findViewById(R.id.questionTextView);
////            answer =itemView.findViewById(R.id.answerTextView);
//
//        }
//    }
//
//    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
//
//        private String[] mList,s;
//        public RecyclerViewAdapter(String[] list, String[] s){
//            this.mList=list;
//            this.s=s;
//
//        }
//
//
//
//
//        @NonNull
//        @Override
//        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//            LayoutInflater inflater = LayoutInflater.from(getActivity());
//            return new RecyclerViewHolder(inflater, viewGroup);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
//
////            recyclerViewHolder.question.setText(mList[i]);
////            recyclerViewHolder.answer.setText(s[i]);
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return s.length;
//        }
//    }
//}
