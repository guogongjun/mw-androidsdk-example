package com.magicwindow.deeplink.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.magicwindow.deeplink.R;
import com.magicwindow.deeplink.activity.LearnActivity;
import com.magicwindow.deeplink.activity.LoginActivity;
import com.magicwindow.deeplink.app.BaseFragment;
import com.magicwindow.deeplink.config.Config;
import com.magicwindow.deeplink.domain.User;
import com.zxinsight.MarketingHelper;
import com.zxinsight.TrackAgent;

import cn.salesuite.saf.inject.Injector;
import cn.salesuite.saf.inject.annotation.InjectView;
import cn.salesuite.saf.log.L;

public class SettingsFragment extends BaseFragment {


    @InjectView
    private PullToZoomScrollViewEx scrollView;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            L.e("SettingsFragment visible");
            TrackAgent.currentEvent().onPageStart("“我”页");

        } else {
            L.e("SettingsFragment invisible");
            TrackAgent.currentEvent().onPageEnd("“我”页");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        Injector.injectInto(this, view);

        initViews();
        return view;
    }

    private void initViews() {
        View headView = LayoutInflater.from(mContext).inflate(R.layout.settings_head_view, null, false);
        View zoomView = LayoutInflater.from(mContext).inflate(R.layout.settings_zoom_view, null, false);
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.settings_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
        final TextView login = (TextView) scrollView.getPullRootView().findViewById(R.id.login);
        if (User.currentUser().isLoggedIn()) {
            login.setText(R.string.logout_with_blank);
        } else {
            login.setText(R.string.login_with_blank);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (User.currentUser().isLoggedIn()) {
                    login.setText(R.string.login_with_blank);
                    User.currentUser().logout();
                } else {
//                    login.setText(R.string.logout_with_blank);
                    Intent i = new Intent(mContext, LoginActivity.class);
                    startActivity(i);
                    mContext.finish();
                }
            }
        });

        scrollView.getPullRootView().findViewById(R.id.custom_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[92]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.user_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[93]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.grade).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[94]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[95]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.to_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[96]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.my_achievement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[97]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.my_friend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarketingHelper.currentMarketing(mContext).click(mContext, Config.MWS[98]);
            }
        });
        scrollView.getPullRootView().findViewById(R.id.learning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, LearnActivity.class);
                i.putExtra(LearnActivity.TYPE, LearnActivity.FROM_SETTING);
                startActivity(i);
            }
        });
    }

}
