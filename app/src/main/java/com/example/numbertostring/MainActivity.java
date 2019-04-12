package com.example.numbertostring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    private static final String[] tens = {
            "","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"
    };
    private static final String[] nums = {
            "","one","two","three","four","five","six","seven","eight","nine",
            "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "conversion button clicked",Toast.LENGTH_SHORT).show();
                textView.setText(convertlessthanonethousand(Integer.parseInt(editText.getText().toString())));
 //convertlessthanonethousand bhaneko muni banaeko method lai taneko result dekhauna,
// textView.set text (answer aauna ko lagi) inter.pareint(editext.gettext().toString()))) (mathi number lekhne thau ma value pass gareko)
            }
        });
    }
   private static String convertlessthanonethousand(int number){
        String sofar;
        if(number % 100 < 20){
            sofar = nums[number % 10];
            number /= 100;
        } else {
            sofar = nums[number % 10];
            number /= 10;
            sofar = tens[number % 10] + sofar;
            number /= 10;
        }
        if (number == 0) return sofar;
        return nums[number] + "hundred" + sofar;
   }


}
