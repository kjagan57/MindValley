package com.mindvalley.assignment.pinterest.clientInterface.ImageHandler;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.mindvalley.assignment.pinterest.adater.CustomListAdapter;
import com.mindvalley.assignment.pinterest.app.ApplicationController;
import com.mindvalley.assignment.pinterest.clientInterface.ImageType;
import com.mindvalley.assignment.pinterest.model.Profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by jk035766 on 1/30/17.
 */

public class JsonImageHandler implements ImageType {
    private static String TAG = JsonImageHandler.class.getSimpleName();

    CustomListAdapter adapter;

    private List<Profile> profileList;

    public JsonImageHandler(CustomListAdapter adapter,List<Profile> profileList){
        this.profileList = profileList;
        this.adapter = adapter;
    }

    @Override
    public void volleyRequestHandler(String jsonUrl) {
        JsonArrayRequest profileRequest = new JsonArrayRequest(jsonUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "Json Response : "+response.toString());
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject profileObj = response.getJSONObject(i);
                                Profile profile = new Profile();
                                profile.setLikes(profileObj.getInt("likes"));
                                JSONObject user = profileObj.getJSONObject("user");
                                profile.setName(user.getString("name"));
                                JSONObject url = profileObj.getJSONObject("urls");
                                profile.setImageUrl(url.getString("raw"));
                                profileList.add(profile);
                            } catch (JSONException e) {
                                Log.e(TAG,e.getMessage());
                                e.printStackTrace();
                            }
                        }
                        /*
                         *
                          notifying list adapter about data changes
                          so that it renders the list view with updated data
                         *
                         */
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                     @Override
                      public void onErrorResponse(VolleyError error) {
                         VolleyLog.d(TAG, "Error: " + error.getMessage());
                      }
                 });

        // Adding request to request queue
        ApplicationController.getInstance().addToRequestQueue(profileRequest);
    }
}
