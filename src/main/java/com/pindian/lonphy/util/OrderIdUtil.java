package com.pindian.lonphy.util;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.time.DateFormatUtils;

public class OrderIdUtil {
	public static String newOrderId() {
		UUID uuid = UUID.randomUUID();
		String orderid = DateFormatUtils.format(new Date(), "yyyyMMddHHmmSS");
		if(uuid.hashCode()<0) {
			orderid += "1"+Math.abs(uuid.hashCode());
		} else {
			orderid+= uuid.hashCode();
		}
		return orderid;
	}
}
