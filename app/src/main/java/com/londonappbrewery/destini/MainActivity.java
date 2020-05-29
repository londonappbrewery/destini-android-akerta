package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        //final ViewGroup layout = (ViewGroup) mButtonTop.getParent(); //OPTION 1
        //OPTION 2 - no variable required

        if(savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("storyIndex");


            switch (mStoryIndex) {
                case 1:
                    mStoryTextView.setText(R.string.T1_Story);
                    mButtonTop.setText(R.string.T1_Ans1);
                    mButtonBottom.setText(R.string.T1_Ans2);
                    break;
                case 2:
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                    break;
                case 3:
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    break;
                case 4:
                    mStoryTextView.setText(R.string.T4_End);
                    mButtonTop.setVisibility(View.GONE); //OPTION 2
                    mButtonBottom.setVisibility(View.GONE); //OPTION 2
                    break;
                case 5:
                    mStoryTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(View.GONE); //OPTION 2
                    mButtonBottom.setVisibility(View.GONE); //OPTION 2
                    break;
                case 6:
                    mStoryTextView.setText(R.string.T6_End);
                    mButtonTop.setVisibility(View.GONE); //OPTION 2
                    mButtonBottom.setVisibility(View.GONE); //OPTION 2
                    break;
                default:
                    mStoryIndex = 1;
                    mStoryTextView.setText(R.string.T1_Story);
                    mButtonTop.setText(R.string.T1_Ans1);
                    mButtonBottom.setText(R.string.T1_Ans2);
            }
            
        } else {
            mStoryIndex = 1;
        }

                // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryIndex = 3;
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 6;
                    mStoryTextView.setText(R.string.T6_End);
                    //layout.removeView(mButtonTop); //OPTION 1
                    //layout.removeView(mButtonBottom); //OPTION 1
                    mButtonTop.setVisibility(View.GONE); //OPTION 2
                    mButtonBottom.setVisibility(View.GONE); //OPTION 2
                }
                //note - no default; hard-coded numbers
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mStoryIndex == 1) {
                    mStoryIndex = 2;
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                    mStoryTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(View.GONE); //OPTION 2
                    mButtonBottom.setVisibility(View.GONE); //OPTION 2
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                    mStoryTextView.setText(R.string.T4_End);
                    mButtonTop.setVisibility(View.GONE); //OPTION 2
                    mButtonBottom.setVisibility(View.GONE); //OPTION 2
                }
                //note - no default; hard-coded numbers
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("storyIndex", mStoryIndex);
    }
}
