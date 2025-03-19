package com.abhi.exceptions;

public class ReturnValueFromTryCatchFinally
{
    public static void main(String[] args)
    {
        System.out.println(methodReturningValue());
        System.out.println("DONE");
    }
 
   public static String methodReturningValue()
    {
        String s = null;
        try
        {
        	System.out.println("try block..");
            s = "return value from try block;";
            //throw new Exception();
            return s;
        }
        catch (Exception e)
        {
            s = s + " return value from catch block;";
            return s;
        }
        finally
        {
        	System.out.println("finally block");
            s = s + " return value from finally block";
            return s;
        }
    }
}

/*
try block..
finally block
return value from try block return value from finally block
done
*/