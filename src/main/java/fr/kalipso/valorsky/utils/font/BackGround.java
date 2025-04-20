package fr.kalipso.valorsky.utils.font;

import fr.kalipso.valorsky.utils.font.enums.FontOffset;
import org.bukkit.OfflinePlayer;

public record BackGround(SimpleChar start, SimpleChar offset_1, SimpleChar offset_2, SimpleChar offset_4, SimpleChar offset_8, SimpleChar offset_16, SimpleChar offset_32, SimpleChar offset_64, SimpleChar offset_128, SimpleChar end, int start_width, int end_width) {
    public BackGround(SimpleChar start, SimpleChar offset_1, SimpleChar offset_2, SimpleChar offset_4, SimpleChar offset_8, SimpleChar offset_16, SimpleChar offset_32, SimpleChar offset_64, SimpleChar offset_128, SimpleChar end, int start_width, int end_width) {
        this.start = start;
        this.offset_1 = offset_1;
        this.offset_2 = offset_2;
        this.offset_4 = offset_4;
        this.offset_8 = offset_8;
        this.offset_16 = offset_16;
        this.offset_32 = offset_32;
        this.offset_64 = offset_64;
        this.offset_128 = offset_128;
        this.end = end;
        this.start_width = start_width;
        this.end_width = end_width;
    }

    public String getBackGround(int n) {
        String offset = FontOffset.getShortestNegChars(n + this.end_width + 2);
        n = n + this.start_width + this.end_width + 2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.start.getChars());

        while(n >= 128) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_128.getChars());
            n -= 128;
        }

        if (n - 64 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_64.getChars());
            n -= 64;
        }

        if (n - 32 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_32.getChars());
            n -= 32;
        }

        if (n - 16 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_16.getChars());
            n -= 16;
        }

        if (n - 8 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_8.getChars());
            n -= 8;
        }

        if (n - 4 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_4.getChars());
            n -= 4;
        }

        if (n - 2 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_2.getChars());
            n -= 2;
        }

        if (n - 1 >= 0) {
            stringBuilder.append(FontOffset.NEG_1.getCharacter());
            stringBuilder.append(this.offset_1.getChars());
        }

        stringBuilder.append(FontOffset.NEG_1.getCharacter());
        stringBuilder.append(this.end.getChars()).append(offset);
        return stringBuilder.toString();
    }

    public SimpleChar start() {
        return this.start;
    }

    public SimpleChar offset_1() {
        return this.offset_1;
    }

    public SimpleChar offset_2() {
        return this.offset_2;
    }

    public SimpleChar offset_4() {
        return this.offset_4;
    }

    public SimpleChar offset_8() {
        return this.offset_8;
    }

    public SimpleChar offset_16() {
        return this.offset_16;
    }

    public SimpleChar offset_32() {
        return this.offset_32;
    }

    public SimpleChar offset_64() {
        return this.offset_64;
    }

    public SimpleChar offset_128() {
        return this.offset_128;
    }

    public SimpleChar end() {
        return this.end;
    }

    public int start_width() {
        return this.start_width;
    }

    public int end_width() {
        return this.end_width;
    }
    public static String getBackground(String text, OfflinePlayer player) {
        //BackGround backGround = Core.getInstance().getFontUtil().getBackGround();
       // return "<font:nameplates:default><color:#FFFEFD>" + backGround.getBackGround(FontUtil.getTotalWidth(PlaceholderAPI.setPlaceholders(player, text))) + "</font>";
        return "";
    }
}