package altong.mon.amtalk.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;


public class AltongBar extends Toolbar {

    public AltongBar(Context context) {
        super(context);
        setupElevation();
    }

    public AltongBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupElevation();
    }

    public AltongBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupElevation();
    }

    private void setupElevation() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) setElevation(4.0f);
    }
}
