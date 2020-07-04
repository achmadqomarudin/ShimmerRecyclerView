package com.achmadqomarudin.shimmerrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.achmadqomarudin.shimmerrecyclerview.adapters.CardAdapter;
import com.achmadqomarudin.shimmerrecyclerview.utils.BaseUtils;
import com.achmadqomarudin.shimmerrecyclerview.utils.DemoConfiguration;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

public class DemoActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE = "type";
    private ShimmerRecyclerView shimmerRecycler;
    private CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int type = getType();

        RecyclerView.LayoutManager layoutManager;

        final DemoConfiguration demoConfiguration = BaseUtils.getDemoConfiguration(type, this);
        setTheme(demoConfiguration.getStyleResource());
        setContentView(demoConfiguration.getLayoutResource());
        layoutManager = demoConfiguration.getLayoutManager();
        setTitle(demoConfiguration.getTitleResource());

        shimmerRecycler = findViewById(R.id.shimmer_recycler_view);

        if (demoConfiguration.getItemDecoration() != null) {
            shimmerRecycler.addItemDecoration(demoConfiguration.getItemDecoration());
        }

        mAdapter = new CardAdapter();
        mAdapter.setType(type);

        shimmerRecycler.setLayoutManager(layoutManager);
        shimmerRecycler.setAdapter(mAdapter);
        shimmerRecycler.showShimmerAdapter();

        shimmerRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCards();
            }
        }, 3000);
    }

    private void loadCards() {
        int type = getType();

        mAdapter.setCards(BaseUtils.getCards(getResources(), type));
        shimmerRecycler.hideShimmerAdapter();
    }

    private int getType() {
        return getIntent().getIntExtra(EXTRA_TYPE, BaseUtils.TYPE_LIST);
    }
}
