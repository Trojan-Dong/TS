package fileParse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Local;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Log4j
public class ParseFileService {
    
    private String resolveModel;
    
    //当前报表
    private String currReport;
    
    private String settleCurrency;
    
    
    void initJson() throws IOException {
        String fileName = "";
        if (StringUtils.equals(currReport, "SUMMARY")) {
            fileName = "aType.txt";
        }
        if (StringUtils.equals(currReport, "RECAP")) {
            fileName = "bType.txt";
        }
        if (StringUtils.equals(currReport, "SETTLEMENT")) {
            fileName = "120Type.txt";
        }
        if (StringUtils.equals(currReport, "REIMBURSEMENT")) {
            fileName = "130Type.txt";
        }
        if (StringUtils.equals(currReport, "CHARGES")) {
            fileName = "140Type.txt";
        }
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\14761\\Desktop\\" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                sb.append(line);
            }
            System.out.println(sb);
        }
        resolveModel = sb.toString();
        
    }
    
    void parseFile() throws IOException {
        currReport = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\14761\\Desktop\\140.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                String trimLine = line.trim();
                if (Objects.isNull(currReport)) {
                    if (trimLine.startsWith("REPORT ID")) {
                        if (trimLine.contains("VSS-110")) {
                            currReport = "SUMMARY";
                        }
                        if (trimLine.contains("VSS-115")) {
                            currReport = "RECAP";
                        }
                        if (trimLine.contains("VSS-120")) {
                            currReport = "SETTLEMENT";
                        }
                        if (trimLine.contains("VSS-130")) {
                            currReport = "REIMBURSEMENT";
                        }
                        if (trimLine.contains("VSS-140")) {
                            currReport = "CHARGES";
                        }
                        parseJson(null, null);
                        continue;
                    }
                }
                if (StringUtils.containsIgnoreCase(trimLine, "END OF")) {
                    currReport = null;
                    settleCurrency = null;
                }
                if (line.contains("SETTLEMENT CURRENCY")) {
                    settleCurrency = line.split(":")[1];
                    continue;
                }
                List<String> keyList = new ArrayList<>();
                leafMap.keySet().forEach(key -> keyList.add(key));
                String finalLine = line;
                keyList.forEach(x -> {
                    if (StringUtils.startsWith(trimLine, x)) {
                        //数据列解析文件
                        parseLine(finalLine);
                    }
                });
                
                
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void parseLine(String line) {
        System.out.println("---------" + line);
        leafMap.forEach((key, value) -> {
            if (formatStr(line).startsWith(formatStr(key))) {
                value.fieldNames().forEachRemaining(innerKey -> {
                    System.out.println(
                            innerKey + ":" + extractRange(line, Integer.parseInt(value.get(innerKey).toString())));
                });
            }
        });
    }
    
    public String formatStr(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return str.trim().replaceAll("[\\-\\.\\s]", "");
    }
    
    Map<String, JsonNode> keyMap = new HashMap<>();
    
    Map<String, JsonNode> leafMap = new HashMap<>();
    
    public void parseJson(JsonNode rootNode, String rootKey) throws IOException {
        if (Objects.isNull(rootNode)) {
            initJson();
            ObjectMapper objectMapper = new ObjectMapper();
            rootNode = objectMapper.readTree(resolveModel);
            //            System.out.println(rootNode);
        }
        try {
            // 将JSON字符串解析为JsonNode对象
            JsonNode finalRootNode = rootNode;
            finalRootNode.fieldNames().forEachRemaining(key -> {
                if (key.equals("isDataRow")) {
                    leafMap.put(rootKey, finalRootNode.get("data"));
                } else {
                    JsonNode jsonNode = finalRootNode.get(key);
                    if (jsonNode.isObject()) {
                        try {
                            keyMap.put(key, jsonNode);
                            parseJson(jsonNode, key);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            //            leafMap.forEach((key, value) -> {
            //                System.out.println("key:" + key + ",value:" + value);
            //            });
            //            keyMap.forEach((key, value) -> {
            //                System.out.println("key:" + key + ",value:" + value);
            //            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String extractRange(String line, int position) {
        StringBuilder result = new StringBuilder();
        if (position >= 0 && position < line.length()) {
            // 从指定位置向前查找空白字符
            while (position >= 0 && !Character.isWhitespace(line.charAt(position))) {
                result.insert(0, line.charAt(position));
                position--;
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        //        ParseFileService service = new ParseFileService();
        //        try {
        //            service.parseFile();
        //        } catch (Exception e) {
        //
        //        }
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd")));
    }
}
