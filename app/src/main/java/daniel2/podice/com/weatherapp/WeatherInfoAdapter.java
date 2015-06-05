package daniel2.podice.com.weatherapp;

import android.content.Context;
import android.database.Cursor;
<<<<<<< HEAD
import android.graphics.drawable.Drawable;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

=======
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mark on 5/7/15.
 FlickerPhotoAdapter
 */
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
public class WeatherInfoAdapter extends CursorAdapter {

    public WeatherInfoAdapter(Context c, Cursor cursor){
        super(c, cursor, 0);
<<<<<<< HEAD
        Log.i(Constants.TAG, "Needs super constructor complete");
=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView title = (TextView) view.findViewById(R.id.title_text);
<<<<<<< HEAD
        TextView titleDegreeField = (TextView) view.findViewById(R.id.title_degree);
        FrameLayout image = (FrameLayout) view.findViewById(R.id.title_image);

        Drawable pic = null;
//        ViewHolder holder = (ViewHolder)view.getTag();

        String titleMain = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.MAIN));
//        String titleDeg = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.DEGREE));

        Log.i(Constants.TAG, "Main Desc*************************: " + titleMain);

        if(titleMain.toLowerCase().contains("rain")){
            pic = context.getResources().getDrawable(R.drawable.rain);
            image.setBackground(pic);
        }
        else if(titleMain.toLowerCase().contains("clear")){
            pic = context.getResources().getDrawable(R.drawable.sunny);
            image.setBackground(pic);
        }
        else if(titleMain.toLowerCase().contains("cloud")){
            pic = context.getResources().getDrawable(R.drawable.cloudy);
            image.setBackground(pic);
        }
        else if(titleMain.toLowerCase().contains("snow")){
            pic = context.getResources().getDrawable(R.drawable.snowy);
            image.setBackground(pic);
        }

        String titleDegree = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.DEGREE));
        titleDegreeField.setText(titleDegree + " ");
        Log.i(Constants.TAG, "Main Degree*************************: " + titleDegree);

=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
        String titleText = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PhotoEntry.DESCRIPTION));
        title.setText(titleText);
    }
}
