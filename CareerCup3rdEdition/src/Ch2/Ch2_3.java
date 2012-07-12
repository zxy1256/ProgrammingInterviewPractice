package Ch2;

import java.util.List;

public class Ch2_3 {
	
	static public int maxSubListSum(List<Integer> l) {
		if (l == null) {
			throw new IllegalArgumentException();
		}
		if (l.isEmpty()) {
			return 0;
		}
		
		int start = 0;
		int end = 0;
		int max_sum = 0;
		while (start < l.size() && end < l.size()) {
			end = start;
			int sum = 0;
			while (end < l.size()) {
				if (sum+l.get(end) >= 0) {
					sum += l.get(end);
					end++;
				} else {
					start = end+1;
					break;
				}
			}
			if (sum > max_sum) {
				max_sum = sum;
			}
		}
		return max_sum;
	}
	
}
