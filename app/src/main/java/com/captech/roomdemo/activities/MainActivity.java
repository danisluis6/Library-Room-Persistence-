package com.captech.roomdemo.activities;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.captech.roomdemo.R;
import com.captech.roomdemo.adapters.CarAdapter;
import com.captech.roomdemo.localstorage.room.AppDatabase;
import com.captech.roomdemo.localstorage.room.Entity.Car;
import com.captech.roomdemo.localstorage.room.utils.EEConstract;
import com.captech.roomdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by lorence on 03/11/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CarAdapter mContactAdapter;
    private AppDatabase mAppDatabase;
    private Context mContext;

    private RecyclerView rcViewCar;
    private FloatingActionButton actionButtonAdd;
    private List<Car> groupContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        // init View
        rcViewCar = (RecyclerView)this.findViewById(R.id.recycler_view);
        actionButtonAdd = (FloatingActionButton)this.findViewById(R.id.add);

        // init Attributes
        groupContacts = new ArrayList<>();
        mContext = this.getApplication();
        mAppDatabase = Room.databaseBuilder(this, AppDatabase.class, EEConstract.DB_NAME).build();

        // init Event
        actionButtonAdd.setOnClickListener(this);

        // View
        mContactAdapter = new CarAdapter(mContext, groupContacts, new CarAdapter.ICarAdapter() {
            @Override
            public void editContact(Car contact) {
                // Fake data
                final Bitmap fake = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.bitmap);

                new AsyncTask<Contact, Void, Integer>() {
                    @Override
                    protected Integer doInBackground(Contact... params) {
                        Contact saveContact = params[0];
                        saveContact.setFirstName("Lorence NGUYEN");
                        saveContact.setAvatar(Utils.convertToByteArray(fake));
                        return mAppDatabase.carDao().updateContacts(saveContact);
                    }

                    @Override
                    protected void onPostExecute(Integer id) {
                        if (id > 0) {
                            Toast.makeText(mContext, "Update Contact successfully", Toast.LENGTH_SHORT).show();
                            loadContacts();
                        } else {
                            Toast.makeText(mContext, "Update Contact failed", Toast.LENGTH_SHORT).show();
                        }
                        setResult(RESULT_OK);
                    }
                }.execute(contact);
            }

            @Override
            public void deleteContact(Contact contact) {
                new AsyncTask<Contact, Void, Integer>() {
                    @Override
                    protected Integer doInBackground(Contact... contacts) {
                        return mAppDatabase.carDao().deleteContacts(contacts);
                    }

                    @Override
                    protected void onPostExecute(Integer id) {
                        if (id > 0) {
                            Toast.makeText(mContext, "Delete Contact successfully", Toast.LENGTH_SHORT).show();
                            loadContacts();
                        } else {
                            Toast.makeText(mContext, "Delete Contact failed", Toast.LENGTH_SHORT).show();
                        }
                        setResult(RESULT_OK);
                    }
                }.execute(contact);
            }
        });
        rcViewCar = (RecyclerView) findViewById(R.id.recycler_view);
        rcViewCar.setLayoutManager(new LinearLayoutManager(this));
        rcViewCar.setAdapter(mContactAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadContacts();
    }

    private void loadContacts() {
        new AsyncTask<Void, Void, List<Contact>>() {
            @Override
            protected List<Contact> doInBackground(Void... params) {
                return mAppDatabase.carDao().getContacts();
            }

            @Override
            protected void onPostExecute(List<Contact> grouContacts) {
                mContactAdapter.updateListOfContact(grouContacts);
            }
        }.execute();
    }


    @Override
    public void onClick(View v) {
        // Double Click
        switch (v.getId()) {
            case R.id.add:
                // Call AsyncTask to add new Contact
                addFakeContact();
                break;
        }
    }

    private void addFakeContact() {

        // Fake Bitmap
        Bitmap fakeBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.image);

        // Fake Contact
        Contact object = new Contact();
        object.setFirstName("John Harder " + new Random().nextInt(100));
        object.setLastName("NGUYEN");
        object.setNumber("9162583104");
        object.setAvatar(Utils.convertToByteArray(fakeBitmap));
        object.setAddress("22 Amsterdam");
        object.setEmail("vuongluis@hotmail.com");

        new AsyncTask<Contact, Void, Long>() {
            @Override
            protected Long doInBackground(Contact... params) {
                return mAppDatabase.carDao().insertContacts(params[0]);
            }

            @Override
            protected void onPostExecute(Long id) {
                if (id > 0) {
                    Toast.makeText(mContext, "Add Contact successfully", Toast.LENGTH_SHORT).show();
                    loadContacts();
                } else {
                    Toast.makeText(mContext, "Add Contact failed", Toast.LENGTH_SHORT).show();
                }
                setResult(RESULT_OK);
            }
        }.execute(object);
    }
}
