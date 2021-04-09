package com.learning.androidlearning.movemarker.kotlin.splash

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Viewutils {

    companion object {
        fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int)
        {
            /* if (isLollipopHigher()) {
                // transition for fragment1
                */
            /*ChangeBounds changeBoundsTransition = new ChangeBounds();
                changeBoundsTransition.setDuration(500);
                fragment.setAllowReturnTransitionOverlap(true);
                fragment.setSharedElementEnterTransition(changeBoundsTransition);*/
            /*
            }*/
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(frameId, fragment)
            transaction.commit()
        }
    }



}