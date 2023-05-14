package th.o.th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class qrCode extends AppCompatActivity {
    private Button generateButton;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        StringBuilder stringBuilder = new StringBuilder();
        ImageView imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.qrEditText);

        generateButton = findViewById(R.id.qrButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuilder.append(editText.getText().toString());
                // Generate the QR code
                Bitmap qrBitmap = QRCodeGenerator.generateQRCode(stringBuilder.toString());

                // Set the QR code image view
                imageView.setImageBitmap(qrBitmap);
            }
        });
    }
}

class QRCodeGenerator {

    public static Bitmap generateQRCode(String text) {
        // Create a BarcodeEncoder object
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();

        // Encode the text into a QR code bitmap
        Bitmap qrBitmap = null;
        try {
            qrBitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 500, 500);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return qrBitmap;
    }
}