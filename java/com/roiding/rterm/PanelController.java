package com.roiding.rterm;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class PanelController {
  private Animation fadeIn;
  
  private Animation fadeOut;
  
  private boolean isLight = true;
  
  private long lastPressTime = 0L;
  
  private Context mContext;
  
  Handler mHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        if (System.currentTimeMillis() - PanelController.this.lastPressTime >= 1500L) {
          PanelController.this.viewGroup.startAnimation(PanelController.this.fadeOut);
          PanelController.this.isLight = false;
        } 
      }
    };
  
  private ViewGroup viewGroup;
  
  public PanelController(Context paramContext, ViewGroup paramViewGroup) {
    this.mContext = paramContext;
    this.fadeIn = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_in);
    this.fadeOut = AnimationUtils.loadAnimation(this.mContext, R.anim.fade_out);
    this.fadeOut.setFillAfter(true);
    this.fadeIn.setFillAfter(true);
    this.viewGroup = paramViewGroup;
    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
          System.out.println("onTouch:" + param1MotionEvent.getAction() + "," + PanelController.this.isLight);
          PanelController.this.lastPressTime = System.currentTimeMillis();
          if (param1MotionEvent.getAction() == 0) {
            if (!PanelController.this.isLight) {
              PanelController.this.viewGroup.startAnimation(PanelController.this.fadeIn);
              PanelController.this.isLight = true;
            } 
            return param1View.onTouchEvent(param1MotionEvent);
          } 
          if (param1MotionEvent.getAction() == 1)
            PanelController.this.mHandler.sendEmptyMessageDelayed(1, 1600L);
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