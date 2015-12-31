package com.example.intentsactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener, OnClickListener
{

	EditText etNombre, etPass;
	Button btnIngresar, btnBorrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etNombre 	= (EditText) findViewById(R.id.etNombre);
        etPass 	 	= (EditText) findViewById(R.id.etPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnBorrar 	= (Button) findViewById(R.id.btnBorrar);
        
        btnIngresar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) 
	{
		String nombre = etNombre.getText().toString();
		String pass = etPass.getText().toString();
		switch (v.getId()) 
		{
		case R.id.btnIngresar:
			if(nombre.equals("ricardo") && pass.equals("rick"))
			{
				//Mostrar la otra pantalla
				Intent act2 = new Intent("com.example.intentsactivity.Actividad2");
				
				//Pasar datos a otra actividad
				Bundle datos = new Bundle();
				
				datos.putString("nombreKey", nombre);
				act2.putExtras(datos);
				
				startActivity(act2);
			}
			else
			{
				Toast t = Toast.makeText(this,"Error en las crendenciales", Toast.LENGTH_SHORT);
				t.show();
			}
			break;
		case R.id.btnBorrar:
			etNombre.setText("");
			etPass.setText("");
			break;
		default:
			break;
		}
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
