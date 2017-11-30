package my.edu.tarc.lab32inputcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //Create an adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);


       /* Button buttonCalculate = (Button)findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,long id)
    {
        Toast.makeText(getApplicationContext(),"Position :" + position,Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    public void calculatePremium(View view)
    {
        int pos,premium = 0;
        pos = spinnerAge.getSelectedItemPosition();
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();

        switch(pos)
        {
            case 0:
                premium = 50;
                break;
            case 1:
                premium = 55;
            case 2: {
                premium = 60;
                if (indexGender == R.id.radioButtonMale) {
                    //TODO: calculate premium for male
                    premium += 50;

                }

            }
            break;
            case 3:{
                premium = 70;
                if (indexGender == R.id.radioButtonMale) {
                    //TODO: calculate premium for male
                    premium += 100;


                }
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium of smoker
                    premium += 100;
                }


            }
                break;
            case 4:{
                premium = 120;
                if (indexGender == R.id.radioButtonMale) {
                    //TODO: calculate premium for male
                    premium += 100;

                }
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium of smoker
                    premium += 150;
                }

            }
                break;
            case 5: {
                premium = 160;
                if (indexGender == R.id.radioButtonMale) {
                    //TODO: calculate premium for male
                    premium += 50;

                }
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium of smoker
                    premium += 150;
                }

            }
            break;
            case 6:
                premium = 200;
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium of smoker
                    premium += 250;
                }
                break;
            case 7:
                premium = 250;
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium of smoker
                    premium += 250;
                }
                break;
        }

        Locale locale = Locale.getDefault();

        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String currencyText = fmt.format(premium);

        textViewPremium.setText(getString(R.string.premium) + premium);

    }

    public void resetPremium(View view)
    {
       spinnerAge.setSelection(0);
        radioButtonMale.setChecked(true);
        checkBoxSmoker.setChecked(false);
    }



}
