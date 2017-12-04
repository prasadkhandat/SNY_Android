package org.hssus.suryanamaskaryajna;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by prasadkhandat on 10/9/17.
 */

public class SNYApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(2000);
    }
}
