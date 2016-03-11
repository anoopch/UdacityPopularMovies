

package ch.anoop.udacity.popularmovies.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import ch.anoop.udacity.popularmovies.PopularMoviesApplication;
import dagger.ObjectGraph;

public abstract class BaseFragment extends Fragment {

    private ObjectGraph mObjectGraph;
    private Toast mToast;

    @CallSuper
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        buildObjectGraph(activity);
    }

    @CallSuper
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        mObjectGraph = null;
        super.onDestroy();
        PopularMoviesApplication.get(getActivity()).getRefWatcher().watch(this);
    }

    private void buildObjectGraph(Activity activity) {
        Object[] modules = getModules().toArray();
        if (modules.length > 0) {
            mObjectGraph = PopularMoviesApplication.get(activity).buildScopedObjectGraph(modules);
            mObjectGraph.inject(this);
        }
    }

    protected List<Object> getModules() {
        return Collections.emptyList();
    }

    protected void showToast(String message) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected void showToast(@StringRes int resId) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT);
        mToast.show();
    }
}