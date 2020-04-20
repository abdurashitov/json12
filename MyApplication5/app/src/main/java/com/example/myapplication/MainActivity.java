package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView idText , gasText , waterText , electricityText ;
    String k ="";

    public MainActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idText = findViewById(R.id.id);
        gasText  = findViewById(R.id.gas);
        waterText  = findViewById(R.id.water);
        electricityText  = findViewById(R.id.electricity);
        try {
            JSONArray jsonArray = new JSONArray(readJsonFromFile());
            jsonArray.length();
            Comunalka[] comunalka = new Comunalka[4];
            int id, gaz, water, electricity;
            for (int i=0; i<=jsonArray.length();i++){
                JSONObject jsonRoot = new JSONObject(jsonArray.getJSONObject(i).toString());
                id = jsonRoot.getInt("id");
                gaz = jsonRoot.getInt("gas");
                water = jsonRoot.getInt("water");
                electricity = jsonRoot.getInt("electricity");
                comunalka[i] = new Comunalka(id, gaz, water, electricity);
                idText.setText(idText.getText()+"\t"+comunalka[i].getId());
                gasText.setText(gasText.getText()+"\t"+comunalka[i].getGas());
                waterText.setText(waterText.getText()+"\t"+comunalka[i].getWater());
                electricityText.setText(electricityText.getText()+"\t"+comunalka[i].getElectricity());
            }



            Log.d("comunlka", comunalka.toString());
        } catch (JSONException e) {
            Log.d("comunlka", "1");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("comunlka", "2");
            e.printStackTrace();
        }
    }


    private String readJsonFromFile() throws IOException {
        StringBuilder text = new StringBuilder();
        InputStream is =getResources().openRawResource(R.raw.depositions);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        //чтение построчно
        Log.d("myTag", "This is my message");
        String s="123";

        while((s=br.readLine())!=null){
            k+=s;
                Log.d("text ", s);
            }
        //Log.d("text ", s);
        Log.d("r", k);
        return k;
        }
}
///...



