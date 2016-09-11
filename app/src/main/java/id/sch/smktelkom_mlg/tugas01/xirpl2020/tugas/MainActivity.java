package id.sch.smktelkom_mlg.tugas01.xirpl2020.tugas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
{

    EditText etNama;
    EditText etUmur;
    Button bOK;
    TextView tvHasil;
    TextView tvhobi;
    RadioGroup rgStatus;
    RadioButton rl, rp;
    CheckBox cb1,cb2,cb3,cb4;
    int nHobi;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.textView6);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });


        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);

        tvHasil = (TextView) findViewById(R.id.textView6);
        tvhobi = (TextView) findViewById(R.id.textView4);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });

        rgStatus = (RadioGroup) findViewById(R.id.RadioGroup);
        tvHasil = (TextView) findViewById(R.id.textView6);
        rl = (RadioButton) findViewById(R.id.radioButton1);
        rp = (RadioButton) findViewById(R.id.radioButton2);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });

        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if(i == R.id.RadioGroup)
                {
                    findViewById(R.id.RadioGroup).setVisibility(View.GONE);
                }

                else
                {
                    findViewById(R.id.RadioGroup).setVisibility(View.VISIBLE);
                }
            }
        });

        etNama = (EditText) findViewById(R.id.editText);
        etUmur = (EditText) findViewById(R.id.editText2);

        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textView6);

        bOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doProcess();

            }
        });
    }

    private void doProcess()
    {
        String hasil3 = sp.getContext().toString();

        if(hasil3 == "")
        {
            tvHasil.setText("Anda belum memilih jurusan");
        }

        String nama1 = etNama.getText().toString();
        String hasil1 = " Hobi " + nama1 + " :\n";
        int startlen = hasil1.length();

        if(cb1.isChecked()) hasil1+=cb1.getText()+"\n";
        if(cb2.isChecked()) hasil1+=cb2.getText()+"\n";
        if(cb3.isChecked()) hasil1+=cb3.getText()+"\n";
        if(cb4.isChecked()) hasil1+=cb4.getText()+"\n";

        if(hasil1.length() == startlen) hasil1+="Tidak ada pilihan \n";
        tvHasil.setText(hasil1);


        String hasil = null;

        if(hasil == null)
        {
            tvHasil.setText("Belum diisi");
        }

        if(rl.isChecked())
        {
            hasil = rl.getText().toString();
        }

        else if(rp.isChecked())
        {
            hasil = rp.getText().toString();
        }

        if(isValid())
        {
            String nama = etNama.getText().toString();
            int umur = Integer.parseInt(etUmur.getText().toString());
            tvHasil.setText(nama + "\n berusia " + umur + " tahun " + "\n gender " + hasil + "\n"+ hasil1 + " Jurusan " + nama + sp.getSelectedItem().toString());
        }

    }



    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText() .toString();
        String umur = etUmur.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid  = false;
        }

        else
        {
            etNama.setError(null);
        }


        if(umur.isEmpty())
        {
            etUmur.setError("Umur Belum Diiisi");
            valid = false;
        }

        else
        {
            etUmur.setError(null);
        }

        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if(isChecked) nHobi += 1;
        else nHobi -= 1;



        tvhobi.setText("Hobi ("+nHobi+" terpilih)");
    }
}