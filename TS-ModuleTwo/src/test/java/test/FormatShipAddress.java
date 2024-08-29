package test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class FormatShipAddress {
    
    public static void main(String[] args) {
        String path = "D:\\FILE\\desktop\\cbib\\i2c\\sql\\bankcardV1.5\\sqlData.xlsx";
        //逐行读取path路径的excel文件,并将第一列作为country,第二列作为city,第三列作为province,第四列作为country,第五列作为address
        ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file(path), 1);
        List<Map<String, Object>> readAll = excelReader.readAll();
        int count = 2;
        for (Map<String, Object> map : readAll) {
            String address = String.valueOf(map.get("mail_address_detail_en"));
            System.out.println(count++);
            System.out.println(address);
            String city = String.valueOf(map.get("mail_city_en"));
            String province = String.valueOf(map.get("mail_province_en"));
            String country = String.valueOf(map.get("mail_country_en"));
            address = address.replace(" " + city, "," + city);
            address = address.replace(" " + province, "," + province);
            address = address.replace(" " + country, "," + country);
//            String regex = "\\b(" + Pattern.quote(city) + "|" + Pattern.quote(province) + "|" + Pattern.quote(country) + ")\\b";
//            address = address.replaceAll(regex, ",$1");
            address = address.replace(",,", ",");
            System.out.println(address+"\n");
        }
        
        //        String shipAddressEn = "HALAL TRADE CENTER SANITARY TILES &amp; WARE, KA-158/1 KURIL, VATARA, BANGLADESH Dhaka Dhaka Bangladesh";
        //        String cityEn = "Dhaka";
        //        String provinceEn = "Dhaka";
        //        String countryEn = "Bangladesh";
        //        System.out.println(" " + cityEn);
        //        System.out.println(" " + provinceEn);
        //        System.out.println(" " + countryEn);
        //        shipAddressEn = shipAddressEn.replaceFirst(" " + cityEn, "," + cityEn);
        //        shipAddressEn = shipAddressEn.replaceFirst(" " + provinceEn, "," + provinceEn);
        //        shipAddressEn = shipAddressEn.replace(" " + countryEn, "," + countryEn);
        //        System.out.println(shipAddressEn);
    }
}
