package daniel2.podice.com.weatherapp;

import android.provider.BaseColumns;
<<<<<<< HEAD

=======
/**
 * Created by mark on 5/7/15.
 */
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
//String id, owner, secret, server, farm, title;
//        Boolean isPublic, isFriend, isFamily;

public class Contract{
    public static final String DATABASE_NAME = "weatherapp.db";
    PhotoEntry pe = new PhotoEntry();

    public static final class PhotoEntry implements BaseColumns{
        public int test = 7;
<<<<<<< HEAD

//        public static final String _ID = "_id";
=======
		
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
		public static final String TABLE_NAME = "weather_entry";
		public static final String CITY = "city";
		public static final String COUNTRY = "country";
		public static final String HUMIDITY = "humidity";
		public static final String DEGREE = "degree";
		public static final String MAIN = "main";
		public static final String DESCRIPTION = "description";
<<<<<<< HEAD
=======
		public static final String _ID = "id";
>>>>>>> c483c87b204f3c326e8098fe11414d1712ff672d
		
		
//        public static final String TABLE_NAME = "photo_entry";
//        public static final String OWNER = "owner";
//        public static final String SECRET = "secret";
//        public static final String SERVER = "server";
//        public static final String FARM = "farm";
//        public static final String TITLE = "title";
//        public static final String PUBLIC = "public";
//        public static final String FRIEND = "friend";
//        public static final String FAMILY = "family";

    }

}
