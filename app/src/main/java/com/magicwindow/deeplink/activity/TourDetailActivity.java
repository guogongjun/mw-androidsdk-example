package com.magicwindow.deeplink.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.magicwindow.deeplink.R;
import com.magicwindow.deeplink.app.BaseAppCompatActivity;
import com.magicwindow.deeplink.config.Config;
import com.zxinsight.MarketingHelper;

import cn.salesuite.saf.inject.annotation.OnClick;

/**
 * @author aaron
 * @date 16/01/14
 */
public class TourDetailActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);
        initToolBar();
    }

    @OnClick(id= R.id.tour_detail_button)
    void clickButton() {
        MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[91]);
    }


    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tour_detail_name);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
