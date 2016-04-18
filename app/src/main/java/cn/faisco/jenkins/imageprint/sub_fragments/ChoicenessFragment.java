package cn.faisco.jenkins.imageprint.sub_fragments;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.faisco.jenkins.imageprint.R;


/**
 * Created by Administrator on 2015/10/26.
 */
public class ChoicenessFragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choiceness, container, false);




        ExpandableListAdapter adapter = new ExpandableListAdapter() {

            int[] logos = new int[]{
                    R.drawable.aria,
                    R.drawable.aria,
                    R.drawable.aria
            };
            private String[] armTypes = new String[]
                    {
                            "1号花瓣",
                            "2号花瓣",
                            "3号花瓣"
                    };

            private String[][] arms = new String[][]
                    {
                            {"arms是什么1", "arms是什么2", "arms是什么3", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4", "arms是什么4"},
                            {"arms是什么2_1", "arms是什么2_2", "arms是什么2_3", "arms是什么2_4"},
                            {"arms是什么3_1", "arms是什么3_2", "arms是什么3_3"}
                    };


            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }


            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(getContext());
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(100, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }


            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(getContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(getContext());
                logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            //以下方法并未被实现
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {
            }

            @Override
            public void onGroupCollapsed(int groupPosition) {
            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }


        };
        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.ex_lv);

        expandableListView.setAdapter(adapter);

        expandableListView.expandGroup(0);



        return view;
    }
}
