/**
 *  UploadUtil
 *  alaric.norris.core.library.utils
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/11/5         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
/**
 ClassName:      UploadUtil
 Function:       Uplaod tool
 Contact:        Norris.sly@gmail.com
 @author AlaricNorris
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/11/5    16:26
 Modifications:  init
 ***************************************************************************************************
 */
public class UploadUtil {
    /***
     * Upload success
     */
    public static final int UPLOAD_SUCCESS_CODE = 1;
    /**
     * File not exists
     */
    public static final int UPLOAD_FILE_NOT_EXISTS_CODE = 2;
    /**
     * Server error
     */
    public static final int UPLOAD_SERVER_ERROR_CODE = 3;
    protected static final int WHAT_TO_UPLOAD = 1;
    protected static final int WHAT_UPLOAD_DONE = 2;
    // BOUNDARY
    private static final String BOUNDARY = UUID.randomUUID().toString();
    private static final String PREFIX = "--";
    private static final String LINE_END = "\r\n";
    // CONTENT_TYPE
    private static final String CONTENT_TYPE = "multipart/form-data";
    private static final String TAG = "UploadUtil";
    private static final String CHARSET = "utf-8";
    private static UploadUtil uploadUtil;
    private static int requestTime = 0;
    private HttpURLConnection conn;
    private int readTimeOut = 10 * 1000;
    private int connectTimeout = 10 * 1000;
    private OnUploadProcessListener onUploadProcessListener;
    private UploadUtil () {

    }
    public static UploadUtil getInstance () {
        if ( null == uploadUtil ) {
            uploadUtil = new UploadUtil();
        }
        return uploadUtil;
    }
    /**
     * getRequestTime
     * @return
     */
    public static int getRequestTime () {
        return requestTime;
    }
    /**
     * uploadFile
     *
     * @param filePath filePath
     * @param fileKey on web page "input type=file name=xxx" xxx=fileKey
     * @param RequestURL    RequestURL
     */
    public void uploadFile (
            String filePath, String fileKey, String RequestURL, Map< String, String > param
    ) {
        if ( filePath == null ) {
            sendMessage( UPLOAD_FILE_NOT_EXISTS_CODE, "File not exist" );
            return;
        }
        try {
            File file = new File( filePath );
            uploadFile( file, fileKey, RequestURL, param );
        }
        catch ( Exception e ) {
            sendMessage( UPLOAD_FILE_NOT_EXISTS_CODE, "File not exist" );
            e.printStackTrace();
            return;
        }
    }
    /**
     * uploadFile
     *
     * @param file file
     * @param fileKey on web page "input type=file name=xxx" xxx=fileKey
     * @param RequestURL    RequestURL
     */
    public void uploadFile (
            final File file, final String fileKey, final String RequestURL,
            final Map< String, String > param
    ) {
        if ( file == null || ( ! file.exists() ) ) {
            sendMessage( UPLOAD_FILE_NOT_EXISTS_CODE, "File not exist" );
            return;
        }

        Log.i( TAG, "URL=" + RequestURL );
        Log.i( TAG, "fileName=" + file.getName() );
        Log.i( TAG, "fileKey=" + fileKey );
        new Thread(
                new Runnable() {

                    @Override
                    public void run () {
                        toUploadFile( file, fileKey, RequestURL, param );
                    }
                }
        ).start();

    }
    private void toUploadFile (
            File file, String fileKey, String RequestURL, Map< String, String > param
    ) {
        String result = null;
        requestTime = 0;

        long requestTime = System.currentTimeMillis();
        long responseTime = 0;

        try {
            URL url = new URL( RequestURL );
            conn = ( HttpURLConnection ) url.openConnection();
            conn.setReadTimeout( readTimeOut );
            conn.setConnectTimeout( connectTimeout );
            conn.setDoInput( true ); //
            conn.setDoOutput( true ); //
            conn.setUseCaches( false ); //
            conn.setRequestMethod( "POST" ); //
            conn.setRequestProperty( "Charset", CHARSET ); //
            conn.setRequestProperty( "connection", "keep-alive" );
            conn.setRequestProperty(
                    "user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"
            );
            conn.setRequestProperty( "Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY );
            // conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            DataOutputStream dos = new DataOutputStream( conn.getOutputStream() );
            StringBuffer sb = null;
            String params = "";

            /***
             * upload param
             */
            if ( param != null && param.size() > 0 ) {
                Iterator< String > it = param.keySet().iterator();
                while ( it.hasNext() ) {
                    sb = null;
                    sb = new StringBuffer();
                    String key = it.next();
                    String value = param.get( key );
                    sb.append( PREFIX ).append( BOUNDARY ).append( LINE_END );
                    sb.append( "Content-Disposition: form-data; name=\"" )
                      .append( key )
                      .append( "\"" )
                      .append( LINE_END )
                      .append( LINE_END );
                    sb.append( value ).append( LINE_END );
                    params = sb.toString();
                    Log.i( TAG, key + "=" + params + "##" );
                    dos.write( params.getBytes() );
                    // dos.flush();
                }
            }

            sb = null;
            params = null;
            sb = new StringBuffer();
            /**
             * Notice :
             * name = fileKey ; the Key get the file
             * filename is the file's name
             */
            sb.append( PREFIX ).append( BOUNDARY ).append( LINE_END );
            sb.append(
                    "Content-Disposition:form-data; name=\"" + fileKey + "\"; filename=\"" +
                            file.getName() + "\"" + LINE_END
            );
            // important Content-type
            sb.append( "Content-Type:image/pjpeg" + LINE_END );
            // server to tell the file type
            sb.append( LINE_END );
            params = sb.toString();
            sb = null;

            Log.i( TAG, file.getName() + "=" + params + "##" );
            dos.write( params.getBytes() );
            /**upload file*/
            InputStream is = new FileInputStream( file );
            onUploadProcessListener.initUpload( ( int ) file.length() );
            byte[] bytes = new byte[ 1024 ];
            int len = 0;
            int curLen = 0;
            while ( ( len = is.read( bytes ) ) != - 1 ) {
                curLen += len;
                dos.write( bytes, 0, len );
                onUploadProcessListener.onUploadProcess( curLen );
            }
            is.close();

            dos.write( LINE_END.getBytes() );
            byte[] end_data = ( PREFIX + BOUNDARY + PREFIX + LINE_END ).getBytes();
            dos.write( end_data );
            dos.flush();
            //
            // dos.write(tempOutputStream.toByteArray());
            /**
             * 200=success
             */
            int res = conn.getResponseCode();
            responseTime = System.currentTimeMillis();
            this.requestTime = ( int ) ( ( responseTime - requestTime ) / 1000 );
            Log.e( TAG, "response code:" + res );
            if ( res == 200 ) {
                Log.e( TAG, "request success" );
                InputStream input = conn.getInputStream();
                StringBuffer sb1 = new StringBuffer();
                int ss;
                while ( ( ss = input.read() ) != - 1 ) {
                    sb1.append( ( char ) ss );
                }
                result = sb1.toString();
                input.close();
                Log.e( TAG, "result : " + result );
                sendMessage( UPLOAD_SUCCESS_CODE, result );
                return;
            }
            else {
                Log.e( TAG, "request error" );
                sendMessage( UPLOAD_SERVER_ERROR_CODE, "upload fail：code=" + res );
                return;
            }
        }
        catch ( MalformedURLException e ) {
            sendMessage( UPLOAD_SERVER_ERROR_CODE, "upload fail：error=" + e.getMessage() );
            e.printStackTrace();
            return;
        }
        catch ( IOException e ) {
            sendMessage( UPLOAD_SERVER_ERROR_CODE, "upload fail：error=" + e.getMessage() );
            e.printStackTrace();
            return;
        }
        catch ( Exception e ) {
            sendMessage( UPLOAD_SERVER_ERROR_CODE, "upload fail：error=" + e.getMessage() );
            e.printStackTrace();
            return;
        }
        finally {
            conn.disconnect();

        }
    }
    /**
     * send result
     * @param responseCode  responseCode
     * @param responseMessage   responseMessage
     */
    private void sendMessage ( int responseCode, String responseMessage ) {
        onUploadProcessListener.onUploadDone( responseCode, responseMessage );
    }
    public void setOnUploadProcessListener ( OnUploadProcessListener onUploadProcessListener ) {
        this.onUploadProcessListener = onUploadProcessListener;
    }

    public int getReadTimeOut () {
        return readTimeOut;
    }

    public void setReadTimeOut ( int readTimeOut ) {
        this.readTimeOut = readTimeOut;
    }

    public int getConnectTimeout () {
        return connectTimeout;
    }

    public void setConnectTimeout ( int connectTimeout ) {
        this.connectTimeout = connectTimeout;
    }

    public static interface OnUploadProcessListener {
        void onUploadDone ( int responseCode, String message );

        void onUploadProcess ( int uploadSize );

        void initUpload ( int fileSize );
    }

    public static interface uploadProcessListener {

    }

}

