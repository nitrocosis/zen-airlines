package com.srgiovine.zenairlines;

import android.app.Application;

import com.srgiovine.zenairlines.data.ZenDB;
import com.srgiovine.zenairlines.data.ZenSQL;

/**
 * The application instance. Provides access to {@link ZenSQL}.
 */
public class ZenAirlinesApplication extends Application {

    private ZenDB zenDB;

    @Override
    public void onCreate() {
        super.onCreate();
        zenDB = new ZenSQL(this);
    }

    public ZenDB getZenDB() {
        return zenDB;
    }
}
