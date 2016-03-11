package ch.anoop.udacity.popularmovies.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import ch.anoop.udacity.popularmovies.PopularMoviesApplication;
import ch.anoop.udacity.popularmovies.R;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @CallSuper
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setupToolbar();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        PopularMoviesApplication.get(this).getRefWatcher().watch(this);
    }

    private void setupToolbar() {
        if (mToolbar == null) {
            Timber.w("Didn't find a toolbar");
            return;
        }

        ViewCompat.setElevation(mToolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }

    @Nullable
    public final Toolbar getToolbar() {
        return mToolbar;
    }
}