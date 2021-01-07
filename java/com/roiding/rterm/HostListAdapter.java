package com.roiding.rterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.roiding.rterm.bean.Host;
import com.roiding.rterm.util.TerminalManager;
import java.util.ArrayList;
import java.util.List;

public class HostListAdapter extends BaseAdapter {
  private Context context;
  
  private final List<Host> list;
  
  private List<View> viewList;
  
  public HostListAdapter(Context paramContext, List<Host> paramList) {
    this.context = paramContext;
    this.list = paramList;
    this.viewList = new ArrayList<View>(paramList.size());
    for (int i = 0;; i++) {
      if (i >= paramList.size())
        return; 
      this.viewList.add(null);
    } 
  }
  
  private View buildView(Host paramHost) {
    ViewGroup viewGroup = (ViewGroup)LayoutInflater.from(this.context).inflate(R.layout.item_host, null);
    //getResources(). R.layout.item_host;
    TextView textView1 = (TextView)viewGroup.findViewById(R.id.tv_hostName);
    TextView textView2 = (TextView)viewGroup.findViewById(R.id.tv_hostAddress);
    ImageView imageView = (ImageView)viewGroup.findViewById(R.id.iv_icon);
    View view1 = viewGroup.findViewById(R.id.tv_hostSsh);
    View view2 = viewGroup.findViewById(R.id.tv_hostAutoLogin);
    TextView textView3 = (TextView)viewGroup.findViewById(R.id.tv_hostEncoding);
    textView1.setText(paramHost.getName());
    textView2.setText(String.valueOf(paramHost.getProtocal()) + "://" + paramHost.getHost() + ":" + paramHost.getPort());
    if (TerminalManager.getInstance().getView(paramHost.getId()) == null) {
      imageView.setImageResource(R.drawable.host_offline);
    } else {
      imageView.setImageResource(R.drawable.host_online);
    } 
    if (!"ssh".equalsIgnoreCase(paramHost.getProtocal()))
      view1.setVisibility(8); 
    if (paramHost.getUser() == null || paramHost.getUser().length() == 0 || paramHost.getPass() == null || paramHost.getPass().length() == 0)
      view2.setVisibility(8); 
    textView3.setText(paramHost.getEncoding());
    return (View)viewGroup;
  }
  
  public int getCount() {
    return this.list.size();
  }
  
  public Object getItem(int paramInt) {
    return this.list.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = this.viewList.get(paramInt);
    paramView = view;
    if (view == null) {
      paramView = buildView(this.list.get(paramInt));
      this.viewList.set(paramInt, paramView);
    } 
    return paramView;
  }
}
