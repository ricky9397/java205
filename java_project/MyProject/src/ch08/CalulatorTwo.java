package ch08;

public class CalulatorTwo implements Calulator {
	
	@Override
	public long add(long n1, long n2) {
		return (long)n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return (long)n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return (long)n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return (double)n1 / n2;
	}

}

