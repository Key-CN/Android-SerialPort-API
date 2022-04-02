package android.serialport;

import androidx.annotation.NonNull;

/**
 * @author Key
 * Time: 2022/04/02 17:30
 * Description:
 */
public class SerialPortUtil {

    /**
     * 是否是常用波特率，因为c代码那边是有控制的，所以虽然波特率可以随意，但是输入不常用的，那边只会返回-1，所以还是提前检测好比较好
     * 从SerialPort.c复制过来的，跟写个List.contains()也没差
     *
     * @param baudRate 波特率
     * @return 是否可用
     */
    public static boolean isValidBaudRete(int baudRate) {
        switch (baudRate) {
            case 0:
            case 50:
            case 75:
            case 110:
            case 134:
            case 150:
            case 200:
            case 300:
            case 600:
            case 1200:
            case 1800:
            case 2400:
            case 4800:
            case 9600:
            case 19200:
            case 38400:
            case 57600:
            case 115200:
            case 230400:
            case 460800:
            case 500000:
            case 576000:
            case 921600:
            case 1000000:
            case 1152000:
            case 1500000:
            case 2000000:
            case 2500000:
            case 3000000:
            case 3500000:
            case 4000000:
                return true;
            default:
                return false;
        }
    }

    /**
     * 获取最新的所有串口地址列表
     * 原版的东西不要改，因为已经是历史API了，太多人太多地方调用
     */
    @NonNull
    public static String[] getAvailablePorts() {
        // 不单例，会缓存，直接匿名每次刷新
        SerialPortFinder serialPortFinder = new SerialPortFinder();
        return serialPortFinder.getAllDevicesPath();
    }
}
