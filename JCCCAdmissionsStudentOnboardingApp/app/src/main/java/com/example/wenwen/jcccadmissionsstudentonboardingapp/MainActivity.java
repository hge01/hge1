package com.example.wenwen.jcccadmissionsstudentonboardingapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class MainActivity extends ActionBarActivity
        implements NavDrawer.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavDrawer mNavDrawer;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    //private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        myWebView = new WebView(this);
        myWebView.loadUrl("file:///android_asset/about.html");
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        this.setContentView(myWebView);*/

        //WebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
        setContentView(R.layout.activity_main);

        mNavDrawer = (NavDrawer)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavDrawer.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }

    //add login activity


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        //When click each menu, it will show the related title.
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
                break;
            case 7:
                mTitle = getString(R.string.title_section7);
                break;
            case 8:
                mTitle = getString(R.string.title_section8);
                break;
            case 9:
                mTitle = getString(R.string.title_section9);
                break;
            case 10:
                mTitle = getString(R.string.title_section10);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavDrawer.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
/*
            //add submenu(finally delete)
            super.onCreateOptionsMenu(menu, inflater);
            inflater.inflate(R.menu.main, menu);
            MenuItem menuItem1 = menu.findItem(R.id.action_application).getSubMenu().findItem(R.id.action_application).getSubMenu().add(Menu.NONE, 1, Menu.NONE, "Apply for Admission");
            MenuItem menuItem2 = menu.findItem(R.id.action_application).getSubMenu().findItem(R.id.action_application).getSubMenu().add(Menu.NONE, 2, Menu.NONE, "Selective Programs");
            */
        }
        return super.onCreateOptionsMenu(menu);


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final WebView myWebView = (WebView)rootView.findViewById(R.id.WebView);
            myWebView.setWebChromeClient(new WebChromeClient());

            //Enable JavaScript so that the video in the html files will work.
            myWebView.getSettings().setJavaScriptEnabled(true);

            int i = getArguments().getInt(ARG_SECTION_NUMBER);
            String webUrl = "http://www.jccc.edu/";          //define default WebView

            myWebView.setHorizontalScrollBarEnabled(false);


            //JCCCParser facts = new JCCCParser("http://www.jccc.edu/about/story/facts/index.html#.VTQRGxcxlE4");
            //System.out.println(facts.parseToString());
            //facts.writeToFile("facts.html");


            //Enable WebView when click each menu.
            switch(i){
                case 1:
                    //About JCCC
                    webUrl= "file:///android_asset/about.html";
                    break;
                case 2:
                    //Campus Visit
                    webUrl= "file:///android_asset/campusVisit.html";
                    break;
                case 3:
                    //Campus Map
                    webUrl= "file:///android_asset/campusMap.html";
                    break;
                case 4:
                    //Areas of Study and Degrees
                    webUrl= "file:///android_asset/programs_and_degrees.html";
                    break;
                case 5:
                    //Meet a Counselor
                    webUrl= "file:///android_asset/counseling.html";
                    break;
                case 6:
                    //Admission
                    webUrl= "file:///android_asset/admission.html";
                    break;
                case 7:
                    //Login
                    webUrl= "file:///android_asset/login.html";
                    break;
                case 8:
                    //Twitter
                    webUrl="https://twitter.com/jccctweet";
                    break;
                case 9:
                    //Facebook
                    webUrl="https://www.facebook.com/JCCC411";
                    break;
                case 10:
                    //Emergency
                    webUrl= "file:///android_asset/emergency.html";
                    break;
            }

            if(myWebView != null){
                myWebView.loadUrl(webUrl);
                //myWebView.loadData(facts.parseToString(), "text/html", null);
            }
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }



    /*
    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()){
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
