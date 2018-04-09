package altong.mon.amtalk.viewmodel;


import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchViewModel implements ViewModel {

    private Activity activity;
    private EditText editText;
    private TextView textView;

    public SearchViewModel(Activity activity, EditText editText, TextView textView) {
        this.activity = activity;
        this.editText = editText;
        this.textView = textView;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    public void searchListener(View view) {
        switch (view.getId()) {

        }
    }
}
