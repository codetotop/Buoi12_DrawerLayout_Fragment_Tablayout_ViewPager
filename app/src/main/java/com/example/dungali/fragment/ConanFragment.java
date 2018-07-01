package com.example.dungali.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dungali.buoi12_drawerlayout_fragment_tablayout_viewpager.R;

/**
 * Created by Dung Ali on 6/22/2017.
 */

public class ConanFragment extends Fragment implements View.OnClickListener,Runnable {
    private TextView tvTime;
    private Button btnStart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.conan_fragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        addControls();
        addEvents();
    }


    private void addControls() {
        tvTime = getActivity().findViewById(R.id.tvTime);
        btnStart = getActivity().findViewById(R.id.btnStart);
    }


    private void addEvents() {
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Thread thread = new Thread(this);
        thread.start();
        btnStart.setClickable(false);
    }


    @Override
    public void run() {
        for(int i=10;i>=0;i--){
            Message message = new Message();
            message.what=1;
            message.arg1=i;
            handler.sendMessage(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if(message.what==1) {
                Integer time = message.arg1;
                tvTime.setText(time+"");
                if(time==0){
                    btnStart.setClickable(true);
                }
            }
            return false;
        }
    });
}
