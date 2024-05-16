package fileParse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Log4j
public class ParseFileService {
    
    private final String resolveModel =
            "{\n" + "\t\"TOTAL\": {\n" + "\t\t\"TOTAL\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ACQUIRER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ISSUER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL OTHER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t}\n"
                    + "\t},\n" + "\t\"VISA CHARGES\": {\n" + "\t\t\"TOTAL\": {\n" + "\t\t\t\"isDataRow\": true,\n"
                    + "\t\t\t\"data\": {\n" + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ACQUIRER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ISSUER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL OTHER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t}\n"
                    + "\t},\n" + "\t\"INTERCHANGE\": {\n" + "\t\t\"TOTAL\": {\n" + "\t\t\t\"isDataRow\": true,\n"
                    + "\t\t\t\"data\": {\n" + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ACQUIRER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ISSUER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL OTHER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t}\n"
                    + "\t},\n" + "\t\"REIMBURSEMENT FEES\": {\n" + "\t\t\"TOTAL\": {\n" + "\t\t\t\"isDataRow\": true,\n"
                    + "\t\t\t\"data\": {\n" + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ACQUIRER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL ISSUER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t},\n"
                    + "\t\t\"TOTAL OTHER\": {\n" + "\t\t\t\"isDataRow\": true,\n" + "\t\t\t\"data\": {\n"
                    + "\t\t\t\t\"COUNT\": 50,\n" + "\t\t\t\t\"CREDIT AMOUNT\": 76,\n"
                    + "\t\t\t\t\"DEBIT AMOUNT\": 102,\n" + "\t\t\t\t\"TOTAL AMOUNT\": 128\n" + "\t\t\t}\n" + "\t\t}\n"
                    + "\t}\n" + "}";
    
    //当前报表
    private String currReport;
    
    private String settleCurrency;
    
    
    void parseFile() {
        currReport = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\14761\\Desktop\\a.txt"))) {
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
                        parseJson(null, null);
                        continue;
                    }
                }
                if (line.contains("SETTLEMENT CURRENCY")) {
                    settleCurrency = line.split(":")[1];
                    continue;
                }
                List<String> keyList = new ArrayList<>();
                leafMap.keySet().forEach(key -> keyList.add(key));
                String finalLine = line;
                keyList.forEach(x -> {
                    if (StringUtils.startsWithAny(trimLine, x)) {
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
        System.out.println(line);
        leafMap.forEach((key, value) -> {
            if (line.trim().startsWith(key)) {
                value.fieldNames().forEachRemaining(innerKey -> {
                    System.out.println(
                            innerKey + ":" + extractRange(line, Integer.parseInt(value.get(innerKey).toString())));
                });
            }
        });
    }
    
    Map<String, JsonNode> keyMap = new HashMap<>();
    
    Map<String, JsonNode> leafMap = new HashMap<>();
    
    public void parseJson(JsonNode rootNode, String rootKey) throws JsonProcessingException {
        if (Objects.isNull(rootNode)) {
            ObjectMapper objectMapper = new ObjectMapper();
            rootNode = objectMapper.readTree(resolveModel);
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
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
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
        ParseFileService service = new ParseFileService();
        try {
            service.parseFile();
        } catch (Exception e) {
        
        }
    }
}
