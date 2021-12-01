package com.coforge.training.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class MockitoSpyTest {
List<String> list=new ArrayList<String>(); 
@Spy
List<String> listSpy=new ArrayList<String>(list);// @Before
// void setUp() throws Exception {
// list=new ArrayList<String>();
// listSpy=new ArrayList<String>(list);
// } @Test
void test() {
listSpy.add("James Gosling");
System.out.println(listSpy.get(0));
// assertTrue("James Gosling".equals(listSpy.get(0)));
assertEquals("James Gosling", listSpy.get(0));
//
// when(listSpy.get(0)).thenReturn("Red Johnson");
//
// assertEquals("Red Johnson", listSpy.get(0));
}

}
