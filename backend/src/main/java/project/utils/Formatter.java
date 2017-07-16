package project.utils;

import org.apache.commons.lang.StringUtils;

public enum Formatter {

    CARD_NUMBER {

        @Override
        public String format(String source) {
            if (source == null) {
                return StringUtils.EMPTY;
            }

            return formatValue(source);
        }

        private String formatValue(String source) {
            if (source.length() <= 4) {
                return source;
            }

            return source.substring(0, 4) + "-" + format(source.substring(4));
        }

    };

    public abstract String format(String source);
}
