package com.rba.mvpproject.util;

import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.rba.mvpproject.R;

import java.util.regex.Pattern;

/**
 * Created by Ricardo Bravo on 23/07/16.
 */

public class Util {

    public static boolean validEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static void onErrorView(Context context, View view) {
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.anim_shake);
        view.startAnimation(shake);
    }

}
