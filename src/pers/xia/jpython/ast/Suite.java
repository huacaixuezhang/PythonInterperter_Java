// Autogenerated AST node
package pers.xia.jpython.ast;
import pers.xia.jpython.object.PyObject;
import java.io.DataOutputStream;
import java.io.IOException;

public class Suite extends modType {
    public java.util.List<stmtType> body;

    public Suite(java.util.List<stmtType> body) {
        this.body = body;
    }

    public String toString() {
        return "Suite";
    }

    public void pickle(DataOutputStream ostream) throws IOException {
    }

    public Object accept(VisitorIF visitor) throws Exception {
        return visitor.visitSuite(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
    }

}