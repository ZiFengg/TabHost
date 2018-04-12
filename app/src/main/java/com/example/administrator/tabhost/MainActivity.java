package com.example.administrator.tabhost;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-4-11.
 */

public class MainActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_main,tabHost.getTabContentView(),true);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("已接电话").setContent(R.id.tab01));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("呼出电话",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.tab02));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("未接电话").setContent(R.id.tab03));
        Button bn =findViewById(R.id.bn);
        final AlertDialog.Builder b = new AlertDialog.Builder(this);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setIcon(R.mipmap.ic_launcher);
                b.setTitle("简单的对话框标题");
                b.setItems(
                        new String[]{"红", "绿", "黄"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                TextView tv = findViewById(R.id.text01);
                                switch(i){
                                    case 0:
                                        tv.setBackgroundColor(Color.RED);
                                        break;
                                    case 1:
                                        tv.setBackgroundColor(Color.GREEN);
                                        break;
                                    case 2:
                                        tv.setBackgroundColor(Color.BLUE);
                                        break;

                                }
                            }
                        }
                );
                b.create();
            }
        });
    }
}
