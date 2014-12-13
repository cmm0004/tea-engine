package recommender;

public class Tea {
	public double caffeine;
	public double astringency;
	public String teaName;
	
	public Tea(double caffeine, double astringency, String teaName){
		this.caffeine = caffeine;
		this.astringency = astringency;
		this.teaName = teaName;
	}
	
	public double[] teaDouble(){
		return new double[]{caffeine,astringency};
		
	}
	@Override
	public String toString(){
		return caffeine + "," + astringency + "," + teaName;
	}

}
