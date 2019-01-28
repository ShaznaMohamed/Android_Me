package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 ** Created by ShaznaM on 1/23/2019.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> mInmageIds;
    private int mListIndex;
    private static final String TAG = BodyPartFragment.class.getName();
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    public BodyPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            mInmageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootview = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootview.findViewById(R.id.body_part_image_view);
        if(mInmageIds != null){
            imageView.setImageResource(mInmageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex< mInmageIds.size() -1){
                        mListIndex++;
                    }else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mInmageIds.get(mListIndex));
                }
            });
        }else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        return rootview;
    }

    public void setmInmageIds(List<Integer> mInmageIds) {
        this.mInmageIds = mInmageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {

        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mInmageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
