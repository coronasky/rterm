package com.roiding.rterm;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class PanelControler {
  private Animation fadeIn;
  
  private Animation fadeOut;
  
  private boolean isLight = true;
  
  private long lastPressTime = 0L;
  
  private Context mContext;
  
  Handler mHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        if (System.currentTimeMillis() - PanelControler.this.lastPressTime >= 1500L) {
          PanelControler.this.viewGroup.startAnimation(PanelControler.this.fadeOut);
          PanelControler.this.isLight = false;
        } 
      }
    };
  
  private ViewGroup viewGroup;
  
  public PanelControler(Context paramContext, ViewGroup paramViewGroup) {
    this.mContext = paramContext;
    this.fadeIn = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
    this.fadeOut = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
    this.fadeOut.setFillAfter(true);
    this.fadeIn.setFillAfter(true);
    this.viewGroup = paramViewGroup;
    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
          System.out.println("onTouch:" + param1MotionEvent.getAction() + "," + PanelControler.this.isLight);
          PanelControler.this.lastPressTime = System.currentTimeMillis();
          if (param1MotionEvent.getAction() == 0) {
            if (!PanelControler.this.isLight) {
              PanelControler.this.viewGroup.startAnimation(PanelControler.this.fadeIn);
              PanelControler.this.isLight = true;
            } 
            return param1View.onTouchEvent(param1MotionEvent);
          } 
          if (param1MotionEvent.getAction() == 1)
            PanelControler.this.mHandler.sendEmptyMessageDelayed(1, 1600L); 
          return param1View.onTouchEvent(param1MotionEvent);
        }
      };
    attachOnTouchLsner(this.viewGroup, onTouchListener);
  }
  
  private void attachOnTouchLsner(ViewGroup paramViewGroup, View.OnTouchListener paramOnTouchListener) {
    for (int i = 0;; i++) {
      if (i >= paramViewGroup.getChildCount())
        return; 
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof ViewGroup) {
        attachOnTouchLsner((ViewGroup)view, paramOnTouchListener);
      } else {
        view.setOnTouchListener(paramOnTouchListener);
      } 
    } 
  }
}