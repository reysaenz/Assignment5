
public class HolidayBonus {
	public static double[] calculateHolidayBonus(double[][] a, double h, double l, double o) {
		double bonus[] = new double[a.length];
		double low = -1;
		int lowI = -1;
		double high = -1;
		int highI = -1;
		for (int i = 0; i < a.length; i++) {
			double total = 0;
			for (int j = 0; j < a[i].length; j++) {
				total += a[i][j];
			}
			if (low == -1 || total < low) {
				low = total;
				lowI = i;
			}
			if (high == -1 || high < total) {
				high = total;
				highI = i;
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (i == lowI) {
				bonus[i] = l;
				continue;
			}
			if (i == highI) {
				bonus[i] = h;
				continue;
			}
			bonus[i] = o;
		}
		return bonus;
	}
  public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
      double other) {
    
    double[] bonusArray = calculateHolidayBonus(data, high, low, other);
    double total = 0;
    
    for (double bonus:bonusArray) {
      total+=bonus;
    }
    return total;
  }
}