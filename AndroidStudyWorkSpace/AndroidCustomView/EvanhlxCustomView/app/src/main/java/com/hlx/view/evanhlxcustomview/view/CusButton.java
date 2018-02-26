package com.hlx.view.evanhlxcustomview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hlx.view.evanhlxcustomview.App;

/**
 * Created by Administrator on 2018/2/8/008.
 */

public class CusButton extends android.support.v7.widget.AppCompatButton {
    private Context mContext;

    /**
     * Simple constructor to use when creating a button from code.
     *
     * @param context The Context the Button is running in, through which it can
     *                access the current theme, resources, etc.
     * @see #Button(Context, AttributeSet)
     */
    public CusButton(Context context) {
        super(context, null);
    }

    /**
     * {@link LayoutInflater} calls this constructor when inflating a Button from XML.
     * The attributes defined by the current theme's
     * {@link android.R.attr#buttonStyle android:buttonStyle}
     * override base view attributes.
     * <p>
     * You typically do not call this constructor to create your own button instance in code.
     * However, you must override this constructor when
     * <a href="{@docRoot}training/custom-views/index.html">creating custom views</a>.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML Button tag being used to inflate the view.
     * @see #Button(Context, AttributeSet, int)
     * @see View#View(Context, AttributeSet)
     */
    public CusButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    /**
     * This constructor allows a Button subclass to use its own class-specific base style from a
     * theme attribute when inflating. The attributes defined by the current theme's
     * {@code defStyleAttr} override base view attributes.
     * <p>
     * <p>For Button's base view attributes see
     * {@link android.R.styleable#Button Button Attributes},
     * {@link android.R.styleable#TextView TextView Attributes},
     * {@link android.R.styleable#View View Attributes}.
     *
     * @param context      The Context the Button is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML Button tag that is inflating the view.
     * @param defStyleAttr The resource identifier of an attribute in the current theme
     *                     whose value is the the resource id of a style. The specified style’s
     *                     attribute values serve as default values for the button. Set this parameter
     *                     to 0 to avoid use of default values.
     * @see #Button(Context, AttributeSet, int, int)
     * @see View#View(Context, AttributeSet, int)
     */
    public CusButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Toast.makeText(App.getApp(), "--onTouchEvent--", Toast.LENGTH_LONG).show();
        Log.w("CusButton","--onTouchEvent--");
        return super.onTouchEvent(event);
    }
}
