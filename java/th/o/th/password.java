package th.o.th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class password extends AppCompatActivity {

    int length;
    Context context = password.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        TextView textView = findViewById(R.id.passText);
        EditText editText = findViewById(R.id.passEditText);

        String onlyChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String char_Number = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        String char_Num_specialChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{};:,.<>?";

        Button charOnly = findViewById(R.id.passOnlyChar);
        charOnly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(password.this, "Enter Length Of the Password", Toast.LENGTH_LONG).show();
                } else {

                    length = 0;
                    textView.setText(null);
                    StringBuilder stringBuilder = new StringBuilder();
                    Random random = new Random();

                    length = Integer.parseInt(editText.getText().toString());

                    for (int i = 0; i < length; i++) {
                        int index = random.nextInt(charOnly.length());
                        stringBuilder.append(onlyChar.charAt(index));
                    }

                    textView.setText(stringBuilder);
                }
            }
        });

        Button charNum = findViewById(R.id.passCharNum);
        charNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(password.this, "Enter Length Of the Password", Toast.LENGTH_LONG).show();
                } else {
                    length = 0;
                    textView.setText(null);
                    StringBuilder stringBuilder = new StringBuilder();
                    Random random = new Random();

                    length = Integer.parseInt(editText.getText().toString());

                    for (int i = 0; i < length; i++) {
                        int index = random.nextInt(char_Number.length());
                        stringBuilder.append(char_Number.charAt(index));
                    }

                    textView.setText(stringBuilder);
                }
            }
        });

        Button charNumSpecial = findViewById(R.id.passCharNumSpecial);
        charNumSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(password.this, "Enter Length Of the Password", Toast.LENGTH_LONG).show();
                } else {
                    length = 0;
                    textView.setText(null);
                    StringBuilder stringBuilder = new StringBuilder();
                    Random random = new Random();

                    length = Integer.parseInt(editText.getText().toString());

                    for (int i = 0; i < length; i++) {
                        int index = random.nextInt(char_Num_specialChar.length());
                        stringBuilder.append(char_Num_specialChar.charAt(index));
                    }

                    textView.setText(stringBuilder);

                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(textView.getText());
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
}