package com.github.maxfonten.randomanswers;

import static java.util.Arrays.asList;

import java.util.Iterator;

import org.mockito.internal.stubbing.defaultanswers.ReturnsDeepStubs;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Extension of {@link ReturnsDeepStubs} that attempts to get a non null answer
 * from delegate {@link Answer}s before falling back on deep stubs. Answers for
 * deep stubs will also attempt to get a non null answer from the delegate
 * {@link Answer}s before stubbing.
 * 
 * @author Max Fonten
 */
public class DelegatesOrReturnsDeepStubs extends ReturnsDeepStubs {
    private static final long serialVersionUID = 1523011951975692018L;
    private final Iterable<Answer<Object>> delegates;

    public DelegatesOrReturnsDeepStubs(Answer<Object>... delegates) {
        this.delegates = asList(delegates);
    }

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Object answer = null;

        Iterator<Answer<Object>> delegatesIterator = delegates.iterator();
        while (delegatesIterator.hasNext() && answer == null) {
            answer = delegatesIterator.next().answer(invocation);
        }

        return answer == null ? super.answer(invocation) : answer;
    }
}
