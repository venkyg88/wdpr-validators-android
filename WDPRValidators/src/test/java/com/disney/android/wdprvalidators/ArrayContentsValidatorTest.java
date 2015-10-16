package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 10/14/15.
 */
public class ArrayContentsValidatorTest extends TestCase{

    private ArrayContentsValidator mArrayContentsValidator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mArrayContentsValidator = new ArrayContentsValidator();
        Holder holder[] = {new Holder(12), new Holder(11)};

    }

    public void testForObjectArray(){
        Object obj[] = { 1, 2, 4, "disney", null};
        Integer arrayType = 10;
        assertEquals(false, mArrayContentsValidator.isArrayOfIntendedType(obj, Integer.class));
        assertEquals(ValidatorConstant.ERR_CONTENTS_MISMATCH, mArrayContentsValidator.checkArrayOfIntendedType(obj, Integer.class).get(0));

        Object obj1[] = { 1, 2, 4, 5, 6};
        assertEquals(true, mArrayContentsValidator.isArrayOfIntendedType(obj1, Integer.class));
        assertEquals(true, mArrayContentsValidator.checkArrayOfIntendedType(obj1, Integer.class).isEmpty());

        Object obj2[] = { 1, 2, 4, 5, 6};
        assertEquals(true, mArrayContentsValidator.isArrayOfIntendedType(obj1, Integer.class));
        assertEquals(true, mArrayContentsValidator.checkArrayOfIntendedType(obj1, Integer.class).isEmpty());

        Object obj3[] = {false, true};
        assertEquals(true, mArrayContentsValidator.isArrayOfIntendedType(obj3, Boolean.class));
        assertEquals(true, mArrayContentsValidator.checkArrayOfIntendedType(obj3, Boolean.class).isEmpty());

        Object obj4[] = {"Big","pig","rig","mug"};
        assertEquals(true, mArrayContentsValidator.isArrayOfIntendedType(obj4, String.class));
        assertEquals(true, mArrayContentsValidator.checkArrayOfIntendedType(obj4, String.class).isEmpty());

        Object obj5[] = {2.3, 23.4,4.3,45.566};
        assertEquals(false, mArrayContentsValidator.isArrayOfIntendedType(obj5, Integer.class));
        assertEquals(ValidatorConstant.ERR_CONTENTS_MISMATCH, mArrayContentsValidator.checkArrayOfIntendedType(obj5, Integer.class).get(0));
        assertEquals(true, mArrayContentsValidator.isArrayOfIntendedType(obj5, Double.class));
        assertEquals(true, mArrayContentsValidator.checkArrayOfIntendedType(obj5, Double.class).isEmpty());

        assertEquals(false, mArrayContentsValidator.isArrayOfIntendedType(null, Double.class));
        assertEquals(false, mArrayContentsValidator.checkArrayOfIntendedType(null, Double.class).isEmpty());
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, mArrayContentsValidator.checkArrayOfIntendedType(null, Double.class).get(0));

        Object objects[] = {new HolderTwo("Walt"), new HolderTwo("Disney"), new Holder(1), new Holder(5), new HolderTwo("company")};
        assertEquals(false, mArrayContentsValidator.checkArrayOfIntendedType(objects, String.class).isEmpty());
        Object objects2[] = {new HolderTwo("Walt"), new HolderTwo("Disney"), new HolderTwo("company")};
        assertEquals(true, mArrayContentsValidator.checkArrayOfIntendedType(objects2, HolderTwo.class).isEmpty());
    }

    public void testForInteger(){
        Integer intArray[] = {10, 20, 30};
        assertEquals(true, mArrayContentsValidator.isArrayOfIntendedType(intArray, Integer.class));
    }

    public class Holder{
        private int anInt;
        Holder(int anInt){
            this.anInt = anInt;
        }
    }

    public class HolderTwo{
        private String anInt;
        HolderTwo(String anInt){
            this.anInt = anInt;
        }
    }

    public interface HoldersHolder{
        Holder holder[] = new Holder[10];
        HolderTwo holderTwo[] = new HolderTwo[10];
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
