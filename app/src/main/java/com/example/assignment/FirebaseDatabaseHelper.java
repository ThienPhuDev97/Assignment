package com.example.assignment;

import androidx.annotation.NonNull;

import com.example.assignment.Model.Student;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceStudents;
    private List<Student> students = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Student> students,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        this.mDatabase = FirebaseDatabase.getInstance();
        mReferenceStudents = mDatabase.getReference("Students");
    }
    public  void readStudents( final DataStatus dataStatus){
        mReferenceStudents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                students.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Student st = keyNode.getValue(Student.class);
                    students.add(st);
                }
                dataStatus.DataIsLoaded(students,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public  void addStudent(Student st, final  DataStatus dataStatus){
        String key = mReferenceStudents.push().getKey();
        mReferenceStudents.child(key).setValue(st).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsInserted();
            }
        });
    }
}
