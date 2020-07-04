package com.achmadqomarudin.shimmerrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.achmadqomarudin.shimmerrecyclerview.utils.BaseUtils;

public class MainActivity extends AppCompatActivity {
    private Button btn_example1, btn_example2, btn_example3, btn_example4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_example1 = findViewById(R.id.btn_example1);
        btn_example2 = findViewById(R.id.btn_example2);

        createClickListener(btn_example1, BaseUtils.TYPE_LIST);
        createClickListener(btn_example2, BaseUtils.TYPE_GRID);

        btn_example3 = findViewById(R.id.btn_example3);
        btn_example4 = findViewById(R.id.btn_example4);

        createClickListener(btn_example3, BaseUtils.TYPE_SECOND_LIST);
        createClickListener(btn_example4, BaseUtils.TYPE_SECOND_GRID);
    }

    private void createClickListener(Button button, final int demoType) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDemo(demoType);
            }
        });
    }

    private void startDemo(int demoType) {
        Intent intent = new Intent(this, DemoActivity.class);
        intent.putExtra(DemoActivity.EXTRA_TYPE, demoType);
        startActivity(intent);
    }
}