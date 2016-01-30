
public class WordCountResult {
	private int wordsCount;
	private int linesCount;
	private int charactersCount;
	
	public WordCountResult(int wordsCount,int linesCount,int charactersCount){
		this.wordsCount=wordsCount;
		this.linesCount=linesCount;
		this.charactersCount=charactersCount;
	}
	
	public void print(){
		System.out.println(wordsCount+"words");

		System.out.println(linesCount+"lines");

		System.out.println(charactersCount+"characters");
	}
}
