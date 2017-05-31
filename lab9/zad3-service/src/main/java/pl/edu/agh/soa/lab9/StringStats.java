package pl.edu.agh.soa.lab9;

public class StringStats {
    private long charCount;
    private long whiteSpacesCount;
    private long upperCaseLettersCount;
    private long lowerCaseLettersCount;
    private long digitCount;

    public long getCharCount() {
        return charCount;
    }

    public void setCharCount(long charCount) {
        this.charCount = charCount;
    }

    public long getWhiteSpacesCount() {
        return whiteSpacesCount;
    }

    public void setWhiteSpacesCount(long whiteSpacesCount) {
        this.whiteSpacesCount = whiteSpacesCount;
    }

    public long getUpperCaseLettersCount() {
        return upperCaseLettersCount;
    }

    public void setUpperCaseLettersCount(long upperCaseLettersCount) {
        this.upperCaseLettersCount = upperCaseLettersCount;
    }

    public long getLowerCaseLettersCount() {
        return lowerCaseLettersCount;
    }

    public void setLowerCaseLettersCount(long lowerCaseLettersCount) {
        this.lowerCaseLettersCount = lowerCaseLettersCount;
    }

    public long getDigitCount() {
        return digitCount;
    }

    public void setDigitCount(long digitCount) {
        this.digitCount = digitCount;
    }
}
