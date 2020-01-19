package configuration;

import static java.lang.Boolean.TRUE;

 public class Config {

     public static final int MACHINES = 4;
     public static final int INSTANCE_START_SIZE = 50;
     public static final int INSTANCE_N = 10;

     public static final int MIN_PROCESSING_TIME = 1;
     public static int MAX_PROCESSING_TIME = 10;

     public static final int SHIFT_DUE_TIME = 4;
     public static final int DENOMINATOR_SHIFT = 3;

     public static final double PROCENT_READY_TIME = 0.8;

     public static final boolean PROCESSING_TIME_VAR = TRUE;
     
     public static String[] INSTANCE_NAMES =  new String[]{"00","01"};
 }
