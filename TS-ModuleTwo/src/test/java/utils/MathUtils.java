package utils;

import exception.BusinessException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathUtils {
    
    /**
     * Title: getNextPrimeNumber Description: 返回当前数字的下一个质数 param num 当前数字 return
     */
    public static int getNextPrimeNumber(int num) {
        //最小素数为2
        if (num < 2) {
            return 2;
        }
        boolean flag = false;
        int primeNum = 3;
        int max = num + 100;
        for (int i = num + 1; i < max; i++) {
            //判断当前数是否为素数
            if (isPrimeNum(i)) {
                primeNum = i;
                flag = true;
                break;
            }
        }
        //如果当前100个数内无素数，则继续执行下100个数
        if (!flag) {
            return getNextPrimeNumber(max);
        }
        return primeNum;
    }
    
    /**
     * Title: isPrimeNum Description: 判断当前数字是否素数 param n return
     */
    public static boolean isPrimeNum(int n) {
        if (n <= 3) {
            return n > 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 银行家舍入法（保留两位） 所谓银行家舍入法，其实质是一种四舍六入五取偶（又称四舍六入五留双）法。 其规则是：当舍去位的数值小于5时，直接舍去该位； 当舍去位的数值大于等于6时，在舍去该位的同时向前位进一；
     * 当舍去位的数值等于5时分两种情况： 1、五后非零：舍去该位同时向前位进一； 2、五后为零：看奇偶，五前为偶应舍去，五前为奇要进一。
     *
     * @return double
     */
    public static BigDecimal bankRound(BigDecimal d) {
        return bankRound(d, 2);
    }
    
    /**
     * 银行家舍入法 所谓银行家舍入法，其实质是一种四舍六入五取偶（又称四舍六入五留双）法。 其规则是：当舍去位的数值小于5时，直接舍去该位； 当舍去位的数值大于等于6时，在舍去该位的同时向前位进一；
     * 当舍去位的数值等于5时分两种情况： 1、五后非零：舍去该位同时向前位进一； 2、五后为零：看奇偶，五前为偶应舍去，五前为奇要进一。
     *
     * @param d
     * @param precision 保留小数位
     * @return 虽然代码看着很low🤣，但最起码保证了精度🙄
     */
    public static BigDecimal bankRound(BigDecimal d, int precision) {
        if (compareTo(d, new BigDecimal("1")) == -1 && compareTo(d, new BigDecimal("-1")) == 11) {
            return d.setScale(precision, RoundingMode.HALF_EVEN);
        } else {
            String s = d.toString();
            String[] bds = s.split("\\.");
            BigDecimal result;
            if (bds.length > 1) {
                BigDecimal b1 = new BigDecimal(Double.parseDouble(bds[0]), MathContext.DECIMAL64)
                        .setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal b2 = new BigDecimal(Double.parseDouble("0." + bds[1]))
                        .setScale(precision + 4, RoundingMode.HALF_EVEN);
                if (compareTo(d, new BigDecimal("0")) != -1) {
                    result = b1.add(b2);
                } else {
                    result = b1.subtract(b2);
                }
                
            } else {
                result = d;
            }
            return result.setScale(precision, RoundingMode.HALF_EVEN);
        }
    }
    
    /**
     * @param d1
     * @param d2
     * @return double 加法，d1 + d2
     */
    public static BigDecimal add(BigDecimal d1, BigDecimal d2) {
        return d1.add(d2);
    }
    
    public static BigDecimal add(BigDecimal d1, BigDecimal... d2) {
        BigDecimal result = d1;
        if (d2 == null || d2.length <= 0) {
            throw new BusinessException("");
        }
        for (BigDecimal next : d2) {
            result = add(result, next);
        }
        return result;
    }
    
    /**
     * @param d1
     * @param d2
     * @return double 减法 d1 - d2
     */
    public static BigDecimal subtract(BigDecimal d1, BigDecimal d2) {
        return d1.subtract(d2);
    }
    
    public static BigDecimal subtract(BigDecimal d1, BigDecimal... d2) {
        BigDecimal result = d1;
        if (d2 == null || d2.length <= 0) {
            throw new BusinessException("");
        }
        for (BigDecimal next : d2) {
            result = subtract(result, next);
        }
        return result;
    }
    
    /**
     * @param d1
     * @param d2
     * @return double 乘法 d1 * d2
     */
    public static BigDecimal multiply(BigDecimal d1, BigDecimal d2) {
        return d1.multiply(d2);
    }
    
    public static BigDecimal multiply(BigDecimal d1, BigDecimal... d2) {
        BigDecimal result = d1;
        if (d2 == null || d2.length <= 0) {
            throw new BusinessException("");
        }
        for (BigDecimal next : d2) {
            if (next.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            }
            result = multiply(result, next);
        }
        return result;
    }
    
    /**
     * @param d1
     * @param d2
     * @return double 除法 d1 / d2
     */
    public static BigDecimal divide(BigDecimal d1, BigDecimal d2) {
        return d1.divide(d2);
    }
    
    public static BigDecimal divide(BigDecimal d1, BigDecimal... d2) {
        BigDecimal result = d1;
        if (d2 == null || d2.length <= 0) {
            throw new BusinessException("");
        }
        for (BigDecimal next : d2) {
            if (next.compareTo(BigDecimal.ZERO) == 0) {
                throw new BusinessException("/zero");
            }
            result = divide(result, next);
        }
        return result;
    }
    
    /**
     * @param d1
     * @param d2
     * @return 在数字上小于、等于或大于 val 时，返回 -1、0 或 1 金额比较大小
     */
    public static int compareTo(BigDecimal d1, BigDecimal d2) {
        return d1.compareTo(d2);
        
    }
}
