
public class newMath implements interMath{
	
	public double mod(double x, double y){
		double decimal = x/y - (int)(x/y);
		return (decimal * y);
	}
	
	public double pow(double x, int y){
		double product = 1;
		for(int i = 0; i < y; i++){
			product *= x;
		}
		return product;
	}

	public double[] quadratic(double a, double b, double c){
		double[] returnAry = new double[2];
		returnAry[0] = ((-b - sqrt(pow(b, 2)) - 4*a*c) / 2*a);
		returnAry[1] = ((-b + sqrt(pow(b, 2)) - 4*a*c) / 2*a);
		return returnAry;
	}
	
	public double sqrt(double num){
		double i;
		for(i = 0; i * i <= num; i++);
		for(i = i - 1; i * i <= num; i += 0.1);
		for(i = i - 0.1; i * i <= num; i += 0.01);
		for(i = i - 0.01; i * i <= num; i += 0.001);
		for(i = i - 0.001; i * i <= num; i += 0.0001);
		for(i = i - 0.0001; i * i <= num; i += 0.00001);
		return i - 0.00001;
	}
	
	

	public double multiply(double a, double b) {
		return a * b;
	}

	public double divide(double a, double b) {
		return a / b;
	}
	
	public double[] quadVertex(double a, double b, double c){
		double xVal = -b/(2 * a);
		double yVal = (a * pow(xVal, 2)) + (b * xVal) + c;
		return new double[]{xVal, yVal};
		
	}
	
	public double rectArea(double l, double w){
		return l * w;
	}
	
	public double triArea(double b, double h){
		return 0.5 * b * h;
	}
	
	
	
	/*
	public double sqrt2(double num){
	double i;
	double j;
	for(i = 0; i * i <= num; i++);
	for(j = 1; j > 0.000000000000001; j /= 10){
		for(i = i - j; i * i <= num; i += j/10);
	}
	return i - j;

	}
	*/
}
