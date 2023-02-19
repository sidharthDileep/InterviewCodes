package thread.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(5,9,14);
		
		list.stream().map(num -> CompletableFuture.supplyAsync(() -> getNumber(num)))
					 .map(cf -> cf.thenApply(n -> n*n))
					 .map(t -> t.join())
					 .forEach(s ->System.out.println(s));;
		
	}

	private static int getNumber(int a) {
		return a * a;
	}

}
