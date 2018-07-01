package com.example.dungali.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungali.buoi12_drawerlayout_fragment_tablayout_viewpager.R;
import com.example.dungali.model.Story;

import java.util.ArrayList;

/**
 * Created by Dung Ali on 6/22/2017.
 */

public class DrawerAdapter extends ArrayAdapter<Story> {
  private Activity context;
  private ArrayList<Story> objects;

  public DrawerAdapter(@NonNull Activity context, @NonNull ArrayList<Story> objects) {
    super(context, android.R.layout.simple_list_item_1, objects);
    this.context = context;
    this.objects = objects;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
    ViewHolder viewHolder;
    if (v == null) {
      viewHolder = new ViewHolder();
      LayoutInflater inflater = this.context.getLayoutInflater();
      v = inflater.inflate(R.layout.item, parent, false);
      viewHolder.imgStory = v.findViewById(R.id.imgStory);
      viewHolder.tvStory = v.findViewById(R.id.tvStory);

      v.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) v.getTag();
    }

    Story story = objects.get(position);
    viewHolder.imgStory.setImageResource(story.getPictureProfile());
    viewHolder.tvStory.setText(story.getNameStory());

    return v;
  }

  class ViewHolder {
    ImageView imgStory;
    TextView tvStory;
  }
}
