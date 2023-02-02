package com.improve10x.uicomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MultipleActivity extends AppCompatActivity {
    Button seekBtn;
    Button submitBtn;
    TextView resultTxt;
    SeekBar seekSb;
    RatingBar ratingBr;
    Button ratingBtn;
    Button dateBtn;
    DatePicker dateDp;
    Button timeBtn;
    TimePicker timeTp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipul);
        unitViews();
        hideAllComponents();
        handleSeekbarBtn();
        handleSubmitBtn();
        handleRatingBarBtn();
        handleDatePickerBtn();
        handleTimePickerBtn();
    }

    private void hideAllComponents() {
        timeTp.setVisibility(View.GONE);
        dateDp.setVisibility(View.GONE);
        ratingBr.setVisibility(View.GONE);
        seekSb.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);
        resultTxt.setVisibility(View.GONE);
    }

    public void unitViews() {
        seekSb = findViewById(R.id.seek_sb);
        resultTxt = findViewById(R.id.result_txt);
        seekBtn = findViewById(R.id.seek_btn);
        submitBtn = findViewById(R.id.submit_btn);
        ratingBtn = findViewById(R.id.rating_btn);
        ratingBr = findViewById(R.id.rating_rb);
        dateBtn = findViewById(R.id.date_btn);
        dateDp = findViewById(R.id.date_dp);
        timeTp = findViewById(R.id.time_tp);
        timeBtn = findViewById(R.id.time_btn);

    }

    public void handleSeekbarBtn() {
        seekBtn.setOnClickListener(v -> {
            seekSb.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);
            resultTxt.setVisibility(View.VISIBLE);
            ratingBr.setVisibility(View.GONE);
            dateDp.setVisibility(View.GONE);
            timeTp.setVisibility(View.GONE);
        });
    }

    public void handleSubmitBtn() {
        submitBtn.setOnClickListener(v -> {
            if (seekSb.getVisibility() == View.VISIBLE) {
                int progress = seekSb.getProgress();
                resultTxt.setText(progress + " ");
            }
            if (ratingBr.getVisibility() == View.VISIBLE) {
                String rating = String.valueOf(ratingBr.getRating());
                resultTxt.setText(rating);
            }
            if (dateDp.isShown() == true) {
                String date = String.valueOf(dateDp.getDayOfMonth());
                String month = String.valueOf(dateDp.getMonth());
                String year = String.valueOf(dateDp.getYear());
                resultTxt.setText(date + " / " + month + " / " + year);
            }
            if (timeTp.isShown() == true) {
                timeTp.setIs24HourView(true);
                String hour = String.valueOf(timeTp.getCurrentHour());
                String minutes = String.valueOf(timeTp.getCurrentMinute());
                resultTxt.setText(hour + " : " + minutes);
            }

        });

    }

    public void handleRatingBarBtn() {
        ratingBtn.setOnClickListener(view -> {
            ratingBr.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);
            resultTxt.setVisibility(View.VISIBLE);
            seekSb.setVisibility(View.GONE);
            dateDp.setVisibility(View.GONE);
            timeTp.setVisibility(View.GONE);
        });

    }

    public void handleDatePickerBtn() {
        dateBtn.setOnClickListener(view -> {
            dateDp.setVisibility(View.VISIBLE);
            resultTxt.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);
            seekSb.setVisibility(View.GONE);
            ratingBr.setVisibility(View.GONE);
            timeTp.setVisibility(View.GONE);
        });

    }

    public void handleTimePickerBtn() {
        timeBtn.setOnClickListener(view -> {
            timeTp.setIs24HourView(true);
            timeTp.setVisibility(View.VISIBLE);
            resultTxt.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);
            seekSb.setVisibility(View.GONE);
            ratingBr.setVisibility(View.GONE);
            dateDp.setVisibility(View.GONE);
        });
    }
}