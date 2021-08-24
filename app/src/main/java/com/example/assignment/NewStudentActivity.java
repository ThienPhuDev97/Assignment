package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.Model.Student;

import java.util.List;

public class NewStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        Button mAdd_btn = (Button) findViewById(R.id.bt_Add);
        Button mBack_btn = (Button) findViewById(R.id.bt_Back);

        EditText mName_edText = (EditText) findViewById(R.id.ed_Name);
        EditText mAddress_edText = (EditText) findViewById(R.id.ed_Address);
        EditText mDepartment_edText = (EditText) findViewById(R.id.ed_deparment);
        EditText mPhone_edText = (EditText) findViewById(R.id.ed_phone);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student st = new Student();
                st.setFullname(mName_edText.getText().toString());
                st.setAddress(mAddress_edText.getText().toString());
                st.setDegree_title(mDepartment_edText.getText().toString());
                st.setPhone((mPhone_edText.getText().toString()));
                new FirebaseDatabaseHelper().addStudent(st, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Student> students, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewStudentActivity.this,"add successful",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(NewStudentActivity.this,MainActivity.class));
                        finish();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();return;
            }
        });
    }
}