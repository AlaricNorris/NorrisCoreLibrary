package alaric.norris.core.library.utils;

import com.blankj.utilcode.util.Utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author carlos carlosk@163.com
 */

public class AESUtils {
    private AESUtils () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }
    public static final String TAG = "AESUtils";

    public static String encrypt ( String seed, String clearText ) {
        Utils.getApp();

        //        Log.i( TAG, "seed=" + seed + ",:" + clearText );
        byte[] result = null;
        try {
            byte[] rawkey = getRawKey( seed.getBytes() );
            result = encrypt( rawkey, clearText.getBytes() );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        //        Log.i( TAG, ":" + content );
        return toHex( result );

    }

    public static String decrypt ( String seed, String encrypted ) {
        //        Log.i( TAG, "seed=" + seed + ",:" + encrypted );
        byte[] rawKey;
        try {
            rawKey = getRawKey( seed.getBytes() );
            byte[] enc = toByte( encrypted );
            byte[] result = decrypt( rawKey, enc );
            String content = new String( result );
            //            Log.i( TAG, ":" + content );
            return content;
        }
        catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }

    }

    private static byte[] getRawKey ( byte[] seed ) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance( "AES" );
        // SHA1PRNG above 4.2
        SecureRandom sr = null;
        if ( android.os.Build.VERSION.SDK_INT >= 17 ) {
            sr = SecureRandom.getInstance( "SHA1PRNG", "Crypto" );
        }
        else {
            sr = SecureRandom.getInstance( "SHA1PRNG" );
        }
        sr.setSeed( seed );
        kgen.init( 128, sr );
        SecretKey sKey = kgen.generateKey();
        byte[] raw = sKey.getEncoded();

        return raw;
    }

    private static byte[] encrypt ( byte[] raw, byte[] clear ) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec( raw, "AES" );
        //        Cipher cipher = Cipher.getInstance("AES");
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
        cipher.init(
                Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(
                        new byte[ cipher.getBlockSize() ]
                )
        );
        byte[] encrypted = cipher.doFinal( clear );
        return encrypted;
    }

    private static byte[] decrypt ( byte[] raw, byte[] encrypted ) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec( raw, "AES" );
        //        Cipher cipher = Cipher.getInstance("AES");
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
        cipher.init(
                Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(
                        new byte[ cipher.getBlockSize() ]
                )
        );
        byte[] decrypted = cipher.doFinal( encrypted );
        return decrypted;
    }

    public static String toHex ( String txt ) {
        return toHex( txt.getBytes() );
    }

    public static String fromHex ( String hex ) {
        return new String( toByte( hex ) );
    }

    public static byte[] toByte ( String hexString ) {
        int len = hexString.length() / 2;
        byte[] result = new byte[ len ];
        for ( int i = 0 ; i < len ; i++ )
            result[ i ] = Integer.valueOf(
                    hexString.substring( 2 * i, 2 * i + 2 ), 16
            ).byteValue();
        return result;
    }

    public static String toHex ( byte[] buf ) {
        if ( buf == null )
            return "";
        StringBuffer result = new StringBuffer( 2 * buf.length );
        for ( int i = 0 ; i < buf.length ; i++ ) {
            appendHex( result, buf[ i ] );
        }
        return result.toString();
    }

    private static void appendHex ( StringBuffer sb, byte b ) {
        final String HEX = "0123456789ABCDEF";
        sb.append( HEX.charAt( ( b >> 4 ) & 0x0f ) ).append( HEX.charAt( b & 0x0f ) );
    }
}