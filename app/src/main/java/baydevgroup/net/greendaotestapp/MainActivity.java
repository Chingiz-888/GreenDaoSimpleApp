package baydevgroup.net.greendaotestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;

import model.DaoMaster;
import model.DaoSession;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: надо это переместить в Application класс
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "test-db");
        Database db = helper.getReadableDb();
        DaoSession sDaoSession = new DaoMaster(db).newSession();

        // Для отладки через Chrome DevTools
        Stetho.initializeWithDefaults(this);
    }
}
