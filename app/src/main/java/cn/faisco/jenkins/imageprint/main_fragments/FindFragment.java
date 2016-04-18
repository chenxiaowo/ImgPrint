package cn.faisco.jenkins.imageprint.main_fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.faisco.jenkins.imageprint.R;
import cn.faisco.jenkins.imageprint.sub_fragments.ChoicenessFragment;
import cn.faisco.jenkins.imageprint.sub_fragments.FocusFragment;
import cn.faisco.jenkins.imageprint.sub_fragments.HangoutFragment;


/**
 * Created by Administrator on 2015/11/1.
 * 继承自Fragmnet，实现了view的监听接口和底部tab切换的接口
 */
public class FindFragment extends Fragment implements View.OnClickListener {


    /*各成员变量的声明*/
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;


    //顶部的三个Tab便签
    private LinearLayout mTopTabChoiceness;
    private LinearLayout mTopTabHangout;
    private LinearLayout mTopTabFocus;

    //标签中的图片按钮
    private ImageButton mImgChoiceness;
    private ImageButton mImgHangout;
    private ImageButton mImgFocus;

    //drawerLayout抽屉
//    private DrawerLayout mDrawer;

    //打开drawer的图标
//    private ImageButton mImg_drawer;
    //drawer中关闭drawer的图标
//    private ImageButton mImg_close_drawer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, null);
        //初始化本Fragment中的View
        initView(view);
        //初始化本Fragment中组件的事件
        initEvents();
        return view;
    }

    /**
     * 初始化本Fragment中中组件的事件
     */
    private void initEvents() {
        mImgChoiceness.setOnClickListener(this);
        mImgHangout.setOnClickListener(this);
        mImgFocus.setOnClickListener(this);
//        mImg_drawer.setOnClickListener(this);
//        mImg_close_drawer.setOnClickListener(this);
    }

    /**
     * 初始化本Fragment中的View
     *
     * @param view 对应xml文件的view
     */
    private void initView(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mTopTabChoiceness = (LinearLayout) view.findViewById(R.id.tab_1);
        mTopTabHangout = (LinearLayout) view.findViewById(R.id.tab_2);
        mTopTabFocus = (LinearLayout) view.findViewById(R.id.tab_3);

        mImgChoiceness = (ImageButton) view.findViewById(R.id.img_1);
        mImgHangout = (ImageButton) view.findViewById(R.id.img_2);
        mImgFocus = (ImageButton) view.findViewById(R.id.img_3);
//        mImg_close_drawer = (ImageButton) view.findViewById(R.id.ib_drawerback);


        Fragment mTab1 = new ChoicenessFragment();
        Fragment mTab2 = new HangoutFragment();
        Fragment mTab3 = new FocusFragment();

//        mDrawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);


        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mViewPager.setOffscreenPageLimit(3);


        mFragments = new ArrayList<Fragment>();
        mFragments.add(mTab1);
        mFragments.add(mTab2);
        mFragments.add(mTab3);

        mAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mImgChoiceness.setImageResource(R.drawable.tab_tob_1_s);
                        break;
                    case 1:
                        mImgHangout.setImageResource(R.drawable.tab_tob_2_s);
                        break;
                    case 2:
                        mImgFocus.setImageResource(R.drawable.tab_tob_3_s);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        setSelect(0);
    }


    /**
     * 用于处理viewPager的页面切换
     *
     * @param i 页码
     */
    private void setSelect(int i) {
        resetImg();
        switch (i) {
            case 0:
                mImgChoiceness.setImageResource(R.drawable.tab_tob_1_s);
                mViewPager.setCurrentItem(0);
                break;
            case 1:
                mViewPager.setCurrentItem(1);
                mImgHangout.setImageResource(R.drawable.tab_tob_2_s);
                break;
            case 2:
                mViewPager.setCurrentItem(2);
                mImgFocus.setImageResource(R.drawable.tab_tob_3_s);
                break;
        }
    }


    /**
     * 重置所有图片
     */
    private void resetImg() {
        mImgChoiceness.setImageResource(R.drawable.tab_tob_1);
        mImgHangout.setImageResource(R.drawable.tab_tob_2);
        mImgFocus.setImageResource(R.drawable.tab_tob_3);
    }

    /**
     * 处理点击事件
     *
     * @param v 事件对应的控件
     */
    @Override
    public void onClick(View v) {
        //处理ImageButton作为标签的tab的点击事件
        switch (v.getId()) {
            case R.id.img_1:
                setSelect(0);
                break;
            case R.id.img_2:
                setSelect(1);
                break;
            case R.id.img_3:
                setSelect(2);
                break;
        }

    }

}
