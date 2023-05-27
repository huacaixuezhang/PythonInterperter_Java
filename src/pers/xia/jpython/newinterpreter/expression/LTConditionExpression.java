package pers.xia.jpython.newinterpreter.expression;

import pers.xia.jpython.newinterpreter.ProgramState;
import pers.xia.jpython.object.*;

public class LTConditionExpression extends OpExpression{

    public LTConditionExpression(Expression lhs, Expression rhs){
        super(lhs, rhs);
    }
    @Override
    public Object accept(ProgramState programState, ExpVisitor v) {
        Object lhs = this.lhs.accept(programState,v);
        Object rhs = this.rhs.accept(programState, v);
        if(lhs instanceof PyLong){
            return new PyBoolean(((PyLong)lhs).compare((PyObject)rhs) < 0);
        }else if(lhs instanceof PyFloat){
            return new PyBoolean(((PyFloat)lhs).compare((PyObject)rhs) < 0);
        }else if(lhs instanceof PyUnicode && rhs instanceof PyUnicode){
            return new PyBoolean(((PyUnicode) rhs).compare((PyUnicode) lhs) < 0);
        }else{
            System.out.println("not support < with given data");
            return new PyBoolean(false);
        }
    }
}
