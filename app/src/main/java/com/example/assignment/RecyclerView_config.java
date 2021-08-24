package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Model.Student;

import java.util.List;

public class RecyclerView_config {
    private Context mContext;
    private StudentApdater mStudentsAdapter;
    public  void setConfig(RecyclerView recyclerView,Context context,List<Student> students,List<String> keys){
        mContext = context;
        mStudentsAdapter = new StudentApdater(students,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mStudentsAdapter);
    }

    class  StudentItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mAddress;
        private TextView mCode;
        private  TextView mPhone;

        private  String key;

        public StudentItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext)
                    .inflate(R.layout.student_list_item,parent,false));
            mName= (TextView) itemView.findViewById(R.id.name_txt);
            mAddress = (TextView)itemView.findViewById(R.id.address_txt);
            mCode = (TextView)itemView.findViewById(R.id.code_txt);
            mPhone = (TextView) itemView.findViewById(R.id.phone_txt);
        }
        public void bind(Student st, String key){
            mName.setText(st.getFullname());
            mAddress.setText((st.getAddress()));
            mCode.setText(st.getDegree_title());
            mPhone.setText(st.getPhone());
            this.key = key;
        }

    }
    class  StudentApdater extends  RecyclerView.Adapter<StudentItemView>{
        private List<Student> mStudents;
        private List<String> mKeys;

        public StudentApdater(List<Student> mStudents, List<String> mKeys) {
            this.mStudents = mStudents;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public StudentItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return  new StudentItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentItemView holder, int position) {
            holder.bind(mStudents.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mStudents.size();
        }
    }
}
