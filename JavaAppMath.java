/*
 
 */
//package javaappmath;

/**
 *
  @author pamela alonge
  SENG 560 project #1 Due Midnight 9/19/17
  write a reusable library of basic arithmetic  functions. This library should be able to perform the following operations on integers and floating point numbers as well as numbers provided in octal, binary, and hexadecimal). The operations to be supported are: 
- Addition
- Subtraction
- Multiplication
- Division
- Square Root
- Exponent
- Conversion between the various types (octal, hexadecimal, integer, binary)..

 */

public class JavaAppMath {
    
private String oper;
private String base;
private float no1;
private float no2;
private float float_result;
private Integer error_code;
private String error_message;
private final int MATH_SUCCESS=0;
private final int DIVISION_ERROR=-1;
private final int MISSING_ARGUMENT_ERROR=-2;
private final int ADD_ERROR=-3;
private final int SUB_ERROR=-4;
private final int SQRT_ERROR=-5;
private final int EXP_ERROR=-6;
private final int CONVERSION_ERROR=-7;
private final int UNKNOWN_ERROR=-8;
private final int UNSUPPORTED_ARGUMENT_ERROR=-9;
private final int UNKNOWN_OPERATION=-10;
private final int UNKNOWN_TYPE=-11;
private final int BASE_TYPES_CONVERSION_ERROR=-12;

  
   //for sq root no2 number is not used
    void setRequest(String opIn, int no1In, int no2In) {
       try { 
       if (!op_choices.contains(opIn.toUpperCase())) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="Operation"  + opIn + " must be ADD, SUB, MUL, DIV, SQR, EXP, or CON.";
           return;
        } else this.oper=opIn.toUpperCase();
      
       this.base="INT";
       this.no1=(float)no1In;
       this.no2=(float)no2In;
       this.error_code=MATH_SUCCESS;
       this.error_message="";
       this.float_result=0; 
       doMath();
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } }

//for sq root no2 number is not used
    void setRequest(String opIn, float no1In, float no2In) {
       try { 
       if (!op_choices.contains(opIn.toUpperCase())) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="Operation"  + opIn + " must be ADD, SUB, MUL, DIV, SQR, EXP, or CON.";
           return;
        } else this.oper=opIn.toUpperCase();
      
       this.base="FLO";
       this.no1=no1In;
       this.no2=no2In;
       this.error_code=MATH_SUCCESS;
       this.error_message="";
       this.float_result=0; 
       doMath();
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } }
    
    
    //for sq root no2 number is not used
    void setRequest(String opIn, int no1In) {
       try { 
       if (!opIn.toUpperCase().equals("SQR")) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="This operation of two arugments accepts only SQR.";
           return;
        } else this.oper=opIn.toUpperCase();
      
       this.base="INT";
       this.no1=(float) no1In;
       this.no2=0;
       this.error_code=MATH_SUCCESS;
       this.error_message="";
       this.float_result=0; 
       doMath();
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } }

    //for sq root no2 number is not used
    void setRequest(String opIn, float no1In) {
    try { 
       if (!opIn.toUpperCase().equals("SQR")) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="This operation of two arugments accepts only SQR.";
           return;
        } else this.oper=opIn.toUpperCase();
      
       this.base="";
       this.no1=no1In;
       this.no2=0;
       this.error_code=0;
       this.error_message="";
       this.float_result=0;
       doMath();
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } 
 }

    
   // conversion request only   
    void setRequest(String opIn, String baseIn, String noIn) {
       try { 
       if (!opIn.toUpperCase().equals("CON")) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="This operation of three arugments accepts only CON.";
           return;
        } else this.oper=opIn.toUpperCase();
      
        if (!ty_choices.contains(baseIn.toUpperCase())) { 
           this.float_result=0;
           this.error_code=UNKNOWN_TYPE;
           this.error_message="Number type"  + baseIn + " must be INT, FLO, OCT, BIN, HEX or STR.";
           return;
        } else this.base=baseIn.toUpperCase();
                
       this.no1=0;
       this.no2=0;        
       this.error_code=MATH_SUCCESS;
       this.error_message="";
       this.float_result=doConversion(baseIn,noIn);  
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } }
    
       // conversion request only   
    void setRequest(String opIn, String baseIn, float noIn) {
       try { 
       if (!opIn.toUpperCase().equals("CON")) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="This operation of three arugments accepts only CON.";
           return;
        } else this.oper=opIn.toUpperCase();
      
        if (!ty_choices.contains(baseIn.toUpperCase())) { 
           this.float_result=0;
           this.error_code=UNKNOWN_TYPE;
           this.error_message="Number type"  + baseIn + " must be INT, FLO, OCT, BIN, HEX or STR.";
           return;
        } else this.base=baseIn.toUpperCase();
                
       this.no1=0;
       this.no2=0;        
       this.error_code=MATH_SUCCESS;
       this.error_message="";
       this.float_result=noIn;  
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } }
    
    
       // conversion request only   
    void setRequest(String opIn, String baseIn, int noIn) {
       try { 
       if (!opIn.toUpperCase().equals("CON")) { 
           this.float_result=0;
           this.error_code=UNKNOWN_OPERATION;
           this.error_message="This operation of three arugments accepts only CON.";
           return;
        } else this.oper=opIn.toUpperCase();
      
        if (!ty_choices.contains(baseIn.toUpperCase())) { 
           this.float_result=0;
           this.error_code=UNKNOWN_TYPE;
           this.error_message="Number type"  + baseIn + " must be INT, FLO, OCT, BIN, HEX or STR.";
           return;
        } else this.base=baseIn.toUpperCase();
                
       this.no1=0;
       this.no2=0;        
       this.error_code=MATH_SUCCESS;
       this.error_message="";
       this.float_result=(float) noIn;  
       } 
       catch (Exception e)
       { this.error_code=UNKNOWN_ERROR;
         this.error_message="Unknown Error on setRequest\n";
         this.float_result=0;
       } }
 
    
 private float doConversion(String baseIn, String noIn){
     float returnvalue;
     returnvalue=0;
      switch (baseIn){
          case "INT":                           
              returnvalue=Float.valueOf(noIn);  //needs validated for non- numbers still
               this.error_code=MATH_SUCCESS;
               break;
          case "FLO":
               returnvalue=Float.valueOf(noIn);  //needs validated for non- numbers still
               this.error_code=MATH_SUCCESS;
               break;
          case "OCT":
              returnvalue=(float)Integer.parseInt(noIn, 4); //needs validated
              this.error_code=MATH_SUCCESS;
               break;
          case "BIN":
              returnvalue=(float)Integer.parseInt(noIn, 2); //needs validated
              this.error_code=MATH_SUCCESS;
               break;
          case "HEX":
              returnvalue=(float)Integer.parseInt(noIn, 16); //needs validated
              this.error_code=MATH_SUCCESS;
               break;
              default:  {
                        this.float_result=0;
                        this.error_code=UNKNOWN_TYPE;
                        this.error_message="Number Conversation had unknown error.";
                        break;
                 } 
              
      } 
    return returnvalue;
 }
    
    
