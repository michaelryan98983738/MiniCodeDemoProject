package org.demo.miniCode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LetterCombinationTest {
    private LetterCombination letterCombination;

    @BeforeEach
    public void before() {
        letterCombination = new LetterCombination();
    }

    @AfterEach
    public void after() {
        letterCombination = null;
    }

    /**
     * Method: letterCombinationStageOne(int[] numbers)
     */
    @Test
    public void testLetterCombinationStageOne() {
        Assertions.assertEquals("a b c", letterCombination.letterCombinationStageOne(new int[]{1, 2}));
        Assertions.assertEquals("w x y z", letterCombination.letterCombinationStageOne(new int[]{0, 9}));
        Assertions.assertEquals("aw ax ay az bw bx by bz cw cx cy cz", letterCombination.letterCombinationStageOne(new int[]{2, 1, 9}));
        Assertions.assertEquals("", letterCombination.letterCombinationStageOne(new int[]{1}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageOne(new int[]{}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageOne(new int[]{-1}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageOne(new int[]{20, 9}));
    }

    /**
     * Method: letterCombinationStageTwo(int[] numbers)
     */
    @Test
    public void testLetterCombinationStageTwo() {
        Assertions.assertEquals("a b c", letterCombination.letterCombinationStageTwo(new int[]{1, 2}));
        Assertions.assertEquals("w x y z", letterCombination.letterCombinationStageTwo(new int[]{0, 19}));
        Assertions.assertEquals("aw ax ay az bw bx by bz cw cx cy cz", letterCombination.letterCombinationStageTwo(new int[]{2, 19}));
        Assertions.assertEquals("ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz", letterCombination.letterCombinationStageTwo(new int[]{0, 99}));
        Assertions.assertEquals("", letterCombination.letterCombinationStageOne(new int[]{0, 1}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageTwo(new int[]{}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageTwo(new int[]{-1}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageTwo(new int[]{1, 9, -1}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> letterCombination.letterCombinationStageTwo(new int[]{200, 9}));
    }

} 
