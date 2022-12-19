package th.o.th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    int min_num, max_num, range_num;
    EditText maxEditText, minEditText, rangeEditText;
    TextView textView1, textView2;
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        maxEditText = findViewById(R.id.editTextMax);
        minEditText = findViewById(R.id.editTextMin);
        rangeEditText = findViewById(R.id.editTextRange);

        Button button_with_repetition = findViewById(R.id.buttonWithRepetition);
        button_with_repetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the edit text is empty
                if (TextUtils.isEmpty(maxEditText.getText().toString())
                        || TextUtils.isEmpty(minEditText.getText().toString())
                        || TextUtils.isEmpty(rangeEditText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter Inputs", Toast.LENGTH_LONG).show();
                } else {

                    min_num = Integer.parseInt(minEditText.getText().toString());
                    max_num = Integer.parseInt(maxEditText.getText().toString());
                    range_num = Integer.parseInt(rangeEditText.getText().toString());

                    ArrayList<Integer> list = new ArrayList<>();

                    if (range_num <= max_num) {
                        for (int i = 0; i < range_num; i++) {
                            final int xz = new Random().nextInt((max_num - min_num) + 1) + min_num;
                            list.add(xz);

                        }
                        textView1.setText("Code with repetition :\n" + list);
                    } else {
                        Toast.makeText(MainActivity.this, "The range should be lower than the max number", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        Button button_without_repetition = findViewById(R.id.buttonWithOutRepetition);
        button_without_repetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the edit text is empty
                if (TextUtils.isEmpty(maxEditText.getText().toString())
                        || TextUtils.isEmpty(minEditText.getText().toString())
                        || TextUtils.isEmpty(rangeEditText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter Inputs", Toast.LENGTH_LONG).show();
                } else {
                    min_num = Integer.parseInt(minEditText.getText().toString());
                    max_num = Integer.parseInt(maxEditText.getText().toString());
                    range_num = Integer.parseInt(rangeEditText.getText().toString());

                    Set<Integer> set = new LinkedHashSet<Integer>();

                    Random random = new Random();

                    if (range_num <= max_num) {
                        for (int i = 0; i < range_num; i++) {

                            while (set.size() < range_num) {
                                set.add(random.nextInt(max_num) + min_num);
                            }
                            textView2.setText("Code without repetition :\n" + set);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "The range should be lower than the max number", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Button button_clear = findViewById(R.id.buttonClear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(null);
                textView2.setText(null);
            }
        });

        //enable standard copy paste for a TextView
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(textView1.getText());
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        //enable standard copy paste for a TextView
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(textView2.getText());
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });


    }

    class claculate extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }
}