private void doMath(){
    
    switch (oper){
                 case "ADD": 
                            this.float_result=add(this.no1,this.no2);
                             break;
                 case "SUB":
                            this.float_result=subtract(this.no1,this.no2);
                             break;
                 case "MUL": 
                            this.float_result=multiply(this.no1,this.no2);
                             break;
                 case "DIV":
                            this.float_result=divide(this.no1,this.no2);
                             break;
                 case "SQR":
                            this.float_result=sqroot(this.no1);
                             break;
                 case "EXP":
                             this.float_result=exponent(this.no1,this.no2);
                             break;
                 case "CON":  //this converstion had a number input
                           this.float_result=this.no1;
                     break;
                 default:  {
                        this.float_result=0;
                        this.error_code=UNKNOWN_OPERATION;
                        this.error_message="Operation must be ADD, SUB, MUL, DIV, SQR, EXP, or CON.";
                        break;
                 }          
        }
}
      
    public float getFloatResult() {
     return float_result;
 }
 
   public String getStrResult() {
     return Float.toString(getFloatResult());
 }
 
   public String getHexResult() {
     int t;
     t = Math.round(getFloatResult());
     return Integer.toHexString(t);
 }
   
   public String getBinResult() {
     int t;
     t = Math.round(getFloatResult());
     return Integer.toBinaryString(t);
 }
public int getIntResult(){
    return Math.round(getFloatResult());
}

   public String getOctResult() {
     int t;
     t = Math.round(getFloatResult());
     return Integer.toOctalString(t);
 }
   
enum op_choices {
   ADD,SUB,MUL,DIV,SQR,EXP,CON;

  public static boolean contains(String s)
  {
      for(op_choices choice:values())
           if (choice.name().equals(s)) 
              return true;
      return false;
  } 
};
  enum ty_choices {
   INT, FLO, OCT, BIN, HEX, STR;

  public static boolean contains(String s)
  {
      for(ty_choices choice:values())
           if (choice.name().equals(s)) 
              return true;
      return false;
  } 

};
  
  private void setOper(String oper){
     this.oper=oper;
}
 private String getOper(){
     return oper;
 }
 private void setBase(String base) {
     this.base=base;
 }
 private String getBase() {
     return base;
 }
 private void setNo1(float no1) {
     this.no1=no1;
 }
 private float getNo1() {
     return no1;
 }
 private void setNo2(float no2) {
     this.no2=no2;
 }
 private float getNo2 (){
     return no2;
 }
 private void setError_code(int error_code) {
     this.error_code =error_code;
 }
 public int getError_code() {
     return error_code;
 }
 private void setError_message(String error_message) {
     this.error_message=error_message;
 }
 public String getError_message() {
     return error_message;
 }
 
 private static float add(float one, float two){
   return (one + two);
}
 
private static float subtract(float one, float two){
return (one-two);
}
  
private static float multiply(float one, float two){
return (one*two);
}

private float divide(float one, float two){
    
  if (two >0) return (one/two);
  else {
      this.setError_code(DIVISION_ERROR);
      this.error_message="Math error you cannot divide by zero.\n";
  }
      return 0;
}

private float sqroot(float one){    
  return (float)(Math.sqrt(one));
}

private float exponent(float one, float two){
    return (float) (Math.pow(one,two));
}

}



