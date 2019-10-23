package com.example.crap_v2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class Game extends AppCompatActivity {

    Boolean first_roll = true;
    ImageView die1_i, die2_i;
    TextView wins_t, losses_t, games_t, roles_t, point_t, news_t, balance;
    Button roll_b;



    int sum; // dice sum in main
    int point;
    int game;
    int wins;
    int losses;
    int die1, die2;
    int d_sum; // dice sum in throwDice()
    int roles;
<<<<<<< Updated upstream
    int bal;
=======
    int bal; //balance from start game
    int bet; //how much to bet per game
>>>>>>> Stashed changes

    String s_won = "Winner Winner!";
    String s_lost = "You Lose! Play Again!";
    String s_point = "The Point has been Made! "
            + "Winner Winner!";
    String s_reroll = "Roll Again!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        //
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                bal= 0;
            } else {
                bal= extras.getInt("buyin");
            }
        } else {
            bal= (int) savedInstanceState.getSerializable("buyin");
        }
//

        die1_i = (ImageView) findViewById(R.id.Dice_1);
        die2_i = (ImageView) findViewById(R.id.Dice_2);

        balance = (TextView) findViewById(R.id.BuyIn_amount);
        wins_t = (TextView) findViewById(R.id.Wins);
        losses_t = (TextView) findViewById(R.id.Losses);
        games_t = (TextView) findViewById(R.id.Craps_game);
        roles_t = (TextView) findViewById(R.id.Rolls);
        point_t = (TextView) findViewById(R.id.Points);

        news_t = (TextView) findViewById(R.id.News);

        roll_b = (Button) findViewById(R.id.Rollbutton);



        sum = 0;
        point = 0;
        point_t.setText(String.valueOf(point));
        game = 1;
        games_t.setText(String.valueOf(game));
        wins = 0;
        wins_t.setText(String.valueOf(wins));
        losses = 0;
        losses_t.setText(String.valueOf(losses));
        roles = 0;
        roles_t.setText(String.valueOf(roles));
        balance.setText(String.valueOf(bal));
    }

    public void onClickBtn(View v)
    {
        newGame();
    }

    public void newGame(){
        if (first_roll){

            roles = 1;
            roles_t.setText(String.valueOf(roles));

            games_t.setText(String.valueOf(game));

            sum = throwDice();
            Toast.makeText(getApplicationContext(), String.valueOf(sum) ,Toast.LENGTH_SHORT).show();

            switch (sum) {

                // WIN
                case 7:
                case 11:
                    //Toast.makeText(getApplicationContext(), s_won ,Toast.LENGTH_SHORT).show();
                    news_t.setText(String.valueOf(s_won));

                    wins = wins + 1;
                    wins_t.setText(String.valueOf(wins));

                    game = game + 1;
                    games_t.setText(String.valueOf(game));
                    first_roll = true;

                    break;

                // LOSE
                case 2:
                case 3:
                case 12:
                    //Toast.makeText(getApplicationContext(), s_lost ,Toast.LENGTH_SHORT).show();
                    news_t.setText(String.valueOf(s_lost));

                    losses = losses + 1;
                    losses_t.setText(String.valueOf(losses));

                    game = game + 1;
                    games_t.setText(String.valueOf(game));
                    first_roll = true;

                    break;

                // ROLL AGAIN
                default:
                    //Toast.makeText(getApplicationContext(), s_reroll ,Toast.LENGTH_SHORT).show();
                    news_t.setText(String.valueOf(s_reroll));

                    point = sum;
                    point_t.setText(String.valueOf(point));
                    first_roll = false;
                    break;
            }
        }

        else {

            roles = roles + 1;
            roles_t.setText(String.valueOf(roles));

            sum = throwDice();
            Toast.makeText(getApplicationContext(), String.valueOf(sum) ,Toast.LENGTH_SHORT).show();

            // WIN
            if (sum == point) {
                //Toast.makeText(getApplicationContext(), s_point ,Toast.LENGTH_SHORT).show();
                news_t.setText(String.valueOf(s_point));

                wins = wins + 1;
                wins_t.setText(String.valueOf(wins));

                game = game + 1;
                //games_t.setText(String.valueOf(game));
                first_roll = true;
            }

            // LOSE
            if (sum == 7) {
                //Toast.makeText(getApplicationContext(), s_lost ,Toast.LENGTH_SHORT).show();
                news_t.setText(String.valueOf(s_lost));

                losses = losses + 1;
                losses_t.setText(String.valueOf(losses));

                game = game + 1;
                //games_t.setText(String.valueOf(game));
                first_roll = true;
            }

            else {
                //Toast.makeText(getApplicationContext(), s_reroll ,Toast.LENGTH_SHORT).show();
                news_t.setText(String.valueOf(s_reroll));
            }
        }
    }

    public int throwDice() {
        die1 = (int)(Math.random()*6 + 1);
        switch (die1) {
            case 1: die1_i.setImageResource(R.mipmap.d1_foreground);
                break;
            case 2: die1_i.setImageResource(R.mipmap.d2_foreground);
                break;
            case 3: die1_i.setImageResource(R.mipmap.d3_foreground);
                break;
            case 4: die1_i.setImageResource(R.mipmap.d4_foreground);
                break;
            case 5: die1_i.setImageResource(R.mipmap.d5_foreground);
                break;
            case 6: die1_i.setImageResource(R.mipmap.d6_foreground);
                break;
        }

        die2 = (int)(Math.random()*6 + 1);
        switch (die2) {
            case 1: die2_i.setImageResource(R.mipmap.d1_foreground);
                break;
            case 2: die2_i.setImageResource(R.mipmap.d2_foreground);
                break;
            case 3: die2_i.setImageResource(R.mipmap.d3_foreground);
                break;
            case 4: die2_i.setImageResource(R.mipmap.d4_foreground);
                break;
            case 5: die2_i.setImageResource(R.mipmap.d5_foreground);
                break;
            case 6: die2_i.setImageResource(R.mipmap.d6_foreground);
                break;
        }

        d_sum = die1 + die2;
        return d_sum;
    }

    public void showHelp(){
        Intent intent = new Intent(Game.this, Instruct.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                newGame();
                return true;
            case R.id.help:
                showHelp();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}