package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Referee {
        private final List<Lotto> lottos;
        private final Lotto winningNumbers;
        private final int bonusNumber;

        public Referee(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
            this.lottos = lottos;
            this.winningNumbers = winningNumbers;
            this.bonusNumber = bonusNumber;
        }

        public List<Grade> calculateGrades() {
            List<Grade> grades = new ArrayList<>();
            for(Lotto lotto : lottos) {
                int matchCount = getWinningNumberMatchCount(lotto);
                int bonusCount = getBonusNumberMatchCount(lotto);
                Grade grade = Grade.findingRank(matchCount, bonusCount);
                if (grade != null) {
                    grades.add(grade);
                }
            }
            return grades.stream().sorted(Comparator.comparingInt(Grade::getRanking)).collect(Collectors.toList());
        }

        // fix
        public Map<String, Integer> getStatics(List<Grade> grades) {
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();
            map.put("3",0);
            map.put("4",0);
            map.put("5",0);
            map.put("5+B",0);
            map.put("6",0);
            for(Grade grade: grades) {
                int value = map.get(grade.getKey());
                map.put(grade.getKey(), value+1);
            }
            return map;
        }


        public int getWinningNumberMatchCount(Lotto lotto) {
            int winNumberMatchCount = 0;
            for (Integer winningNumber : winningNumbers.getNumbers()) {
                if (lotto.getNumbers().contains(winningNumber)) {
                    winNumberMatchCount++;
                }
            }
            return winNumberMatchCount;
        }

        public int getBonusNumberMatchCount(Lotto lotto) {
            int bonusNumberMatchCount = 0;
            if (lotto.getNumbers().contains(bonusNumber)) {
                bonusNumberMatchCount++;
            }
            return bonusNumberMatchCount;
        }
}