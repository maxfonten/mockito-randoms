package com.github.maxfonten.randomanswers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMoreEmptyValues;

@SuppressWarnings("unchecked")
public class DelegatesOrReturnsDeepStubsTest {
    @Test
    public void answerShouldDelegateUntilNonNullAnswerFound() {
        VO vo = mock(VO.class, new DelegatesOrReturnsDeepStubs(new DoesNothing(), new ReturnsMoreEmptyValues()));
        assertThat(vo.getFoo(), equalTo(""));
    }

    @Test
    public void answerShouldFallbackOnDeepStub() {
        VO vo = mock(VO.class, new DelegatesOrReturnsDeepStubs(new DoesNothing()));
        assertThat(vo.getFoo(), is(nullValue()));
        assertThat(vo.getVo().toString(), startsWith("Mock"));
        assertThat(vo.getVo().getFoo(), is(nullValue()));
    }

    @Test
    public void deepStubShouldDelegate() {
        VO vo = mock(VO.class, new DelegatesOrReturnsDeepStubs(new ReturnsMoreEmptyValues()));
        assertThat(vo.getFoo(), equalTo(""));
        assertThat(vo.getVo().toString(), startsWith("Mock"));
        assertThat(vo.getVo().getFoo(), equalTo(""));
    }
    
    
    private static class VO {
        private String foo;
        private VO vo;
        
        public String getFoo() {
            return foo;
        }
        
        public VO getVo() {
            return vo;
        }
    }
}
