import java.util.List;
import java.util.SplittableRandom;

import org.junit.Test;

import com.google.common.base.Splitter;

public class TestT {

	@Test
	public void tet() {
		List<String> list = Splitter.on(",").splitToList("12,23,45");
		System.out.println(list);
	}
}
