package com.wordpress.arogyavidyastonepaperscissor;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Play extends Activity {

	public String user_choice, comp_choice;
	public TextView user_txt,comp_txt,res;
	 public int k;
	public int playerscore, computerscore;
	
	public Button share,exit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	

	public void stclicks(View view)
	{
		k=1;
		compChoice(k);
		 
	}
	
	public void ppclicks(View view)
	{
		k=2;
		compChoice(k);
	}
	
	public void scclicks(View view)
	{
		k=3;
		compChoice(k);
	}
	
	public void compChoice(int user)
	{
		comp_txt=(TextView)findViewById(R.id.clickofComp);
		user_txt =(TextView)findViewById(R.id.clickofHum);
		res = (TextView)findViewById(R.id.Result);
		
		//clearing the text
		user_txt.setText("");
		comp_txt.setText("");
		res.setText("");
		
		if(user==1)
		user_choice="Stone";
		else if(user == 2)
			user_choice="Paper";
		else
			user_choice="Scissor";
		//setting the text 
		user_txt.append(user_choice);
		
		Random rn = new Random();
		int comp = rn.nextInt((3 - 1) + 1) + 1;
		switch(comp)
		{
		case 1:
			comp_txt.append("Stone");
			break;
			
		case 2:
			comp_txt.append("Paper");
			break;
		case 3:
			comp_txt.append("Scissor");
			break;
		}

		// comparison..
		if(user==1){
			if(comp==1)
				res.append("Tie");
			else if(comp==2){
				res.append("Computer Win");
				loses();
			}
				
			else
			{			
				res.append("You Win");
			wins();
			}
		}
		else if(user==2)
		{
				if(comp==2)
					res.append("Tie");
				else if(comp==1)
				{
					res.append("You Win");
				wins();
		}
				else
					
				{
					res.append("Computer Win");
				loses();
				}
		}
		else
		{
			if(comp ==3)
				res.append("Tie");
			else if(comp ==2)
			{
				res.append("You Win");
				wins();
			}
			else
			{
				res.append("Computer Win");
			loses();
			}
		}
			

	}
	
	public void wins()
	{
		TextView pc,sc;
		pc=(TextView)findViewById(R.id.playerScore);
		sc=(TextView)findViewById(R.id.cScore);
		res = (TextView)findViewById(R.id.Result);
		
		int ps,cs;
		//getting the score
		ps=Integer.parseInt(pc.getText().toString());
		cs=Integer.parseInt(sc.getText().toString());
		
		ps=ps+2;
		cs=cs-1;
				
		pc.setText(ps+"");
		sc.setText(cs+"");
		//telling the end
		if(ps>=15 || cs>=15)
		{
			playerscore=ps;
			computerscore=cs;
			if(ps>cs)
			{
				Intent intent = new Intent(this,Winner.class);
				startActivity(intent);	
			}
		 
			else
			{
				Intent intent = new Intent(this,Loser.class);
				startActivity(intent);	
			}
		}
			
		
	}
	public void loses()
	{
		TextView pc,sc;
		pc=(TextView)findViewById(R.id.playerScore);
		sc=(TextView)findViewById(R.id.cScore);
		
		int ps,cs;
		//getting the score
		ps=Integer.parseInt(pc.getText().toString());
		cs=Integer.parseInt(sc.getText().toString());
		
		ps=ps-1;
		cs=cs+2;
		pc.setText(ps+"");
		sc.setText(cs+"");
		//telling the end
		if(ps>=15 || cs>=15)
			{
			playerscore=ps;
			computerscore=cs;
			if(ps>cs)
			{
				Intent intent = new Intent(this,Winner.class);
				startActivity(intent);	
			}
		 
			else
			{
				Intent intent = new Intent(this,Loser.class);
				startActivity(intent);	
			}
				
			
			}
	}
	
 
	
	public void exits(View view){
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}


}
