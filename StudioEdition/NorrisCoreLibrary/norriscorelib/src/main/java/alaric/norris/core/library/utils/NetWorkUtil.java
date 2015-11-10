/**
 *  NetWorkUtil
 *  alaric.norris.core.library.utils
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/11/5         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IntDef;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 ClassName:      NetWorkUtil
 Function:       ${TODO}  ADD FUNCTION
 Contact:        Norris.sly@gmail.com
 @author AlaricNorris
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/11/5    16:54
 Modifications:  ${TODO}
 ***************************************************************************************************
 */
public class NetWorkUtil {
    /** no network */
    public static final int NETWORKTYPE_INVALID = 0;
    /** wap network */
    public static final int NETWORKTYPE_WAP = 1;
    /** 2G network */
    public static final int NETWORKTYPE_2G = 2;
    /** 3G network */
    public static final int NETWORKTYPE_3G = 3;
    /** wifi network */
    public static final int NETWORKTYPE_WIFI = 4;
    private static final String TAG = "NetWorkUtil";
    /**
     * isConnnected
     * @param context    context
     * @return true:connected; false not
     */
    public static boolean isConnnected ( Context context ) {
        ConnectivityManager connectivityManager =
                ( ConnectivityManager ) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        if ( null != connectivityManager ) {
            NetworkInfo networkInfo[] = connectivityManager.getAllNetworkInfo();

            if ( null != networkInfo ) {
                for ( NetworkInfo info : networkInfo ) {
                    if ( info.getState() == NetworkInfo.State.CONNECTED ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * getNetWorkType
     * @param context context
     * @return int NETWORKTYPE_WAP,NETWORKTYPE_2G,NETWORKTYPE_3G,NETWORKTYPE_WIFI
     */
    @NetWorkType
    public static int getNetWorkType ( Context context ) {
        int mNetWorkType = NETWORKTYPE_INVALID;
        ConnectivityManager manager =
                ( ConnectivityManager ) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if ( networkInfo != null && networkInfo.isConnected() ) {
            String type = networkInfo.getTypeName();
            if ( type.equalsIgnoreCase( "WIFI" ) ) {
                mNetWorkType = NETWORKTYPE_WIFI;
            }
            else if ( type.equalsIgnoreCase( "MOBILE" ) ) {
                String proxyHost = android.net.Proxy.getDefaultHost();
                mNetWorkType = TextUtils.isEmpty( proxyHost ) ?
                        ( isFastMobileNetwork( context ) ? NETWORKTYPE_3G : NETWORKTYPE_2G ) :
                        NETWORKTYPE_WAP;
            }
        }
        return mNetWorkType;
    }
    /**
     * @param mContext mContext
     * @return NetworkTypeString
     */
    public static String getNetworkType ( Context mContext ) {
        NetworkInfo networkInfo = ( ( ConnectivityManager ) mContext.getSystemService(
                Context.CONNECTIVITY_SERVICE
        ) ).getActiveNetworkInfo();
        String type = "Unknown";
        if ( networkInfo != null ) {
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    type = "WiFi";
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    switch (( ( TelephonyManager ) mContext.getSystemService(
                            Context.TELEPHONY_SERVICE
                    ) ).getNetworkType()) {
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                            type = "GPRS";
                            break;
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                            type = "UMTS";
                            break;
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                            type = "EDGE";
                        default:
                            break;
                    }
                    break;
                default:
                    type = "Unknown";
            }
        }
        return type;
    }
    /****
     * getNetworkState
     * @param mContext  mContext
     * @return int   NetworkState
     */
    public static int getNetworkState ( Context mContext ) {
        NetworkInfo networkInfo = ( ( ConnectivityManager ) mContext.getSystemService(
                Context.CONNECTIVITY_SERVICE
        ) ).getActiveNetworkInfo();
        int type = TelephonyManager.NETWORK_TYPE_UNKNOWN;
        if ( networkInfo != null ) {
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    type = - 1;
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    switch (( ( TelephonyManager ) mContext.getSystemService(
                            Context.TELEPHONY_SERVICE
                    ) ).getNetworkType()) {
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                            // GPRS
                            type = - 3;
                            break;
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                            // EDGE
                            type = - 3;
                            break;
                        default:
                            // 3G
                            type = - 2;
                            break;
                    }
                    break;
                default:
                    type = - 2;
            }
        }
        return type;
    }
    private static boolean isFastMobileNetwork ( Context context ) {
        TelephonyManager telephonyManager =
                ( TelephonyManager ) context.getSystemService( Context.TELEPHONY_SERVICE );
        switch (telephonyManager.getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return false; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return false; // ~ 14-64 kbps
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return false; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return true; // ~ 400-1000 kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return true; // ~ 600-1400 kbps
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return false; // ~ 100 kbps
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return true; // ~ 2-14 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return true; // ~ 700-1700 kbps
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return true; // ~ 1-23 Mbps
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return true; // ~ 400-7000 kbps
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return true; // ~ 1-2 Mbps
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return true; // ~ 5 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return true; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return false; // ~25 kbps
            case TelephonyManager.NETWORK_TYPE_LTE:
                return true; // ~ 10+ Mbps
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return false;
            default:
                return false;
        }
    }
    public static boolean checkNetworkConnectionState ( Context context ) {
        boolean flag = false;
        ConnectivityManager connectivityManager =
                ( ConnectivityManager ) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        if ( connectivityManager != null ) {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            connectivityManager = null;
            if ( networkInfo != null ) {
                for ( int i = 0 ; i < networkInfo.length ; i++ ) {
                    if ( networkInfo[ i ].getState() == NetworkInfo.State.CONNECTED ) {
                        return flag = true;
                    }
                }
            }
        }
        return flag;
    }

    @IntDef ( {
                      NETWORKTYPE_INVALID , NETWORKTYPE_WAP , NETWORKTYPE_2G , NETWORKTYPE_3G ,
                      NETWORKTYPE_WIFI
              } )
    public @interface NetWorkType {}
}
