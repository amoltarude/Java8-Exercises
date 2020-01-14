package com.nio2files;

import java.time.LocalDate;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
	    Map<String, LocalDate> expiredTablets = TabletUtils.getExpiredTablets("tablet.txt", "cipla");
	    expiredTablets.forEach((k,v)-> System.out.println(k + ":" + v));
	}

}
