package com.github.maxfonten.randomanswers;

import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Return random values for primitives, boxed primitives, strings and dates. Random
 * strings will be numeric only if the invoked method name ends with either
 * "Id", "ID", "Number", "Num", or "No".
 * 
 * @author Max Fonten
 */
public class ReturnsRandoms implements Answer<Object>, Serializable {
    private static final long serialVersionUID = 7401483879992145571L;
    private static final Random RANDOM = new Random(currentTimeMillis());
    private static final String[] NUMBERY_SUFFIXES = { "Id", "ID", "Number", "Num", "No" };

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Object answer = null;

        Class<?> type = invocation.getMethod().getReturnType();
        if (Boolean.TYPE == type || Boolean.class == type) {
            answer = RANDOM.nextBoolean();
        } else if (Byte.TYPE == type || Byte.class == type) {
            answer = (byte) (RANDOM.nextInt(Byte.MAX_VALUE + 1 * 2) / 2);
        } else if (Short.TYPE == type || Short.class == type) {
            answer = (short) (RANDOM.nextInt(Short.MAX_VALUE + 1 * 2) / 2);
        } else if (Character.TYPE == type || Character.class == type) {
            answer = (char) (RANDOM.nextInt('~' - ' ' + 1) + ' ');
        } else if (Integer.TYPE == type || Integer.class == type) {
            answer = RANDOM.nextInt();
        } else if (Long.TYPE == type || Long.class == type) {
            answer = RANDOM.nextLong();
        } else if (Double.TYPE == type || Double.class == type) {
            answer = RANDOM.nextDouble();
        } else if (Float.TYPE == type || Float.class == type) {
            answer = RANDOM.nextFloat();
        } else if (String.class == type) {
            answer = isNumbery(invocation.getMethod().getName()) ? String.valueOf(RANDOM.nextInt(Integer.MAX_VALUE)) : randomUUID().toString();
        } else if (Date.class == type) {
            answer =  new Date(RANDOM.nextLong());
        } else if (Calendar.class == type) {
            answer = Calendar.getInstance();
            ((Calendar) answer).setTimeInMillis(RANDOM.nextLong());
        }
        return answer;
    }

    private static boolean isNumbery(String methodName) {
        boolean numbery = false;

        for (String numberySuffix : NUMBERY_SUFFIXES) {
            if (methodName.endsWith(numberySuffix)) {
                numbery = true;
                break;
            }
        }

        return numbery;
    }
}
