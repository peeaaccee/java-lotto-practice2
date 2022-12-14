package lotto.domain;

import java.util.Arrays;
public enum Grade {

    FIFTH("3",3, 5_000, 5),
    FOURTH("4",4, 50_000, 4),
    THIRD("5",5, 1_500_000, 3),
    SECOND("5+B",5, 30_000_000, 2),
    FIRST("6",6, 2_000_000_000, 1);

    private final int matchCount;

    private final String key;
    private final int prizeMoney;
    private final int ranking;

    Grade(String key, int matchCount, int prizeMoney, int ranking) {
        this.key = key;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.ranking = ranking;
    }

    public static Grade findingRank(int matchCount, int bonusCount) {
        if ((THIRD.matchCount == matchCount) && (bonusCount == 0)) {
            return THIRD;
        }
        if ((SECOND.matchCount == matchCount) && (bonusCount == 1)) {
            return SECOND;
        }
        return Arrays.stream(values()).filter(grade -> grade.matchCount == matchCount)
                .findAny().orElse(null);
    }

    public static Grade findGradeByKey(String key) {
        return Arrays.stream(values()).filter(grade -> grade.key == key)
            .findAny().orElseThrow();
    }

    public String getKey() {
        return key;
    }

    public int getRanking() {
        return ranking;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
