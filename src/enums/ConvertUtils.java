package enums;

import java.math.BigDecimal;

public class ConvertUtils
{
  // LENGTH CONVERSIONS
  // km conversions
  final static BigDecimal KM_TO_M = new BigDecimal(1000.0);
  final static BigDecimal KM_TO_CM = new BigDecimal(100000.0);
  final static BigDecimal KM_TO_MI = new BigDecimal(0.621371);
  final static BigDecimal KM_TO_FT = new BigDecimal(3280.83);
  final static BigDecimal KM_TO_IN = new BigDecimal(39369.96);
  
  // m conversions
  final static BigDecimal M_TO_KM = new BigDecimal(0.001);
  final static BigDecimal M_TO_CM = new BigDecimal(100.0);
  final static BigDecimal M_TO_MI = new BigDecimal(0.000621371);
  final static BigDecimal M_TO_FT = new BigDecimal(3.28084);
  final static BigDecimal M_TO_IN = new BigDecimal(39.3701);
  
  // cm conversions
  final static BigDecimal CM_TO_M = new BigDecimal(1000.0);
  final static BigDecimal CM_TO_KM = new BigDecimal(0.00001);
  final static BigDecimal CM_TO_MI = new BigDecimal(0.000062137);
  final static BigDecimal CM_TO_FT = new BigDecimal(0.0328084);
  final static BigDecimal CM_TO_IN = new BigDecimal(0.3937008);
  
  // mi conversions
  final static BigDecimal MI_TO_M = new BigDecimal(1609.344051499);
  final static BigDecimal MI_TO_CM = new BigDecimal(1.60934);
  final static BigDecimal MI_TO_KM = new BigDecimal(0.621371);
  final static BigDecimal MI_TO_FT = new BigDecimal(5280.0);
  final static BigDecimal MI_TO_IN = new BigDecimal(63360.0);
  
  // ft conversions
  final static BigDecimal FT_TO_M = new BigDecimal(0.3048);
  final static BigDecimal FT_TO_CM = new BigDecimal(30.48);
  final static BigDecimal FT_TO_MI = new BigDecimal(0.000189394);
  final static BigDecimal FT_TO_KM = new BigDecimal(0.000304800097536);
  final static BigDecimal FT_TO_IN = new BigDecimal(12.0);
  
  // in conversions
  final static BigDecimal IN_TO_M = new BigDecimal(0.0254);
  final static BigDecimal IN_TO_CM = new BigDecimal(2.54);
  final static BigDecimal IN_TO_MI = new BigDecimal(0.000015783);
  final static BigDecimal IN_TO_FT = new BigDecimal(0.0833333);
  final static BigDecimal IN_TO_KM = new BigDecimal(0.0000254);
  
  
  // WEIGHT CONVERSIONS
  // kg conversions
  final static BigDecimal KG_TO_G = new BigDecimal(1000.0);
  final static BigDecimal KG_TO_LB = new BigDecimal(2.20462);
  final static BigDecimal KG_TO_OZ = new BigDecimal(35.274);
  
  // g conversions
  final static BigDecimal G_TO_KG = new BigDecimal(0.001);
  final static BigDecimal G_TO_LB = new BigDecimal(0.00220462);
  final static BigDecimal G_TO_OZ = new BigDecimal(0.035274);
  
  // lb conversions
  final static BigDecimal LB_TO_G = new BigDecimal(453.592);
  final static BigDecimal LB_TO_KG = new BigDecimal(0.453592);
  final static BigDecimal LB_TO_OZ = new BigDecimal(16.0);
  
  // oz conversions
  final static BigDecimal OZ_TO_G = new BigDecimal(28.3495);
  final static BigDecimal OZ_TO_LB = new BigDecimal(0.0625);
  final static BigDecimal OZ_TO_KG = new BigDecimal(0.0283495);
  
  
  // VOLUME CONVERSIONS
  // gal conversions
  final static BigDecimal GAL_TO_L = new BigDecimal(23.78541);
  
  // l conversions
  final static BigDecimal L_TO_GAL = new BigDecimal(0.264172);
  
  
  // TIME CONVERSIONS
  //month conversions
  final static BigDecimal MONTH_TO_HR = new BigDecimal(730.0);
  final static BigDecimal MONTH_TO_MIN = new BigDecimal(43800.0);
  final static BigDecimal MONTH_TO_DAY = new BigDecimal(30.0);
  
  // day conversions
  final static BigDecimal DAY_TO_HR = new BigDecimal(24.0);
  final static BigDecimal DAY_TO_MIN = new BigDecimal(1440.0);
  final static BigDecimal DAY_TO_MONTH = new BigDecimal(0.0328767);
  
  // hr conversions
  final static BigDecimal HR_TO_DAY = new BigDecimal(0.0416667);
  final static BigDecimal HR_TO_MIN = new BigDecimal(60.0);
  final static BigDecimal HR_TO_MONTH = new BigDecimal(0.00136986);
  
  // min conversions
  final static BigDecimal MIN_TO_DAY = new BigDecimal(0.000694444);
  final static BigDecimal MIN_TO_HR = new BigDecimal(0.0166667);
  final static BigDecimal MIN_TO_MONTH = new BigDecimal(0.000022831);
}
