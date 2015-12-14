package com.srgiovine.zenairlines;

import android.app.Application;

import com.srgiovine.zenairlines.data.ZenSQL;
import com.srgiovine.zenairlines.data.ZenSQLImpl;

/**
 * The application instance. Provides access to {@link ZenSQLImpl}.
 */
public class ZenAirlinesApplication extends Application {

    private ZenSQLImpl zenSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        zenSQL = new ZenSQLImpl(this);
    }

    public ZenSQL getZenSQL() {
        return zenSQL;
    }
}
