package tests;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.Test;

import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;


public class OrderTest {

    @Test(expected=OrderExpiredException.class)
    public void testOrderExpired() {
        Order order = new Order();
        order.submit();
        LocalDate date = new LocalDate(DateTime.now().plusDays(2));
        DateTimeUtils.setCurrentMillisFixed(date.toDateTimeAtCurrentTime().getMillis());
        order.confirm();
    }

}
