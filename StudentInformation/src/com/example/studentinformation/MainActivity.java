package com.example.studentinformation;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

	EditText Idno;
	EditText Name;
	RadioGroup Sex;
	Spinner Course;
	Button Okay;
	Button Cancel;
	private String selected_Course;
	private int selected_sex;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instances
        
        Idno=(EditText) this.findViewById(R.id.editText1);
        Name=(EditText) this.findViewById(R.id.editText2);
        Sex=(RadioGroup) this.findViewById(R.id.radioGroup1);
        Course=(Spinner) this.findViewById(R.id.spinner1);
        Okay=(Button) this.findViewById(R.id.button1);
        Cancel=(Button) this.findViewById(R.id.button2);
        
        Okay.setOnClickListener(this);
        Cancel.setOnClickListener(this);
        
        Course.setOnItemSelectedListener(this);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		int id=arg0.getId();
		switch(id){
		case R.id.button1:
			
		selected_sex=Sex.getCheckedRadioButtonId();	
		
			String idnum=Idno.getText().toString();
			String nm=Name.getText().toString();
			
			if(idnum.equals("")&&nm.equals(""))
			{
				Toast.makeText(this, "Please fill Idno and Name", Toast.LENGTH_SHORT).show();
			}
			else
			{
				RadioButton sexbutton=(RadioButton) this.findViewById(selected_sex);
				String mysex=sexbutton.getText().toString();
			
				String message="Idno:"+idnum+"\nName:"+nm+"\nSex:"+mysex+"\nCourse:"+this.selected_Course;
				
				
				AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle("Student Inforamtion");
				builder.setMessage(message);
				builder.setNeutralButton("Okay", null);
				
				AlertDialog dialog=builder.create();
				dialog.show();
			}
			
			break;
		case R.id.button2:
			
			Name.setText("");
			Idno.setText("");
			Sex.clearCheck();
			Course.setSelection(0);
		}
		
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		selected_Course=Course.getItemAtPosition(arg2).toString();
				
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
