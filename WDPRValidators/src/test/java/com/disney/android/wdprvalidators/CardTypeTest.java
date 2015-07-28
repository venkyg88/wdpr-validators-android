package com.disney.android.wdprvalidators;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by venkatgonuguntala on 7/26/15.
 */

public class CardTypeTest {

    @Test
    public void testDetection() {
        assertEquals(CardType.VISA, CardType.getCardType("4000056655665554"));
        assertEquals(CardType.VISA, CardType.getCardType("4242424242424242"));

        assertEquals(CardType.MASTERCARD, CardType.getCardType("5105105105105100"));
        assertEquals(CardType.MASTERCARD, CardType.getCardType("5200828282828210"));
        assertEquals(CardType.MASTERCARD, CardType.getCardType("5555555555554444"));

        assertEquals(CardType.AMEX, CardType.getCardType("371449635398431"));
        assertEquals(CardType.AMEX, CardType.getCardType("378282246310005"));

        assertEquals(CardType.DISCOVER, CardType.getCardType("6011000990139424"));
        assertEquals(CardType.DISCOVER, CardType.getCardType("6011111111111117"));

        assertEquals(CardType.DINERS, CardType.getCardType("30569309025904"));
        assertEquals(CardType.DINERS, CardType.getCardType("38520000023237"));

        assertEquals(CardType.JCB, CardType.getCardType("3530111333300000"));
        assertEquals(CardType.JCB, CardType.getCardType("3566002020360505"));

        assertEquals(CardType.UNKNOWN, CardType.getCardType("0000000000000000"));
    }
}