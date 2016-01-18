import java.util.Vector;

public class NVector {
	private Vector<Double> vector=new Vector<>();
	public NVector(double[] coordinates){
		for(int i=0;i<coordinates.length;i++){
			vector.add(coordinates[i]);
		}
	}
	
	public NVector(Vector<Double> nVector){
		vector=new Vector<Double> (nVector);
	}
	
	public void setCoordinate(int index,double element){
		vector.set(index,element);
	}
	
	public double getCoordinate(int index){
		return vector.elementAt(index);
	}
	
	public double getDimensionality(){
		double sum=0;
		for(int i=0;i<vector.size();i++){
			sum+=vector.elementAt(i)*vector.elementAt(i);
		}
		return Math.sqrt(sum);
	}

	@Override
	public int hashCode() {
        int hash = 17;
        for(int i=0;i<vector.size();i++){
        	hash = hash * 23 + vector.elementAt(i).hashCode();
        }
        return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof NVector)){
			return false;
		}
		else{
			if(checkDimensions(((NVector)obj).vector,vector)){
				return false;
			}
			else{
				for(int i=0;i<vector.size();i++){
					if(vector.elementAt(i)!=((NVector)obj).vector.elementAt(i)){
						return false;
					}
				}
				return true;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder output=new StringBuilder();
		output.append(vector.size()+"D Vector with coordinates:("+vector.elementAt(0));
		for(int i=1;i<vector.size();i++){
			output.append(", "+vector.elementAt(i));
		}
		output.append(")");
		return output.toString();
	}
	
	public void add(NVector nVector){
		if(checkDimensions(nVector.vector,vector)){
			System.out.println("Vectors have different dimensions");
		}else{
			for(int i=0;i<vector.size();i++){
				vector.set(i,vector.get(i)+nVector.vector.get(i));
			}
		}
	}
	
	public void subtract(NVector nVector){
		if(checkDimensions(nVector.vector,vector)){
			System.out.println("Vectors have different dimensions");
		}else{
			for(int i=0;i<vector.size();i++){
				vector.set(i,vector.get(i)-nVector.vector.get(i));
			}
		}
	}
	
	public void add(float scalar){
		for(int i=0;i<vector.size();i++){
			vector.set(i, vector.get(i)+scalar);
		}
	}
	
	public void subtract(float scalar){
		for(int i=0;i<vector.size();i++){
			vector.set(i, vector.get(i)-scalar);
		}
	}
	
	public void multiply(float scalar){
		for(int i=0;i<vector.size();i++){
			vector.set(i, vector.get(i)*scalar);
		}
	}
	
	public void divide(float scalar){
		if(scalar==0){
			System.out.println("Can not divide by 0");
			return;
		}
		for(int i=0;i<vector.size();i++){
			vector.set(i, vector.get(i)/scalar);
		}
	}
	
	private static boolean checkDimensions(Vector<Double> vector1, Vector<Double> vector2){
		if(vector1.size()==vector2.size()){
			return true;
		}
		else return false;
	}
	
	public double dotProduct(NVector nVector){
		double sum=0;
		if(checkDimensions(nVector.vector,vector)){
			System.out.println("Not similar dimensions");
			return 0;
		}
		for(int i=0;i<vector.size();i++){
			sum+=vector.get(i)*nVector.vector.get(i);
		}
		return sum;
	}
}
