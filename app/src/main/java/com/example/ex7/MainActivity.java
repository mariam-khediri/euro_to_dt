package com.example.ex7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextAmount;
    private Button convertButton;
    private TextView resultTextView;
    private ListView conversionHistoryListView;

    private List<String> conversionHistory;
    private ArrayAdapter<String> historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);
        conversionHistoryListView = findViewById(R.id.conversionHistoryListView);

        conversionHistory = new ArrayList<>();
        historyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conversionHistory);
        conversionHistoryListView.setAdapter(historyAdapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double euroAmount = Double.parseDouble(editTextAmount.getText().toString());

                // Supposons que le taux de change soit 2 pour cet exemple.
                double dinarAmount = euroAmount * 3.36;

                resultTextView.setText("Résultat en dinars tunisiens : " + dinarAmount);
                resultTextView.setVisibility(View.VISIBLE);

                String historyEntry = euroAmount + " euro = " + dinarAmount + " dinars";
                conversionHistory.add(historyEntry);
                historyAdapter.notifyDataSetChanged();

                conversionHistoryListView.setVisibility(View.VISIBLE);
            }
        });
    }
}
