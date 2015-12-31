package com.example.intentsactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Actividad2 extends Activity 
{
	TextView tvNombre;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.actividad2);
		
		tvNombre = (TextView) findViewById(R.id.tvNombre);
		
		//Recuperación de los datos de la Actividad Principal
		Bundle datos = getIntent().getExtras();
		tvNombre.setText(datos.getString("nombreKey"));
	}

}
