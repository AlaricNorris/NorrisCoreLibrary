package alaric.norris.core.library.utils;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Util to format File Size
 */
public class FileSizeUtil {
    // byte
    public static final long SIZE_BT = 1L;
    // KB
    public static final long SIZE_KB = SIZE_BT * 1024L;
    // MB
    public static final long SIZE_MB = SIZE_KB * 1024L;
    // GB
    public static final long SIZE_GB = SIZE_MB * 1024L;
    // TB
    public static final long SIZE_TB = SIZE_GB * 1024L;
    public static final int SACLE = 2;
    private static final boolean DEBUG = false;
    private static final String TAG = "FileSize";
    private static final DecimalFormat decimalFormat = new DecimalFormat( "#0.00" );
    private double mSize;

    private FileSizeUtil () {
        /* cannot be instantiated */
        throw new UnsupportedOperationException( "Util class cannot be instantiated" );
    }

    /**
     * 添加要计算的文件或者目录
     *
     * @param file 要计算的文件或者目录
     * @return
     * @throws FileNotFoundException
     */
    public static FileSizeUtil setFile ( File file ) throws FileNotFoundException {
        if ( DEBUG )
            Log.v( TAG, "setFile" );
        if ( file != null && file.exists() ) {
            FileSizeUtil fileSize = new FileSizeUtil();
            if ( file.isFile() ) {
                fileSize.mSize = file.length();
            }
            else {
                fileSize.mSize = getDirSize( file );
            }
            return fileSize;
        }
        else {
            throw new FileNotFoundException(
                    "File:" + ( file != null ? file.getPath() : "null" ) + "  Not Found"
            );
        }
    }
    /**
     * 返回由此抽象路径名表示的目录的大小。
     *
     * @param dir 必须是一个有效的存在的目录.
     * @return 此抽象路径名表示的文件的长度，以字节为单位.
     */
    private static long getDirSize ( File dir ) {
        if ( DEBUG )
            Log.v( TAG, "getDirSize()" );
        long dirSize = 0;
        File[] files = dir.listFiles();
        for ( File file : files ) {
            if ( file.isFile() ) {
                dirSize += file.length();
            }
            else if ( file.isDirectory() ) {
                dirSize += file.length();
                dirSize += getDirSize( file );
            }
        }
        return dirSize;
    }
    public static FileSizeUtil setFile ( String filePath ) throws FileNotFoundException {
        return setFile( new File( filePath ) );
    }
    public double getSizeB () {
        if ( DEBUG )
            Log.v( TAG, "getSizeB()" );
        return mSize;
    }

    public double getSizeKB () {
        if ( DEBUG )
            Log.v( TAG, "getSizeKB()" );
        double size = mSize / SIZE_KB;
        BigDecimal sizeDecimal = new BigDecimal( size );
        size = sizeDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP ).doubleValue();
        return size;
    }

    public double getSizeMB () {
        if ( DEBUG )
            Log.v( TAG, "getSizeMB()" );
        double size = mSize / SIZE_MB;
        BigDecimal sizeDecimal = new BigDecimal( size );
        size = sizeDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP ).doubleValue();
        return size;
    }

    public double getSizeGB () {
        if ( DEBUG )
            Log.v( TAG, "getSizeGB()" );
        double size = mSize / SIZE_GB;
        BigDecimal sizeDecimal = new BigDecimal( size );
        size = sizeDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP ).doubleValue();
        return size;
    }

    public double getSizeTB () {
        if ( DEBUG )
            Log.v( TAG, "getSizeTB()" );
        double size = mSize / SIZE_TB;
        BigDecimal sizeDecimal = new BigDecimal( size );
        size = sizeDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP ).doubleValue();
        return size;
    }

    public String getSize () {
        if ( DEBUG )
            Log.v( TAG, "getSize()" );
        double size = getSizeB();
        if ( size > 1000 ) {
            return getSizeKBString();
        }
        return decimalFormat.format( size ) + "B";
    }
    /**
     * 设置要计算的文件或者目录大小
     *
     * @param file 要计算的文件或者目录
     * @return
     * @throws FileNotFoundException
     */
    public static FileSizeUtil setSize ( double size ) {
        if ( DEBUG )
            Log.v( TAG, "setFile" );
        FileSizeUtil fileSize = new FileSizeUtil();
        fileSize.mSize = size;
        return fileSize;
    }
    private String getSizeKBString () {
        if ( DEBUG )
            Log.v( TAG, "getSizeKBString()" );
        double size = getSizeKB();
        if ( size > 1000 ) {
            return getSizeMBString();
        }
        return decimalFormat.format( size ) + "KB";
    }
    private String getSizeMBString () {
        if ( DEBUG )
            Log.v( TAG, "getSizeMBString()" );
        double size = getSizeMB();
        if ( size > 1000 ) {
            return getSizeGBString();
        }
        return decimalFormat.format( size ) + "MB";
    }
    private String getSizeGBString () {
        if ( DEBUG )
            Log.v( TAG, "getSizeGBString()" );
        double size = getSizeGB();
        if ( size > 1000 ) {
            return getSizeTBString();
        }
        return decimalFormat.format( size ) + "GB";
    }
    private String getSizeTBString () {
        if ( DEBUG )
            Log.v( TAG, "getSizeTBString()" );
        double size = getSizeTB();
        return decimalFormat.format( size ) + "TB";
    }

}
