package pl.edu.agh.soa.lab9;

import javax.jws.WebService;

@WebService(endpointInterface = "pl.edu.agh.soa.lab9.StringService")
public class StringServiceImpl implements StringService {
    public StringStats getStringStats(String s) {
        StringStats stringStats = new StringStats();
        stringStats.setCharCount(s.length());
        stringStats.setWhiteSpacesCount(countWhiteSpaces(s));
        stringStats.setUpperCaseLettersCount(countUpperCaseLetters(s));
        stringStats.setLowerCaseLettersCount(countLowerCaseLetters(s));
        stringStats.setDigitCount(countDigits(s));
        return stringStats;
    }

    private long countWhiteSpaces(String s) {
        return s.length() - s.replaceAll(" ", "").length();
    }

    private long countUpperCaseLetters(String s) {
        return s.chars().filter(Character::isUpperCase).count();
    }

    private long countLowerCaseLetters(String s) {
        return s.chars().filter(Character::isLowerCase).count();
    }

    private long countDigits(String s) {
        return s.chars().filter(Character::isDigit).count();
    }
}
