package com.mindvalley.assignment.pinterest.clientInterface;

import com.mindvalley.assignment.pinterest.adater.CustomListAdapter;
import com.mindvalley.assignment.pinterest.clientInterface.ImageHandler.XmlImageHandler;
import com.mindvalley.assignment.pinterest.clientInterface.ImageHandler.JsonImageHandler;
import com.mindvalley.assignment.pinterest.model.Profile;

import java.util.List;

/**
 * Created by jk035766 on 1/30/17.
 */

public class ImageFactory {
    public static ImageType buildImageHandler(String imageType, CustomListAdapter adapter, List<Profile> profileList){
        if(imageType.equalsIgnoreCase("JSON")){
            return new JsonImageHandler(adapter,profileList);
        }
        else if(imageType.equalsIgnoreCase("CDN")){
            return new XmlImageHandler(adapter,profileList);
        }
        else
            throw new IllegalArgumentException("No Such ImageType Supported ...");
    }
}
