package com.example.administrator.initiatepagedata;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.initiatepagedata.JsonData.ComplexInfoRoot;
import com.example.administrator.initiatepagedata.Untils.OkHttpUntils;

import java.io.IOException;

public class ComplexActivity extends AppCompatActivity {
    Handler mhandler;
    String aid=null;
    TextView tv_validDuration,tv_departCounty,tv_dealCount,tv_likeCount;
    ImageView iv1,iv2,iv3,iv4,iv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);

        init();
    }

    private void init() {
        tv_dealCount= (TextView) findViewById(R.id.dealCount);
        tv_departCounty= (TextView) findViewById(R.id.departCounty);
        tv_likeCount= (TextView) findViewById(R.id.likeCount);
        tv_validDuration= (TextView) findViewById(R.id.validDuration);



        mhandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==1) {
                    ComplexInfoRoot c= (ComplexInfoRoot) msg.obj;
                    tv_dealCount.setText("成交量:"+c.getComplexInfo().get(0).getDealCount());
                    tv_departCounty.setText("开始区县:"+c.getComplexInfo().get(0).getDepartCounty());
                    tv_likeCount.setText("收藏量:"+c.getComplexInfo().get(0).getLikeCount());
                    tv_validDuration.setText("活动有效期："+c.getComplexInfo().get(0).getValidDurationStart()+"到"+c.getComplexInfo().get(0).getValidDurationEnd());
                    String p1=c.getComplexInfo().get(0).getPhotoID1();


                }
            }
        };
        Intent i=getIntent();
        aid=i.getStringExtra("aid");
        try {
            new OkHttpUntils().getComplexInfo(mhandler,aid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
