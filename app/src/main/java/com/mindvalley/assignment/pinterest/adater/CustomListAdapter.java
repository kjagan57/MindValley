package com.mindvalley.assignment.pinterest.adater;

import com.mindvalley.assignment.pinterest.app.ApplicationController;
import com.mindvalley.assignment.pinterest3.R;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mindvalley.assignment.pinterest.model.Profile;

/**
 * Created by jk035766 on 1/30/17.
 */

public class CustomListAdapter extends BaseAdapter {

	private static String TAG = CustomListAdapter.class.getSimpleName();

	private Activity activity;
	private LayoutInflater inflater;
	private List<Profile> profileItems;
	ImageLoader imageLoader = ApplicationController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<Profile> profileItems) {
		this.activity = activity;
		this.profileItems = profileItems;
	}

    private static class ViewHolder {
        public NetworkImageView imageView = null;
        public TextView name = null;
        public TextView likes = null;

        private ViewHolder() {
        }
    }

	@Override
	public int getCount() {
		return profileItems.size();
	}

	@Override
	public Object getItem(int location) {
		return profileItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_row, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.likes = (TextView) convertView.findViewById(R.id.likes);
            convertView.setTag(viewHolder);
        }
		viewHolder = (ViewHolder) convertView.getTag();
		Profile profile = profileItems.get(position);
		viewHolder.imageView.setImageUrl(profile.getImageUrl(), imageLoader);
		viewHolder.name.setText(profile.getName());
		viewHolder.likes.setText("Likes: " + String.valueOf(profile.getLikes()));

		return convertView;
	}

}