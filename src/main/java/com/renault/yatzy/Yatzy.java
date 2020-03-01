package com.renault.yatzy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yatzy {

    private int[] dices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = new int[5];
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
    }

     // ok
    public int computeChance() {
        return dices[0] + dices[1] + dices[2] + dices[3] + dices[4];
    }

    public int computeYatzy() {
        Set<Integer> diceSet = Arrays.stream(this.dices)
                .boxed()
                .collect(Collectors.toSet());

        return diceSet.size() == 1 ? 50 : 0;
    }

    public int computeOnes() {
        return getDiceSum(1);
    }

    public int computeTwos() {
        return getDiceSum(2);
    }


    public int computeThrees() {
        return getDiceSum(3);
    }


    public int computeFours() {
        return getDiceSum(4);
    }

    public int computeFives() {
        return getDiceSum(5);
    }

    public int computeSixes() {
        return getDiceSum(6);
    }

    public int computeScorePair() {
        return computeGroupScore(2, extractGroupBySize(2));
    }

    public int computeTwoPair() {
        Map<Integer, Long> groupBySize = extractGroupBySize(2);

        if (groupBySize.size() == 2) {
            return 2 * groupBySize.keySet().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        return 0;
    }

    private int computeGroupScore(int size, Map<Integer, Long> groups) {
        if (groups.isEmpty()) {
            return 0;
        }

        Integer element = Collections.max(groups.keySet());

        return Math.max(element, 0) * size;
    }

    private Map<Integer, Long> getFrequence() {
        return Arrays.stream(this.dices)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Map<Integer, Long> extractGroupBySize(int size) {
        return getFrequence().entrySet().stream()
                .filter(e -> e.getValue() >= size)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public int computeFourOfAKind() {
        return sumOccurenceOfKind(4);
    }

    private int sumOccurenceOfKind(int i) {
        Map<Integer, Long> groupBySize = extractGroupBySize(i);

        if (!groupBySize.isEmpty()) {
            return groupBySize.keySet()
                    .stream()
                    .findFirst()
                    .get() * i;
        }
        return 0;
    }

    public int computeThreeOfAKind() {
        return sumOccurenceOfKind(3);

    }

    public int computeSmallStraight() {
        Set<Integer> diceSet = Arrays.stream(this.dices)
                .boxed()
                .collect(Collectors.toSet());
        return diceSet.size() == 5 && !diceSet.contains(6) ? 15 : 0;
    }

    public int computeLargeStraight() {
        Set<Integer> diceSet = Arrays.stream(this.dices)
                .boxed()
                .collect(Collectors.toSet());
        return diceSet.size() == 5 && !diceSet.contains(1) ? 20 : 0;
    }

    public int computeFullHouse() {
        Map<Integer, Long> groupByTwo = extractGroupBySize(2);
        return groupByTwo.size() == 2 && groupByTwo.containsValue(3L) ? this.computeChance() : 0;

    }

    private int getDiceSum(int value) {
        return Arrays.stream(this.dices).filter(item -> item == value)
                .boxed()
                .collect(Collectors.toList())
                .size() * value;
    }
}
