
public abstract class Card {
	
	int value;
	String name;
	String cType = "";
	
	public Card(String type){
		if(type.equals("Spade") || type.equals("Heart") || type.equals("Diamond") || type.equals("Club")){
			cType = type;
		}else{
			cType = "none";
		}
	}
	
	public String getName(){
		return name;
	}
	public int getValue(){
		return value;
	}
	public String getType(){
		return cType;
	}
	public void setType(String t){
		cType = t;
	}
}
