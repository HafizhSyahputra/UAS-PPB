package com.example.uas_ppb;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;

public class belitiket extends AppCompatActivity {

    Spinner jenispesawatSpinner;
    private Calendar calendar;
    private int year, month, day;
    TextView tanggalTextView;
    TextView hargaTextView;
    Button bayar;
    EditText seatEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belitiket);

        tanggalTextView = findViewById(R.id.tanggal);
        hargaTextView = findViewById(R.id.harga);
        bayar = findViewById(R.id.pesan);
        jenispesawatSpinner = findViewById(R.id.jenispesawatSpinner);
        seatEditText = findViewById(R.id.seat);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jenis_pesawat_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenispesawatSpinner.setAdapter(adapter);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        seatEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                hitungHargaOtomatis();
            }
        });

        jenispesawatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hitungHargaOtomatis();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Tambahkan onClickListener untuk tombol Bayar
        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilkanInvoice();
            }
        });
    }

    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        tanggalTextView.setText(selectedDate);

                    }
                },
                year, month, day);

        datePickerDialog.show();
    }

    private void hitungHargaOtomatis() {
        String jumlahPenumpang = seatEditText.getText().toString();
        int hargaPerPenumpang = 0;
        String selectedPesawat = jenispesawatSpinner.getSelectedItem().toString();
        switch (selectedPesawat) {
            case "AB002":
                hargaPerPenumpang = 1000000;
                break;
            case "GC003":
                hargaPerPenumpang = 1500000;
                break;
            case "IC409":
                hargaPerPenumpang = 3000000;
                break;
            case "NB230":
                hargaPerPenumpang = 2000000;
                break;
            default:
                break;
        }

        if (!jumlahPenumpang.isEmpty()) {
            int totalHarga = Integer.parseInt(jumlahPenumpang) * hargaPerPenumpang;
            hargaTextView.setText(String.valueOf(totalHarga));
        }
    }

    private void tampilkanInvoice() {
        String tanggal = tanggalTextView.getText().toString();
        String jumlahPenumpang = seatEditText.getText().toString();
        String selectedPesawat = jenispesawatSpinner.getSelectedItem().toString();
        String harga = hargaTextView.getText().toString();

        String invoice = "Tanggal: " + tanggal + "\n"
                + "Jumlah Penumpang: " + jumlahPenumpang + "\n"
                + "Jenis Pesawat: " + selectedPesawat + "\n"
                + "Total Harga: " + harga;

        View customLayout = getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);

        TextView titleTextView = customLayout.findViewById(R.id.alertTitle);
        TextView messageTextView = customLayout.findViewById(R.id.alertMessage);

        titleTextView.setText("Invoice");
        messageTextView.setText(invoice);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }

}
