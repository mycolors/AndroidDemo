package xyz.pozhu.demo.singleclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jakewharton.rxbinding3.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import xyz.pozhu.demo.R;

/**
 * 避免重复点击
 */
public class SingleClickActivity extends AppCompatActivity {

    public static final long TIME_INTERVAL = 1000L;

    private Button btnClick1;
    private Button btnClick2;
    private Button btnClick3;
    private Button btnClick4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_click);
        initView();
        singleClick1();
        singleClick2();
        singleClick3();
        singleClick4();
    }


    private void initView() {
        btnClick1 = findViewById(R.id.btn_click1);
        btnClick2 = findViewById(R.id.btn_click2);
        btnClick3 = findViewById(R.id.btn_click3);
        btnClick4 = findViewById(R.id.btn_click4);
    }

    private void singleClick1() {
        btnClick1.setOnClickListener(new View.OnClickListener() {
            private int time = 0;
            private long mLastClickTime = 0;

            @Override
            public void onClick(View v) {
                long nowTime = System.currentTimeMillis();
                if (nowTime - mLastClickTime > TIME_INTERVAL) {
                    btnClick1.setText("第" + ++time + "次点击");
                    mLastClickTime = nowTime;
                } else {
                    btnClick1.setText("不要重复点击");
                }
            }
        });
    }

    private void singleClick2() {
        btnClick2.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                btnClick2.setText("点击成功");
            }

            @Override
            protected void onFastClick() {
                btnClick2.setText("不要重复点击");
            }
        });
    }


    private void singleClick3() {
        RxView.clicks(btnClick3)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Unit>() {
                    @Override
                    public void accept(Unit unit) throws Exception {
                        btnClick3.setText(unit.toString());
                    }
                });
    }

    private void singleClick4() {
        btnClick4.setOnClickListener(new View.OnClickListener() {

            // 如果需要自定义点击时间间隔，自行传入毫秒值即可
            // @SingleClick(2000)
            @SingleClick
            @Override
            public void onClick(View v) {
                btnClick4.setText("点击时间：    " + System.currentTimeMillis());

            }
        });

    }

}
