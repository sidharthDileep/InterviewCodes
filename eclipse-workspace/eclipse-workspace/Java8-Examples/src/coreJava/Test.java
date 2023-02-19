package coreJava;

import java.math.BigDecimal;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		String[] str = { "12" };

		BigDecimal[] array = Arrays.stream(str).map(s -> {
			try {
				return new BigDecimal(s);
			} catch (NumberFormatException e) {
				return BigDecimal.ZERO;
			}
		}).toArray(BigDecimal[]::new);

		System.out.println(Arrays.toString(array));

	}

}
