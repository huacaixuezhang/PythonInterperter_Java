package pers.xia.jpython.interpreter.expression;

import pers.xia.jpython.ast.OperatorType;
import pers.xia.jpython.interpreter.ProgramState;
import pers.xia.jpython.object.*;

public class BinOpExpression extends OpExpression {
    OperatorType operatorType;
    public BinOpExpression(Expression lhs, Expression rhs, OperatorType operatorType)
    {
        super(lhs, rhs);
        this.operatorType = operatorType;
    }

    @Override
    public PyObject eval(ProgramState programState) {
        PyObject lhs = this.lhs.eval(programState);
        PyObject rhs = this.rhs.eval(programState);
        switch (operatorType){
            case Add:
                return lhs.add(rhs);
            case Sub:
                return lhs.sub(rhs);
            case Mult:
                return lhs.mul(rhs);
            default:
                return new PyUnicode("暂未实现".getBytes(),"utf-8");

        }
    }
}
