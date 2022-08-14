package eugene.korovkin.stocks.iex;

public enum Range {
    FIVE_YEARS("5y"),
    TWO_YEARS("2y"),
    YEAR("1y"),
    YEAR_TO_DATE("ytd"),
    SIX_MONTH("6m"),
    THREE_MONTH("3m"),
    MONTH("1m"),
    NEXT("next");

    Range(String presentation) {
        this.presentation = presentation;
    }

    private String presentation;

    public String getPresentation() {
        return presentation;
    }
}
