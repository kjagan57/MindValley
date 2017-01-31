package com.mindvalley.assignment.pinterest.clientInterface.ImageHandler;

import com.mindvalley.assignment.pinterest.adater.CustomListAdapter;
import com.mindvalley.assignment.pinterest.clientInterface.ImageType;
import com.mindvalley.assignment.pinterest.model.Profile;

import java.util.List;

/**
 * Created by jk035766 on 1/31/17.
 */

public class XmlImageHandler implements ImageType {

    CustomListAdapter adapter;

    private List<Profile> profileList;

    public XmlImageHandler(CustomListAdapter adapter, List<Profile> profileList){
        this.profileList = profileList;
        this.adapter = adapter;
    }
    @Override
    public void volleyRequestHandler(String url) {

    }
}
