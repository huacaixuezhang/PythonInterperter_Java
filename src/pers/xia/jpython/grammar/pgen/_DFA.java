package pers.xia.jpython.grammar.pgen;

import pers.xia.jpython.object.PyExceptions;

class _DFA
{
	
	String name;	//DFA name
	_State initial;	//Initial state,
	int nstates;	//the number of state
	_State[] states;	//states for DFA
	
	static final int MAXSIZE = 256;
	
	public _DFA(String name)
	{
		if(name == null)
		{
			throw new PyExceptions("_DFA must have name");
		}
		this.name = name;
		this.initial = null;
		this.nstates = 0;
		this.states = new _State[_DFA.MAXSIZE];
	}
	
	public boolean addState(_State state)
	{
		if(this.nstates >= this.states.length)
		{
			throw new PyExceptions("Over the max size of DFA");
		}
		this.states[this.nstates++] = state;
		return true;
	}
	
	public _DFA(String name, _State initial, int nstates, _State[] states)
	{
		this.name = name;
		this.initial = initial;
		this.nstates = nstates;
		this.states = states;
	}
	
	public boolean cmp(_DFA dfa)
	{
		if(this.name.equals(dfa.name))
		{
			return true;
		}
		return false;
	}
}
