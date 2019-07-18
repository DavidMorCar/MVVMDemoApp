package com.app.davidmoreno.demoapp.appmodules.main.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.app.davidmoreno.demoapp.R;
import com.app.davidmoreno.demoapp.appmodules.base.BaseActivity;
import com.app.davidmoreno.demoapp.appmodules.main.adapter.MainAdapter;
import com.app.davidmoreno.demoapp.appmodules.main.viewmodel.MainViewModel;

import java.io.Serializable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private MainViewModel mainViewModel;

    private RecyclerView listView;
    @BindView(R.id.button) Button button;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.listView = (RecyclerView) findViewById(R.id.listview);
        this.listView.setLayoutManager(new LinearLayoutManager(this));
        initViewModel();
    }

    private void initViewModel() {
        showLoadingDialog();
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        mainViewModel.getImages().observe(this, images -> {
            if (images == null) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Error loading data...", Snackbar.LENGTH_LONG);
                snackbar.show();
            } else {
                this.mainAdapter = new MainAdapter(this, images);
                this.listView.setAdapter(this.mainAdapter);
            }
            hideLoadingDialog();
        });
        mainViewModel.loadImages();
    }

    @OnClick(R.id.button)
    public void onClick() {
        mainViewModel.loadImages();
        showLoadingDialog();
    }

}
