package com.biel.sampleandroidoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import java8.util.Optional;
import java8.util.function.BinaryOperator;
import java8.util.function.Function;
import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Integer> b = new ArrayList<>();
        b.add(8);
        b.add(9);
        b.add(15);
        Optional<String> result = StreamSupport.stream(b).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 3 * integer;
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "N: " + integer;
            }
        }).reduce(new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + " - " + s2;
            }
        });
        Toast toast = Toast.makeText(getApplicationContext(), result.orElse("No text"), Toast.LENGTH_LONG);
        toast.show();

    }
}
