package com.onpu.rrrr;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.jsoup.Jsoup;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button scan_btn;
    public String urlString;
    public static boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan_btn = (Button) findViewById(R.id.scan_btn);
        final Activity activity = this;
        state = false;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents()==null) {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show(); //выведется
                urlString = result.getContents();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlString));
                startActivity(i);


               Toast.makeText(getApplicationContext(),"Data load", Toast.LENGTH_LONG).show();

            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
