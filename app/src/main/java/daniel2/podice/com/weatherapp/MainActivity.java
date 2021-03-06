package daniel2.podice.com.weatherapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ProgressBar progress;
    private double latitude;
    private double longitude;
<<<<<<< HEAD
    private String cityName, countryName;
    private TextView cityView, countryView;
=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
    LocationManager locationManager;
    LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar) findViewById(R.id.progressBar);
<<<<<<< HEAD
        cityView = (TextView)findViewById(R.id.city);
        countryView = (TextView)findViewById(R.id.country);
//        cityView = (TextView)findViewById(R.id.city);
//        countryView = (TextView)findViewById(R.id.country);
=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
        getLocation();
//        refresh = (Button)findViewById(R.id.refresh);
    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    protected void onPause(){
        super.onPause();
        if(locationManager != null && locationListener != null){
            locationManager.removeUpdates(locationListener);
        }
    }

    public void getLocation(){

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
<<<<<<< HEAD
//                Toast.makeText(MainActivity.this, "latitude: " + latitude + "longitude: " + longitude, Toast.LENGTH_LONG).show();
=======
                Toast.makeText(MainActivity.this, "latitude: " + latitude + "longitude: " + longitude, Toast.LENGTH_LONG).show();
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
                startLoadTask(MainActivity.this);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {}

            @Override
            public void onProviderEnabled(String s) {}

            @Override
            public void onProviderDisabled(String s) {}
        };

        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);

    }



    public void startLoadTask(Context c){
        if (isOnline()) {
            LoadContent task = new LoadContent();
            task.execute();
        } else {
            Toast.makeText(c, "Not online", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }


    public void showList() {
<<<<<<< HEAD
        cityView.setText("City: " + cityName);
        countryView.setText("Country: " + countryName);
=======
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new WeatherFragment());
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class LoadContent extends AsyncTask<String, Long, Long> {
        HttpURLConnection connection = null;
        ArrayList<WeatherInfo> photos;

        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Long doInBackground(String... strings) {
<<<<<<< HEAD

            String dataString = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+ latitude + "&lon=" + longitude + "&cnt=10&mode=json";


=======
//            String dataString = "https://api.flickr.com/services/rest/" +
//                    "?method=flickr.photos.search&api_key="+Constants.API_KEY+"&min_upload_date=04%2F25%2F2015&lat="+latitude+"&lon=" +
//                    longitude+"&radius="+Constants.RADIUS+"&radius_units=km&format=json&nojsoncallback=1

            String dataString = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+ latitude + "&lon=" + longitude + "&cnt=10&mode=json";

//            String dataString = "https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api+key=" +
//                   Constants.API_KEY + "&per_page=" + Constants.NUM_PHOTOS + "&format=json&nojsoncallback=1";

//"api.openweathermap.org/data/2.5/forecast/daily?lat="+ longitude +
//				"&lon=" + latitude + "&cnt=10&mode=json";
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
            Log.i(Constants.TAG, dataString);
            try {
                URL dataUrl = new URL(dataString);
                connection = (HttpURLConnection) dataUrl.openConnection();
                connection.connect();
                int status = connection.getResponseCode();
                Log.d("TAG", "status " + status);
                //if it is successful
                if (status == 200) {
                    InputStream is = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String responseString;
                    StringBuilder sb = new StringBuilder();

                    while ((responseString = reader.readLine()) != null) {
                        sb = sb.append(responseString);
                    }
                    String weatherData = sb.toString();

                    photos = WeatherInfo.makeWeatherList(weatherData);
<<<<<<< HEAD


                    cityName = photos.get(0).getCityName();
                    countryName = photos.get(0).getCountryName();
//


//                    Log.d(Constants.TAG, weatherData);
=======
                    Log.d(Constants.TAG, weatherData);
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d

                    return 0l;
                } else {
                    return 1l;
                }
            } catch (MalformedURLException e) {
                Log.i(Constants.TAG, "Malformed Url");
                e.printStackTrace();
                return 1l;
            } catch (IOException e) {
                e.printStackTrace();
                return 1l;
            } catch (JSONException e) {
                e.printStackTrace();
                return 1l;
            } finally {
                if (connection != null)
                    connection.disconnect();
            }

        }


        @Override
        protected void onPostExecute(Long result) {
            if (result != 1l) {
                DataBaseHelper dbHelper = new DataBaseHelper(getApplicationContext());
                dbHelper.clearTable();
                dbHelper.addRows(photos);
                dbHelper.close();
                if(locationManager != null && locationListener != null){
                    locationManager.removeUpdates(locationListener);
                }
                showList();

            } else {
                Toast.makeText(getApplicationContext(), "AsyncTask didn't complete", Toast.LENGTH_LONG).show();
            }
            progress.setVisibility(View.GONE);
        }
    }


}
