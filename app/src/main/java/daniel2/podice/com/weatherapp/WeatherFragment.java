package daniel2.podice.com.weatherapp;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;

<<<<<<< HEAD

=======
/**
 * Created by mark on 4/29/15.
 FlickerFragment
 */
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
public class WeatherFragment extends Fragment implements AdapterView.OnItemClickListener{
    Cursor cursor;
    ListView lv;
    WeatherInfoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        MainActivity activity = (MainActivity)this.getActivity();

        DataBaseHelper dbHelper = new DataBaseHelper(getActivity());
        cursor = dbHelper.getAllRows();
<<<<<<< HEAD
        Log.i(Constants.TAG, "Cursor transaction complete");
=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d

        //will change this later when we use a CursorLoader
        getActivity().startManagingCursor(cursor);

        adapter = new WeatherInfoAdapter(getActivity(), cursor);

        lv =(ListView)view.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        return view;
    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), mTitles[i], Toast.LENGTH_LONG).show();
        cursor.moveToFirst();
        cursor.move(i);
		

		/*
        String id = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry._ID));
        String farm = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.FARM));
        String server = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.SERVER));
        String secret = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.SECRET));


        // public static String getURL(String farm, String server, String id, String secret, boolean big)
        String url = FlickrPhoto.getURL(farm, server, id, secret, true);
        PhotoFragment pf = new PhotoFragment();
        Bundle args = new Bundle();
        args.putString("URL", url);
        pf.setArguments(args);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, pf);
        ft.addToBackStack("Image");
        ft.commit();
		*/
    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to {@link Activity#onStop() Activity.onStop} of the containing
     * Activity's lifecycle.
     */

}
