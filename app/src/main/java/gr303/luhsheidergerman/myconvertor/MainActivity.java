package gr303.luhsheidergerman.myconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerFrom, spinnerTo;
    EditText editFrom;
    TextView textTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinner_from);
        spinnerTo = findViewById(R.id.spinner_to);
        editFrom = findViewById(R.id.editText_from);
        textTo = findViewById(R.id.textView_to);

        ((RadioButton)findViewById(R.id.radioButton_length)).performClick();
    }
    Unit unit = new Unit();
    public void radioGroup_onClick(View v) {
        RadioButton rb = (RadioButton)v;

        ArrayAdapter<String> adp = new<String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        switch (rb.getId()) {
            case R.id.radioButton_length: adp = unit.setUnit(adp, "length");
                break;
            case R.id.radioButton_time: adp = unit.setUnit(adp, "time");
                break;
            case R.id.radioButton_weight: adp = unit.setUnit(adp, "weight");
                break;
        }
        spinnerFrom.setAdapter(adp);
        spinnerTo.setAdapter(adp);
    }

    public void button_convert_onClick(View v) {
        String strFrom = editFrom.getText().toString();

        if(strFrom.isEmpty() || strFrom.equals(".")) {
            Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show();
            return;
        }

        double from = Double.parseDouble(strFrom);

        String sFrom = (String) spinnerFrom.getSelectedItem();
        String sTo = (String) spinnerTo.getSelectedItem();

        textTo.setText("To:\t\t\t\t"+unit.Calculate(from, sFrom, sTo));
    }
}