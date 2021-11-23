package com.example.bibliotheca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent i = new Intent(MainActivity.this,Loginscreen.class);
                startActivity(i);
                finish();
            }
        });

        ViewPager2 yearsViewPager = findViewById(R.id.yearsViewPager);

        List<EngYear> engYears = new ArrayList<>();

        EngYear engYearFirstYear = new EngYear();
        engYearFirstYear.imageUrl = "https://cdn.dribbble.com/users/3979326/screenshots/16113935/media/01dc95d15dd9a1e679f9f13c7b7339a9.jpg";
        engYearFirstYear.title = "First Year";
        engYearFirstYear.year = "First Year";
        engYearFirstYear.textLatest = "Engineering";
        engYears.add(engYearFirstYear);

        EngYear engYearSecondYear = new EngYear();
        engYearSecondYear.imageUrl = "https://cdn.dribbble.com/users/1287291/screenshots/5355515/media/db2193709a7739826095dc94a395952e.png";
        engYearSecondYear.title = "Second Year";
        engYearSecondYear.year = "Second Year";
        engYearSecondYear.textLatest = "Engineering";
        engYears.add(engYearSecondYear);

        EngYear engYearThirdYear = new EngYear();
        engYearThirdYear.imageUrl = "https://cdn.dribbble.com/users/1287291/screenshots/5359892/media/07babaf7549a013dccfe86e8e5b48434.png";
        engYearThirdYear.title = "Third Year";
        engYearThirdYear.year = "Third Year";
        engYearThirdYear.textLatest = "Engineering";
        engYears.add(engYearThirdYear);

        EngYear engYearFourthYear = new EngYear();
        engYearFourthYear.imageUrl = "https://cdn.dribbble.com/users/2092964/screenshots/15599853/media/a7eb7c74ab820c8b5f57da3a66fc86df.png";
        engYearFourthYear.title = "Fourth Year";
        engYearFourthYear.year = "Fourth Year";
        engYearFourthYear.textLatest = "Engineering";
        engYears.add(engYearFourthYear);

        yearsViewPager.setAdapter(new EngYearAdapter(engYears));
        yearsViewPager.setClipToPadding(false);
        yearsViewPager.setClipChildren(false);
        yearsViewPager.setOffscreenPageLimit(3);
        yearsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        yearsViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SubjectActivity.class);
                startActivity(i);
            }
        });

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer( 40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        yearsViewPager.setPageTransformer(compositePageTransformer);

    }

}