package com.example.crap_v2;
        import android.content.Intent;
        import android.content.res.Configuration;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }

    public void MainStartClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartGame:
                Intent start = new Intent(Start.this, Game.class);
                startActivity(start);
                break;

            case R.id.btnInstruct:
                Intent instruct = new Intent(Start.this, Instruct.class);
                startActivity(instruct);
                break;
        }
    }
}