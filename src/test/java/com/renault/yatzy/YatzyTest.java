package com.renault.yatzy;

import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {

        assertEquals(15, new Yatzy(2,3,4,5,1).computeChance());
        assertEquals(16, new Yatzy(3,3,4,5,1).computeChance());
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, new Yatzy(4,4,4,4,4).computeYatzy());
        assertEquals(50, new Yatzy(6,6,6,6,6).computeYatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).computeYatzy());
    }

    @Test public void test_1s() {
        assertEquals(1,new Yatzy(1,2,3,4,5).computeOnes());
        assertEquals(2, new Yatzy(1,2,1,4,5).computeOnes());
        assertEquals(0, new Yatzy(6,2,2,4,5).computeOnes());
        assertEquals(4, new Yatzy(1,2,1,1,1).computeOnes());
    }

    @Test
    public void test_2s() {
        assertEquals(4, new Yatzy(1,2,3,2,6).computeTwos());
        assertEquals(10, new Yatzy(2,2,2,2,2).computeTwos());
    }

    @Test
    public void test_threes() {
        assertEquals(6, new Yatzy(1,2,3,2,3).computeThrees());
        assertEquals(12, new Yatzy(2,3,3,3,3).computeThrees());
    }

    @Test
    public void fours_test()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).computeFours());
        assertEquals(8, new Yatzy(4,4,5,5,5).computeFours());
        assertEquals(4, new Yatzy(4,5,5,5,5).computeFours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).computeFives());
        assertEquals(15, new Yatzy(4,4,5,5,5).computeFives());
        assertEquals(20, new Yatzy(4,5,5,5,5).computeFives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).computeSixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).computeSixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).computeSixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).computeScorePair());
        assertEquals(10, new Yatzy(5,3,3,3,5).computeScorePair());
        assertEquals(12, new Yatzy(5,3,6,6,5).computeScorePair());
        assertEquals(0, new Yatzy(5,3,6,1,2).computeScorePair());
    }

    @Test
    public void two_Pair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).computeTwoPair());
        assertEquals(16, new Yatzy(3,3,5,5,5).computeTwoPair());
    }

    @Test
    public void three_of_a_kind()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).computeThreeOfAKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).computeThreeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).computeThreeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,3).computeThreeOfAKind());
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new Yatzy(3,3,3,3,5).computeFourOfAKind());
        assertEquals(20, new Yatzy(5,5,5,4,5).computeFourOfAKind());

    }

    @Test
    public void smallStraight() {
        assertEquals(15,new  Yatzy(1,2,3,4,5).computeSmallStraight());
        assertEquals(15,new  Yatzy(2,3,4,5,1).computeSmallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).computeSmallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).computeLargeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).computeLargeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).computeLargeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).computeFullHouse());
        assertEquals(21, new Yatzy(6,3,3,3,6).computeFullHouse());
        assertEquals(0,new  Yatzy(2,3,4,5,6).computeFullHouse());
    }
}
