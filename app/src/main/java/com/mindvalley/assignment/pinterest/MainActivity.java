package com.mindvalley.assignment.pinterest;

import android.app.ProgressDialog;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.mindvalley.assignment.pinterest.adater.CustomListAdapter;
import com.mindvalley.assignment.pinterest.clientInterface.ImageFactory;
import com.mindvalley.assignment.pinterest.clientInterface.ImageType;
import com.mindvalley.assignment.pinterest.model.Profile;
import com.mindvalley.assignment.pinterest3.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String url = null;
    private ProgressDialog pDialog;
    private List<Profile> profileList = new ArrayList<Profile>();
    private ListView listView;
    private CustomListAdapter adapter;

    private ImageType jsonType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, profileList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        url = getResources().getString(R.string.url);

        makeJsonArrayRequest(url,adapter);
        hidePDialog();
    }

    /*
     *
     Building volley request obj based on the image type
     *
     */
    private void makeJsonArrayRequest(String url,CustomListAdapter adapter) {
        jsonType = ImageFactory.buildImageHandler("JSON",adapter,profileList);
        jsonType.volleyRequestHandler(url);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
