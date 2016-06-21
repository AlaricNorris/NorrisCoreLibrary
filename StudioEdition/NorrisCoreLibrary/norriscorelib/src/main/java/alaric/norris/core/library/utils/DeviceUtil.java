/**
 *  DeviceUtil
 *  alaric.norris.core.library.utils
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2015/12/30         AlaricNorris
 *  Copyright (c) 2015, TNT All Rights Reserved.
 */
package alaric.norris.core.library.utils;

import android.os.Build;

import java.util.UUID;
/**
 ClassName:      DeviceUtil
 Function:       ${TODO}  ADD FUNCTION
 Contact:        Norris.sly@gmail.com
 @author AlaricNorris
 @version Ver 1.0
 @since I used to be a programmer like you, then I took an arrow in the knee
  ***************************************************************************************************
 Modified By     AlaricNorris     2015/12/30    10:45
 Modifications:  ${TODO}
 ***************************************************************************************************
 */
public class DeviceUtil {

    //获得独一无二的Psuedo ID
    public static String getUniquePsuedoID () {
        String serial = null;

        String m_szDevIDShort = "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
                Build.USER.length() % 10; //13 位
        try {
            serial = android.os.Build.class.getField( "SERIAL" ).get( null ).toString();
            //API>=9 使用serial号
            return new UUID( m_szDevIDShort.hashCode(), serial.hashCode() ).toString();
        }
        catch ( Exception exception ) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID( m_szDevIDShort.hashCode(), serial.hashCode() ).toString();
    }
}
