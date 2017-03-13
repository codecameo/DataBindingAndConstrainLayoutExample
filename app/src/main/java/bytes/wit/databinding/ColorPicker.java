package bytes.wit.databinding;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Md. Sifat-Ul Haque on 3/11/2017.
 */

public class ColorPicker extends View {

    private ArrayList<OnColorChangeListener> mColorChangeListeners = new ArrayList<>();
    private int mColor;

    public ColorPicker(Context context) {
        super(context);
    }

    public ColorPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ColorPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setColor(int color){
        mColor = color;
        setBackgroundColor(mColor);
        if (mColorChangeListeners != null && !mColorChangeListeners.isEmpty()){
            for (OnColorChangeListener onColorChangeListener: mColorChangeListeners) {
                onColorChangeListener.onColorChangeListener(this,mColor);
            }
        }
    }

    public int getColor() {
        return mColor;
    }

    public void removeListener(OnColorChangeListener oldListener) {
        mColorChangeListeners.remove(oldListener);
    }

    public void addListener(OnColorChangeListener newListener) {
        mColorChangeListeners.add(newListener);
    }

    public interface OnColorChangeListener {
        void onColorChangeListener(ColorPicker colorPicker, int newColor);
    }

}
