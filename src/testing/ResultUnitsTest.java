package testing;

import org.junit.jupiter.api.Test;
import utilities.Operand;
import utilities.ResultUnits;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static utilities.ResultUnits.nonLikeUnits;

class ResultUnitsTest {

  @Test
  void testLikeUnits() {
    Operand op1 = new Operand(new BigDecimal(1), "mon", 1, "");
    Operand op2 = new Operand(new BigDecimal(1), "hr", 1, "");
    Object[] list = ResultUnits.likeUnits(op1, op2);
    Object[] testList = new Object[] {"sec", "hr", "day", "mon", "yr"};
    assertArrayEquals(testList, list);
  }



}