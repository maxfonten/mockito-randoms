package com.github.maxfonten.randomanswers;

import static org.apache.commons.lang3.StringUtils.isAsciiPrintable;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ReturnsRandomsTest {
    @Test
    public void answerShouldReturnNonNullForPrimitives() throws Throwable {
        Primitives primitives = mock(Primitives.class, new ReturnsRandoms());
        assertThat(primitives.isABoolean(), is(notNullValue()));
        assertThat(primitives.getAByte(), is(notNullValue()));
        assertThat(primitives.getAShort(), is(notNullValue()));
        assertThat(primitives.getAChar(), is(notNullValue()));
        assertThat(primitives.getAnInt(), is(notNullValue()));
        assertThat(primitives.getALong(), is(notNullValue()));
        assertThat(primitives.getAFloat(), is(notNullValue()));
        assertThat(primitives.getADouble(), is(notNullValue()));
    }

    @Test
    public void answerShouldReturnNonNullForBoxedPrimitives() throws Throwable {
        BoxedPrimitives boxedPrimitives = mock(BoxedPrimitives.class, new ReturnsRandoms());
        assertThat(boxedPrimitives.isABoolean(), is(notNullValue()));
        assertThat(boxedPrimitives.getAByte(), is(notNullValue()));
        assertThat(boxedPrimitives.getAShort(), is(notNullValue()));
        assertThat(boxedPrimitives.getAChar(), is(notNullValue()));
        assertThat(boxedPrimitives.getAnInt(), is(notNullValue()));
        assertThat(boxedPrimitives.getALong(), is(notNullValue()));
        assertThat(boxedPrimitives.getAFloat(), is(notNullValue()));
        assertThat(boxedPrimitives.getADouble(), is(notNullValue()));
    }

    @Test
    public void answerShouldReturnStrings() throws Throwable {
        Strings strings = mock(Strings.class, new ReturnsRandoms());
        assertThat(isAsciiPrintable(strings.getAString()), is(true));
        assertThat(isNumeric(strings.getAnId()), is(true));
        assertThat(isNumeric(strings.getAnID()), is(true));
        assertThat(isNumeric(strings.getANumber()), is(true));
        assertThat(isNumeric(strings.getANum()), is(true));
        assertThat(isNumeric(strings.getANo()), is(true));
    }

    @Test
    public void answerShouldReturnDates() throws Throwable {
        Dates dates = mock(Dates.class, new ReturnsRandoms());
        assertThat(dates.getDate(), is(notNullValue()));
        assertThat(dates.getCalendar(), is(notNullValue()));
    }

    private static class Dates {
        public Calendar getCalendar() {
            return null;
        }
        
        public Date getDate() {
            return null;
        }
    }
    
    private static class BoxedPrimitives {
        public Boolean isABoolean() {
            return null;
        }

        public Byte getAByte() {
            return null;
        }

        public Short getAShort() {
            return null;
        }

        public Character getAChar() {
            return null;
        }

        public Integer getAnInt() {
            return null;
        }

        public Long getALong() {
            return null;
        }

        public Float getAFloat() {
            return null;
        }

        public Double getADouble() {
            return null;
        }
    }

    private static class Primitives {
        public boolean isABoolean() {
            return false;
        }

        public byte getAByte() {
            return 0;
        }

        public short getAShort() {
            return 0;
        }

        public char getAChar() {
            return 0;
        }

        public int getAnInt() {
            return 0;
        }

        public long getALong() {
            return 0;
        }

        public float getAFloat() {
            return 0;
        }

        public double getADouble() {
            return 0;
        }
    }

    private static class Strings {
        public String getAString() {
            return null;
        }

        public String getAnID() {
            return null;
        }

        public String getAnId() {
            return null;
        }

        public String getANumber() {
            return null;
        }

        public String getANum() {
            return null;
        }

        public String getANo() {
            return null;
        }
    }
}
