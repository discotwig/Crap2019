package com.example.crap_v2;
        import android.content.Intent;
        import android.content.res.Configuration;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    EditText buy;
    TextView warning;
    int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }

    public void MainStartClick(View v) {

        buy = (EditText) findViewById(R.id.Enteramount);
        warning = (TextView) findViewById(R.id.warning);

        switch (v.getId()) {
            case R.id.btnStartGame:

                String input = buy.getText().toString();
                amount = Integer.parseInt(input);

                // if buy-in is not divisible by 5
                if (amount % 5 != 0) {
                    warning.setText(getString(R.string.warning));
                    break;
                }
                else {
                    Intent start = new Intent(Start.this, Game.class);
                    start.putExtra("buyin", amount);
                    startActivity(start);
                    break;
                }
            case R.id.btnInstruct:
                Intent instruct = new Intent(Start.this, Instruct.class);
                startActivity(instruct);
                break;
        }
    }
}