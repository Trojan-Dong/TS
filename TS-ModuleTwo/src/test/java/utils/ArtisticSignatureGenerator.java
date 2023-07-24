package utils;

import com.github.lalyos.jfiglet.FigletFont;

public class ArtisticSignatureGenerator {
    
    public static void main(String[] args) {
        String yourName = "D://tet.txt"; // 更换为您的名字
        
        String fontName = "slant"; // 您可以尝试不同的字体样式
        
        String artisticSignature = generateArtisticSignature(yourName, fontName);
        System.out.println(artisticSignature);
    }
    
    public static String generateArtisticSignature(String text, String fontName) {
        try {
            return FigletFont.convertOneLine(text, fontName);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
