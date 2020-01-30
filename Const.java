package newlang4;

import java.util.EnumSet;
import java.util.Set;

public class Const extends Node{

	LexicalUnit first;
	Environment env;
	Node handler ;
	Value v;

	public Const(LexicalUnit first,Environment env) {
		this.first = first;
		this.env = env;
	}

	static final Set<LexicalType> fristSet =  EnumSet.of(
			LexicalType.NAME
			);

	public static boolean isFirst(LexicalUnit lu) {//isFistメソッドでlu
		return fristSet.contains(lu.getType()); //リストが特定の要素を含むか判定
	}

	public static Node getHandler(LexicalUnit first, Environment env) { //ここでは引数が二つ渡されている。最初に読み込んだ
		return new Const(first,env);//
	}

	public boolean parse() throws Exception{//Constではparseどうする？
		//一番下なしは多くの場合は内容を保存 どういう処理？
		//valueで保存する
		v = first.getValue();
		return true;
	}

}