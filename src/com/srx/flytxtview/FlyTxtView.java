package com.srx.flytxtview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class FlyTxtView extends ViewGroup {

	private static final String TAG = "FlyTxtView";
	private final static int VIEW_MARGIN = 2;

	public FlyTxtView(Context context) {
		super(context);

	}

	public FlyTxtView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public FlyTxtView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.d(TAG, "widthMeasureSpec = " + widthMeasureSpec
				+ " heightMeasureSpec" + heightMeasureSpec);

		for (int index = 0; index < getChildCount(); index++) {
			final View child = getChildAt(index);
			// measure
			child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		}

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {

		Log.d(TAG, "changed = " + changed + " left = " + left + " top = " + top
				+ " right = " + right + " botom = " + bottom);
		final int count = getChildCount();
		int row = 0;// which row lay you view relative to parent
		int lengthX = left; // right position of child relative to parent
		int lengthY = top; // bottom position of child relative to parent
		for (int i = 0; i < count; i++) {

			final View child = this.getChildAt(i);
			int width = child.getMeasuredWidth();
			int height = child.getMeasuredHeight();
			lengthX += width + VIEW_MARGIN;
			lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height + top;
			// if it can't drawing on a same line , skip to next line
			if (lengthX > right) {
				lengthX = width + VIEW_MARGIN + left;
				row++;
				lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height
						+ top;
			}

			child.layout(lengthX - width, lengthY - height, lengthX, lengthY);
		}

	}

	// set text
	public void setTexts(String text) {
		Log.v(TAG, text + "");
		removeAllViews();
		char[] chars = text.toCharArray();
		int count = chars.length;
		for (int i = 0; i < count; i++) {
			Log.v(TAG, chars[i] + "");
			TextView tv = new TextView(getContext());
			tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			tv.setText(chars[i] + "");
			tv.setTextSize(18);
			addView(tv);
		}
	}

	public void startAnimation() {
		AnimationSet set = new AnimationSet(true);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(300);
		set.addAnimation(animation);

		animation = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT,1,
				Animation.RELATIVE_TO_SELF,0,
				Animation.RELATIVE_TO_SELF,0,
				Animation.RELATIVE_TO_SELF,0);
		animation.setDuration(500);
		set.addAnimation(animation);
		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		//controller.setDelay(1);
		setLayoutAnimation(controller);
	}

}
