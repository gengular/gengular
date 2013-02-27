package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;

import static org.junit.Assert.assertNotNull;

public class StringTemplateTest {

    final static Logger LOGGER = LoggerFactory.getLogger(POIWrapperTest.class);

    @Test
    public void testTemplate() {

        ST st = new ST("Hello, <name>");
        st.add("name", "World");
        LOGGER.debug(st.render());
        assertNotNull("Hello, World".equalsIgnoreCase(st.render()));

        /*
        ST st = new ST("<items:{it|<it.id>: <it.lastName>, <it.firstName>\n}>");
        st.addAggr("items.{firstName, lastName ,id}", "Tom", "Burns", 99); // add() uses varargs
        st.addAggr("items.{firstName, lastName ,id}", "Tommmy", "Gurns", 88);
        LOGGER.debug(st.render());
        assertNotNull(st.render());
        */
    }
}
