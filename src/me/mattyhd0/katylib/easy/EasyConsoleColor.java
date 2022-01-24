package me.mattyhd0.katylib.easy;

public class EasyConsoleColor {

    private EasyConsoleColor(){

    }

    public static final String RESET = "\u001B[0m";

    public static class Text{

        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

    }

    public static class Background{

        public static final String BLACK = "\u001B[40m";
        public static final String RED = "\u001B[41m";
        public static final String GREEN = "\u001B[42m";
        public static final String YELLOW = "\u001B[43m";
        public static final String BLUE = "\u001B[44m";
        public static final String MAGENTA = "\u001B[45m";
        public static final String CYAN = "\u001B[46m";
        public static final String WHITE = "\u001B[47m";

    }

    public static class Format{

        public static final String ITALIC = "\u001B[3m";
        public static final String UNDERLINE = "\u001B[4m";
        public static final String BLINK = "\u001B[5m";
        public static final String RAPID_BLINK = "\u001B[6m";
        public static final String REVERSE = "\u001B[7m";
        public static final String INVISIBLE_TEXT = "\u001B[8m";

        public static final String BOLD = "\u001B[1m";
        public static final String NO_BOLD = "\u001B[2m";

    }


    public static String parseText(String text){

        return text
                .replaceAll("<reset>", RESET)

                .replaceAll("<black>", Text.BLACK)
                .replaceAll("<red>", Text.RED)
                .replaceAll("<green>", Text.GREEN)
                .replaceAll("<yellow>", Text.YELLOW)
                .replaceAll("<blue>", Text.BLUE)
                .replaceAll("<magenta>", Text.MAGENTA)
                .replaceAll("<cyan>", Text.CYAN)
                .replaceAll("<white>", Text.WHITE)

                .replaceAll("<bg_black>", Background.BLACK)
                .replaceAll("<bg_red>", Background.RED)
                .replaceAll("<bg_green>", Background.GREEN)
                .replaceAll("<bg_yellow>", Background.YELLOW)
                .replaceAll("<bg_blue>", Background.BLUE)
                .replaceAll("<bg_magenta>", Background.MAGENTA)
                .replaceAll("<bg_cyan>", Background.CYAN)
                .replaceAll("<bg_white>", Background.WHITE)

                .replaceAll("<italic>", Format.ITALIC)
                .replaceAll("<underline>", Format.UNDERLINE)
                .replaceAll("<blink>", Format.BLINK)
                .replaceAll("<rapid_blink>", Format.RAPID_BLINK)
                .replaceAll("<reverse>", Format.REVERSE)
                .replaceAll("<invisible_text>", Format.INVISIBLE_TEXT)
                .replaceAll("<bold>", Format.BOLD)
                .replaceAll("<no_bold>", Format.NO_BOLD);

    }

}
