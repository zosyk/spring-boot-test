package spring.boot.web;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spring.boot.model.StackOverflowWebSite;
import spring.boot.service.StackOverflowService;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by alex on 30.03.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class StackOverFlowControllerTest {

    @Mock
    StackOverflowService stackOverflowService;

    @InjectMocks
    StackOverFlowController sut;

    @Test
    public void getListOfProviders() throws Exception {

        //prepare
//        when(stackOverflowService.findAll()).thenReturn(ImmutableList.of());
//        testing
        List<StackOverflowWebSite> listOfProviders = sut.getListOfProviders();


        verify(stackOverflowService).findAll();
    }

}