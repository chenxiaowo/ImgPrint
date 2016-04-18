package cn.faisco.jenkins.imageprint.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import cn.faisco.jenkins.imageprint.R;
import cn.faisco.jenkins.imageprint.main_fragments.ClassifyFragment;
import cn.faisco.jenkins.imageprint.main_fragments.CommunityFragment;
import cn.faisco.jenkins.imageprint.main_fragments.FindFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    LinearLayout bottomTab1 = null;
    LinearLayout bottomTab2 = null;
    LinearLayout bottomTab3 = null;
//    LinearLayout bottomTab4 = null;

    ImageButton img_btn1 = null;
    ImageButton img_btn2 = null;
    ImageButton img_btn3 = null;
//    ImageButton img_btn4 = null;


    //主界面下部tab所切换的四个Fragment
    Fragment fragment1 = null;
    Fragment fragment2 = null;
    Fragment fragment3 = null;
//    Fragment fragment4 = null;
    //用于保存当前的Fragment
    Fragment content = null;

    //对底部tab切换的监听器

    //用于本Fragment的FragmentManager
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化View
        initView();
        //初始化事件
        initEvent();

        //设置一加载MainActivity所显示的Fragment
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment1);
        transaction.commit();
    }


    /**
     * 用于初始化actionBar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_activity_actions,menu);
        return true;
    }

    /**
     * 用于初始化View
     */
    private void initView() {
        bottomTab1 = (LinearLayout) findViewById(R.id.ll_tab_btm1);
        bottomTab2 = (LinearLayout) findViewById(R.id.ll_tab_btm2);
        bottomTab3 = (LinearLayout) findViewById(R.id.ll_tab_btm3);
//        bottomTab4 = (LinearLayout) findViewById(R.id.ll_tab_btm4);

        img_btn1 = (ImageButton) findViewById(R.id.img_btm1);
        img_btn2 = (ImageButton) findViewById(R.id.img_btm2);
        img_btn3 = (ImageButton) findViewById(R.id.img_btm3);
//        img_btn4 = (ImageButton) findViewById(R.id.img_btm4);

        fragment1 = new FindFragment();
        fragment2 = new ClassifyFragment();
        fragment3 = new CommunityFragment();

        content = fragment1;
    }

    /**
     * 初始化所有控件的事件
     */
    private void initEvent() {
        bottomTab1.setOnClickListener(this);
        bottomTab2.setOnClickListener(this);
        bottomTab3.setOnClickListener(this);
//        bottomTab4.setOnClickListener(this);

        img_btn1.setOnClickListener(this);
        img_btn2.setOnClickListener(this);
        img_btn3.setOnClickListener(this);
//        img_btn4.setOnClickListener(this);

        //初始化监听该类中所发生对应事件的监听器

    }

    /**
     * 用于设置显示的Fragment
     * 这个方法的目的是在切换Fragment时不刷新Fragment里的内容
     * @param from  表示当前显示的Fragment
     * @param to    表示将要显示的Fragment
     */
    public void switchContent(Fragment from, Fragment to) {
        if (content != to) {
            content = to;
            FragmentTransaction transaction = manager.beginTransaction().setCustomAnimations(
                    android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.container, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }


    /**
     * 用于处理点击事件
     * @param v 事件对应的控件
     */
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.img_btm1:
            case R.id.ll_tab_btm1:
                switchContent(content, fragment1);
                break;
            case R.id.img_btm2:
            case R.id.ll_tab_btm2:
                switchContent(content, fragment2);
                break;
            case R.id.img_btm3:
            case R.id.ll_tab_btm3:
                switchContent(content, fragment3);
                break;
//            case R.id.img_btm4:
//            case R.id.ll_tab_btm4:
//                switchContent(content, fragment4);
//                odscl.onStatusChanged(R.id.img_btm4);
//                break;
        }
        transaction.commit();
    }


}