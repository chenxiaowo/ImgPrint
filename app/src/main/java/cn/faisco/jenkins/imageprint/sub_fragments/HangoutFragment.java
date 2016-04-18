package cn.faisco.jenkins.imageprint.sub_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.faisco.jenkins.imageprint.R;


/**
 * Created by Administrator on 2015/10/26.
 */
public class HangoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hangout,container,false);
    }
}
