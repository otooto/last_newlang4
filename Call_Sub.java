package newlang4;

import java.util.EnumSet;
import java.util.Set;

public class Call_Sub extends Node{
	
	LexicalUnit first;
	Environment env;
	Node handler ;

	public Call_Sub(LexicalUnit first,Environment env) {//コンストラクタ
		this.first = first;
		this.env = env;
		type = NodeType.FUNCTION_CALL;
	}
	
	static final Set<LexicalType> firstSet =  EnumSet.of( // EnumSet.of(E e)=指定された要素を最初に含む enum セットを作成します
			LexicalType.NAME
			);
	
	public static boolean isFirst(LexicalUnit lu) { //１つ目のメソッド
		return firstSet.contains(lu.getType());
	}
	
	public static Node getHandler(LexicalUnit first, Environment env) throws Exception { //二つ目のメソッド

		if(Call_Sub.isFirst(first)){ //まずfirst集合を比べて、大丈夫ならPrgramインスタンスが生成される
			return new Call_Sub(first,env);
		}
		throw new Exception("Call_Subにないfirst集合です");//first集合でない時
	}

	public boolean parse() throws Exception{ //三つ目のメソッド parse＝解析をする

		if(.isFirst(first)) { //次の判定を開始する
			handler = StmtList.getHandler(first,env);
			handler.parse();
			return true;
		}
		throw new Exception("Call_subエラーです");//first集合でない時
	}


	public String toString() { //handerが出力するのはこれ
		return   handler.toString() ;
	}
}



			
			

		

}