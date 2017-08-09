package com.che.practice.autoloopviewpage;

import android.os.Handler;
import android.os.Message;

/**
 * Created by dove on 2017/8/3.
 */

public class TimerHandler extends Handler {

    static final int MSG_TIMER_ID = 99991;

    public  long millisecond;

    boolean isStopped = true;

    interface TimerHandlerListener{
        void callBack();
    }

    TimerHandlerListener mListener;

    public TimerHandler(TimerHandlerListener listener, long millisecond){
        this.mListener = listener;
        this.millisecond = millisecond;
    }

    @Override
    public void handleMessage(Message msg) {
        if (MSG_TIMER_ID == msg.what){
            if (mListener != null) mListener.callBack();
            sendEmptyMessageDelayed(MSG_TIMER_ID, millisecond);
        }
    }
}
