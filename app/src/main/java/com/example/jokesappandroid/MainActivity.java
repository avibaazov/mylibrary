package com.example.jokesappandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.mylibrary.MyJokes;

public class MainActivity extends AppCompatActivity {

    private TextView jokeTextView;
    private MyJokes myJokes;
    private AppCompatButton button;;
    private Spinner spinner;
//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.myButton);
        jokeTextView = findViewById(R.id.myText);
        spinner = findViewById(R.id.spinner1);
        //populate spinner with categories:food, programming , chicken
        //when i select a category from spinner i want to get a joke from that category
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_options, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        myJokes = new MyJokes();
//when i press button i want to get a new joke from mylibrary and set it in the textview
       button.setOnClickListener(v -> getJoke());

//        myJokes.getRandomJoke(new MyJokes.JokeCallback() {
//            @Override
//            public void onSuccess(final String jokeJson) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        jokeTextView.setText(jokeJson);
//                    }
//                });
//            }
//
//            @Override
//            public void onError(final String errorMessage) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        jokeTextView.setText(errorMessage);
//                    }
//                });
//            }
//        });
    }
    private void getJoke(){
        String category = spinner.getSelectedItem().toString();
    //make switch case by category
        switch (category){
            case "food":
                myJokes.getRandomFoodJoke(new MyJokes.JokeCallback() {
                    @Override
                    public void onSuccess(final String jokeJson) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(jokeJson);
                            }
                        });
                    }

                    @Override
                    public void onError(final String errorMessage) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(errorMessage);
                            }
                        });
                    }
                });
                break;
            case "programming":
                myJokes.getRandomProgrammingJoke(new MyJokes.JokeCallback() {
                    @Override
                    public void onSuccess(final String jokeJson) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(jokeJson);
                            }
                        });
                    }

                    @Override
                    public void onError(final String errorMessage) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(errorMessage);
                            }
                        });
                    }
                });
                break;
            case "chicken":
                myJokes.getRandomChickenJoke(new MyJokes.JokeCallback() {
                    @Override
                    public void onSuccess(final String jokeJson) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(jokeJson);
                            }
                        });
                    }

                    @Override
                    public void onError(final String errorMessage) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(errorMessage);
                            }
                        });
                    }
                });
                break;
            case "random":
                myJokes.getRandomJoke(new MyJokes.JokeCallback() {
                    @Override
                    public void onSuccess(final String jokeJson) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(jokeJson);
                            }
                        });
                    }

                    @Override
                    public void onError(final String errorMessage) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jokeTextView.setText(errorMessage);
                            }
                        });
                    }
                });
                break;
        }


    }
//    private void getRandomJoke() {
//        myJokes.getRandomJoke(new MyJokes.JokeCallback() {
//            @Override
//            public void onSuccess(final String jokeJson) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        jokeTextView.setText(jokeJson);
//                    }
//                });
//            }
//
//            @Override
//            public void onError(final String errorMessage) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        jokeTextView.setText(errorMessage);
//                    }
//                });
//            }
//        });
//    }
}
