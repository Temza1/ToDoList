package com.moinonemoi.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.TreeMap;

public class AddNoteActivity extends AppCompatActivity {

    private EditText inputNameNote;

    private RadioButton lowButton;
    private RadioButton mediumButton;

    private Button saveNoteButton;

    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_note);
        initViews();
        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
    }

    private void initViews() {
        inputNameNote = findViewById(R.id.inputNameNote);

        lowButton = findViewById(R.id.radioButtonLow);
        mediumButton = findViewById(R.id.radioButtonMedium);

        saveNoteButton = findViewById(R.id.saveNoteButton);

        mainViewModel = new MainViewModel(getApplication());
    }
    private void saveNote() {
        String text = inputNameNote.getText().toString().trim();
        int priority = getPriority();
        Note note = new Note(0,text,priority);
        mainViewModel.add(note);

    }

    private int getPriority() {
        int priority;
        if(lowButton.isChecked()) {
            priority = 0;
        } else if(mediumButton.isChecked()) {
            priority = 1;
        } else {
            priority = 2;
        }
        return priority;
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,AddNoteActivity.class);
        return intent;
    }
}