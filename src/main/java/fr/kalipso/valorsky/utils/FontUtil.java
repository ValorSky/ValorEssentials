package fr.kalipso.valorsky.utils;




import fr.kalipso.valorsky.utils.font.BackGround;
import fr.kalipso.valorsky.utils.font.SimpleChar;
import fr.kalipso.valorsky.utils.font.enums.FontOffset;
import fr.kalipso.valorsky.utils.font.enums.FontWidthNormal;

import java.util.HashMap;
import java.util.Objects;

public class FontUtil {

    private final BackGround backGround;
    public static final HashMap<Character, Integer> fontWidth = new HashMap<>();

    public FontUtil() {
        fontWidth.clear();

        int i;
        for (i = 0; i < FontWidthNormal.values().length; ++i) {
            fontWidth.put(FontWidthNormal.values()[i].getCharacter(), FontWidthNormal.values()[i].getLength());
        }

        for (i = 0; i < FontOffset.values().length; ++i) {
            fontWidth.put(FontOffset.values()[i].getCharacter(), FontOffset.values()[i].getSpace() - 1);
        }

        backGround = generateBackGround();
    }

    public static int getInfo(char c) {
        return Objects.requireNonNullElse(fontWidth.get(c), 8);
    }

    public static int getTotalWidth(String s) {
        int length = s.length();
        int n = 0;

        for(int i = 0; i < length; ++i) {
            n += getInfo(s.charAt(i));
        }

        return n + length;
    }

    public static String getOffset(int offset) {
        return offset >= 0 ? FontOffset.getShortestPosChars(offset) : FontOffset.getShortestNegChars(-offset);
    }

    private BackGround generateBackGround() {
        char oStart = '뀁';
        char o1 = (char) (oStart + 1);
        char o2 = (char) (o1 + 1);
        char o4 = (char) (o2 + 1);
        char o8 = (char) (o4 + 1);
        char o16 = (char) (o8 + 1);
        char o32 = (char) (o16 + 1);
        char o64 = (char) (o32 + 1);
        char o128 = (char) (o64 + 1);
        char oEnd = (char) (o128 + 1);
        int height = 14;
        int ascent = 7;
        SimpleChar startChar = new SimpleChar(14, 7, 1, oStart, "b0.png");
        SimpleChar offset_1 = new SimpleChar(height, ascent, 1, o1, "b1.png");
        SimpleChar offset_2 = new SimpleChar(height, ascent, 1, o2, "b2.png");
        SimpleChar offset_4 = new SimpleChar(height, ascent, 1, o4, "b4.png");
        SimpleChar offset_8 = new SimpleChar(height, ascent, 1, o8, "b8.png");
        SimpleChar offset_16 = new SimpleChar(height, ascent, 1, o16, "b16.png");
        SimpleChar offset_32 = new SimpleChar(height, ascent, 1, o32, "b32.png");
        SimpleChar offset_64 = new SimpleChar(height, ascent, 1, o64, "b64.png");
        SimpleChar offset_128 = new SimpleChar(height, ascent, 1, o128, "b128.png");
        SimpleChar endChar = new SimpleChar(14, 7, 1, oEnd, "b0.png");
        return new BackGround(startChar, offset_1, offset_2, offset_4, offset_8, offset_16, offset_32, offset_64, offset_128, endChar, 1, 1);
    }

    public BackGround getBackGround() {
        return backGround;
    }
}