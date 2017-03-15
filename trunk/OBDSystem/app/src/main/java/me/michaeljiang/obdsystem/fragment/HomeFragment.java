package me.michaeljiang.obdsystem.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.michaeljiang.obdsystem.R;
import me.michaeljiang.obdsystem.util.AppSetting;

public class HomeFragment extends Fragment {
    private Handler uiHandle = null;
    public Handler getUiHandle() {
        return uiHandle;
    }

    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        uiHandle = new UiHandle();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        TextView tv = (TextView)view.findViewById(R.id.txt_info);
        tv.setText(agrs1);
        return view;
    }



    private class UiHandle extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d(AppSetting.LOG_HOME_FRAGMENT_TAG,"getMessage");
            if(msg.what== AppSetting.MESSAGE_HOME_FRAGMENT_KEY){
                //ui更新
            }
            super.handleMessage(msg);
        }
    }
}
