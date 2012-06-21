package com.ilsoft.funnycreatures.ui;

import java.util.Random;

import com.ilsoft.funnycreatures.R;
import com.ilsoft.funnycreatures.core.Case;
import com.ilsoft.funnycreatures.core.FunnyCreature;
import com.ilsoft.funnycreatures.core.FunnyCreatureDescriptor;
import com.ilsoft.funnycreatures.core.FunnyCreatureGenerator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FunnyCreaturesWalkActivity extends Activity 
{
	private TextView creatureName_TextView;
	private TextView creatureDescription_TextView;
	private Button goForward_Button;
	private Button goForAWalk_Button;
	private LinearLayout youMeetCreature_LinearLayout;
	private LinearLayout goForAWalk_LinearLayout;

    private Random rnd = new Random();
    private volatile ProgressDialog pd = null;

    Runnable walkingRunnable = new Runnable()
    {
    	
    	public void run() 
    	{
	    	double wait = rnd.nextDouble() * 1.6 + 0.5;

	    	try {
				Thread.sleep((long) (wait * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	FunnyCreaturesWalkActivity.this.runOnUiThread(new Runnable()
	    	{
				public void run() 
				{
					if (pd != null) 
					{
						FunnyCreature fc = FunnyCreatureGenerator.generate(rnd);
						
						creatureName_TextView.setText(fc.getFullName(Case.NOMINATIVE));
						creatureDescription_TextView.setText(FunnyCreatureDescriptor.describe(fc));

						goForAWalk_LinearLayout.setVisibility(View.GONE);
						youMeetCreature_LinearLayout.setVisibility(View.VISIBLE);

						pd.dismiss();
						pd = null;

						goForward_Button.setEnabled(true);
						goForAWalk_Button.setEnabled(true);
					}
				}
	    	});
			
    	}
    };
    
	OnClickListener go_Button_OnClick = new OnClickListener()
	{
	    public void onClick(View v) 
		{
			goForward_Button.setEnabled(false);
			goForAWalk_Button.setEnabled(false);
	    	pd = ProgressDialog.show(FunnyCreaturesWalkActivity.this, null, "Идем куда глаза глядят...");
			Thread walkingThread = new Thread(walkingRunnable);
			walkingThread.start();
		}
	};
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Getting widgets
        goForAWalk_LinearLayout = (LinearLayout)findViewById(R.id.goForAWalk_LinearLayout);
        goForAWalk_Button = (Button)findViewById(R.id.goForAWalk_Button);
        
        youMeetCreature_LinearLayout = (LinearLayout)findViewById(R.id.youMeetCreature_LinearLayout);
        creatureName_TextView = (TextView)findViewById(R.id.creatureName_TextView);
        creatureDescription_TextView = (TextView)findViewById(R.id.creatureDescription_TextView);
        goForward_Button = (Button)findViewById(R.id.goForward_Button);

        // Setting listeners
        goForward_Button.setOnClickListener(go_Button_OnClick);
        goForAWalk_Button.setOnClickListener(go_Button_OnClick);
    }
}