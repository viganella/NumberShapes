package com.vigan.company.numbershapes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class Number{

        int number;

        public boolean isSquare(){

            double squareRoot=Math.sqrt(number);

            if(squareRoot==Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }

        }

        public boolean isTriangular(){
            int x=1;
            int triangularNumber=1;
            while(triangularNumber<number){
                x++;

                triangularNumber=triangularNumber+x;
            }
            if(triangularNumber==number){
                return true;}else{
                return false;}
        }


    }


public void testNumber(View view){

        //Normally the second part is a view but we converted to editext by (EditText)
        EditText usersNumber=(EditText)findViewById(R.id.userNumbers);

            String message="";

            if(usersNumber.getText().toString().isEmpty()){
             message="Please enter a number into the textfield";
            }else{
                Number mynumber=new Number();
                mynumber.number=Integer.parseInt(usersNumber.getText().toString());
                if (mynumber.isSquare()){
                    if(mynumber.isTriangular()){
                        message=mynumber.number+" is both triangular and square";
                    }else{
                        message=mynumber.number+" is square but not triangular";
                    }
                }else if(mynumber.isTriangular()){
                    message=mynumber.number+" is triangular but not square";
                }else{
                    message=mynumber.number+" is nothing";
                }
                Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();

            }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
